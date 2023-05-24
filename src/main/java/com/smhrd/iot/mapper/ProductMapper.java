package com.smhrd.iot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.smhrd.iot.domain.before_product;

@Mapper
public interface ProductMapper {
	@Insert("INSERT IGNORE INTO BEFORE_PRODUCT VALUES(#{bepro.P_CODE},#{bepro.P_NAME},#{bepro.P_PRICE},#{bepro.P_LOC},#{bepro.P_WEIGHT},#{fileName})")
	public int insertProduct(String fileName,before_product bepro);
}
