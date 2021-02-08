package com.web.dazu.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.dazu.model.Class;
import com.web.dazu.model.ClassQnA;
import com.web.dazu.model.ClassReview;
import com.web.dazu.model.ClassRoom;
import com.web.dazu.model.ClassTime;

@Mapper
public interface ClassMapper {

	List<Class> selectAllClass(String dong) throws Exception;

	Class selectClass(String classcode) throws Exception;

	ClassTime selectClassTime(String classcode) throws Exception;

	List<Class> selectClassByStore(String storecode) throws Exception;

	List<ClassReview> selectClassReview(String classcode) throws Exception;

	void insertClassReview(ClassReview classreview) throws Exception;

	void insertClassRoom(ClassRoom room) throws Exception;

	List<ClassQnA> selectClassQnA(String classcode) throws Exception;

	void insertClassQnA(ClassQnA qna) throws Exception;

	void insertClassQnAAnswer(ClassQnA answer) throws Exception;

	void insertClass(Class c) throws Exception;

}
