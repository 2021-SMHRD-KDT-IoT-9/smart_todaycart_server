package com.smhrd.iot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smhrd.iot.domain.barcodeEvent;
import com.smhrd.iot.domain.before_product;
import com.smhrd.iot.domain.scanBarcode;
import com.smhrd.iot.service.andProductService;

import lombok.Data;

import com.smhrd.iot.service.RaspberryPiService;


@Data
@RestController
public class RasberryPiController {

	//이미지 파일 통신을 위해 필요한 객체
	@Autowired
	RaspberryPiService service;
	
	//바코드 값 저장을 위해 필요한 객체
	@Autowired
	barcodeEvent barcodeScan;
	
	//라즈베리파이에서 전달한 weight와 비교하기 위해 필요
	before_product product;
	
	//라즈베리파이에서 읽어온 weight 다른 함수에서 비교하기 위해 전역함수 설정
	Double weightMeasure;
	

	//라즈베리파이에서 카메라로 찍은 이미지 파일, 무게센서로 읽어온 무게 값 받는 코드
	@PostMapping(value="/scan")
	public void scanProduct(@RequestParam("img") MultipartFile file, @RequestParam("weight") Double weight) throws IOException {
	    try {
	        weightMeasure = weight;
	        service.dataToImage(file);
	        System.out.println(weightMeasure);
	    } catch (NullPointerException e) {
	        // 예외 처리 로직을 추가해주세요
	    	System.out.println("널에러");
	        e.printStackTrace();
	        weightMeasure=(double) 0;
	        // 예외 발생 시에도 진행되게 하려면, 적절한 대체값이나 처리 방법을 선택하여 코드를 추가해주세요.
	    }
	}

	
	//라즈베리파이에서 바코드를 읽은 후 해당 상품을 안드로이드로 보내는 코드
	@GetMapping(value="/barcode")
	public void getBarcode(@RequestParam("barcode") String barcode) throws Exception {
		System.out.println("라즈베리파이에서 읽은 바코드 값 : "+barcode);
		barcodeScan.setBarcode(barcode);
	}
			
		}
		
