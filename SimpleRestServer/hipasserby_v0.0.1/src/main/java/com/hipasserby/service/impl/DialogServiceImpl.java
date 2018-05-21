package com.hipasserby.service.impl;

import com.hipasserby.entity.Dialog;
import com.hipasserby.entity.Message;
import com.hipasserby.entity.User;
import com.hipasserby.repository.DialogRepository;
import com.hipasserby.request.FindOneByIdRequest;
import com.hipasserby.service.DialogService;
import com.hipasserby.service.MessageService;
import com.hipasserby.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class DialogServiceImpl implements DialogService {

    @Autowired
    private DialogRepository dialogRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    UserServiceImpl userServiceImpl = new UserServiceImpl();

    @Override
    public Dialog findOne(FindOneByIdRequest findOneByIdRequest) {
        return dialogRepository.findOne(findOneByIdRequest.getId());
    }

    @Override
    public Dialog findOne(Integer id) {
        return dialogRepository.findOne(id);
    }

    @Override
    public boolean delete(Integer id) {
        dialogRepository.delete(id);
        return true;
    }

    @Override
    public Dialog createDialog(Dialog dialog) {
        return dialogRepository.save(dialog);
    }

    @Override
    public List<Dialog> findAll() {
//        for(Dialog dialog:dialogRepository.findAll()){
//            dialog.setDate(dialog.getMessages().get(dialog.getMessages().size()-1).getDateOfCreating());
//            dialog.setLastMessage(dialog.getMessages().get(dialog.getMessages().size()-1).getText());
//            dialogRepository.save(dialog);
//        }
//        List<Dialog> dialogs = dialogRepository.findAll();
//        Collections.sort(dialogs, new Comparator<Dialog>() {
//            public int compare(Dialog dialog1,Dialog dialog2) {
//                return dialog1.getDate().compareTo(dialog2.getDate());
//            }
//        });
//
//        return dialogs;
        return dialogRepository.findAll();
    }

    @Override
    public Dialog isThere(Integer id, Integer id2) {
        return null;
    }

    @Override
    public Dialog save(Dialog dialog) {
        return null;
    }

    @Override
    public Integer save(User receiver, User sender) {
        Dialog dialog = new Dialog();
        List<User> users = new ArrayList<User>();
        users.add(sender);
        users.add(receiver);
        dialog.setUsers(users);
        Message message1 = new Message();
        Message message2 = new Message();
        message1.setAuthor(sender);
        message1.setText("Added to dialog");
        message1.setDialog(dialog);
        message2.setDialog(dialog);
        message2.setAuthor(receiver);
        message2.setText("Added to dialog");
        dialogRepository.save(dialog);
        messageService.createMessage(message1);
        messageService.createMessage(message2);
        System.out.println("Діалог створено!Повертаємо його id");
        return dialog.getId();
    }

    @Override
    public Integer notification(User user) {
        FindOneByIdRequest findOneByIdRequest = new FindOneByIdRequest(user.getId());
        Integer count = 0;
//        do {
            for (Dialog dialog : userService.getUsersDialogs(findOneByIdRequest)) {
                for (Message message : dialog.getMessages()) {
                    if (message.getIsRead() == false) {
                        if (message.getAuthor().getId()!=user.getId()) {
                            count++;
                        }
                    }
                }
            }
            return count;
//        } while (true);
    }
}
