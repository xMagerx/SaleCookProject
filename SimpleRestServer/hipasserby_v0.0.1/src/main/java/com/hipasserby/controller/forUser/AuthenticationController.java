package com.hipasserby.controller.forUser;

import com.fasterxml.jackson.annotation.JsonView;
import com.hipasserby.dto.TokenModel;
import com.hipasserby.entity.User;
import com.hipasserby.entity.enums.Flag;
import com.hipasserby.repository.UserRepository;
import com.hipasserby.request.LoginRequest;
import com.hipasserby.security.TokenUtils;
import com.hipasserby.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/login")
public class AuthenticationController {


	@Value("${lgs.token.header}")
	private String tokenHeader;
	
	@Autowired 
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@PostMapping
	public TokenModel authenticationRequest(@RequestBody LoginRequest loginRequest ){
		User user = userService.findByEmail(loginRequest.getEmail());

		if(user.getPassword().equals(loginRequest.getPassword())&user.getFlag().ordinal() == 0) {
			Authentication authentication = this.authenticationManager
					.authenticate
							(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			UserDetails userDetails =
					this.userDetailsService.loadUserByUsername(loginRequest.getEmail());
			String token = this.tokenUtils.generateToken(userDetails);
			TokenModel tokenModel = new TokenModel("A-Token", token);
			return tokenModel;
		}else{
			throw new IllegalArgumentException("Неавторизовано!");
		}
	}

	@GetMapping
	@PreAuthorize("hasRole('ROLE_USER')")
	public User getUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		return user;
	}


//
//	public String authenticationRequest(String email, String password) {
//		Authentication authentication = this.authenticationManager
//				.authenticate
//						(new UsernamePasswordAuthenticationToken(email,password));
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		UserDetails userDetails =
//				this.userDetailsService.loadUserByUsername(email);
//		String token = this.tokenUtils.generateToken(userDetails);
//		return token;
//	}
}
