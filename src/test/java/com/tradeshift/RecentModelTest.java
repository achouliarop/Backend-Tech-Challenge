package com.tradeshift;

import com.tradeshift.model.Content;
import com.tradeshift.model.Message;
import com.tradeshift.model.RecentModel;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RecentModelTest {

    @Test
    public void addNoParameters(){

        RecentModel recentModel = new RecentModel();
        Assert.assertEquals(recentModel.getLastMessage(), new Timestamp(0));
        Assert.assertEquals(recentModel.getMessageCount(), 0);
        Assert.assertEquals(recentModel.getMessages().size(), 0);
    }

    @Test
    public void addAllParameters(){

        List<Message> messages = new ArrayList<>();
        messages.add(new Message(new Content("1")));
        messages.add(new Message(new Content("2")));

        RecentModel recentModel = new RecentModel(2, new Timestamp(0), messages);
        Assert.assertEquals(recentModel.getLastMessage(), new Timestamp(0));
        Assert.assertEquals(recentModel.getMessageCount(), 2);
        Assert.assertEquals(recentModel.getMessages().size(), 2);
    }
}
