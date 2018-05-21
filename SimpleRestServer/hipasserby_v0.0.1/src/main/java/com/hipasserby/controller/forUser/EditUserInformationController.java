package com.hipasserby.controller.forUser;

import com.hipasserby.editor.DialogEditor;
import com.hipasserby.entity.Dialog;
import com.hipasserby.entity.User;
import com.hipasserby.repository.UserRepository;
import com.hipasserby.request.editUsersInformation.ContactInformationAboutUserRequest;
import com.hipasserby.request.editUsersInformation.EditUserPhotoRequest;
import com.hipasserby.request.editUsersInformation.EducationInformationAboutUserRequest;
import com.hipasserby.request.editUsersInformation.MainInformationAboutUserRequest;
import com.hipasserby.service.DialogService;
import com.hipasserby.service.EditInformationAboutUserService;
import com.hipasserby.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
public class EditUserInformationController {

    @Autowired
    private UserService userService;

    @Autowired
    private EditInformationAboutUserService editInformationAboutUserService;


    @PutMapping("/edit/photo")
    @PreAuthorize("hasRole('ROLE_USER')")
    public boolean editPhoto(@RequestBody EditUserPhotoRequest editUserPhotoRequest) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        return editInformationAboutUserService.saveUserPhoto(editUserPhotoRequest,user.getId());
    }

    @PutMapping("/edit/main_information")
    @PreAuthorize("hasRole('ROLE_USER')")
    public boolean editMainInformation(@RequestBody MainInformationAboutUserRequest mainInformationAboutUserRequest) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        return editInformationAboutUserService.saveMainInformation(mainInformationAboutUserRequest,user.getId());
    }

    @PutMapping("/edit/education_information")
    @PreAuthorize("hasRole('ROLE_USER')")
    public boolean editEducationInformation(@RequestBody EducationInformationAboutUserRequest educationInformationAboutUserRequest){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        return editInformationAboutUserService.saveEducationInformation(educationInformationAboutUserRequest,user.getId());
    }

    @PutMapping("/edit/contact_information")
    @PreAuthorize("hasRole('ROLE_USER')")
    public boolean editContactInformation(@RequestBody ContactInformationAboutUserRequest contactInformationAboutUserRequest){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        return editInformationAboutUserService.saveContactInformation(contactInformationAboutUserRequest,user.getId());
    }





}
