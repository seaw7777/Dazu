package com.web.dazu.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.web.dazu.model.Comment;
import com.web.dazu.service.RestaurantsBoardCommentService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/Restaurants_board_comment")
@RestController
public class RestaurantsboardCommentController {
	@Autowired
	private RestaurantsBoardCommentService service;
	
	@ApiOperation(value = "맛집 게시판 게시글의 댓글목록을 받아온다.", response = List.class)
	@GetMapping(value = "/list/{board_code}")
	public List<Comment> getBoardCommentList(@PathVariable int board_code) {
		try {
			List<Comment> list = service.getBoardCommentList(board_code);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@ApiOperation(value = "특정맛집  게시판에 댓글 달기", response = String.class)
	@PostMapping(value = "/write")
	public String writeBoardComment(@RequestBody Comment comment) {
		System.out.println(comment);
		try {
			service.writeBoardComment(comment);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "fail";
	}
	
	@ApiOperation(value = "맛집 게시판 게시글 댓글 수정페이지로", response = Comment.class)
	@GetMapping(value = "/modify/{comment_code}")
	public Comment modifyCommentForm(@PathVariable int comment_code) {
		try {
			Comment Comment = service.modifyCommentForm(comment_code);
			return Comment;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@ApiOperation(value = "맛집 게시판 게시글 댓글 수정진행", response = String.class)
	@PutMapping(value = "/modify")
	public String modifyComment(@RequestBody Comment comment) {
		try {
			service.modifyComment(comment);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "fail";
	}
	@ApiOperation(value = "맛집 게시판 게시글 댓글 삭제", response = String.class)
	@DeleteMapping(value = "/delete/{comment_code}")
	public String deleteBoardComment(@PathVariable int comment_code) {
		try {
			service.deleteBoardComment(comment_code);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "fail";
	}

}
