package br.edu.infnet.springintrojsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import br.edu.infnet.springintrojsp.model.Message;
import br.edu.infnet.springintrojsp.model.User;
import br.edu.infnet.springintrojsp.service.UserService;

@Controller
public class ChatController {

    @Autowired
    private UserService userService;

    @MessageMapping("/channels/{channelid}")
    @SendTo("/topic/channels/{channelid}")
    public Message sendMessage(@DestinationVariable(value = "channelid") String channelid, @Payload Message message) {
        User user = userService.getUserById(message.getSender());
        message.setSender(user.getUsername());
        return message;
    }

}
