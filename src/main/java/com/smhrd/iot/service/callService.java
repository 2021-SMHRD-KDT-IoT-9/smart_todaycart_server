package com.smhrd.iot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.iot.domain.callList;
import com.smhrd.iot.mapper.CallMapper;

@Service
public class callService {
	@Autowired
	CallMapper mapper;
	
	public List<callList> showCallList(){
		return mapper.showCallList();
	}
	
	public void deleteCall(String call_id) {
		mapper.deleteCall(call_id);
	}
}
