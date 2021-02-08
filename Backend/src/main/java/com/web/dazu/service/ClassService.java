package com.web.dazu.service;

import java.util.HashMap;
import java.util.List;

import com.web.dazu.model.Class;
import com.web.dazu.model.ClassQnA;
import com.web.dazu.model.ClassReview;
import com.web.dazu.model.ClassRoom;
import com.web.dazu.model.ClassTime;
import com.web.dazu.model.KakaoPayAccount;

public interface ClassService {

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

	void deleteClass(int classcode) throws Exception;

	void updateClass(Class c) throws Exception;

	String KakaoReady(ClassRoom room) throws Exception;

	KakaoPayAccount KakaoAccount(String pg_token) throws Exception;

}
