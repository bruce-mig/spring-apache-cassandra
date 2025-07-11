package com.github.bruce_mig.reactive_user_management.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

@Configuration
@EnableReactiveCassandraRepositories
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("${spring.cassandra.keyspace-name}")
    private String keySpace;

    @Value("${spring.cassandra.local-datacenter}")
    private String dataCenter;

    @Override
    protected String getKeyspaceName() {
        return keySpace;
    }

    @Override
    protected String getLocalDataCenter() {
        return dataCenter;
    }
}
