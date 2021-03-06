package com.tradeshift.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tradeshift.model.Content;
import com.tradeshift.model.DBMessage;
import com.tradeshift.model.Message;
import com.tradeshift.model.RecentModel;

public class HelloWorldServiceImpl implements HelloWorldService {

    @Autowired
    private MessagesDAO messagesDAO;

    public HelloWorldServiceImpl() {
    }

    public HelloWorldServiceImpl(MessagesDAO messagesDAO) {
        this.messagesDAO = messagesDAO;
    }

    @Override
    public String getHelloWorldMessage(String name) throws IllegalArgumentException{

        if(name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name can not be null or empty");
        }
        return "hello " + name;
    }

    @Override
    public void insert(String name) {
        if(name.isEmpty()) {
            throw new IllegalArgumentException("String is null or empty");
        }
        this.messagesDAO.insert(name);
    }

    @Override
    public RecentModel getMessages(int amount) {

        List<DBMessage> retrievedMessages = messagesDAO.getMessages(10);

        if (retrievedMessages.size() > 0) {

            List<Message> messages = new ArrayList<>();
            for (DBMessage temp : retrievedMessages) {
                messages.add(new Message(new Content(getHelloWorldMessage(temp.getName()))));
            }

            RecentModel recentModel = new RecentModel();
            recentModel.setMessageCount(retrievedMessages.size());  // set messages count
            recentModel.setLastMessage(retrievedMessages.get(retrievedMessages.size()-1).getDate());    // set the date of the last message, it's sorted in the SQL query so its the last entry of the list
            recentModel.setMessages(messages);

            return recentModel;
        }
        else return new RecentModel();
    }
}
