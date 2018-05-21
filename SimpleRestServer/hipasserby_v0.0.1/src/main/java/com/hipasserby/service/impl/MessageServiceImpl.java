package com.hipasserby.service.impl;

import com.hipasserby.entity.Dialog;
import com.hipasserby.entity.Message;
import com.hipasserby.entity.User;
import com.hipasserby.repository.DialogRepository;
import com.hipasserby.repository.MessageRepository;
import com.hipasserby.request.FindOneByIdRequest;
import com.hipasserby.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private DialogRepository dialogRepository;

    private DialogServiceImpl dialogServiceImpl = new DialogServiceImpl();

    private UserServiceImpl userServiceImpl = new UserServiceImpl();

    @Override
    public List<Message> getMessages(FindOneByIdRequest findOneByIdRequest) {

        User user = userServiceImpl.findOne(findOneByIdRequest);
        List<Message> messages = user.getMessages();
        return messages;
    }

    @Override
    public List<Message> getMessages(Integer id) {
        User user = userServiceImpl.findOne(id);
        List<Message> messages = user.getMessages();
        return messages;
    }

    @Override
    public List<Message> getMessages() {
        return null;
    }


    @Override
    public List<Message> findMessagesByDialogId(Integer id,User user) {
        for(Message message: dialogRepository.findOne(id).getMessages()){
            if(message.getAuthor().getId()!=user.getId()) {
                if (message.getIsRead() == false) {
                    message.setIsRead(true);
                }
            }
            messageRepository.save(message);
        }
        return dialogRepository.findOne(id).getMessages();
    }

    @Override
    public Message findOne(Integer id) {
        return messageRepository.findOne(id);
    }

    @Override
    public Message findOne(FindOneByIdRequest findOneByIdRequest) {
        return messageRepository.findOne(findOneByIdRequest.getId());
    }

    @Override
    public Message getLastMessage(Integer id) {
//        System.out.println("1HELLOOOOOOOOOOOOOOOOOOOO HELLLOOOOOOOOOOOOOO");
//        List<Message> messages = findMessagesByDialogId(id);
//        System.out.println("2HELLOOOOOOOOOOOOOOOOOOOO HELLLOOOOOOOOOOOOOO");
//        Message message = messages.get(messages.size() - 1);
//        System.out.println("3HELLOOOOOOOOOOOOOOOOOOOO HELLLOOOOOOOOOOOOOO");
//        return message;
        return null;
    }

    @Override
    public void createMessage(Message message) {
        messageRepository.save(message);
    }

    @Override
    public boolean deleteMessage(Integer id) {
        messageRepository.delete(id);
        return true;
    }

    @Override
    public boolean deleteMessage(FindOneByIdRequest findOneByIdRequest) {
        messageRepository.delete(findOneByIdRequest.getId());
        return true;
    }
}
