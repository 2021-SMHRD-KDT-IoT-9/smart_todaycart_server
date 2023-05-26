package com.smhrd.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.smhrd.iot.domain.before_product;
import com.smhrd.iot.service.andProductService;

@RestController
public class andProductController {
	@Autowired
	andProductService service;
	
	//@Autowired
	//private SimpMessagingTemplate messagingTemplate;
	
	
	//@MessageMapping("/newShopping")
	//@SendTo("/topic/greetings")
	//public String handleNewShopping(@Payload String barcode) throws JsonProcessingException {
	    // 바코드 값을 받아 처리하는 로직을 구현합니다.
	    // 예를 들어, 해당 상품 정보를 조회하고 안드로이드 앱으로 전송할 수 있습니다.
	    
	    // 받은 바코드 값을 상품 조회 메소드로 전달하여 상품 정보를 얻어옵니다.
	//    before_product product = service.getBarcodeProduct(barcode);
//
	    // 얻어온 상품 정보를 JSON 형태로 변환합니다.
	// mapper = new ObjectMapper();
	//    String jsonProduct = mapper.writeValueAsString(product);

	    // 얻어온 상품 정보를 안드로이드 앱으로 전송합니다.
	//    messagingTemplate.convertAndSend("/topic/greetings", jsonProduct);

	    // 응답 메시지를 반환합니다.
	 //   return "Product found: " + product.getName();
	//}
	
}
