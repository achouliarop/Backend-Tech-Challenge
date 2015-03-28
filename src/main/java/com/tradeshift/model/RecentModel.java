package com.tradeshift.model;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RecentModel {

    private int messageCount;
    private Timestamp lastMessage;
    private List<Message> messages;

    public RecentModel() {

        this.messageCount = 0;
        this.lastMessage = null;
        this.messages = new ArrayList<>();
    }

    public RecentModel(int messageCount, Timestamp lastMessage, List<Message> messages) {
        this.messageCount = messageCount;
        this.lastMessage = lastMessage;
        this.messages = messages;
    }

    public void setMessageCount(int messageCount) {

        this.messageCount = messageCount;
    }

    public void setLastMessage(Timestamp lastMessage) {

        this.lastMessage = lastMessage;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public int getMessageCount() {
        return messageCount;
    }

    public Timestamp getLastMessage() {

        return lastMessage;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
