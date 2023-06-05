package com.smhrd.iot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.smhrd.iot.domain.before_product;

@Mapper
public interface AndProductMapper {
	@Select("SELECT * FROM BEFORE_PRODUCT where P_CODE=#{barcode}")
	public before_product getBarcodeProduct(String barcode);
	
	@Insert("INSERT INTO callList (call_id, call_cart, call_tel,call_loc) SELECT  MEMBER_INFO.MEMBER_ID,CART_INFO.cart_id, MEMBER_INFO.MEMBER_TEL, (SELECT BEFORE_PRODUCT.P_LOC FROM BEFORE_PRODUCT WHERE BEFORE_PRODUCT.P_CODE = #{barcode}) AS P_LOC\r\n"
			+ "FROM CART_INFO\r\n"
			+ "JOIN MEMBER_INFO ON CART_INFO.MEMBER_ID = MEMBER_INFO.MEMBER_ID\r\n"
			+ "WHERE CART_INFO.MEMBER_ID =#{id};")
	public int InsertCallList(String id, String barcode);
	
	@Insert("Insert into AFTER_PRODUCT values(#{member_id},#{code},NOW())")
	public int InsertAfterProduct(int code,String member_id);
	
   @Select("select * from  BEFORE_PRODUCT where P_NAME=#{p_name}")
    public before_product searchProduct(String p_name);
   
   @Select("select * from  BEFORE_PRODUCT where P_LOC=#{p_loc}")
   public List<before_product> map(String p_loc);
   
}
