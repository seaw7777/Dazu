package com.web.dazu.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dazu.mapper.NoticeMapper;
import com.web.dazu.model.Notice;

@Service
public class NoticeServiceImpl implements NoticeService {
		
	@Autowired
	private SqlSession session;

	@Override
	public List<Notice> selectAllNotice() throws Exception {
		return session.getMapper(NoticeMapper.class).selectAllNotice();
	}

	@Override
	public void insertNotice(Notice notice) throws Exception {
		session.getMapper(NoticeMapper.class).insertNotice(notice);
	}

	@Override
	public Notice selectDetailNotice(String noticecode) throws Exception {
		return session.getMapper(NoticeMapper.class).selectDetailNotice(noticecode);
	}

}
