package Websocket;

import models.MessageModel;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

public class MessageHandler extends TextWebSocketHandler {
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        TextMessage msg = new TextMessage("Hello, " + message.getPayload() + "!");
        session.sendMessage(msg);
        MessageController test = new MessageController();
        MessageModel messageModel = new MessageModel();
        messageModel.setMessage("hi");
        messageModel.setUsername("hi");
        test.greeting(messageModel);
    }
}
