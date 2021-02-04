//package com.web.dazu.service;
//
//import java.nio.channels.SeekableByteChannel;
//import java.util.List;
//
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.web.dazu.mapper.TipBoardCommentMapper;
//import com.web.dazu.model.Board;
//import com.web.dazu.model.Comment;
//
//public class RestaurantsBoardCommentServiceImpl implements TipBoardCommentService {
//	@Autowired
//	private SqlSession sqlsession;
//	@Override
//	public List<Comment> getBoardCommentList(int board_code) throws Exception {
//		// TODO Auto-generated method stub
//		return sqlsession.getMapper(TipBoardCommentMapper.class).getBoardCommentList(board_code);
//	}
//
//	@Override
//	public void writeBoardComment(Comment comment) throws Exception {
//		// TODO Auto-generated method stub
//		sqlsession.getMapper(TipBoardCommentMapper.class).writeBoardComment(comment);
//	}
//
//	@Override
//	public Comment modifyCommentForm(int comment_code) throws Exception {
//		// TODO Auto-generated method stub
//		return sqlsession.getMapper(TipBoardCommentMapper.class).modifyCommentForm(comment_code);
//	}
//
//	@Override
//	public void modifyComment(Comment comment) throws Exception {
//		// TODO Auto-generated method stub
//		sqlsession.getMapper(TipBoardCommentMapper.class).modifyComment(comment);
//	}
//
//	@Override
//	public void deleteBoardComment(int comment_code) throws Exception {
//		// TODO Auto-generated method stub
//		sqlsession.getMapper(TipBoardCommentMapper.class).deleteBoardComment(comment_code);
//	}
//
//}
