package com.web.dazu.controller;

import java.util.ArrayList;
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
import com.web.dazu.model.ClassReview;
import com.web.dazu.model.ClassTime;
import com.web.dazu.service.ClassService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/class")
public class ClassController {
	
	@Autowired
	private ClassService service;
	
	@ApiOperation(value = "행정동 별 클래스 정보를 읽어온다.", response = List.class)
	@GetMapping("/dong/{dong}")
	public ResponseEntity<List<Class>> selectAllClass(@PathVariable String dong) {
		List<Class> list = new ArrayList<Class>();
		try {
			list = service.selectAllClass(dong);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Class>>(list, HttpStatus.OK);
	}
	
	@ApiOperation(value = "클래스 상세 정보를 읽어온다.", response = Class.class)
	@GetMapping("/detail/{classcode}")
	public ResponseEntity<Class> selectClass(@PathVariable String classcode) {
		Class c = new Class();
		try {
			c = service.selectClass(classcode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Class>(c, HttpStatus.OK);
	}
	
	@ApiOperation(value = "클래스 일정(날짜, 시간 등) 정보를 읽어온다.", response = ClassTime.class)
	@GetMapping("/time/{classcode}")
	public ResponseEntity<ClassTime> selectClassTime(@PathVariable String classcode) {
		ClassTime ct = new ClassTime();
		try {
			ct = service.selectClassTime(classcode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<ClassTime>(ct, HttpStatus.OK);
	}
	
	@ApiOperation(value = "가게 별 등록된 모든 클래스 정보를 읽어온다.", response = List.class)
	@GetMapping("/store/{storecode}")
	public ResponseEntity<List<Class>> selectClassByStore(@PathVariable String storecode) {
		List<Class> list = new ArrayList<>();
		try {
			list = service.selectClassByStore(storecode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Class>>(list, HttpStatus.OK);
	}
	
	@ApiOperation(value = "클래스에 등록된 후기 목록을 읽어온다.", response = List.class)
	@GetMapping("/review/{classcode}")
	public ResponseEntity<List<ClassReview>> selectClassReview(@PathVariable String classcode) {
		List<ClassReview> list = new ArrayList<>();
		try {
			list = service.selectClassReview(classcode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<ClassReview>>(list, HttpStatus.OK);
	}
}
