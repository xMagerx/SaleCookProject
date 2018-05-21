package com.hipasserby.service;

import com.hipasserby.entity.Message;
import com.hipasserby.entity.User;
import com.hipasserby.request.FindOneByIdRequest;

import java.util.List;

public interface MessageService {

    List<Message> getMessages(FindOneByIdRequest findOneByIdRequest);

    List<Message> getMessages(Integer id);

    Message getLastMessage(Integer id);

    List<Message> getMessages();

    List<Message> findMessagesByDialogId(Integer id, User user);

    Message findOne(Integer id);

    Message findOne(FindOneByIdRequest findOneByIdRequest);

    void createMessage(Message message);

    boolean deleteMessage(Integer id);

    boolean deleteMessage(FindOneByIdRequest findOneByIdRequest);


}
