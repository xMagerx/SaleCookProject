package com.hipasserby.controller.forMessage;

import com.hipasserby.editor.DialogEditor;
import com.hipasserby.editor.UserEditor;
import com.hipasserby.entity.Dialog;
import com.hipasserby.entity.Message;
import com.hipasserby.entity.User;
import com.hipasserby.request.FindOneByIdRequest;
import com.hipasserby.service.DialogService;
import com.hipasserby.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/message")
public class MessageController {


    @Autowired
    private MessageService messageService;

    @Autowired
    private DialogService dialogService;

    @InitBinder
    protected void initBinder(WebDataBinder webDataBinder){
        webDataBinder.registerCustomEditor(Dialog.class,new DialogEditor(dialogService));
    }

    @PostMapping
    public List<Message> findByDialogId(@RequestBody FindOneByIdRequest findOneByIdRequest){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        Dialog dialog = dialogService.findOne(findOneByIdRequest);
        List<Message> messages = messageService.findMessagesByDialogId(dialog.getId(),user);
        return messages;
    }

    @PostMapping("/last_message")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Message getLastMessage(@RequestBody FindOneByIdRequest findOneByIdRequest){
        System.out.println(findOneByIdRequest.getId());
        return messageService.getLastMessage(findOneByIdRequest.getId());
    }

    @PutMapping("/create")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Message createMessage(@RequestBody Message message){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        message.setAuthor(user);
        messageService.createMessage(message);
        Dialog dialog = message.getDialog();
        List<Message> messages = dialog.getMessages();
        return message;
    }


}
