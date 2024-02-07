package com.weather.platform.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@ConditionalOnProperty(prefix = "mongodb", name = "connection-string")
public class MongoConfig {

    @Bean
    @Qualifier("MongoConnectionString")
    public String getMongoConnectionString(@Value("${mongodb.is-connection-secret}") boolean isConnectionSecret,
                                           @Value("${mongodb.connection-string}") String connectionString) {
        if (isConnectionSecret) {
            throw new IllegalArgumentException("Not yet implemented sensitive connection string handling yet.");
        } else {
            return connectionString;
        }
    }

    @Bean
    public MongoClient mongoClient(@Qualifier("MongoConnectionString") String connectionString) {
        final MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    MongoTemplate mongoTemplate(MongoClient mongoClient, @Value("${mongodb.database-name}") String databaseName) {
        return new MongoTemplate(mongoClient, databaseName);
    }
}
