package com.web.dazu.mapper;

import java.util.List;
import com.web.dazu.model.Comment;


public interface TipBoardCommentMapper {

	List<Comment> getBoardCommentList(int board_code);

	void writeBoardComment(Comment comment);

	Comment modifyCommentForm(int comment_code);

	void modifyComment(Comment comment);

	void deleteBoardComment(int comment_code);
	
}
