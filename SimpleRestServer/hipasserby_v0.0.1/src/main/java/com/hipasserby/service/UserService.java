package com.hipasserby.service;

import com.hipasserby.entity.Dialog;
import com.hipasserby.entity.Message;
import com.hipasserby.entity.User;
import com.hipasserby.request.*;
import com.hipasserby.response.UserResponse;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.mail.MailException;


import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public interface UserService {

	boolean signUp(RegisterUserRequest registerUserRequest) throws MailException, MessagingException;
	
	boolean login(LoginRequest loginRequest);

	User saveUser(User user);
	
	boolean delete(Integer id);

	List<User> findAll();

	List<User> findAll(SearchingRequest searchingRequest);

	Page<UserResponse> findAll(MyPageRequest page);

	User findOne(FindOneByIdRequest findOneByIdRequest);

	User findOne(Integer id);

	List<Dialog> getUsersDialogs(FindOneByIdRequest findOneByIdRequest);

	List<Message> getUsersMessage(FindOneByIdRequest findOneByIdRequest);

	User findGet(FindOneByIdRequest findOneByIdRequest);

	boolean editUserFlag(ActivationUserRequest activationUserRequest);

	User findByEmail(String email);

	//Метод перевіряє, чи ім'я містить тільки букви латині та кириллиці,
	//та перевіряє правильність написання Ім'я(Велика буква перша а решту малі!)
	//Якщо користувач ввів ім'я тільки буквами але у верблюжому стилі, або з малої літери
	//метод виправляє це!
	boolean includesOnlyLetters(String set,RegisterUserRequest registerUserRequest);

	boolean emailForm(RegisterUserRequest registerUserRequest);

	String emailMessageForActivationAccount(RegisterUserRequest registerUserRequest);





}
