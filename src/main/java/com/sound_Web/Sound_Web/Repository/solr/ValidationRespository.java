package com.sound_Web.Sound_Web.Repository.solr;

import com.sound_Web.Sound_Web.Model.EmailAndUsername;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface ValidationRespository extends SolrCrudRepository<EmailAndUsername , Integer> {
    EmailAndUsername findByEmail(String Email) ;
    EmailAndUsername findByName(String Name) ;


}
