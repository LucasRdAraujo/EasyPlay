package br.edu.infnet.springintrojsp.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import br.edu.infnet.springintrojsp.model.Message;
import br.edu.infnet.springintrojsp.service.IServerService;

@Controller
@Transactional
public class ChatController {

    @Autowired
    private IServerService iServerService;

    @MessageMapping("/channels/{channelid}/message")
    @SendTo("/topic/channels/{channelid}/message")
    public Message sendMessage(@DestinationVariable(value = "channelid") String channelid, @Payload Message message) {
        message = iServerService.createMessage(channelid, message.getSenderid(), message.getContent());
        return message;
    }

}
