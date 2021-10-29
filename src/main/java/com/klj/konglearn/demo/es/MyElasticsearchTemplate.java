package com.klj.konglearn.demo.es;

import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

public class MyElasticsearchTemplate extends ElasticsearchRestTemplate {

    private static MyElasticsearchTemplate template;

    public MyElasticsearchTemplate getInstance(){
        if(template == null){


            RestHighLevelClient restHighLevelClient = new RestHighLevelClient(null);
        }
        return template;
    }

    private MyElasticsearchTemplate(RestHighLevelClient client) {
        super(client);
    }
}
