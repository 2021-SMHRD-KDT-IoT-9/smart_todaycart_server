package com.smhrd.iot.domain;

import lombok.Data;

@Data
public class before_product {
	private int p_code; 
	private String p_name;
	private int p_price;  
	private String p_loc;
	private int p_weight;
	private String p_img;
	
	@Override
	public String toString() {
		return "before_product [p_code=" + p_code + ", p_name=" + p_name + ", p_price=" + p_price + ", p_loc=" + p_loc
				+ ", p_weight=" + p_weight + ", p_img=" + p_img + "]";
	}
    //기본 생성자
	public before_product() {
		
	}
	
	public before_product(int p_code, String p_name, int p_price, String p_loc, int p_weight, String p_img) {
		super();
		this.p_code = p_code;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_loc = p_loc;
		this.p_weight = p_weight;
		this.p_img = p_img;
	}

	
}
