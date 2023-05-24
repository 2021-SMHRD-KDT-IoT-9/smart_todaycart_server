package com.smhrd.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.iot.domain.before_product;
import com.smhrd.iot.mapper.ProductMapper;

@Service
public class productService {
	@Autowired
	ProductMapper mapper;
	
	public int insertProduct(String fileName,before_product bepro) {
		return mapper.insertProduct(fileName,bepro);
	}
	
}
