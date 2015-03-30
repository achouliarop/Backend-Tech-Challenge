package com.tradeshift.resources;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
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
        String addr = System.getenv("DB_PORT_5432_TCP_ADDR");
        String port = System.getenv("DB_PORT_5432_TCP_PORT");
        if (addr == null || port == null) {
            throw new IllegalArgumentException("Can not connect to postgress using variables  "  + "\n env:" + System.getenv());
        }

        SimpleDriverDataSource dataSource = new SimpleDriverDataSource(new org.postgresql.Driver(), "jdbc:postgresql://"+ addr+":"+port+ "/messagesdb", "messagesdb", "password");
        String sql = "DROP TABLE IF EXISTS message;\n" +
                "\n" +
                "CREATE TABLE message\n" +
                "(\n" +
                "  message_id serial NOT NULL,\n" +
                "  name text NOT NULL,\n" +
                "  date timestamp without time zone DEFAULT now(),\n" +
                "  CONSTRAINT message_pkey PRIMARY KEY (message_id)\n" +
                ")";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql);

        return dataSource;
    }

    @Bean(name = "messagesDAO")
    public MessagesDAO getMessagesDAO() {
        return new MessagesDAOImpl(getDataSource());
    }
}