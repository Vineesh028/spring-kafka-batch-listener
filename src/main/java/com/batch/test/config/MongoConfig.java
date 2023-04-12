package com.batch.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import com.mongodb.ConnectionString;

@Configuration
public class MongoConfig {
	
	@Value("${spring.data.mongodb.uri}")
	private String uri;
	
	@Bean
	public SimpleMongoClientDatabaseFactory mongoDbFactory(ConnectionString connectionString) {
		SimpleMongoClientDatabaseFactory factory = new SimpleMongoClientDatabaseFactory(connectionString);
		return factory;
	}

	@Bean
	public MongoTemplate mongoTemplate() {
		ConnectionString connectionString = new ConnectionString(uri);
		return new MongoTemplate(mongoDbFactory(connectionString));
	}

}
