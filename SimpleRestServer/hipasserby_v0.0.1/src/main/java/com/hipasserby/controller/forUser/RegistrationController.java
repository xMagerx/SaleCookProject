package com.hipasserby.controller.forUser;

import com.hipasserby.editor.DialogEditor;
import com.hipasserby.editor.UserEditor;
import com.hipasserby.entity.Dialog;
import com.hipasserby.entity.User;
import com.hipasserby.request.ActivationUserRequest;
import com.hipasserby.request.RegisterUserRequest;
import com.hipasserby.service.DialogService;
import com.hipasserby.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
public class RegistrationController {

    private AuthenticationController authenticationController;

    @Autowired
    private UserService userService;


    @GetMapping("/signup_message")
    public String signUp(){
        return "Повідомлення з підтвердженням відправлено на вашу email-адресу!";
    }


    @PutMapping("/signup")
    public boolean signUp (@RequestBody RegisterUserRequest registerUserRequest){
        try{
            userService.signUp(registerUserRequest);
            return true;
        }catch (MailException e){
            System.out.println("Error send email!");
            System.out.println(e);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return false;
    }

    @PostMapping("/signup/activation")
    public boolean activation(@RequestBody ActivationUserRequest activationUserRequest){
        if(userService.editUserFlag(activationUserRequest)){
            return true;
        }

        return false;
    }








}
