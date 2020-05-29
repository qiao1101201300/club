package com.demo.club.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/webSocket")
@Component
@Slf4j
public class ServiceWebSocket {
    private Session session;

    private static CopyOnWriteArraySet<ServiceWebSocket> webSockets = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSockets.add(this);
        System.out.println("有新的连接，总数" + webSockets.size());
    }

    @OnClose
    public void onClose() {
        webSockets.remove(this);
        System.out.println("有新的断开，总数" + webSockets.size());
    }

    @OnMessage
    public void onMessage(String message) {

        System.out.println(message);

        send(message);
    }

    @OnError
    public void onError(Throwable error) {
        System.out.println(this + "；发生错误");
        error.printStackTrace();
    }
    public void send(String message) {
        for (ServiceWebSocket webSocket : webSockets) {
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
