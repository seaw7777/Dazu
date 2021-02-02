package com.web.dazu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.dazu.model.Member;
import com.web.dazu.model.Notice;
import com.web.dazu.service.NoticeService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/notice")
@RestController
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	@ApiOperation(value = "등록된 모든 공지사항을 읽는다.", response = List.class)
	@GetMapping("/list")
	public List<Notice> selectAllNotice() {
		List<Notice> list = new ArrayList<Notice>();
		try {
			list = service.selectAllNotice();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}	
	
	@ApiOperation(value = "새로운 공지사항을 등록한다.")
	@PostMapping("/insert")
	public void insertNotice(@RequestBody Notice notice) {
		try {
			service.insertNotice(notice);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
