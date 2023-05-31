package com.smhrd.iot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.iot.domain.barcodeEvent;
import com.smhrd.iot.domain.before_product;
import com.smhrd.iot.service.andProductService;

@RestController
public class andProductController {
	
	@Autowired 
	barcodeEvent barcodeScan;
	
	@Autowired
	andProductService service;
	
	//직원 호출 버튼 클릭했을 때 callList테이블에 추가
	@RequestMapping(value="/callManager", method=RequestMethod.POST)
	public void callManager(@RequestParam("id") String id) {
		String barcode=barcodeScan.getBarcode();
		service.InsertCallList(id, barcode);
		System.out.println("안드로이드 직원호출 컨트롤러");
		
	}
	
	//장바구니 상품 추가
	@RequestMapping(value = "/shopingCart", method = RequestMethod.GET)
	public ResponseEntity<before_product> shopingCart() {
		String barcode = "45678";
		//String barcode = barcodeScan.getBarcode();
	    //라즈베리파이에서 바코드를 읽을 때 장바구니에 상품 추가 할 수 있게 if문 쓰기
	    if (barcode != null) {
	        before_product product = service.getBarcodeProduct(barcode);
	        String imgFile = product.getP_img();
	        //안드로이드 측에서 서버에 저장된 이미지 경로를 읽을 수 있게 setter로 재설정
	        product.setP_img("/static/productUpload"+imgFile);
	        System.out.println("장바구니 컨트롤러");
	        return new ResponseEntity<>(product, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	//상품 검색을 눌렀을 때(?) 보류 
	@RequestMapping(value="/searchProduct", method=RequestMethod.GET)
	public ResponseEntity<before_product> searchProduct() {
		 String barcode = barcodeScan.getBarcode();
		    if (barcode != null) {
		        before_product product = service.getBarcodeProduct(barcode);
		        return new ResponseEntity<>(product, HttpStatus.OK);
		    } else {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
	
	
}
