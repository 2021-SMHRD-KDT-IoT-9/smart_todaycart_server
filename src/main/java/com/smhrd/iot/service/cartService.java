package com.smhrd.iot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.iot.domain.cartList;
import com.smhrd.iot.mapper.CartMapper;

@Service
public class cartService {
	@Autowired
	CartMapper mapper;
	
	public List<cartList> showCartList(){
		System.out.println("카트리스트 성공 서비스");
		return mapper.showCartList();
	}
}
