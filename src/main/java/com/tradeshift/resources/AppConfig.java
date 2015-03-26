package com.tradeshift.resources;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

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
/*    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.jdbc.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/messagesdb");
        dataSource.setUsername("postgres");
        dataSource.setPassword("password");

        return dataSource;
    }*/
    DataSource getDataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource(new org.postgresql.Driver(), "jdbc:postgresql://localhost:5432/messagesdb", "postgres", "password");

        return dataSource;
    }

    @Bean
    public MessagesDAO getMessagesDAO() {
        return new MessagesDAOImpl(getDataSource());
    }
}