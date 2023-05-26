package com.smhrd.iot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.smhrd.iot.domain.member_info;

@Mapper
public interface AndMapper {
	@Select("select count(*) from MEMBER_INFO WHERE MEMBER_ID=#{id} AND MEMBER_PW=#{pw}")
	public int memberLogin(String id, String pw);
	@Insert("Insert into MEMBER_INFO(MEMBER_ID,MEMBER_PW,MEMBER_NAME,MEMBER_TEL,MEMBER_ADD) values(#{member_id},#{member_pw},#{member_name},#{member_tel},#{member_add})")
	public int newMember(member_info m);
}
