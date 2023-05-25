package com.smhrd.iot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.smhrd.iot.domain.before_product;

@Mapper
public interface ProductMapper {
	@Insert("INSERT IGNORE INTO BEFORE_PRODUCT VALUES(#{bepro.p_code},#{bepro.p_name},#{bepro.p_price},#{bepro.p_loc},#{bepro.p_weight},#{fileName})")
	public int insertProduct(String fileName,before_product bepro);
}
