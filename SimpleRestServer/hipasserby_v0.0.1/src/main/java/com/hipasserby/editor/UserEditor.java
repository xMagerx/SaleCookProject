package com.hipasserby.editor;

import com.hipasserby.entity.Dialog;
import com.hipasserby.entity.User;
import com.hipasserby.service.DialogService;
import com.hipasserby.service.UserService;

import java.beans.PropertyEditorSupport;

public class UserEditor extends PropertyEditorSupport{

    private final UserService userService;

    public UserEditor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void setAsText(String s) throws IllegalArgumentException {
        User user = userService.findOne(Integer.parseInt(s));
        setValue(user);
    }
}
