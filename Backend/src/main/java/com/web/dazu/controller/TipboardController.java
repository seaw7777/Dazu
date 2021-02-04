package com.web.dazu.controller;

import java.util.HashMap;
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
import com.web.dazu.service.TipBoardService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/tip_board")
@RestController
public class TipboardController {
	@Autowired
	private TipBoardService service;

	@ApiOperation(value = "팁 게시판 목록을 받아온다.", response = List.class)
	@GetMapping(value = "/list")
	public List<Board> getBoardList(@RequestParam Map<String, String> map) {
		System.out.println("진입");
//		System.out.println(map);
		for (String key : map.keySet()) {
			String value = (String) map.get(key);
			System.out.println(key + " : " + value);
			System.out.println("진입2");
		}
		Map<String, String> dummy = new HashMap<String, String>();
		dummy.put("searchWord", "향신");
		dummy.put("searchType", "샤싣");
		System.out.println(dummy);
		try {
			List<Board> list = service.getBoardList(dummy);
			System.out.println(list);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@ApiOperation(value = "팁 게시판 글쓰기", response = String.class)
	@PostMapping(value = "/write")
	public String writeBoard(@RequestBody Board notice) {
		System.out.println(notice);
		try {
			service.writeBoard(notice);
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

	@ApiOperation(value = "팁 게시판 게시글 수정페이지로 이동", response = Board.class)
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

	@ApiOperation(value = "팁 게시판 게시글 수정진행", response = String.class)
	@PutMapping(value = "/modify")
	public String modifyTip(@RequestBody Board board) {
		System.out.println(board);
		try {
			service.modifyBoard(board);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "fail";
	}

	@ApiOperation(value = "팁 게시판 게시글 삭제", response = String.class)
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
}
