package com.example.orliv.service;

import com.example.orliv.config.SolrJConfig;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.MapSolrParams;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@ExtendWith(SpringExtension.class)
class OpusServiceTest {

    @Autowired
    private SolrJConfig solrJConfig;

    @Test
    void getOpusByAuthor() {
        HttpSolrClient solrClient = this.solrJConfig.solrConnect();
        final Map<String, String> queryParamMap = new HashMap<>();
        queryParamMap.put("q", "*:*");
        queryParamMap.put("fl", "id, name");
        queryParamMap.put("sort", "id asc");
        try {
            QueryResponse response = solrClient.query("techproducts", new MapSolrParams(queryParamMap));
            Assertions.assertThat(response.getResults()).isNotEmpty();
        } catch (SolrServerException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}