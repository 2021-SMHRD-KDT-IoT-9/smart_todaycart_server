package com.smhrd.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.iot.domain.before_product;
import com.smhrd.iot.mapper.AndProductMapper;

@Service
public class andProductService {
	@Autowired
	AndProductMapper mapper;
	
	
	
	public before_product getBarcodeProduct(String barcode) {
		return mapper.getBarcodeProduct(barcode);
	}
}
