package com.tradeshift;


import com.tradeshift.service.MessagesDAO;
import com.tradeshift.service.MessagesDAOImpl;
import org.junit.Test;

import javax.ws.rs.BadRequestException;

public class MessagesDAOImplTest {

    @Test(expected = BadRequestException.class)
    public void testIfNameIsNull() {
        MessagesDAO messagesDAO = new MessagesDAOImpl(null);
        messagesDAO.insert(null);
    }
}