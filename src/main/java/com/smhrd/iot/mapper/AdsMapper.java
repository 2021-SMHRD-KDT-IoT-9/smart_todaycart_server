package com.smhrd.iot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdsMapper {
	@Insert("  INSERT IGNORE INTO ADS (ADS_ID, ADS_IMG, ADS_TYPE)\r\n"
			+ "  VALUES (#{imageName}, #{fileName}, #{adsType})")
	public int insertImage(String fileName, String imageName, String adsType);

}
