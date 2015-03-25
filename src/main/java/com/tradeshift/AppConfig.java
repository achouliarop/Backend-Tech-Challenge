package com.tradeshift;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.tradeshift.service.HelloWorldService;
import com.tradeshift.service.SpringHelloWorldService;

@Configuration
@ComponentScan({"com.tradeshift"})
public class AppConfig{

    @Bean(name = "helloWorldService")
    public HelloWorldService getHelloWorldService() {
        return new SpringHelloWorldService();
    }
}