package com.smirnov.test1;

import java.io.IOException;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/echo")
public class EchoServer {
    @OnMessage
    public void onMessage(final Session session, String msg) {
        System.out.println("Msg: " + msg);
        try {
            session.getBasicRemote().sendText(msg);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
