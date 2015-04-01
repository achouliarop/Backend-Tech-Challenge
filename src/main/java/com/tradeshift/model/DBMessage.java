package com.tradeshift.model;


import java.sql.Timestamp;

public class DBMessage {

    private String name;
    private Timestamp date;

    public DBMessage () {
        this.name = null;
        this.date = null;
    }

    public DBMessage(String name, Timestamp date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
