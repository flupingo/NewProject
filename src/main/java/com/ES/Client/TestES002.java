package com.ES.Client;

import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.NestedQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.net.UnknownHostException;

/**
 * Created：Jeffrey
 * date   ：2021/7/3 14:57
 */
public class TestES002 {
    public static void main(String[] args) {
        try {
            TransportClient transportClient = ESClient.getTransport();
            SearchRequestBuilder searchRequestBuilder = transportClient.prepareSearch("rkb").setTypes("type01");
            //普通查询
            QueryBuilder queryBuilder = QueryBuilders.termQuery("", ""); //关键字
            searchRequestBuilder.setQuery(queryBuilder)
                    .setFrom(1)
                    .setSize(10)
                    .addSort("", SortOrder.ASC);

            //bool
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
            boolQueryBuilder.should();
            boolQueryBuilder.should(queryBuilder);
            boolQueryBuilder.must();
            boolQueryBuilder.mustNot();


            //聚合
            AggregationBuilder aggregationBuilder = AggregationBuilders.nested("agg01", "memberinfo");
            aggregationBuilder.subAggregation(AggregationBuilders.terms("agg02").field("1"));


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }
}
