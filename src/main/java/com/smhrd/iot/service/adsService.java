package com.smhrd.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.iot.mapper.AdsMapper;

@Service
public class adsService {
	
	@Autowired
	AdsMapper mapper;
	
	public int insertImage(String fileName, String imageName, String adsType) {
		System.out.println(mapper.insertImage(fileName, imageName, adsType));
		return mapper.insertImage(fileName, imageName, adsType);
	}
}
