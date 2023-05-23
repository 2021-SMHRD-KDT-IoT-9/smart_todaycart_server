package com.smhrd.iot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.smhrd.iot.domain.callList;

@Mapper
public interface CallMapper {
	@Select("select * from callList")
	public List<callList> showCallList();
	
	@Delete("Delete from callList where call_id=#{call_id}")
	public void deleteCall(String call_id);
}
