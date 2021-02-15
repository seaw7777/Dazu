package com.web.dazu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.web.dazu.model.Mealkit;
import com.web.dazu.service.FileUploadService;
import com.web.dazu.service.MealkitService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/mealkit")
@RestController
public class MealkitController {
	
	@Autowired
	private MealkitService service;
	@Autowired
	private FileUploadService fileuploadservice;
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
	
	@ApiOperation(value = "새로운 밀키트 정보를 등록한다.")
	@PostMapping("/insert")
	public void insertMealkit(@RequestPart(value = "files", required = true) List<MultipartFile> file,
			@RequestPart(value = "key", required = false) Mealkit mealkit) {
		try {
			service.insertMealkit(mealkit);
			fileuploadservice.uploadmilkit(file,mealkit.getClass_information_classcode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ApiOperation(value = "밀키트 정보를 수정한다.")
	@PutMapping("/update")
	public void updateMealkit(@RequestBody Mealkit mealkit) {
		try {
			service.updateMealkit(mealkit);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ApiOperation(value = "밀키트 정보를 삭제한다.")
	@DeleteMapping("/delete/{code}")
	public void deleteMealkit(@PathVariable String code) {
		try {
			service.deleteMealkit(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ApiOperation(value = "클래스의 밀키트를 읽어온다.", response = Mealkit.class)
	@GetMapping("/class/{classcode}") 
	public Mealkit selectMealkit(@PathVariable String classcode) {
		Mealkit mealkit = new Mealkit();
		try {
			mealkit = service.selectMealkit(classcode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mealkit;
	}
}
