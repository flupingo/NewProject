package com.ES.Client;

import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.action.admin.indices.create.CreateIndexAction;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.*;
import org.elasticsearch.search.aggregations.bucket.nested.InternalNested;
import org.elasticsearch.search.aggregations.bucket.nested.NestedAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.Transport;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * Created：Jeffrey
 * date   ：2020/8/10 16:26
 */
public class ESClient {
    public static void main(String[] args) throws UnknownHostException {
        //创建ES操作对象transportClient
        TransportClient transportClient = ESClient.getTransport();
        //查询源数据: 这里id是_id，不是字段id
        GetResponse getResponse = transportClient.prepareGet("rkb", "type1", "1").get();
        System.out.println(getResponse.getSourceAsMap());

        //创建/删除索引一般不用JAVA客户端，了解即可！
//        System.out.println(createIndex(transportClient));

        //matchAll
//        matchAllQuery(transportClient);

        //关键字查询
//        termQuery(transportClient);


//        filterQuery(transportClient);

        //bool查询-复杂查询
        boolQueryBuilder(transportClient);

        //关闭ES连接
        transportClient.close();
    }

    //获取ES客户端
    public static TransportClient getTransport() throws UnknownHostException {
        //1.创建ES客户端
        TransportClient transportClient = new PreBuiltTransportClient(Settings.EMPTY);
        //2.设置IP(192.168.0.103) 及 ES-Web端口是9300
        //如果是集群，就要添加多个IP及端口，后面继续addTransportAddress（IP，port）！！！
        transportClient.addTransportAddress(new TransportAddress(InetAddress.getByName("192.168.0.103"), 9300));
        return transportClient;
    }

    //创建索引，不能创建已经存在的，要先删除
    public static boolean createIndex(TransportClient transportClient) {
        //删除用prepareDelete()
        CreateIndexResponse createIndexResponse = transportClient.admin().indices().prepareCreate("rkb01").get();
        return createIndexResponse.isAcknowledged();
    }

    //MatchAll查询所有
    public static void matchAllQuery(TransportClient transportClient) {
        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();//QueryBuilders工具类
        SearchResponse searchResponse = transportClient.prepareSearch("rkb")  //写法类比Kibana的命令！！！！！query/sort是单
                .setTypes("type1")
                .setQuery(matchAllQueryBuilder) //构建查询条件！！！
                .setFrom(1)//from/size和query同级，和Kibana命令一致
                .setSize(10)
                .addSort("age", SortOrder.ASC)
                .setSource(SearchSourceBuilder.searchSource().fetchSource("*", "name"))//指定返回字段
                .get();

        System.out.println(searchResponse.getHits().totalHits);         //====命中总条数===
        for (SearchHit searchHit : searchResponse.getHits().getHits()) { //===获取hits转成hit数组，并遍历每个hit文档，输出文档===
            System.out.println(searchHit.getSourceAsString());
        }
    }

    //termQuery关键字查询
    public static void termQuery(TransportClient transportClient) {
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("age", "12");
        SearchResponse searchResponse = transportClient.prepareSearch("rkb") //返回SearchRequestBuilder
                .setTypes("type1")          //返回SearchRequestBuilder
                .setQuery(termQueryBuilder) //返回SearchRequestBuilder
                .get();
        for (SearchHit searchHit : searchResponse.getHits().getHits()) { //遍历hits下的每个hit文档
            System.out.println(searchHit.getSourceAsString());
        }
    }

    //rangeQuery-范围查询
    public static void rangeQuery(TransportClient transportClient) {
        RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("age").gte(1).lte(30);
        SearchResponse searchResponse = transportClient.prepareSearch("rkb")
                .setTypes("type01")
                .setQuery(rangeQueryBuilder)
                .addSort("age", SortOrder.DESC)
                .get();
        System.out.println(searchResponse.getHits().totalHits);
    }

    //filterQuery先过滤后查询
    public static void filterQuery(TransportClient transportClient) {
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "xiaoyang");
        TermQueryBuilder termQueryBuilder01 = QueryBuilders.termQuery("age", "30");
        SearchResponse searchResponse = transportClient.prepareSearch("rkb")
                .setTypes("type1")
                .setPostFilter(termQueryBuilder) //先过滤后query
                .setQuery(termQueryBuilder01)
                .get();
        System.out.println(searchResponse.getHits().totalHits);

    }


    //=========复杂查询！！！！=========
    public static void boolQueryBuilder(TransportClient transportClient) {
        SearchRequestBuilder searchRequestBuilder = transportClient.prepareSearch("rkb01").setTypes("type1");
        //1.布尔查询
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        //对嵌套字段加匹配条件 bool里must/must-not/should对应的是数组！！！
        boolQueryBuilder.must(QueryBuilders.termQuery("memberInfo.sex", "girl"))
                .must(QueryBuilders.termQuery("memberInfo.height", "1.2"))
                .must(QueryBuilders.existsQuery("memberInfo.sex"));


        //2.嵌套字段查询
        NestedQueryBuilder nestedQueryBuilder = QueryBuilders.nestedQuery("memberInfo", boolQueryBuilder, ScoreMode.Max);
//        System.out.println("==嵌套查询queryBuilder的DSL语句==" + nestedQueryBuilder);

        //3.聚合查询
        AggregationBuilder aggregationBuilder = AggregationBuilders.terms("group").field("date");

        searchRequestBuilder.setTypes("type1")
                .addAggregation(aggregationBuilder)
                .setQuery(nestedQueryBuilder);
//        System.out.println("==执行DSL语句==" + searchRequestBuilder);

        //4.复杂聚合
        SearchRequestBuilder searchRequestBuilder1 = transportClient.prepareSearch("rkb01");
        //聚合下嵌套
        NestedAggregationBuilder nestedAggregationBuilder = AggregationBuilders.nested("agg01", "memberInfo");
//        System.out.println("嵌套聚合查询"+nestedAggregationBuilder);
        TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("agg02").field("sex");
        //嵌套聚合包裹子字段的聚合！！！
        nestedAggregationBuilder.subAggregation(termsAggregationBuilder);
        System.out.println("terms聚合查询：" + nestedAggregationBuilder);
        SearchResponse searchResponse = searchRequestBuilder.addAggregation(nestedAggregationBuilder)
                .setTypes("type1")
                .execute()
                .actionGet();
        //



        //score相等，查询更快
//        ConstantScoreQueryBuilder constantScoreQuery=QueryBuilders.constantScoreQuery(boolQueryBuilder);
//        searchRequestBuilder.setTypes("type1")
//                .setQuery(boolQueryBuilder);
//        System.out.println(constantScoreQuery);
//        System.out.println(boolQueryBuilder);
    }


}
