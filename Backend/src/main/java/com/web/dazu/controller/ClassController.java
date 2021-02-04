package com.web.dazu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.dazu.model.Class;
import com.web.dazu.model.ClassNotice;
import com.web.dazu.model.ClassReview;
import com.web.dazu.model.ClassRoom;
import com.web.dazu.model.ClassTime;
import com.web.dazu.service.ClassService;
import com.web.dazu.service.StoreService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/class")
public class ClassController {
	
	@Autowired
	private ClassService service;
	@Autowired
	private StoreService storeService;
	
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
	
	@ApiOperation(value = "클래스에 등록된 공지사항 목록을 읽어온다.", response = List.class)
	@GetMapping("/notice/{classcode}")
	public ResponseEntity<List<ClassNotice>> selectClassNotice(@PathVariable String classcode) {
		List<ClassNotice> list = new ArrayList<>();
		try {
			list = service.selectClassNotice(classcode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<ClassNotice>>(list, HttpStatus.OK);
	}
	@ApiOperation(value = "클래스 공지 상세보기",response = ClassNotice.class)
	@GetMapping("/noticedetail/{class_notice_board_code}")
	public ResponseEntity<ClassNotice> selectClassNoticeDetail(@PathVariable String class_notice_board_code) {
		ClassNotice classnotice = new ClassNotice();
		try {
			classnotice = service.selectClassNoticeDetail(class_notice_board_code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<ClassNotice>(classnotice, HttpStatus.OK);
	}
	
	@ApiOperation(value = "클래스에 후기를 등록한다. 등록된 후기의 평점에 따라 가게 평점도 변한다.")
	@PostMapping("/review/insert")
	public void insertClassReview(@RequestBody ClassReview review) {
		try {
			service.insertClassReview(review);
			storeService.updateStoreGrade(review);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ApiOperation(value = "사용자(고객)이 클래스를 신청(등록)한다. - KAKAO PAY API")
	@PostMapping("/insert") 
	public void insertClassRoom(@RequestBody ClassRoom room) {
		try {
			service.insertClassRoom(room);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
