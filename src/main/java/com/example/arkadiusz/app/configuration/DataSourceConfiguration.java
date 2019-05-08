package com.example.arkadiusz.app.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;

import javax.sql.DataSource;

@EnableJpaRepositories( basePackages = "com.example.arkadiusz.app.dao")
@Configuration
public class DataSourceConfiguration
    {
    @Value("${url}")
    String url;
    @Value("${user}")
    String user;
    @Value("${password}")
    String password;

    @Bean
    public DataSource getDataSource()
        {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setUrl(url);
        source.setUsername(user);
        source.setPassword(password);
        return source;
        }

    @Bean
    public BeanPostProcessor processor(){
    return new PersistenceAnnotationBeanPostProcessor();
    }

    }
