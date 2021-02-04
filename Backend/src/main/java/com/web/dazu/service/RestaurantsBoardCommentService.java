package com.web.dazu.service;

import java.util.List;

import com.web.dazu.model.Comment;

public interface RestaurantsBoardCommentService {

	List<Comment> getBoardCommentList(int board_code) throws Exception;

	void writeBoardComment(Comment comment) throws Exception;

	Comment modifyCommentForm(int board_code) throws Exception;

	void modifyComment(Comment comment) throws Exception;

	void deleteBoardComment(int comment_code) throws Exception;

}
