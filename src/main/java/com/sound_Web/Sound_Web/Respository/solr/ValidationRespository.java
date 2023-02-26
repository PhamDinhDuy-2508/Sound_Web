package com.sound_Web.Sound_Web.Respository.solr;

import com.sound_Web.Sound_Web.Model.EmailAndUsername;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

public interface ValidationRespository extends SolrCrudRepository<EmailAndUsername , Integer> {
    EmailAndUsername findByEmail(String Email) ;
    EmailAndUsername findByName(String Name) ;

}
