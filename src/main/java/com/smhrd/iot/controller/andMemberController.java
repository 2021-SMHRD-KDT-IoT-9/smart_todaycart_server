package com.smhrd.iot.controller;

import java.awt.PageAttributes.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smhrd.iot.domain.cart_info;
import com.smhrd.iot.domain.member_info;
import com.smhrd.iot.service.adsService;
import com.smhrd.iot.service.andMemberService;


@RestController
public class andMemberController {
	@Autowired
	andMemberService service;
	
	@Autowired
	adsService adsSelect;
	
	@Autowired
	adsMachineController adsMachine;
	
	@Autowired
	cart_info cart;
	
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	//안드로이드에서 로그인 요청이 왔을 때
	//로그인에 성공하면 해당 회원에 맞는 광고 이미지 전송(주간,추천)
	 @RequestMapping(value="/loginCheckMember", method=RequestMethod.POST, consumes = "application/json")
	 public ResponseEntity<Map<String, Object>> memberLogin(@RequestBody member_info m,HttpSession session,String cart_id) {
		 
		  String id =m.getMember_id();
		  String pw =m.getMember_pw();
		  Map<String, Object> response = new HashMap<>();
		 if(service.memberLogin(id,pw)>0) {
			 System.out.println("로그인 시도");
			 //nfc에 저장된 카트 아이디를 저장해 놓기
			 cart.setCart_id(cart_id);
			 //로그인한 정보에 맞는 광고 받아오기
			 String adsType=adsMachine.sendMemberInfo(id);
			 //로그인한 정보에 맞는 광고가 올바르게 받아졌으면 광고 이미지와 로그인 했다는 표시를 안드로이드에 전송
			 if(adsSelect.getAdsImg(adsType,"2")!=null) {
				 response.put("adsImg",adsSelect.getAdsImg(adsType,"2"));
				 response.put("success", true);
		            response.put("message", "로그인 성공");
			 }
			 else {
				 System.out.println("로그인은 되는데 광고가 안들어감");
				 response.put("adsImg",null);
				 response.put("success",true);
		            response.put("message", "로그인만되고 광고 이미지가 안보내짐");
			 }
			 
	           
		 }
		 else { response.put("adsImg",null);
		        response.put("success", false);
		        response.put("message", "로그인 실패");
		    }
		 return ResponseEntity.ok(response);
	 } 
	 
	 
	 
	 @RequestMapping(value="/newMember", method=RequestMethod.POST, consumes = "application/json")
	 public ResponseEntity<Map<String, Object>> newMember(@RequestBody member_info m){
		System.out.println(m.toString());
		 if(service.newMember(m)>0) {
			 Map<String, Object> response = new HashMap<>();
	            response.put("success", true);
	            response.put("message", "회원가입 성공");
	            
	            return ResponseEntity.ok(response);
		 }
		 else {
		    	Map<String, Object> response = new HashMap<>();
		        response.put("fail", false);
		        response.put("message", "회원가입 실패");
		        
		        return ResponseEntity.ok(response);
		    }
	 }
	
	
	}



	
