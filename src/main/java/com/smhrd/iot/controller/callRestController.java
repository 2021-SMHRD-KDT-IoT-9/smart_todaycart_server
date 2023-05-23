package com.smhrd.iot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smhrd.iot.domain.callList;
import com.smhrd.iot.domain.cartList;
import com.smhrd.iot.service.callService;

@RestController
public class callRestController {
	@Autowired
	callService service;
	
	@GetMapping(value="/showCallList", produces = "application/json")
	public String  showCallList() throws JsonProcessingException{
		 List<callList> callList = service.showCallList();
		 	
		    ObjectMapper objectMapper = new ObjectMapper();
		    String json = objectMapper.writeValueAsString(callList);
		    System.out.println("콜 리스트 컨트롤러");
		    return json;
	}
	@PostMapping(value="/deleteCall")
	public void deleteCall(@RequestBody Map<String, String> requestData) {
	    String call_id = requestData.get("call_id");
	    service.deleteCall(call_id);
	    
	}
	
	
}
