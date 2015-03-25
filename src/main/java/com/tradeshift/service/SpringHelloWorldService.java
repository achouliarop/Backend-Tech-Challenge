package com.tradeshift.service;


public class SpringHelloWorldService implements HelloWorldService {


    @Override
    public String getHelloMsg(String name){

        return "hello " + name;
    }
}
