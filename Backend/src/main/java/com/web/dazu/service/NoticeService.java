package com.web.dazu.service;

import java.util.List;

import com.web.dazu.model.Notice;

public interface NoticeService {

	List<Notice> selectAllNotice() throws Exception;

	void insertNotice(Notice notice) throws Exception;

	Notice selectDetailNotice(String noticecode) throws Exception;

}
