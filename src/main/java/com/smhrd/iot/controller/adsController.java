package com.smhrd.iot.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smhrd.iot.service.adsService;

@RestController
public class adsController {
	@Autowired
	adsService service;

	@Value("${upload.path}")
	private String uploadPath;

	@PostMapping("/upload")
	public void uploadImage(HttpServletRequest request, @RequestParam("imageFile") MultipartFile imageFile,
			@RequestParam("imageName") String imageName,@RequestParam("imageType") String imageType, @RequestParam("adsType") String adsType) {

		if (!imageFile.isEmpty()) {
			String fileName = "/" + imageName + "_" + imageFile.getOriginalFilename();
			String realPath=uploadPath+"/adsUpload";
			
			System.out.println(realPath);
			//String filePath2 = request.getRealPath("resources/static/adsUpload");
			//System.out.println(filePath2);
			Path filePath = Path.of(realPath, fileName);
			//Path filePath = Path.of(filePath2, fileName);
	

			try {
				Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
				// 파일 저장 성공 시 처리할 로직
				insertImage(fileName, imageName, adsType,imageType);
				imageFile.getInputStream().close();
				System.out.println("이미지 저장 성공");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
				
				
				
			}

		} else {
			// 업로드할 이미지가 없는 경우 처리할 로직
			System.err.println("업로드할 이미지 없음");

		}
	}

	private void insertImage(String fileName, String imageName, String adsType,String imageType) {
		service.insertImage(fileName, imageName, adsType,imageType);
		System.out.println(service.insertImage(fileName, imageName, adsType,imageType));
	}

}
