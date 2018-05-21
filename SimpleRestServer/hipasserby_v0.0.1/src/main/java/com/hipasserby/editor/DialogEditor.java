package com.hipasserby.editor;

import com.hipasserby.entity.Dialog;
import com.hipasserby.service.DialogService;

import java.beans.PropertyEditorSupport;

public class DialogEditor extends PropertyEditorSupport {

    private final DialogService dialogService;

    public DialogEditor(DialogService dialogService) {
        this.dialogService = dialogService;
    }

    @Override
    public void setAsText(String s) throws IllegalArgumentException {
        Dialog dialog = dialogService.findOne(Integer.parseInt(s));
        setValue(dialog);
    }
}
