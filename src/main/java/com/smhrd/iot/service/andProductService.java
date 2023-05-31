package com.smhrd.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.iot.domain.before_product;
import com.smhrd.iot.mapper.AndProductMapper;

@Service
public class andProductService {
	@Autowired
	AndProductMapper mapper;
	
	//바코드에 해당하는 상품을 안드로이드 장바구니에 추가
	public before_product getBarcodeProduct(String barcode) {
		return mapper.getBarcodeProduct(barcode);
	}
	
	//바코드에 해당하는 상품의 위치를 해당 아이디 직원과 묶어 cartList에 insert시켜서 웹에 보이게
	public int InsertCallList(String id, String barcode) {
		System.out.println("안드로이드 직원호출 서비스");
		return mapper.InsertCallList(id, barcode);
	}
	//결제 완료된 상품 객체를 after_product에 insert시키는 단
	public int InsertAfterProduct(before_product product,String member_id) {
		System.out.println("결제 완료 물품 추가");
		return mapper.InsertAfterProduct(product, member_id);
	}
}
