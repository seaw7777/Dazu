package com.web.dazu.mapper;

import java.util.List;

import com.web.dazu.model.Class;

public interface ClassMapper {

	List<Class> selectAllClass(String dong) throws Exception;

}
