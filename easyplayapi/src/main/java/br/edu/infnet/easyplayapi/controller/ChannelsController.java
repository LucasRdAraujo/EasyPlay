package br.edu.infnet.easyplayapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.easyplayapi.model.Message;
import br.edu.infnet.easyplayapi.model.TextChannel;
import br.edu.infnet.easyplayapi.model.User;
import br.edu.infnet.easyplayapi.service.TextChannelService;
import br.edu.infnet.easyplayapi.service.UserService;
import br.edu.infnet.easyplayapi.util.IdGenerator;

@RestController
@RequestMapping(value = "/api/v1/channels")
public class ChannelsController {

    @Autowired
    private UserService userService;

    @Autowired
    private TextChannelService textChannelService;

    @RequestMapping(value = "/{channelid}/messages", method = RequestMethod.GET)
    public TextChannel getTextChannelMessages(@PathVariable(name = "channelid") String channelid) {
        Optional<TextChannel> textChannel = textChannelService.getById(channelid);
        if (!textChannel.isPresent())
            return new TextChannel();
        return textChannel.get();
    }

    @RequestMapping(value = "/{channelid}", method = RequestMethod.DELETE)
    public TextChannel deleteChannel(@PathVariable("channelid") String channelid) {
        Optional<TextChannel> textChannelExist = textChannelService.getById(channelid);
        TextChannel textChannel = textChannelExist.get();

        if (!textChannelExist.isPresent())
            return new TextChannel();

        textChannelService.deleteById(textChannel.getId());
        return textChannel;

    }

    @RequestMapping(value = "/{channelid}/messages", method = RequestMethod.POST)
    public Message createMessage(@PathVariable(name = "channelid") String channelid,
            @RequestParam(name = "senderid") String senderid, @RequestParam(name = "content") String content) {

        Optional<User> user = userService.getById(senderid);
        Message message = new Message();

        if (user.isPresent()) {
            User uExists = user.get();
            message.setId(IdGenerator.genId());
            message.setSenderid(senderid);
            message.setSender(uExists.getUsername());
            message.setContent(content);

            Optional<TextChannel> txtchannel = textChannelService.getById(channelid);
            if (txtchannel.isPresent()) {
                TextChannel updated = txtchannel.get();
                updated.getMessages().add(message);
                textChannelService.store(updated);
            }
        }
        return message;
    }
}
