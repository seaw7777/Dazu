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

import com.web.dazu.model.Store;
import com.web.dazu.service.StoreService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/map")
@RestController
public class StoreController {
	
	@Autowired
	private StoreService service;
	
	@ApiOperation(value = "현재 로그인된 회원의 행정동에 위치하는 모든 가게 정보 불러오기", response = List.class)
	@GetMapping("/{dong}")
	public ResponseEntity<List<Store>> selectAllStore(@PathVariable String dong) {
		
		List<Store> list = new ArrayList<Store>();
		try {
			list = service.selectAllStore(dong);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<List<Store>>(list, HttpStatus.OK);
	}
}
