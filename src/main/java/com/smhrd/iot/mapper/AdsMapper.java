package com.smhrd.iot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdsMapper {
	//웹 페이지에서 광고 이미지 넣는 기능
	@Insert("  INSERT IGNORE INTO ADS (ADS_ID, ADS_IMG, ADS_TYPE,ADS_ITEM)\r\n"
			+ "  VALUES (#{imageName}, #{fileName}, #{adsType},#{imageType})")
	public int insertImage(String fileName, String imageName, String imageType,String adsType);
	
	//파이썬 서버에서 받은 상품 유형에 맞는 광고 이미지 고르기
	@Select("Select ADS_IMG from ADS where ADS_ITEM=#{ads_item} and ADS_TYPE=#{ads_type}")
	public String getAdsImg(String ads_item,String ads_type);
	
}
