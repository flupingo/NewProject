package com.ES.Client;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.sort.SortOrder;

import java.net.UnknownHostException;
import java.util.List;

/**
 * Created：Jeffrey
 * date   ：2021/6/5 22:07
 */
public class TestES001 {
    public static void main(String[] args) {
        try {
            TransportClient transportClient = ESClient.getTransport();

            QueryBuilder queryBuilder = QueryBuilders.termQuery("name", "21");
            //bool
            QueryBuilder boolQuery = QueryBuilders.boolQuery();
            ((BoolQueryBuilder) boolQuery).must(queryBuilder).mustNot(queryBuilder).should(queryBuilder);


            //嵌套字段聚合
            AggregationBuilder aggregationBuilder = AggregationBuilders.nested("agg01", "memberinfo");
            //===聚合字段===
            AggregationBuilder aggregationBuilder1 = AggregationBuilders.terms("memberinfo.age").field("age");
            aggregationBuilder.subAggregation(aggregationBuilder1);

            SearchResponse searchResponse = transportClient.prepareSearch("type").setTypes()
                    .setQuery(boolQuery)
                    .addAggregation(aggregationBuilder)
                    .addSort("123", SortOrder.DESC)
                    .execute().actionGet();

            Aggregations aggregations = searchResponse.getAggregations();
            StringTerms terms = aggregations.get("agg01");
            List<StringTerms.Bucket> buckets = terms.getBuckets();
            for (StringTerms.Bucket bucket : buckets) {
                String ke = bucket.getKeyAsString();
                long count = bucket.getDocCount();
            }


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
