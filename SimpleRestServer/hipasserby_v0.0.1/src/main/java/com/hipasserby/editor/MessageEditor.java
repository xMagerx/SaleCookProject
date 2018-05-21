package com.hipasserby.editor;

import com.hipasserby.entity.Message;
import com.hipasserby.service.MessageService;

import java.beans.PropertyEditorSupport;

public class MessageEditor extends PropertyEditorSupport {

    private final MessageService messageService;

    public MessageEditor(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void setAsText(String s) throws IllegalArgumentException {
        Message message = messageService.findOne(Integer.parseInt(s));
        setValue(message);
    }
}
