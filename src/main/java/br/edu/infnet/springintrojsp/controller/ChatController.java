package br.edu.infnet.springintrojsp.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import br.edu.infnet.springintrojsp.model.Message;
import br.edu.infnet.springintrojsp.model.TextChannel;
import br.edu.infnet.springintrojsp.model.User;
import br.edu.infnet.springintrojsp.service.TextChannelService;
import br.edu.infnet.springintrojsp.service.UserService;

@Controller
@Transactional
public class ChatController {

    @Autowired
    private UserService userService;

    @Autowired
    private TextChannelService textChannelService;

    @MessageMapping("/channels/{channelid}/message")
    @SendTo("/topic/channels/{channelid}/message")
    public Message sendMessage(@DestinationVariable(value = "channelid") String channelid, @Payload Message message) {
        User user = userService.getUserById(message.getSenderid());
        message.setSender(user.getUsername());

        TextChannel txtchannel = textChannelService.getTextChannelById(channelid);
        if (txtchannel != null) {
            txtchannel.getMessages().add(message);
            textChannelService.store(txtchannel);
        }

        return message;
    }

}
