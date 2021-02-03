package com.web.dazu.mapper;

import java.util.List;
import java.util.Map;

import com.web.dazu.model.Board;
import com.web.dazu.model.Comment;


public interface RestaurantsBoardCommentMapper2 {

	List<Comment> getBoardCommentList(int board_code);

	void writeBoardComment(Comment comment);

	Comment modifyCommentForm(int comment_code);

	void modifyComment(Comment comment);

	void deleteBoardComment(int comment_code);
	
}
