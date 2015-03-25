package com.tradeshift.service;


public class SpringHelloWorldService implements HelloWorldService {


    @Override
    public String getHelloWorldMessage(String name){

        return "hello " + name;
    }
}
