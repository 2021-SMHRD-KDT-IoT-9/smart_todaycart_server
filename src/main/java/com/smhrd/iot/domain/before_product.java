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
}
