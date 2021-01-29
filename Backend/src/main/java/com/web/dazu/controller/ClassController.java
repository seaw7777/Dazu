package com.web.dazu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.dazu.model.Class;
import com.web.dazu.service.ClassService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/class")
public class ClassController {
	
	@Autowired
	private ClassService service;
	
	@ApiOperation(value = "행정동 별 클래스 정보를 읽어온다.", response = List.class)
	@GetMapping("/{dong}")
	public ResponseEntity<List<Class>> selectAllClass(@PathVariable String dong) {
		List<Class> list = new ArrayList<Class>();
		try {
			list = service.selectAllClass(dong);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Class>>(list, HttpStatus.OK);
	}
}
