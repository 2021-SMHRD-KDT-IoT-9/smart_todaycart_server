package com.smhrd.iot.domain;

import lombok.Data;

@Data
public class member_info {
	private String member_id;
	private String member_pw;
	private String member_name;
	private String member_tel;
	private String member_add;
	private String member_gender;
	
	private String abc;
	private String def;
	
	@Override
	public String toString() {
		return "member_info [member_id=" + member_id + ", member_pw=" + member_pw + ", member_name=" + member_name
				+ ", member_tel=" + member_tel + ", member_add=" + member_add + ", member_gender=" + member_gender
				+ "]";
	}
	
	
}
