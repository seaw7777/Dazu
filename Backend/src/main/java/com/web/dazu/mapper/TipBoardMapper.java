package com.web.dazu.mapper;

import java.util.List;
import java.util.Map;

import com.web.dazu.model.Board;


public interface TipBoardMapper {
	List<Board> getBoardList(Map<String, String> map) throws Exception;
	void writeBoard(Board board) throws Exception;
	Board getBoard(int no) throws Exception;
	void updateViews(int board_code) throws Exception;
	void modifyBoard(Board board) throws Exception;
	void deleteBoard(int board_code) throws Exception;
	List<Board> searchByTitle(String word) throws Exception;
	
}
