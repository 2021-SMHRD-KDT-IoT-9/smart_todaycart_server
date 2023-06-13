package com.smhrd.iot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smhrd.iot.domain.cartList;
import com.smhrd.iot.domain.member_info;
import com.smhrd.iot.service.cartService;

@RestController
public class cartRestController {
	@Autowired
	cartService service;
	
	//웹 페이지에서 카트에 대한 정보 열람 가능
	@GetMapping(value="/showCartList", produces = "application/json")
	public String showCartList() throws JsonProcessingException{
		 List<cartList> cartList = service.showCartList();
		 	
		    ObjectMapper objectMapper = new ObjectMapper();
		    String json = objectMapper.writeValueAsString(cartList);
		    return json;
	}
	
	
}
