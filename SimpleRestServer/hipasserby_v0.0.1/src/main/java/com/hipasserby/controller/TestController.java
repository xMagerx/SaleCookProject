package com.hipasserby.controller;

import com.hipasserby.entity.Dialog;
import com.hipasserby.repository.UserRepository;
import com.hipasserby.request.FindOneByIdRequest;
import com.hipasserby.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserService userService;

    @PostMapping
    public List<Dialog>getDialogs(@RequestBody FindOneByIdRequest findOneByIdRequest){
        return userService.getUsersDialogs(findOneByIdRequest);
    }

}
