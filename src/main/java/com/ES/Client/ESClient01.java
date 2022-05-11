package com.ES.Client;

import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.*;
import org.elasticsearch.search.aggregations.bucket.nested.InternalNested;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

/**
 * Created：Jeffrey
 * date   ：2021/5/29 17:11
 */
public class ESClient01 {
    public static void main(String[] args) {
        try {
            TransportClient transportClient = ESClient.getTransport();
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

            //1.多条件 ==> QueryBuilders工具类
            QueryBuilder queryBuilder = QueryBuilders.termQuery("1", "1");
            QueryBuilder queryBuilder01 = QueryBuilders.termQuery("1", "1");
            boolQueryBuilder.must(queryBuilder).must(queryBuilder01).mustNot(queryBuilder01).should(queryBuilder01).should(queryBuilder01);


            //2.对嵌套字段的条件
            QueryBuilder nest = QueryBuilders.nestedQuery("member", queryBuilder01, ScoreMode.Max);


            //3.聚合---类型 ==> AggregationBuilders工具类，对应DSL 理解
            AggregationBuilder aggregationBuilder = AggregationBuilders.terms("agg01").field("date");

            //3.1 普通聚合
            SearchResponse searchResponse = transportClient.prepareSearch("rkb").setTypes("type1")
                    .addAggregation(aggregationBuilder)
                    .execute().actionGet();

            //3.2 嵌套下添加聚合
//            AggregationBuilder aggregationBuilder1 = AggregationBuilders.nested("agg01", "memberinfo");
//            aggregationBuilder1.subAggregation(aggregationBuilder);


            Aggregations aggregations = searchResponse.getAggregations();

            //======agg01对应的是Terms对象，不是aggregation ！！！=====
            StringTerms terms = aggregations.get("agg01");
            List<StringTerms.Bucket> list = terms.getBuckets();
            for (StringTerms.Bucket bucket : list) {
                System.out.println("字段值为：" + bucket.getKeyAsString() + "==");
                long count = bucket.getDocCount();
                System.out.println("数量为：" + count + "==");
            }


            //*嵌套字段聚合结果处理*
//            InternalNested internalNested = aggregations.get("agg01");
//            InternalAggregations internalAggregations = internalNested.getAggregations();
//            StringTerms aggTerms = internalAggregations.get("agg02");
//            List<?> aggList = aggTerms.getBuckets();


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }


}
