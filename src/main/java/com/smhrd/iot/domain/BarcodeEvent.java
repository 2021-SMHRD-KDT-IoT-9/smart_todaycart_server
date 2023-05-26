package com.smhrd.iot.domain;

//클래스간 바코드 이동을 위한 바코드 객체 생성
public class BarcodeEvent {
	  private String barcode;

	    public BarcodeEvent(String barcode) {
	        this.barcode = barcode;
	    }

	    public String getBarcode() {
	        return barcode;
	    }

		public void setBarcode(String barcode) {
			this.barcode = barcode;
		}
}
