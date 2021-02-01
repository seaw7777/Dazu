package com.web.dazu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.dazu.model.Member;
import com.web.dazu.service.LoginService;
import com.web.dazu.service.MemberService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/member")
@RestController
public class MemberController {
	
	@Autowired
	private MemberService service;
	@Autowired
	private LoginService loginService;
	
	@ApiOperation(value = "현재 KAKAO 연동 로그인된 회원 정보 읽는다.", response = Member.class)
	@GetMapping("/selectMember/{id}")
	public ResponseEntity<Member> selectMember(String id) {
		Member member = new Member();
		try {
			member = service.selectMember(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	@ApiOperation(value = "현재 KAKAO 연동 로그인된 회원 정보에 추가 정보(주소:address, address_detail)를 붙여 등록한다.")
	@PostMapping("/insertMember")
	public void insertMember(@RequestBody Member member) {
		try {
			service.insertMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ApiOperation(value = "현재 KAKAO 연동 로그인된 회원 정보(유저 이름, 주소)를 수정한다.")
	@PutMapping("/updateMember")
	public void updateMember(@RequestBody Member member) {
		try {
			service.updateMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ApiOperation(value = "현재 KAKAO 연동 계정에 대한 연결을 끊고, DB를 삭제한다.")
	@DeleteMapping("/deleteMember/{id}/{accessToken}") 
	public void deleteMember(@PathVariable String id, @PathVariable String accessToken) {
		
		try {
			// DB 삭제
			service.deleteMember(id);
			// KAKAO 연결 끊기
			service.unlink(accessToken);
			// 로그아웃 (토큰 만료)
			loginService.logout(accessToken);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
