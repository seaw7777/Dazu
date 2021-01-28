package com.web.dazu.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileUploadMapper {
	public int fileupload(String filePath) throws SQLException;
}	
