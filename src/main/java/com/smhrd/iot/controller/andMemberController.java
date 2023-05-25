package com.smhrd.iot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.iot.domain.member_info;
import com.smhrd.iot.service.andMemberService;
import com.smhrd.iot.service.memberService;

@RestController
public class andMemberController {
	@Autowired
	andMemberService service;

	//@RequestMapping(value = "/loginCheckMember")
	//public String memberLogin() {
		// @RequestBody Map<String, String> params
	//	System.out.println("안드로이드 요청 들어옴");
		// JSONObject responseJson = new JSONObject();
		// responseJson.put("success", true);
		// responseJson.put("message", "로그인 성공");

		// return responseJson.toString();
	//	return null;
	//}
	
	}



	

