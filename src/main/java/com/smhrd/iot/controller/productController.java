package com.smhrd.iot.controller;

import java.awt.PageAttributes.MediaType;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smhrd.iot.domain.before_product;
import com.smhrd.iot.service.adsService;
import com.smhrd.iot.service.productService;

@RestController
public class productController {
	@Autowired
	productService service;

	@Value("${upload.path}")
	private String uploadPath;

	@PostMapping(value = "/insertProduct")
	public void uploadImage(HttpServletRequest request, @RequestParam("imageFile") MultipartFile imageFile, @ModelAttribute before_product product) {
		if (!imageFile.isEmpty()) {
	
			String fileName = "/" + product.getP_name() + "_" + imageFile.getOriginalFilename();
			String realPath=uploadPath+"/productUpload";
			
			System.out.println(realPath);
			//String filePath2 = request.getRealPath("resources/static/adsUpload");
			//System.out.println(filePath2);

			
			Path filePath = Path.of(realPath, fileName);
			//Path filePath = Path.of(filePath2, fileName);


			try {
				Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
				// 파일 저장 성공 시 처리할 로직
				insertProduct(fileName,product);
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


	private void insertProduct(String fileName, before_product product) {
		service.insertProduct(fileName, product);
		System.out.println(service.insertProduct(fileName, product));
	}
}
