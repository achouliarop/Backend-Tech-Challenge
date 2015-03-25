package com.tradeshift.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement
public class ResultModel {

    @XmlElement(name = "Message")
    public void setMessage(MessageModel content) {

        this.content = content;
    }

    public MessageModel getMessage() {

        return content;
    }

    private MessageModel content;
}