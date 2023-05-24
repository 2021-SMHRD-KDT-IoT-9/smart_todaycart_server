package com.smhrd.iot.controller;

import java.nio.file.spi.FileSystemProvider;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smhrd.iot.domain.scanBarcode;

@RestController
public class RasberryPiController {

	@PostMapping(value="/scan")
	public void scanBarcode(@RequestParam("img") MultipartFile imageFile, @RequestBody scanBarcode scan) {
		System.out.println("라즈베리파이 : "+imageFile.toString());
		System.out.println(scan.getName());
		System.out.println(scan.getType());
	}
	
	@GetMapping(value="/barcode")
	public void getBarcode(@RequestParam("barcode")String barcode) {
		System.out.println(barcode);
	}
	
}
