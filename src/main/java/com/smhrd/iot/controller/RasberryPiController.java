package com.smhrd.iot.controller;

import java.io.IOException;


import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.smhrd.iot.domain.before_product;
import com.smhrd.iot.domain.scanBarcode;
import com.smhrd.iot.service.andProductService;
import com.smhrd.iot.service.RaspberryPiService;


@RestController
public class RasberryPiController {
	

	@Autowired
	RaspberryPiService service;


	@PostMapping(value="/scan")
	public void scanBarcode(@RequestParam("img") MultipartFile file) throws IOException{
		service.dataToImage(file);
	}
	
	@GetMapping(value="/Barcode")
	public void getBarcode(@RequestParam("barcode")String barcode) {
		System.out.println("라즈베리파이에서 읽은 바코드 값 : "+barcode);
		Cookie cookie = new Cookie("barcodeValue", barcode); // andProductController에서 읽을 수 있게
		
	}
	
}
