package com.tradeshift.resources;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.tradeshift.service.HelloWorldService;
import com.tradeshift.service.MessagesDAO;
import com.tradeshift.service.MessagesDAOImpl;
import com.tradeshift.service.SpringHelloWorldService;

@Configuration
public class AppConfig{

    @Bean(name = "helloWorldService")
    public HelloWorldService getHelloWorldService() {

        return new SpringHelloWorldService();
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/messagesdb");
        dataSource.setUsername("postgres");
        dataSource.setPassword("password");

        return dataSource;
    }

    @Bean
    public MessagesDAO getMessagesDAO() {
        return new MessagesDAOImpl(getDataSource());
    }
}