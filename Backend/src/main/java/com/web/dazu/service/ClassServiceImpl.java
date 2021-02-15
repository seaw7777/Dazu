package com.web.dazu.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.web.dazu.mapper.ClassMapper;
import com.web.dazu.model.Class;
import com.web.dazu.model.ClassQnA;
import com.web.dazu.model.ClassReview;
import com.web.dazu.model.ClassRoom;
import com.web.dazu.model.ClassTime;
import com.web.dazu.model.KakaoPayAccount;
import com.web.dazu.model.KakaoPayReady;

@Service
public class ClassServiceImpl implements ClassService {
	
	@Autowired
	private SqlSession session;
	
	@Autowired
	private FileUploadService fileuploadservice;
	
	@Override
	public List<Class> selectAllClass(String dong) throws Exception {
		return session.getMapper(ClassMapper.class).selectAllClass(dong);
	}

	@Override
	public Class selectClass(String classcode) throws Exception {
		return session.getMapper(ClassMapper.class).selectClass(classcode);
	}

	@Override
	public List<ClassTime> selectClassTime(String classcode) throws Exception {
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
	public void insertClass(List<MultipartFile> file, Class c) throws Exception {
		session.getMapper(ClassMapper.class).insertClass(c);
		fileuploadservice.classfileup(file, session.getMapper(ClassMapper.class).getclasscode(c));
	}

	@Override
	public void deleteClass(String classcode) throws Exception {
		session.getMapper(ClassMapper.class).deleteClass(classcode);
	}

	@Override
	public void updateClass(List<MultipartFile> file, Class c) throws Exception {
		fileuploadservice.classfileup(file, c.getClasscode());
		session.getMapper(ClassMapper.class).updateClass(c);
	}

	private static KakaoPayReady ready;
	private static ClassRoom cr;
	
	@Override
	public String KakaoReady(ClassRoom room) throws Exception {
		
		System.out.println("클래스코드: " + room.getClass_information_classcode()+ " 클래스 이름: "+ room.getItem_name() + " 클래스 시간 : " + room.getClass_time_information_class_timecode());
		
		cr = room;
		URL url = new URL("https://kapi.kakao.com");
		
		ready = null;
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + "96dde04da1dc175485336a41b21a0ad5");
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("partner_order_id", "partner_order_id");
        params.add("partner_user_id", "partner_user_id");
        params.add("item_name", room.getItem_name()); // 받아오기
        params.add("quantity", "1");
        params.add("total_amount", Integer.toString(room.getTotal_amount())); // 받아오기
        params.add("tax_free_amount", "0");
        params.add("approval_url", "https://i4d104.p.ssafy.io/kakaoPaySuccess");
        params.add("cancel_url", "https://i4d104.p.ssafy.io/kakaoPayCancel");
        params.add("fail_url", "https://i4d104.p.ssafy.io/kakaoPaySuccessFail");
        
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
		
        try {
        	ready = restTemplate.postForObject(new URI(url + "/v1/payment/ready"), body, KakaoPayReady.class);
            
            System.out.println(ready.getNext_redirect_pc_url());
 
        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return ready.getNext_redirect_pc_url();
	}

	@Override
	public KakaoPayAccount KakaoAccount(String pg_token) throws Exception {
		URL url = new URL("https://kapi.kakao.com");
		KakaoPayAccount account = null;
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + "96dde04da1dc175485336a41b21a0ad5");
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("tid", ready.getTid());
        params.add("partner_order_id", "partner_order_id");
        params.add("partner_user_id", "partner_user_id");
        params.add("pg_token", pg_token);
        params.add("total_amount", Integer.toString(cr.getTotal_amount())); // 받아오기
        
        System.out.println("최종결제금액 : " + cr.getTotal_amount());
        
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        
        try {
        	account = restTemplate.postForObject(new URI(url + "/v1/payment/approve"), body, KakaoPayAccount.class);
        
        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        
        cr = null;
        
        return account;

	}

	@Override
	public void insertClassTime(ClassTime time) throws Exception {
		session.getMapper(ClassMapper.class).insertClassTime(time);
	}

	@Override
	public void updateClassTime(ClassTime time) throws Exception {
		session.getMapper(ClassMapper.class).updateClassTime(time); 
	}

	@Override
	public void deleteClassTime(String timecode) throws Exception {
		session.getMapper(ClassMapper.class).deleteClassTime(timecode);
	}

}
