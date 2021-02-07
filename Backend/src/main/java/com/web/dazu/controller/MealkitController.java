package com.web.dazu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@ApiOperation(value = "현재 사용자의 행정동에 해당하는 밀키트 목록을 읽어온다.", response = Mealkit.class)
	@GetMapping("/list/{dong}")
	public List<Mealkit> selectAllMealkit(@PathVariable String dong) {
		List<Mealkit> list = new ArrayList<>();
		try {
			list = service.selectAllMealkit(dong);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
