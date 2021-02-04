package com.web.dazu.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dazu.mapper.RestaurantsBoardCommentMapper;
import com.web.dazu.model.Comment;

@Service
public class RestaurantsBoardCommentServiceImpl implements RestaurantsBoardCommentService {
	@Autowired
	private SqlSession sqlsession;
	@Override
	public List<Comment> getBoardCommentList(int board_code) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.getMapper(RestaurantsBoardCommentMapper.class).getBoardCommentList(board_code);
	}

	@Override
	public void writeBoardComment(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		sqlsession.getMapper(RestaurantsBoardCommentMapper.class).writeBoardComment(comment);
	}

	@Override
	public Comment modifyCommentForm(int comment_code) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.getMapper(RestaurantsBoardCommentMapper.class).modifyCommentForm(comment_code);
	}

	@Override
	public void modifyComment(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		sqlsession.getMapper(RestaurantsBoardCommentMapper.class).modifyComment(comment);
	}

	@Override
	public void deleteBoardComment(int comment_code) throws Exception {
		// TODO Auto-generated method stub
		sqlsession.getMapper(RestaurantsBoardCommentMapper.class).deleteBoardComment(comment_code);
	}

}
