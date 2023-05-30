package com.smhrd.iot.service;

import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smhrd.iot.domain.barcodeEvent;
import com.smhrd.iot.domain.before_product;

@Component
class MyWebSocketHandler extends TextWebSocketHandler {

    private static final ConcurrentHashMap<String, WebSocketSession> CLIENTS = new ConcurrentHashMap<String, WebSocketSession>();
	
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    	System.out.println(session.getId());
        CLIENTS.put(session.getId(), session);        
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        CLIENTS.remove(session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String id = session.getId();  //메시지를 보낸 아이디
        System.out.println(id + " " + message);
        
        CLIENTS.entrySet().forEach( arg->{
            System.out.println(arg.getKey());

            if(arg.getKey().equals(id)) {  //같은 아이디가 아니면 메시지를 전달합니다.
                try {
                    arg.getValue().sendMessage(message);
                    System.out.println("Send message: " + message );

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
            System.out.println("Loop close");

        });
    }
}

@Configuration
@EnableWebSocket
public class WebSocketService implements WebSocketConfigurer {
	
    private final MyWebSocketHandler webSocketHandler;
    
    public WebSocketService(MyWebSocketHandler webSocketHandler) {
        this.webSocketHandler = webSocketHandler;
    }
    
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler, "/shopingcart").setAllowedOrigins("*");
    }
}
