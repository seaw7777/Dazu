package com.web.dazu.mapper;

import java.util.List;

import com.web.dazu.model.Class;
import com.web.dazu.model.ClassNotice;
import com.web.dazu.model.ClassReview;
import com.web.dazu.model.ClassTime;

public interface ClassMapper {

	List<Class> selectAllClass(String dong) throws Exception;

	Class selectClass(String classcode) throws Exception;

	ClassTime selectClassTime(String classcode) throws Exception;

	List<Class> selectClassByStore(String storecode) throws Exception;

	List<ClassReview> selectClassReview(String classcode) throws Exception;

	List<ClassNotice> selectClassNotice(String classcode) throws Exception;

	void insertClassNotice(ClassReview review) throws Exception;

}
