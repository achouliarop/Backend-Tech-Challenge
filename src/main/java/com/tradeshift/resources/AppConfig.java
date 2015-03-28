package com.tradeshift.resources;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import com.tradeshift.service.HelloWorldService;
import com.tradeshift.service.HelloWorldServiceImpl;
import com.tradeshift.service.MessagesDAO;
import com.tradeshift.service.MessagesDAOImpl;

@Configuration
public class AppConfig{

    @Bean(name = "helloWorldService")
    public HelloWorldService getHelloWorldService() {

        return new HelloWorldServiceImpl();
    }

    @Bean
    DataSource getDataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource(new org.postgresql.Driver(), "jdbc:postgresql://localhost:5432/messagesdb", "postgres", "password");

        return dataSource;
    }

    @Bean(name = "messagesDAO")
    public MessagesDAO getMessagesDAO() {
        return new MessagesDAOImpl(getDataSource());
    }
}