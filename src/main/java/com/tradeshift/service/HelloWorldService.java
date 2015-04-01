package com.tradeshift.service;


import com.tradeshift.model.RecentModel;

public interface HelloWorldService {
    public String getHelloWorldMessage(String name);

    public void insert (String name);

    public RecentModel getMessages(int amount);
}
