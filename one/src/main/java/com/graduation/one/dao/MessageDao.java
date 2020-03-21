package com.graduation.one.dao;

import com.graduation.one.entity.Message;

import java.util.List;

public interface MessageDao {

    Message queryMessageById(int id);

    List<Message> queryMessageByType(int type  );

    void updateMessageById(Message message);

    void addMessage(Message message);

    void deleteMessageById(int id);
}
