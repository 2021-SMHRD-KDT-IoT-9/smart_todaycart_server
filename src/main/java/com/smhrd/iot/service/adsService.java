package com.smhrd.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.iot.mapper.AdsMapper;

@Service
public class adsService {
	
	@Autowired
	AdsMapper mapper;
	
	public int insertImage(String fileName, String imageName, String adsType, String imageType) {
		System.out.println(mapper.insertImage(fileName, imageName, adsType,imageType));
		return mapper.insertImage(fileName, imageName, adsType,imageType);
	}
	
	public String  getAdsImg(String ads) {
		System.out.println("서비스단에서 광고 찾기 성공");
		return mapper.getAdsImg(ads);
	}
}
