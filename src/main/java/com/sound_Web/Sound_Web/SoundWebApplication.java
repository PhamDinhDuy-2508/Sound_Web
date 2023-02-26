package com.sound_Web.Sound_Web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@SpringBootApplication
public class SoundWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(SoundWebApplication.class, args);
	}
}
