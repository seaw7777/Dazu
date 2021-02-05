package com.web.dazu.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.dazu.model.Board;
import com.web.dazu.service.RestaurantsBoardService;


import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/Restaurants_board")
@RestController
public class RestaurantsboardController {
	@Autowired
	private RestaurantsBoardService service;
	
	@ApiOperation(value = "맛집 게시판 목록을 받아온다.", response = List.class)
	@GetMapping(value = "/list")
	public List<Board> getBoardList(@RequestParam Map<String, String> map) {
		try {
			List<Board> list = service.getBoardList(map);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@ApiOperation(value = "맛집 게시판 글쓰기", response = String.class)
	@PostMapping(value = "/write")
	public String writeBoard(@RequestBody Board board) {
		System.out.println(board);
		try {
			service.writeBoard(board);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "fail";
	}
	
	@ApiOperation(value = "글번호로 검색하기.", response = Board.class)
	@GetMapping(value = "/view/{board_code}")
	public Board getBoard(@PathVariable int board_code) {
		try {
			Board board = service.getBoard(board_code);
			return board;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@ApiOperation(value = "맛집 게시판 상세보기.", response = Board.class)
	@GetMapping(value = "/detail/{board_code}")
	public Board getBoardDetail(@PathVariable int board_code) {
		try {
			Board board = service.getBoard(board_code);
			service.updateViews(board_code);
			return board;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@ApiOperation(value = "맛집 게시판 게시글 수정페이지로 이동", response = Board.class)
	@GetMapping(value = "/modify/{board_code}")
	public Board modifyForm(@PathVariable int board_code) {
		try {
			Board board = service.getBoard(board_code);
			return board;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@ApiOperation(value = "맛집 게시판 게시글 수정진행", response = String.class)
	@PutMapping(value = "/modify")
	public String modifyRes(@RequestBody Board board) {
		System.out.println(board);
		try {
			service.modifyBoard(board);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "fail";
	}
	@ApiOperation(value = "맛집 게시판 게시글 삭제", response = String.class)
	@DeleteMapping(value = "/delete/{board_code}")
	public String deleteBoard(@PathVariable int board_code) {
		try {
			service.deleteBoard(board_code);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "fail";
	}
	@ApiOperation(value = "맛집 게시판 인기 게시글 불러오기", response = List.class)
	@GetMapping(value = "/Popular_posts")
	public List<Board> selectpopularposts(){
		List<Board> list = new LinkedList<Board>();
		try {
			list = service.selectpopularposts();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
