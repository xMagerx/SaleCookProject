package com.hipasserby.service.impl;

import com.hipasserby.dto.Base64MultipartFile;
import com.hipasserby.entity.User;
import com.hipasserby.repository.UserRepository;
import com.hipasserby.request.editUsersInformation.ContactInformationAboutUserRequest;
import com.hipasserby.request.editUsersInformation.EditUserPhotoRequest;
import com.hipasserby.request.editUsersInformation.EducationInformationAboutUserRequest;
import com.hipasserby.request.editUsersInformation.MainInformationAboutUserRequest;
import com.hipasserby.service.EditInformationAboutUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.*;

@Service
public class EditInformationAboutUserServiceImpl implements EditInformationAboutUserService {

    private final static String PATH = "D://project//hipasserby_v0.0.1//Photos";

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserById(int id) {
        return userRepository.findOne(id);
    }


    @Override
    public boolean saveUserPhoto(EditUserPhotoRequest editUserPhotoRequest, int id) throws IOException {

        User user = findUserById(id);

        user.setPhoto(editUserPhotoRequest.getPhoto());

        byte[]fileContent;
        BASE64Decoder decoder = new BASE64Decoder();
        fileContent = decoder.decodeBuffer(user.getPhoto().split(",")[1]);
        String expansion = user.getPhoto().split(",")[0].split("/")[1].split(";")[0];
        user.setPhoto(null);
        user = userRepository.saveAndFlush(user);
        Base64MultipartFile multipartFile =new Base64MultipartFile(fileContent,user.getId()+"."+expansion);
        saveFile(multipartFile);
        user.setPhoto("/images/"+user.getId()+"."+expansion);

        if(userRepository.save(user)!=null){
            return true;
        }
        else {
            throw  new IllegalArgumentException("Невідома помилка!");
        }

    }

    @Override
    public boolean saveMainInformation(MainInformationAboutUserRequest mainInformationAboutUserRequest, int id) throws IOException {

        User user = findUserById(id);

        mainInformationAboutUserRequest.setFirstName(includesOnlyLetters(mainInformationAboutUserRequest.getFirstName()));
        mainInformationAboutUserRequest.setLastName(includesOnlyLetters(mainInformationAboutUserRequest.getLastName()));

        if(mainInformationAboutUserRequest!=null & user!=null)
        {

            user.userEditMainInformation(mainInformationAboutUserRequest);

            userRepository.save(user);

            return true;
        }

        return false;

    }


    private void saveFile(MultipartFile file) throws FileNotFoundException, IOException {
        File pathToFolder = new File(PATH);
        createFolder(pathToFolder);
        File newFile = new File(pathToFolder + "/" + file.getOriginalFilename());
        writeFile(newFile, file);

    }

    private void createFolder(File path) {
        if (!path.exists()) {
            path.mkdirs();
        }
    }

    private void writeFile(File file, MultipartFile multipartFile) throws FileNotFoundException, IOException {
        try (OutputStream fos = new FileOutputStream(file); BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            bos.write(multipartFile.getBytes(), 0, multipartFile.getBytes().length);
            bos.flush();
        } catch (IOException e) {

        }
    }

    @Override
    public boolean saveEducationInformation(EducationInformationAboutUserRequest educationInformationAboutUserRequest,int id) {

        User user = findUserById(id);

        if(educationInformationAboutUserRequest!=null & user!=null)
        {
            user.userEditEducationInformation(educationInformationAboutUserRequest);

            userRepository.save(user);

            return true;
        }

        return false;
    }

    @Override
    public boolean saveContactInformation(ContactInformationAboutUserRequest contactInformationAboutUserRequest,int id) {

        User user = findUserById(id);

        if(contactInformationAboutUserRequest!=null & user!=null)
        {
            user.userEditContactInformation(contactInformationAboutUserRequest);

            userRepository.save(user);

            return true;
        }

        return false;
    }

    @Override
    public String includesOnlyLetters(String name) {

        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();

        char testChar;
        String testString;
        for (int i = 0; i < name.length(); i++) {

            testChar = name.charAt(i);
            testString = Character.toString(testChar);
            if (testString.matches("^[іІїЇa-zA-Zа-яА-Яа-яА-Я]+$")) {

            }
            else {
                throw new IllegalArgumentException("Слово може містити тільки букви!");
            }
        }
        return name;

    }
}
