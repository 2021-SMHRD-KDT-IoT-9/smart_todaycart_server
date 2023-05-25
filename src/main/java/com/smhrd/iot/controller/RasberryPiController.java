package com.smhrd.iot.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.spi.FileSystemProvider;
import java.util.Arrays;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.smhrd.iot.domain.scanBarcode;

@RestController
public class RasberryPiController {

	@PostMapping(value="/scan")
	public void scanBarcode(@RequestParam("img") MultipartFile files) throws IOException{
		System.out.println("작동");
				
		
		byte [] imgData = files.getBytes();
		String fileName = files.getOriginalFilename();
		System.out.println("멀가?"+Arrays.toString(imgData));
		System.out.println("원래이름"+fileName);
		try (FileOutputStream fos = new FileOutputStream("C:\\Users\\user\\Desktop\\123.jpg")) {
            fos.write(imgData);
            fos.flush();
            System.out.println("이미지 파일이 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("이미지 파일 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
		
		
	}
	
	@GetMapping(value="/barcode")
	public void getBarcode(@RequestParam("barcode")String barcode) {
		System.out.println(barcode);
	}
	
}
