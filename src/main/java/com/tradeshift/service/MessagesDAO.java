package com.tradeshift.service;

import java.util.List;

import com.tradeshift.model.Message;
import com.tradeshift.model.ResultModel;

public interface MessagesDAO {
    public void insert(Message message);

    public List<ResultModel> getMessages (int amount);

}
