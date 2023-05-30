package com.smhrd.iot.domain;

import org.springframework.stereotype.Component;

import lombok.Data;

//클래스간 바코드 이동을 위한 바코드 객체 생성
@Component
@Data
public class barcodeEvent {
	  private String barcode;


}
