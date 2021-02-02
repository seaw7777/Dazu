package com.web.dazu.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.dazu.model.Member;
import com.web.dazu.service.LoginService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
public class LoginController {

	@Autowired
	private LoginService service;
	
	@ApiOperation(value = "로그인 - 카카오  로그인 API로 Token 및 회원 정보 불러오기", response = Member.class)
	@RequestMapping("/login")
	public ResponseEntity<Member> login(@RequestParam(value = "code", required = false) String code) {
		String accessToken = null;
		Member member = new Member();
		System.out.println(code);
		try {
			accessToken = service.getAccessToken(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			member = service.getMemberInfoKAKAO(accessToken);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("controller : " + member.getAccessToken());
		System.out.println(member.getNickname());
		System.out.println(member.getProfileImage());
		System.out.println(member.getUsercode());
		
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	@ApiOperation(value = "로그아웃")
	@RequestMapping("/logout/{accessToken}")
	public void logout(@PathVariable String accessToken) {
		try {
			service.logout(accessToken);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

