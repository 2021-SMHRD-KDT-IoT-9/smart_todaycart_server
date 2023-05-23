package com.smhrd.iot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.smhrd.iot.domain.cartList;

@Mapper
public interface CartMapper {
	@Select("SELECT CI.CART_ID, CI.MEMBER_ID, MI.MEMBER_TEL\r\n"
			+ "FROM CART_INFO CI\r\n"
			+ "JOIN MEMBER_INFO MI ON CI.MEMBER_ID = MI.MEMBER_ID")
	public List<cartList> showCartList();
}
