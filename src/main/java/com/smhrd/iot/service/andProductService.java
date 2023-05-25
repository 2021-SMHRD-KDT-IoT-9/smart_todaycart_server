package com.smhrd.iot.service;

import org.springframework.stereotype.Service;

import com.smhrd.iot.domain.before_product;
import com.smhrd.iot.mapper.AndProductMapper;

@Service
public class andProductService {
	AndProductMapper mapper;
	
	public before_product getBarcodeProduct(String barcode) {
		return mapper.getBarcodeProduct(barcode);
	}
}
