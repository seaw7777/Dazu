package com.web.dazu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

import com.web.dazu.model.Class;
import com.web.dazu.model.ClassQnA;
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
	
	@ApiOperation(value = "새로운 클래스를 등록한다.(사장님)")
	@PostMapping("/ceo/insert")
	public void insertClass(@RequestBody Class c) {
		try {
			service.insertClass(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ApiOperation(value = "특정 클래스를 삭제한다.(사장님)")
	@DeleteMapping("/ceo/delete/{classcode}")
	public void deleteClass(@PathVariable int classcode) {
		try {
			service.deleteClass(classcode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ApiOperation(value = "특정 클래스 정보를 수정한다.(사장님)")
	@PutMapping("/ceo/update")
	public void updateClass(@RequestBody Class c) {
		try {
			service.updateClass(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	@ApiOperation(value = "클래스에 등록된 Q&A 목록을 읽어온다.", response = List.class)
	@GetMapping("/qna/{classcode}")
	public ResponseEntity<List<ClassQnA>> selectClassQnA(@PathVariable String classcode) {
		List<ClassQnA> list = new ArrayList<>();
		try {
			list = service.selectClassQnA(classcode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<ClassQnA>>(list, HttpStatus.OK);
	}
	
	@ApiOperation(value = "클래스에 Q&A를 등록한다.")
	@PostMapping("/qna/insert")
	public void insertClassQnA(@RequestBody ClassQnA qna) {
		System.out.println(qna.getClass_qna_board_write_contents());
		try {
			service.insertClassQnA(qna);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ApiOperation(value = "특정 클래스 특정 Q&A에 댓글(답변)을 등록한다.")
	@PostMapping("/qna/answer/insert")
	public void insertClassQnAAnswer(@RequestBody ClassQnA answer) {
		System.out.println(answer.getClass_qna_answer_write_content());
		System.out.println(answer.getClass_qna_board_code());
		try {
			service.insertClassQnAAnswer(answer);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	@PostMapping("/customer/insert") 
	public String insertClassRoom(@RequestBody ClassRoom room) {
		String url = null;
		try {
			url = service.insertClassRoom(room);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}
}
