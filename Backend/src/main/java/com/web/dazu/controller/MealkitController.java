package com.web.dazu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.dazu.model.Mealkit;
import com.web.dazu.service.MealkitService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/mealkit")
@RestController
public class MealkitController {
	
	@Autowired
	private MealkitService service;
	
	@ApiOperation(value = "밀키트 목록을 읽어온다.", response = Mealkit.class)
	@GetMapping("/list")
	public List<Mealkit> selectAllMealkit() {
		List<Mealkit> list = new ArrayList<>();
		try {
			list = service.selectAllMealkit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
