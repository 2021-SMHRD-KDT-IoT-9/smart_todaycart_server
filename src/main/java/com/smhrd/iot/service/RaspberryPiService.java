package com.smhrd.iot.service;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class RaspberryPiService {
	public void dataToImage(MultipartFile file) throws IOException {
		
		byte [] imgData = file.getBytes();
		String fileName = file.getOriginalFilename();
	
		try (FileOutputStream fos = new FileOutputStream("C:\\Users\\user\\OneDrive\\"+fileName)) {
            fos.write(imgData);
            fos.flush();
            System.out.println("이미지 파일이 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("이미지 파일 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
		
	}
}
