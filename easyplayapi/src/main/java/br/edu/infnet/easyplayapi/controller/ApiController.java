package br.edu.infnet.easyplayapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.easyplayapi.model.Category;
import br.edu.infnet.easyplayapi.model.Message;
import br.edu.infnet.easyplayapi.model.Server;
import br.edu.infnet.easyplayapi.model.TextChannel;
import br.edu.infnet.easyplayapi.model.User;
import br.edu.infnet.easyplayapi.service.CategoryService;
import br.edu.infnet.easyplayapi.service.ServerService;
import br.edu.infnet.easyplayapi.service.TextChannelService;
import br.edu.infnet.easyplayapi.service.UserService;
import br.edu.infnet.easyplayapi.util.IdGenerator;

@RestController
@RequestMapping(value = "/api/v1")
public class ApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private ServerService serverService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TextChannelService textChannelService;

    @RequestMapping(value = "/channels/{channelid}/messages", method = RequestMethod.GET)
    public TextChannel getTextChannelMessages(@PathVariable(name = "channelid") String channelid) {
        Optional<TextChannel> textChannel = textChannelService.getById(channelid);
        if (!textChannel.isPresent())
            return new TextChannel();
        return textChannel.get();
    }

    @RequestMapping(value = "/guilds/{serverid}", method = RequestMethod.GET)
    public Server getGuildById(@PathVariable(name = "serverid") String serverid) {
        Optional<Server> server = serverService.getById(serverid);
        if (!server.isPresent())
            return new Server();
        return server.get();
    }

    @RequestMapping(value = "/channels/{channelid}/messages", method = RequestMethod.POST)
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
            if(txtchannel.isPresent()) {
                TextChannel updated = txtchannel.get();
                updated.getMessages().add(message);
                textChannelService.store(updated);
            }
        }
        return message;
    }

    @RequestMapping(value = "/guilds/{serverid}/join", method = RequestMethod.POST)
    public Server joinGuild(@PathVariable(name = "serverid") String serverid, @RequestParam(name = "id") String id) {
        Optional<User> user = userService.getById(id);
        if(user.isPresent()) {
            User userExists = user.get();

            Optional<Server> server = serverService.getById(serverid);
            if(server.isPresent()) {
                Server serverExists = server.get();

                if(!serverExists.memberExists(userExists.getId())) {
                    serverExists.getMembers().add(userExists);
                    userExists.getServers().add(serverExists);
                    userService.store(userExists);
                }
                return serverExists;
            }
            return new Server();
        }
        return new Server();
    }

    @RequestMapping(value = "/guilds", method = RequestMethod.POST)
    public Server createGuild(@RequestParam(name = "name") String name, @RequestParam(name = "id") String id) {
        Optional<User> user = userService.getById(id);
        Server server = new Server();

        if (user.isPresent()) {
            User uExists = user.get();

            server.setId(IdGenerator.genId());
            server.setName(name);

            server.setOwnerId(uExists.getId());

            Category category = new Category();
            category.setId(IdGenerator.genId());
            category.setName("Canais de texto");

            TextChannel txtchannel = new TextChannel();
            txtchannel.setId(IdGenerator.genId());
            txtchannel.setName("Geral");

            category.getTextchannels().add(txtchannel);
            categoryService.store(category);

            server.getMembers().add(uExists);
            server.getCategories().add(category);
            uExists.getServers().add(server);
            userService.store(uExists);
        }
        return server;
    }

}
