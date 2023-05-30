package com.smhrd.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.iot.domain.barcodeEvent;
import com.smhrd.iot.service.andProductService;

@RestController
public class andProductController {
	
	@Autowired 
	barcodeEvent barcodeScan;
	
	@Autowired
	andProductService service;
	
	@RequestMapping(value="/callManager", method=RequestMethod.POST)
	public void callManager(@RequestParam("id") String id) {
		String barcode=barcodeScan.getBarcode();
		service.InsertCallList(id, barcode);
		System.out.println("안드로이드 직원호출 컨트롤러");
		
		
	}
	
	
}
