package com.web.dazu.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.web.dazu.mapper.ClassMapper;
import com.web.dazu.model.Class;
import com.web.dazu.model.ClassQnA;
import com.web.dazu.model.ClassReview;
import com.web.dazu.model.ClassRoom;
import com.web.dazu.model.ClassTime;
import com.web.dazu.model.KakaoPay;

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
	public String insertClassRoom(ClassRoom room) throws Exception {
		
		URL url = new URL("https://kapi.kakao.com");
		
		KakaoPay pay = null;
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + "96dde04da1dc175485336a41b21a0ad5");
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("partner_order_id", "1001");
        params.add("partner_user_id", "gorany");
        params.add("item_name", "갤럭시S9");
        params.add("quantity", "1");
        params.add("total_amount", "2100");
        params.add("tax_free_amount", "100");
        params.add("approval_url", "http://localhost:8080/kakaoPaySuccess");
        params.add("cancel_url", "http://localhost:8080/kakaoPayCancel");
        params.add("fail_url", "http://localhost:8080/kakaoPaySuccessFail");
        
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
		
        try {
            pay = restTemplate.postForObject(new URI(url + "/v1/payment/ready"), body, KakaoPay.class);
            
            System.out.println(pay.getNext_redirect_pc_url());
 
        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

//		session.getMapper(ClassMapper.class).insertClassRoom(room);
        return pay.getNext_redirect_pc_url();
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
