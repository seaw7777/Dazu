package com.web.dazu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.dazu.model.Notice;
import com.web.dazu.service.NoticeService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/notice")
@RestController
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
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
}
