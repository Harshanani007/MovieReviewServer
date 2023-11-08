package com.example.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${SPRING_DATASOURCE_HOST}")
    private String dataSourceHost;

    @Value("${SPRING_DATASOURCE_PORT}")
    private String dataSourcePort;

    @Value("${SPRING_DATASOURCE_SCHEMA}")
    private String dataSourceSchema;

    @Value("${SPRING_DATASOURCE_USERNAME}")
    private String dataSourceUserName;

    @Value("${SPRING_DATASOURCE_PASSWORD}")
    private String dataSourcePassword;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://" + dataSourceHost + ":" + dataSourcePort + "/" + dataSourceSchema);
        dataSource.setUsername(dataSourceUserName); // Use appropriate environment variable or hard-coded value
        dataSource.setPassword(dataSourcePassword); // Use appropriate environment variable or hard-coded value
        // Other data source configuration properties

        return dataSource;
    }
}
