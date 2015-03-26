package com.tradeshift.service;


import org.springframework.beans.factory.annotation.Autowired;

public class SpringHelloWorldService implements HelloWorldService {


    @Override
    public String getHelloWorldMessage(String name){

        return "hello " + name;
    }
}
