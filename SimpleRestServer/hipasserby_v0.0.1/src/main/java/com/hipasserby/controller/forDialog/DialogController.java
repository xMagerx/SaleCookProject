package com.hipasserby.controller.forDialog;

import com.hipasserby.editor.MessageEditor;
import com.hipasserby.editor.UserEditor;
import com.hipasserby.entity.Dialog;
import com.hipasserby.entity.Message;
import com.hipasserby.entity.User;
import com.hipasserby.request.FindOneByIdRequest;
import com.hipasserby.request.MyPageRequest;
import com.hipasserby.response.UserResponse;
import com.hipasserby.service.DialogService;
import com.hipasserby.service.MessageService;
import com.hipasserby.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/dialog")
public class DialogController {

    @Autowired
    private DialogService dialogService;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @InitBinder
    protected void initBinder1(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(User.class, new UserEditor(userService));
    }

    @InitBinder
    protected void initbinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(Message.class, new MessageEditor(messageService));
    }

    @PostMapping("users_dialog")
    public List<Dialog> getDialogs(@RequestBody FindOneByIdRequest findOneByIdRequest) {
        return userService.getUsersDialogs(findOneByIdRequest);
    }

    @GetMapping()
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Dialog> findAll() {
        return dialogService.findAll();
    }

    @PostMapping()
    @PreAuthorize("hasRole('ROLE_USER')")
    public Dialog findOne(@RequestBody FindOneByIdRequest findOneByIdRequest) {
        return dialogService.findOne(findOneByIdRequest);
    }

    @PutMapping("create_dialog")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Integer returnDialog(@RequestBody FindOneByIdRequest findOneByIdRequest) {
        System.out.println("Якщо нам попередній метод повернув null - починаємо збереження()створення нового діалогу!");
        User receiver = userService.findOne(findOneByIdRequest);
        System.out.println("Знайшли юзера "+ receiver.getFirstName()+" "+receiver.getLastName());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User sender = (User) auth.getPrincipal();
        System.out.println("Відправник повідомлення - "+ sender.getFirstName()+" "+sender.getLastName());
        return dialogService.save(receiver, sender);
    }

    @PostMapping("return_dialog")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Integer createDialog(@RequestBody FindOneByIdRequest findOneByIdRequest) {
        User receiver = userService.findOne(findOneByIdRequest);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User sender = (User) auth.getPrincipal();

        System.out.println("Довжина ліста діалогів юзера в контроллері - " + sender.getDialogs().size());

        try {
            for (Dialog dialog : sender.getDialogs()) {
                System.out.println("Довжина users в Controller - "+dialog.getUsers().size());
                for(User user: dialog.getUsers()){
                    System.out.println("Виводимо чергового юзера - "+user.getId());
                    System.out.println("Виводимо receiver-юзера - "+receiver.getId());
                    System.out.println("Заходимо для провірки цих юзерів!");

                    if (user.getId()==receiver.getId()) {
                        System.out.println("Повертаємо юзеру його діалог!");
                        return dialog.getId();
                    }
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            throw new ArrayIndexOutOfBoundsException(e.getMessage());
        }
        System.out.println("Повертаємо юзеру null!");
        return returnDialog(findOneByIdRequest);

    }

    @PostMapping("/users")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Dialog findTwoUsers(@RequestBody FindOneByIdRequest findOneByIdRequest) {

        return dialogService.findOne(findOneByIdRequest);
    }

    @GetMapping("/notification")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Integer findDialogByUsers() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        return dialogService.notification(user);
    }

}
