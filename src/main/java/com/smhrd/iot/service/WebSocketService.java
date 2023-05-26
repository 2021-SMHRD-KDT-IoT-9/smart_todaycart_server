package com.smhrd.iot.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.iot.domain.before_product;

@Service
@ServerEndpoint(value = "/shopingcart")
public class WebSocketService {
	
	@Autowired
	andProductService service;
	
	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
	
	//바코드 값을 읽어오면 해당 바코드의 상품을 안드로이드 단에 보내는 함수
	@OnMessage
	public before_product onMessage(String barcode) throws Exception{
		System.out.println("받은 바코드 값 : " + barcode);
		before_product product = service.getBarcodeProduct(barcode);
		return product;
	}
	
	
	
	@OnOpen
	public void onOpen(Session s) {
		System.out.println("open session : " + s.toString());
		if(!clients.contains(s)) {
			clients.add(s);
			System.out.println("session open : " + s);
		}else {
			System.out.println("이미 연결된 session 임!!!");
		}
	}
	
	@OnClose
	public void onClose(Session s) {
		System.out.println("session close : " + s);
		clients.remove(s);
	}
	
	
}
