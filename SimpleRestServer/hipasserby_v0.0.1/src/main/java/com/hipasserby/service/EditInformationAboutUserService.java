package com.hipasserby.service;

import com.hipasserby.entity.User;
import com.hipasserby.request.editUsersInformation.ContactInformationAboutUserRequest;
import com.hipasserby.request.editUsersInformation.EditUserPhotoRequest;
import com.hipasserby.request.editUsersInformation.EducationInformationAboutUserRequest;
import com.hipasserby.request.editUsersInformation.MainInformationAboutUserRequest;

import java.io.IOException;

public interface EditInformationAboutUserService {

    User findUserById(int id);

    boolean saveUserPhoto(EditUserPhotoRequest editUserPhotoRequest,int id) throws IOException;

    boolean saveMainInformation(MainInformationAboutUserRequest mainInformationAboutUserRequest, int id) throws IOException;

    boolean saveEducationInformation(EducationInformationAboutUserRequest educationInformationAboutUserRequest,int id);

    boolean saveContactInformation(ContactInformationAboutUserRequest contactInformationAboutUserRequestint, int id);

    String includesOnlyLetters(String name);
}
