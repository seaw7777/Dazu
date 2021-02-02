package com.web.dazu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.dazu.model.Notice;

@Mapper
public interface NoticeMapper {

	List<Notice> selectAllNotice() throws Exception;

	void insertNotice(Notice notice) throws Exception;

} 
