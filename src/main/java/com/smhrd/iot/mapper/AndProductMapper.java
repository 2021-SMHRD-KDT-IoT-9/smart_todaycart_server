package com.smhrd.iot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.smhrd.iot.domain.before_product;

@Mapper
public interface AndProductMapper {
	@Select("SELECT * FROM BEFORE_PRODUCT where P_CODE=#{barcode}")
	public before_product getBarcodeProduct(String barcode);
	
	@Insert("INSERT INTO callList (call_id, call_cart, call_tel,call_loc)\r\n"
			+ "SELECT\r\n"
			+ "  CART_INFO.cart_id,\r\n"
			+ "  MEMBER_INFO.MEMBER_ID,\r\n"
			+ "  (SELECT BEFORE_PRODUCT.P_LOC FROM BEFORE_PRODUCT WHERE BEFORE_PRODUCT.P_CODE = #{barcode}) AS P_LOC\r\n"
			+ "FROM\r\n"
			+ "  CART_INFO\r\n"
			+ "JOIN\r\n"
			+ "  MEMBER_INFO ON CART_INFO.MEMBER_ID = MEMBER_INFO.MEMBER_ID\r\n"
			+ "WHERE\r\n"
			+ "  CART_INFO.MEMBER_ID = #{id};\r\n"
			+ "")
	public int InsertCallList(String id, String barcode);
	
	@Insert("Insert into AFTER_PRODUCT values(#{member_id},#{p_code},NOW())")
	public int InsertAfterProduct(before_product product,String member_id);
}
