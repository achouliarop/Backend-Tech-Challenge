package com.tradeshift;


import com.tradeshift.model.DBMessage;
import com.tradeshift.model.Message;
import com.tradeshift.service.HelloWorldService;
import com.tradeshift.service.HelloWorldServiceImpl;
import com.tradeshift.service.MessagesDAO;
import junit.framework.Assert;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class HelloWorldServiceImplTest {

    @Test
    public void test_getTenResultsFromDatabase() {
        MessagesDAO mockMessagesDAO = mock(MessagesDAO.class);
        List<DBMessage> mockMessagesList = new ArrayList<>();

        for (int i=0; i< 10; i++) {
            mockMessagesList.add(new DBMessage("Taso",new Timestamp(0)));
        }
        when(mockMessagesDAO.getMessages(10)).thenReturn(mockMessagesList);

        HelloWorldService helloWorldService = new HelloWorldServiceImpl(mockMessagesDAO);
        List<Message> getMessages = helloWorldService.getMessages(10).getMessages();
        Assert.assertEquals(getMessages.size(), 10);
    }

    @Test
    public void test_getNoResultsFromDatabase() {
        MessagesDAO mockMessagesDAO = mock(MessagesDAO.class);
        when(mockMessagesDAO.getMessages(10)).thenReturn(new ArrayList<DBMessage>());
        HelloWorldService helloWorldService = new HelloWorldServiceImpl(mockMessagesDAO);
        List<Message> getMessages = helloWorldService.getMessages(10).getMessages();
        Assert.assertEquals(getMessages.size(), 0);
    }

    @Test
    public void test_insertNameSuccessfully() {
        MessagesDAO mockMessagesDAO = mock(MessagesDAO.class);
        HelloWorldService helloWorldService = new HelloWorldServiceImpl(mockMessagesDAO);
        helloWorldService.insert("Anastasios");
        verify(mockMessagesDAO).insert(eq("Anastasios"));
    }

    @Test
    public void test_insertNullName() {
        MessagesDAO mockMessagesDAO = mock(MessagesDAO.class);
        HelloWorldService helloWorldService = new HelloWorldServiceImpl(mockMessagesDAO);

        try {
            helloWorldService.insert(null);
            Assert.assertTrue(false);
        } catch (NullPointerException e) {
            Assert.assertTrue(true);
        }
    }
}
