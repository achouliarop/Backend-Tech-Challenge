package com.tradeshift.service;


public class HelloWorldService implements HelloWorldInterface {


    @Override
    public String getHelloMsg(String name){

        return "hello " + name;
    }
}
