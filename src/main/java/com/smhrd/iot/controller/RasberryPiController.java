package com.smhrd.iot.controller;

import java.io.IOException;


import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smhrd.iot.domain.barcodeEvent;
import com.smhrd.iot.domain.before_product;
import com.smhrd.iot.domain.scanBarcode;
import com.smhrd.iot.service.andProductService;
import com.smhrd.iot.service.RaspberryPiService;
import com.smhrd.iot.service.WebSocketService;


@RestController
public class RasberryPiController {
	
	//웹 소켓 통신을 위해 필요한 객체
	@Autowired
	private WebSocketService socketService;
	
	//이미지 파일 통신을 위해 필요한 객체
	@Autowired
	RaspberryPiService service;
	
	//바코드 값 저장을 위해 필요한 객체
	@Autowired
	barcodeEvent barcodeScan;
	
	@PostMapping(value="/scan")
	public void scanBarcode(@RequestParam("img") MultipartFile file) throws IOException{
		service.dataToImage(file);
	}
	
	
	//라즈베리파이에서 바코드를 읽은 후 해당 상품을 안드로이드로 보내는 코드
	@GetMapping(value="/Barcode")
	public void getBarcode(@RequestParam("barcode") String barcode,HttpSession session) throws Exception {
		System.out.println("라즈베리파이에서 읽은 바코드 값 : "+barcode);
		barcodeScan.setBarcode(barcode);
	}
	
}
