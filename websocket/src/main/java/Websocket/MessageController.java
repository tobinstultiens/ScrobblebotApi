package Websocket;

import models.MessageModel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageController {
    @MessageMapping("/message")
    @SendTo("/client")
    public MessageModel greeting(MessageModel message)   {
        return message;
    }
}
