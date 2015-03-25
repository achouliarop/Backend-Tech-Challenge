package com.tradeshift;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.tradeshift.service.HelloWorldInterface;
import com.tradeshift.service.HelloWorldService;

@Configuration
@ComponentScan({"com.tradeshift"})
public class AppConfig{

    @Bean(name = "helloWorldService")
    public HelloWorldInterface getHelloWorldService() {
        HelloWorldService helloWorldService = new HelloWorldService();

        return helloWorldService;
    }
}