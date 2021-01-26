package com.web.dazu.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.dazu.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService service;
	
	@PostMapping("/login")
	public HashMap<String, Object> login(@RequestParam(value = "code", required = false) String code) {
		
		String accessToken = service.getAccessToken(code);
		HashMap<String, Object> userInfo = service.getUserInfo(accessToken);
		userInfo.put("accessToken", accessToken);
		
		return userInfo;
	}
	
	@PostMapping
	public void logout(String accessToken) {
		service.logout(accessToken);
	}
}
