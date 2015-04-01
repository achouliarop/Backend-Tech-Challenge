package com.tradeshift.model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {

    @XmlElement(name = "message")
    private Content content;

    public Message() {

    }

    public Message(Content content) {
        this.content = content;
    }

    public Content getMessage() {

        return this.content;
    }

    public void setMessage(Content content) {
        this.content = content;
    }
}