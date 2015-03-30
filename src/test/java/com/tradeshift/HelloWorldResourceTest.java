package com.tradeshift;


import com.tradeshift.model.DBMessage;
import com.tradeshift.model.Message;
import com.tradeshift.resources.HelloWorldResource;
import com.tradeshift.service.HelloWorldService;
import com.tradeshift.service.HelloWorldServiceImpl;
import com.tradeshift.service.MessagesDAO;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class HelloWorldResourceTest {

    private MessagesDAO mockMessagesDAO;
    private HelloWorldService mockHelloWorldService;
    private HelloWorldResource helloWorldResource;

    @Before
    public void SetUp() {
        this.mockMessagesDAO = mock(MessagesDAO.class);
        this.mockHelloWorldService = mock(HelloWorldService.class);
        this.helloWorldResource = new HelloWorldResource(mockHelloWorldService);

        when(this.mockHelloWorldService.getHelloWorldMessage("Taso")).thenReturn("hello Taso");
    }

    @Test
    public void test_returnTenResults() {

        MessagesDAO mockMessagesDAO = mock(MessagesDAO.class);
        List<DBMessage> mockMessagesList = new ArrayList<>();

        for (int i=0; i< 10; i++) {
            mockMessagesList.add(new DBMessage("Taso",new Timestamp(0)));
        }
        when(mockMessagesDAO.getMessages(10)).thenReturn(mockMessagesList);

        HelloWorldService helloWorldService = new HelloWorldServiceImpl(mockMessagesDAO);
        HelloWorldResource helloWorldResource = new HelloWorldResource(helloWorldService);
        List<Message> getMessages = helloWorldResource.getMessages().getMessages();
        Assert.assertEquals(getMessages.size(), 10);
        Assert.assertNotNull(helloWorldResource.getMessages());
        Assert.assertEquals(helloWorldResource.getMessages().getMessageCount(), 10);
        Assert.assertEquals(helloWorldResource.getMessages().getLastMessage(), new Timestamp(0));
    }

    @Test
    public void test_returnNoResults() {
        MessagesDAO mockMessagesDAO = mock(MessagesDAO.class);
        when(mockMessagesDAO.getMessages(10)).thenReturn(new ArrayList<DBMessage>());
        HelloWorldService helloWorldService = new HelloWorldServiceImpl(mockMessagesDAO);
        HelloWorldResource helloWorldResource = new HelloWorldResource(helloWorldService);
        List<Message> getMessages = helloWorldResource.getMessages().getMessages();
        Assert.assertEquals(getMessages.size(), 0);
        Assert.assertEquals(new Timestamp(0), helloWorldResource.getMessages().getLastMessage());
        Assert.assertEquals(helloWorldResource.getMessages().getMessageCount(), 0);
    }

    @Test
    public void test_insertNameSuccessfully() {
/*        MessagesDAO mockMessagesDAO = mock(MessagesDAO.class);
        HelloWorldService helloWorldService = new HelloWorldServiceImpl(mockMessagesDAO);
        helloWorldService.insert("Anastasios");
        verify(mockMessagesDAO).insert(eq("Anastasios"));*/

        MessagesDAO mockMessagesDAO = mock(MessagesDAO.class);
        HelloWorldService helloWorldService = new HelloWorldServiceImpl(mockMessagesDAO);
        HelloWorldResource helloWorldResource = new HelloWorldResource(helloWorldService);
        Message message = helloWorldResource.insertNameToDB("Taso");
        Assert.assertEquals("hello Taso", message.getMessage().getContent());
    }

    @Test
    public void test_insertNullName() {
        Message message = helloWorldResource.insertNameToDB(null);
        Assert.assertEquals(message.getMessage().getContent(), null);
        verify(this.mockMessagesDAO, never()).insert(any(String.class));
    }
}
