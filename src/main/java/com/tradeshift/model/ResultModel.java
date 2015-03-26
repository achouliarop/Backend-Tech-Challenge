package com.tradeshift.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement
public class ResultModel {

    @XmlElement(name = "message")
    public void setMessage(Message content) {

        this.content = content;
    }

    public Message getMessage() {

        return content;
    }

    private Message content;
}