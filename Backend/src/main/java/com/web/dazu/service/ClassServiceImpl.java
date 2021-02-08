package com.web.dazu.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dazu.mapper.ClassMapper;
import com.web.dazu.model.Class;
import com.web.dazu.model.ClassQnA;
import com.web.dazu.model.ClassReview;
import com.web.dazu.model.ClassRoom;
import com.web.dazu.model.ClassTime;

@Service
public class ClassServiceImpl implements ClassService {
	
	@Autowired
	private SqlSession session;

	@Override
	public List<Class> selectAllClass(String dong) throws Exception {
		return session.getMapper(ClassMapper.class).selectAllClass(dong);
	}

	@Override
	public Class selectClass(String classcode) throws Exception {
		return session.getMapper(ClassMapper.class).selectClass(classcode);
	}

	@Override
	public ClassTime selectClassTime(String classcode) throws Exception {
		return session.getMapper(ClassMapper.class).selectClassTime(classcode);
	}

	@Override
	public List<Class> selectClassByStore(String storecode) throws Exception {
		return session.getMapper(ClassMapper.class).selectClassByStore(storecode);
	}

	@Override
	public List<ClassReview> selectClassReview(String classcode) throws Exception {
		return session.getMapper(ClassMapper.class).selectClassReview(classcode);
	}

	@Override
	public void insertClassReview(ClassReview classreview) throws Exception {
		session.getMapper(ClassMapper.class).insertClassReview(classreview);
	}
	
	@Override
	public void insertClassRoom(ClassRoom room) throws Exception {
		
		String apiKey = "2ce9bedc0889520f06b58f54d0724e65";
		String apiUrl = "https://kapi.kakao.com/v1/payment/ready";
		String jsonString = null;
		URL url = new URL(apiUrl);
		URLConnection conn = url.openConnection();

	    conn.setRequestProperty("Authorization", "KakaoAK " + apiKey);
	    
	    BufferedReader br = null;
        br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

        String line = "";
        String result = "";
        
        while ((line = br.readLine()) != null) {
            result += line;
        }
        jsonString = result.toString();
        System.out.println(jsonString);
		
		session.getMapper(ClassMapper.class).insertClassRoom(room);
	}

	@Override
	public List<ClassQnA> selectClassQnA(String classcode) throws Exception {
		return session.getMapper(ClassMapper.class).selectClassQnA(classcode);
	}

	@Override
	public void insertClassQnA(ClassQnA qna) throws Exception {
		session.getMapper(ClassMapper.class).insertClassQnA(qna);
	}

	@Override
	public void insertClassQnAAnswer(ClassQnA answer) throws Exception {
		session.getMapper(ClassMapper.class).insertClassQnAAnswer(answer);
	}

	@Override
	public void insertClass(Class c) throws Exception {
		session.getMapper(ClassMapper.class).insertClass(c);
	}

	@Override
	public void deleteClass(int classcode) throws Exception {
		session.getMapper(ClassMapper.class).deleteClass(classcode);
	}

	@Override
	public void updateClass(Class c) throws Exception {
		session.getMapper(ClassMapper.class).updateClass(c);
	}

}
