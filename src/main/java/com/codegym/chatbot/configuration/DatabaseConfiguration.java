package com.codegym.chatbot.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
@Configuration
@EnableAutoConfiguration
@PropertySources({
        @PropertySource("classpath:database.properties"),
        @PropertySource("classpath:hibernate.properties")})
public class DatabaseConfiguration {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Value("${spring.datasource.driverClassName}")
    private String dbDriver;

    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String dbDialect;

    @Bean
    public DataSource dataSource() {
        if (dbUrl == null || dbUrl.isEmpty()) {
            return new HikariDataSource();
        } else {
            HikariConfig config = new HikariConfig();
            config.setDriverClassName(dbDriver);
            config.setJdbcUrl(dbUrl);
            config.setUsername(dbUsername);
            config.setPassword(dbPassword);
            return new HikariDataSource(config);
        }
    }
}