package com.tradeshift.service;

import java.util.List;

import com.tradeshift.model.Message;

public interface MessagesDAO {
    public void insert(Message message);

    public List<Message> getMessages (int amount);

}
