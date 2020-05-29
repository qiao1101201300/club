package com.demo.club.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("ws://")
@Component
@Slf4j
public class ServiceWebSocket {
}
