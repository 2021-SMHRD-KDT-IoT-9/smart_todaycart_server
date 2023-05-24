package com.smhrd.iot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.smhrd.iot.domain.member_info;

@Mapper
public interface AndMapper {
	@Select("select count(*) from MEMBER_INFO WHERE MEMBER_ID=#{MEMBER_ID} AND MEMBER_PW=#{MEMBER_ID}")
	public int memberLogin(member_info m);
}
