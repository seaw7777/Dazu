package com.web.dazu.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dazu.mapper.TipBoardMapper;
import com.web.dazu.model.Board;

@Service
public class TipBoardServiceImpl implements TipBoardService {

	@Autowired
	private SqlSession sqlsession;

	@Override
	public List<Board> getBoardList(Map<String, String> map) throws Exception {
		return sqlsession.getMapper(TipBoardMapper.class).getBoardList(map);
	}

	@Override
	public void writeBoard(Board board) throws Exception {
		// TODO Auto-generated method stub
		sqlsession.getMapper(TipBoardMapper.class).writeBoard(board);
	}

	@Override
	public Board getBoard(int board_code) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.getMapper(TipBoardMapper.class).getBoard(board_code);
	}

	@Override
	public void modifyBoard(Board board) throws Exception {
		// TODO Auto-generated method stub
		sqlsession.getMapper(TipBoardMapper.class).modifyBoard(board);
	}

	@Override
	public void deleteBoard(int board_code) throws Exception {
		// TODO Auto-generated method stub
		sqlsession.getMapper(TipBoardMapper.class).deleteBoard(board_code);
	}

	@Override
	public List<Board> searchByTitle(String word) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.getMapper(TipBoardMapper.class).searchByTitle(word);
	}

}
