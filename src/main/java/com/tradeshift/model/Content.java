package com.tradeshift.model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Content {

    @XmlElement(name = "content")
    private String content;

    public Content() {

    }

    public Content(String content) {

        this.content = content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
