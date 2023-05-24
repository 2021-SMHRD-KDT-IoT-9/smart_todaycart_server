package com.smhrd.iot.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class scanBarcode {
	private MultipartFile img;
	private String type;
	private String name;
}
