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

    @Override
    public String getHelloWorldMessage(String name){

        return "hello " + name;
    }

    @Override
    public void insert(String name) {
        if(name == null && name.isEmpty()) {
            throw new NullPointerException("String is null or empty");
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
