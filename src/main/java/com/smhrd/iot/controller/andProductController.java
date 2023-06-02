package com.smhrd.iot.controller;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ModuleLayer.Controller;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.smhrd.iot.domain.barcodeEvent;
import com.smhrd.iot.domain.before_product;
import com.smhrd.iot.domain.member_info;
import com.smhrd.iot.domain.pythonResult;
import com.smhrd.iot.service.andProductService;

@RestController
public class andProductController {
	//이미지 찾기 위한 경로
	 private static final String IMAGE_DIRECTORY = "static/productUpload";
	
	@Autowired 
	barcodeEvent barcodeScan;
	
	@Autowired
	andProductService service;
	
	before_product pt;
	
	//장바구니에서 상품을 뺐다는 걸 확인하기 위해 필요한 객체\
	RasberryPiController controller = new RasberryPiController();
	//결제 요청한 장바구니에 있는 상품들 이름에 관한 arrayList
	ArrayList<String> productName = new ArrayList<>();
	
	
	
	
	
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
	public before_product addToShoppingCart() {
    	String barcode="12345";
    	 System.out.println("쇼핑카트 시도");
    	if(barcode!=null) {
    		   pt = service.getBarcodeProduct(barcode);
    		    
    		  System.out.println(pt.toString());
    		  return pt;
        } else {
            return null;
        }
    }
	


	/*
	 * @RequestMapping(value="/payProduct", method=RequestMethod.POST, consumes =
	 * "application/json") //@RequestBody ArrayList<before_product> productList
	 * public ResponseEntity<Map<String, Object>> payProduct(@RequestBody
	 * before_product product, @RequestParam String member_id) {
	 * System.out.println(product.toString()); System.out.println(member_id); int
	 * code = product.getP_code(); if(service.InsertAfterProduct(code, member_id)>0)
	 * { System.out.println("결제 완료"); Map<String, Object> response = new
	 * HashMap<>(); response.put("success", true); response.put("message", "결제 완료");
	 * return ResponseEntity.ok(response); } else { Map<String, Object> response =
	 * new HashMap<>(); response.put("success", false); response.put("message",
	 * "결제 실패"); return ResponseEntity.ok(response); } }
	 */
	
	
	//결제 완료 버튼을 눌렀을 때 카메라에 찍힌 이미지와 무게 센서로 측정한 무게로 비교한 후 
	//둘 중 하나라도 맞을 때 결제 후 결제 완료 테이블에 추가
	@RequestMapping(value="/payProduct", method=RequestMethod.POST,  consumes = "application/json")
	 public  ResponseEntity<Map<String, Object>> payProduct(@RequestBody ArrayList<before_product> productList, @RequestParam String member_id) {
		 Map<String, Object> response = new HashMap<>();
		 //check함수를 통해 장바구니 내 무게값과 이름을 비교 
		if(check(controller,productList,productName)) {
			//무게값이 같거나 이름이 전부 장바구니에 포함되어있을 때 장바구니 결제 진행
			for (before_product product : productList) {
				int code = product.getP_code();
				 if(service.InsertAfterProduct(code, member_id)>0) {
					 System.out.println("결제 완료");
			           response.put("success", true);
			          response.put("message", "결제 완료");
			     }
				 else {
					//무게값이 같거나 이름이 전부 장바구니에 포함되어있는데 결제가 제대로 되지 않는 경우 
					    response.put("success", false);
				        response.put("message", "결제 실패");
				     			 
					 }
				 }
		}else {
			//무게값이 같거나 이름이 전부 장바구니에 포함되어있는데 결제가 제대로 되지 않는 경우 
			response.put("success", false);
	        response.put("message", "카메라 찰영 결과 장바구니 품목 이상함");
	        
		}
		//결과가 어떻게 되든 무게 센서에서 측정한 무게 값을 0으로 초기화
		 productName.clear();
		 System.out.println(productName.size());
		controller.weightMeasure=0;
		 return ResponseEntity.ok(response);
		
	}
	
	//무게랑 이름이 같은 지 비교하는 함수
	private boolean check(RasberryPiController controller,ArrayList<before_product> productList,ArrayList<String> productName) {
		boolean check=false;
		int weightSum = 0;
		for (before_product product : productList) {
	        weightSum += product.getP_weight();
	        if (weightSum == controller.getWeightMeasure() || productName.contains(product.getP_name())) {
	           check=true;
	        }
	       
	    }
		 return check;
	}
	
	  //파이썬 서버로부터 스프링 부트는 값을 받아야 한다
	@RequestMapping(value="/deleteCheck", method=RequestMethod.POST,  consumes = "application/json")
	public void deleteShopingCart(@RequestBody List<pythonResult> resultset){
	
				for(pythonResult result : resultset) {
					String p_name = result.getP_name();
					productName.add(p_name);
					
					}
				for (String name : productName) {
				    System.out.println(name);
				}
				
			} 
	
	
	

			
}
	
