package com.smhrd.iot.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.iot.domain.barcodeEvent;
import com.smhrd.iot.domain.before_product;
import com.smhrd.iot.domain.member_info;
import com.smhrd.iot.service.andProductService;

@RestController
public class andProductController {
	//이미지 찾기 위한 경로
	 private static final String IMAGE_DIRECTORY = "static/productUpload";
	
	@Autowired 
	barcodeEvent barcodeScan;
	
	@Autowired
	andProductService service;
	
	//직원 호출 버튼 클릭했을 때 callList테이블에 추가
	@RequestMapping(value="/callManager", method=RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Map<String, Object>> callManager(@RequestBody member_info m) {
		String barcode="12345";
		System.out.println("직원호출 시도");
		//String barcode=barcodeScan.getBarcode();
		 Map<String, Object> response = new HashMap<>();
		if(service.InsertCallList(m.getMember_id(), barcode)>0){
			System.out.println(m.getMember_id());
			System.out.println("안드로이드 직원호출 컨트롤러");
			 response.put("success", true);
	           
		}else {
			 response.put("success", false);
	           
		}
		 return ResponseEntity.ok(response);
		
	}
	
	//장바구니 상품 추가
	@RequestMapping(value = "/shopingcart", method = RequestMethod.POST)
	public ResponseEntity<before_product> addToShoppingCart() {
    	String barcode="12345";
    	 System.out.println("쇼핑카트 시도");
    	if(barcode!=null) {
    		  before_product pt = service.getBarcodeProduct(barcode);
    		  System.out.println(pt.toString());
    		  return ResponseEntity.ok(pt);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


	
	//결제 완료 버튼을 눌렀을 때 after_product테이블에 추가
	@RequestMapping(value="/payProduct", method=RequestMethod.POST,  consumes = "application/json")
	public  ResponseEntity<Map<String, Object>> payProduct(@RequestBody before_product produt, @RequestParam("id") String member_id) {
		 if(service.InsertAfterProduct(produt, member_id)>0) {
			 Map<String, Object> response = new HashMap<>();
	            response.put("success", true);
	            response.put("message", "결제 완료");
	            return ResponseEntity.ok(response);
		 }
		 else {
		    	Map<String, Object> response = new HashMap<>();
		        response.put("success", false);
		        response.put("message", "결제 실패");
		        return ResponseEntity.ok(response);
		    }
	}
	
	/*
	 * //상품 검색을 눌렀을 때(?) 보류
	 * 
	 * @RequestMapping(value="/searchProduct", method=RequestMethod.POST) public
	 * ResponseEntity<before_product> searchProduct() { String barcode =
	 * barcodeScan.getBarcode(); if (barcode != null) { before_product product =
	 * service.getBarcodeProduct(barcode); return new ResponseEntity<>(product,
	 * HttpStatus.OK); } else { return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
	 * }
	 */
	
	
}
