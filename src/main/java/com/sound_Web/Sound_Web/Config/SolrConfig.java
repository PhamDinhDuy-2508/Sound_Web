package com.sound_Web.Sound_Web.Config;

import org.apache.solr.client.solrj.SolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.data.solr.server.support.EmbeddedSolrServerFactory;

@Configuration
@EnableSolrRepositories

public class SolrConfig {
//    @Bean
//    public SolrClient solrClient() {
//        EmbeddedSolrServerFactory factory = new EmbeddedSolrServerFactory("classpath:com/acme/solr");
//        return factory.getSolrServer();
//    }
//
//    @Bean
//    public SolrOperations solrTemplate() {
//        return new SolrTemplate(solrClient());
//    }

}
