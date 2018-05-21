package com.hipasserby.request;

import com.hipasserby.entity.Dialog;

public class CreateDialog {

    private Integer id;

    private Dialog dialog;

    public CreateDialog() {
    }

    public CreateDialog(Integer id, Dialog dialog) {
        this.id = id;
        this.dialog = dialog;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Dialog getDialog() {
        return dialog;
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public String toString() {
        return "CreateDialog{" +
                "id=" + id +
                ", dialog=" + dialog +
                '}';
    }
}
