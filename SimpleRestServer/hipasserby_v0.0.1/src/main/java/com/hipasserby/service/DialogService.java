package com.hipasserby.service;

import com.hipasserby.entity.Dialog;
import com.hipasserby.entity.User;
import com.hipasserby.request.FindOneByIdRequest;

import java.util.List;

public interface DialogService {

    Dialog findOne(FindOneByIdRequest findOneByIdRequest);

    Dialog findOne(Integer id);

    Dialog isThere(Integer id, Integer id2);

    boolean delete(Integer id);

    Dialog createDialog(Dialog dialog);

    List<Dialog> findAll();

    Dialog save(Dialog dialog);

    Integer save(User receiver,User sender);

    Integer notification(User user);
}
