package com.web.dazu.mapper;

import java.util.List;

import com.web.dazu.model.Class;
import com.web.dazu.model.ClassTime;

public interface ClassMapper {

	List<Class> selectAllClass(String dong) throws Exception;

	Class selectClass(String classcode) throws Exception;

	ClassTime selectClassTime(String classcode) throws Exception;

}
