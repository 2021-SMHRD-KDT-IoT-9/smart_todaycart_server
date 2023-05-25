package com.smhrd.iot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.smhrd.iot.domain.before_product;

@Mapper
public interface AndProductMapper {
	@Select("SELECT * FROM before_product where P_CODE=#{barcode}")
	public before_product getBarcodeProduct(String barcode);
}
