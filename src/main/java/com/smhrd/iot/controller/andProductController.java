package com.smhrd.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smhrd.iot.domain.BarcodeEvent;
import com.smhrd.iot.domain.before_product;
import com.smhrd.iot.service.andProductService;

@RestController
public class andProductController {
	@Autowired
	andProductService service;
	
	//@Autowired
	//private SimpMessagingTemplate messagingTemplate;
	
	@EventListener
	public void handleBarcodeEvent(BarcodeEvent event) throws JsonProcessingException {
	    String barcode = event.getBarcode();
	   

	    // 받은 바코드 값을 상품 조회 메소드로 전달하여 상품 정보를 얻어옵니다.
	    before_product product = service.getBarcodeProduct(barcode);

	    // 얻어온 상품 정보를 JSON 형태로 변환합니다.
	    ObjectMapper mapper = new ObjectMapper();
	    String jsonProduct = mapper.writeValueAsString(product);

	    // 얻어온 상품 정보를 안드로이드 앱으로 전송합니다.
	    //messagingTemplate.convertAndSend("/topic/greetings", jsonProduct);
	}


}
