package com.tradeshift;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement
public class ResultModel {

    @XmlElement(name = "Message")
    public void setMsg(String content) {

        this.content = content;
    }

    public String getMsg() {

        return content;
    }

    private String content;
}