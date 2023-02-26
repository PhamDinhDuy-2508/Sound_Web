package com.sound_Web.Sound_Web.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;
import org.springframework.stereotype.Component;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;
@Data
@AllArgsConstructor
@NoArgsConstructor
@SolrDocument(collection = "validation")
public class EmailAndUsername {
    @Id
    @Field
    private int id;
    @Field
    private String name;
    @Field
    private String email;

}
