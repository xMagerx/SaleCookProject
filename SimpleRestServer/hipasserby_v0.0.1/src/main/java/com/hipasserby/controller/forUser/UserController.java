package com.hipasserby.controller.forUser;

import com.hipasserby.editor.DialogEditor;
import com.hipasserby.entity.Dialog;
import com.hipasserby.entity.User;
import com.hipasserby.request.*;
import com.hipasserby.response.UserResponse;
import com.hipasserby.service.DialogService;
import com.hipasserby.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	
	@PostMapping("/page")
	@PreAuthorize("hasRole('ROLE_USER')")
	public Page<UserResponse> users(@RequestBody MyPageRequest myPageRequest){
		return userService.findAll(myPageRequest);
	}

	@PostMapping("/search")
	@PreAuthorize("hasRole('ROLE_USER')")
	public List<User> users(@RequestBody SearchingRequest searchingRequest){
		return userService.findAll(searchingRequest);
	}

	@DeleteMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public boolean delete(@RequestBody DeleteUserRequest request){
		return userService.delete(request.getId());
	}


	@PostMapping
	@PreAuthorize("hasRole('ROLE_USER')")
	public User findOne(@RequestBody FindOneByIdRequest findOneByIdRequest){
		return userService.findOne(findOneByIdRequest);
	}

	@PutMapping
	@PreAuthorize("hasRole('ROLE_USER')")
	public User findOne(@RequestBody User user){
		return userService.saveUser(user);
	}

}
