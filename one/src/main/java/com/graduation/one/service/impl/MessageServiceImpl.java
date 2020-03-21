package com.graduation.one.service.impl;

import com.graduation.one.dao.MessageDao;
import com.graduation.one.entity.Message;
import com.graduation.one.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Resource
    private MessageDao messageDao;

    @Override
    public Message queryMessageById(int id) {
        return messageDao.queryMessageById(id);
    }

    @Override
    public List<Message> queryMessageByType(int type) {
        return messageDao.queryMessageByType(type);
    }

    @Override
    public void updateMessageById(Message message) {
        messageDao.updateMessageById(message);
    }

    @Override
    public void addMessage(Message message) {
        messageDao.addMessage(message);
    }

    @Override
    public void deleteMessageById(int id) {
        messageDao.deleteMessageById(id);
    }
}
