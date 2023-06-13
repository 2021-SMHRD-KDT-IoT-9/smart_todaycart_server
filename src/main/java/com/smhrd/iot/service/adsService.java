package com.smhrd.iot.service;

import java.util.List;

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
	
	public List<String>  getAdsImg(String ads_item,String ads_type) {	
		return mapper.getAdsImg(ads_item,ads_type);
	}
}
