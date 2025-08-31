package com.example.orliv.config;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SolrJConfig {

    @Value("${solr.url}")
    private String url;

    @Bean
    public HttpSolrClient solrConnect() {
        return new HttpSolrClient.Builder("http://localhost:8983/solr").build();
    }

}
