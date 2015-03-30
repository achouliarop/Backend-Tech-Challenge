package com.tradeshift;


import com.tradeshift.model.DBMessage;
import junit.framework.Assert;
import org.junit.Test;

import java.sql.Timestamp;

public class DBMessageTest {

    @Test
    public void testIfMembersAreReturnedCorrectly() {
        String name = "Taso";
        Timestamp date = new Timestamp(1);

        DBMessage dbMessage = new DBMessage(name, date);
        Assert.assertEquals(name, dbMessage.getName());
        Assert.assertEquals(date, dbMessage.getDate());
    }

    @Test
    public void testIfMembersAreSetCorrectly() {
        String name = "Taso";
        Timestamp date = new Timestamp(1);

        DBMessage dbMessage = new DBMessage();
        dbMessage.setName(name);
        Assert.assertEquals(name, dbMessage.getName());

        dbMessage.setDate(date);
        Assert.assertEquals(date, dbMessage.getDate());
    }
}
