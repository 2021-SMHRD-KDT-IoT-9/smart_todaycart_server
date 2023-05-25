package com.smhrd.iot.controller;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smhrd.iot.service.RaspberryPiService;

@RestController
public class RasberryPiController {
	
	@Autowired
	RaspberryPiService service;

	@PostMapping(value="/scan")
	public void scanBarcode(@RequestParam("img") MultipartFile file) throws IOException{
		service.dataToImage(file);
	}
	
	@GetMapping(value="/barcode")
	public void getBarcode(@RequestParam("barcode")String barcode) {
		System.out.println(barcode);
	}
	
}
