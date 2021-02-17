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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.web.dazu.model.Store;
import com.web.dazu.service.FileUploadService;
import com.web.dazu.service.StoreService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/store")
@RestController
public class StoreController {
	
	@Autowired
	private StoreService service;
	@Autowired
	private FileUploadService fileuploadservice;
	@ApiOperation(value = "현재 로그인된 회원의 행정동에 위치하는 모든 가게 정보를 불러온다.", response = List.class)
	@GetMapping("list/{dong}")
	public ResponseEntity<List<Store>> selectAllStore(@PathVariable String dong) {
		
		List<Store> list = new ArrayList<Store>();
		try {
			list = service.selectAllStore(dong);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<List<Store>>(list, HttpStatus.OK);
	}
	
	@ApiOperation(value = "사장님 계정으로 회원가입할 때, 새로운 가게 정보를 등록한다.")
	@PostMapping("/insert")
	public void insertStore(@RequestPart(value = "files", required = true) List<MultipartFile> file,
			@RequestPart(value = "key", required = true) Store store) {
		try {
			service.insertStore(file,store);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ApiOperation(value = "특정 가게 정보를 불러온다. - 사장님 마이페이지", response = Store.class)
	@GetMapping("detail/{usercode}")
	public ResponseEntity<Store> selectStore(@PathVariable String usercode) {
		Store store = new Store();
		try {
			store = service.selectStore(usercode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Store>(store, HttpStatus.OK);
	}
	
	@ApiOperation(value = "가게 이름을 변경한다.")
	@PutMapping("/update/name") 
	public void updateStoreName(@RequestBody Store store) {
		try {
			service.updateStoreName(store);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ApiOperation(value = "가게 주소를 변경한다.")
	@PutMapping("/update/address")
	public void updateStoreAddress(@RequestBody Store store) {
		try {
			service.updateStoreAddress(store);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ApiOperation(value = "가게 상세정보를 변경한다.")
	@PutMapping("/update/detail")
	public void updateStoreDetail(@RequestPart(value = "file", required = true) MultipartFile file,
			@RequestPart(value = "key", required = false) Store store) {
		try {
			service.updateStoreAddress(store);
			fileuploadservice.updateStoreDetail(store.getStorecode(),file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
