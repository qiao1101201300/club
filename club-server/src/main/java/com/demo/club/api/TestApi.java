package com.demo.club.api;

import com.alibaba.fastjson.JSONObject;
import com.demo.club.service.WebSocket;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;

@RestController
@Slf4j
public class TestApi {
    @Test
    public void openDevice() {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
//        container.setDefaultMaxBinaryMessageBufferSize(1024 * 1024);
        URI url = URI.create("ws://127.0.0.1:19000");
        try {
            Session session = container.connectToServer(WebSocket.class, url);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("func", "openDevice");
            jsonObject.put("bioType", 1);
            if (session.isOpen()) {
                log.debug("--------打开设备--------");
                session.getBasicRemote().sendText(jsonObject.toJSONString());
            }
            Thread.sleep(5000);
            JSONObject jsonObject2 = new JSONObject();
            jsonObject2.put("func", "closeDevice");
            if (session.isOpen()) {
                log.debug("--------关闭设备--------");
                session.getBasicRemote().sendText(jsonObject2.toJSONString());
            }
            session.close();
        } catch (DeploymentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() throws IOException {
        String jarWholePath = TestApi.class.getProtectionDomain().getCodeSource().getLocation().getFile();
        try {
            //保险起见，将路径进行decode转码
            jarWholePath = java.net.URLDecoder.decode(jarWholePath, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.toString());
        }
        //获取jar包的上级目录
        String jarPath = new File(jarWholePath).getParentFile().getAbsolutePath();
        System.out.println(jarPath);
    }
}
