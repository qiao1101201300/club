package com.demo.club.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

@ClientEndpoint
@Component(value = "ClientWebSocket")
@Slf4j
public class ClientWebSocket {
    private byte[] bytes = new byte[0];

    @OnOpen
    public void onOpen(Session session) {
        log.debug("--------Client Success--------");
    }

    @OnMessage
    @Async
    public void echoBinaryMessage(Session session, ByteBuffer buffer, boolean last) throws IOException {
        log.info("session={},buffer ={},last={}", session, buffer, last);
        try {

            log.debug("--------接受消息--------");
            byte[] b = buffer.array();
            int aCount = bytes.length;
            int bCount = b.length;
            byte[] c = new byte[aCount + bCount];
            for (int i = 0; i < aCount; i++) {
                c[i] = bytes[i];
            }
            for (int i = 0; i < bCount; i++) {
                c[aCount + i] = b[i];
            }
            bytes = c;
            Map<String, Object> userProperties = session.getUserProperties();
            if (session.isOpen() && last == true) {
                //如果是停止心跳指令，则停止心跳信息
                File file = new File("C:/image/" + System.currentTimeMillis() + ".jpg");
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileOutputStream fe = new FileOutputStream(file, true);
                fe.write(bytes);
                fe.flush();
                fe.close();
                bytes = new byte[0];
            }
        } catch (IOException e) {
            try {
                session.close();
            } catch (IOException e1) {
                // Ignore
            }
        }
    }

    @OnClose
    public void onClose() {
        log.debug("--------Client Close--------");
    }

}
