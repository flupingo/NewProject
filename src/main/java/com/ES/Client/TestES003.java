package com.ES.Client;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;

import java.net.UnknownHostException;

/**
 * Created：Jeffrey
 * date   ：2021/8/17 21:05
 */
public class TestES003 {
    public static void main(String[] args) {
        try {
            TransportClient transportClient = ESClient.getTransport();
            SearchRequestBuilder searchRequestBuilder = transportClient.prepareSearch("").setTypes("");
            TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("age", "1");
            searchRequestBuilder.setQuery(termQueryBuilder);




        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }
}
