package com.tradeshift.service;

import java.util.List;

import com.tradeshift.model.DBMessage;

public interface MessagesDAO {

    public void insert(String name);

    public List<DBMessage> getMessages (int amount);

}
