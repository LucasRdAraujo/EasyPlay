package br.edu.infnet.easyplayapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.easyplayapi.model.Category;
import br.edu.infnet.easyplayapi.model.Server;
import br.edu.infnet.easyplayapi.model.TextChannel;
import br.edu.infnet.easyplayapi.model.User;
import br.edu.infnet.easyplayapi.service.CategoryService;
import br.edu.infnet.easyplayapi.service.ServerService;
import br.edu.infnet.easyplayapi.service.UserService;
import br.edu.infnet.easyplayapi.util.IdGenerator;

@RestController
@RequestMapping(value = "/api/v1/guilds")
public class GuildsController {

    @Autowired
    private UserService userService;

    @Autowired
    private ServerService serverService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/{serverid}", method = RequestMethod.GET)
    public Server getGuildById(@PathVariable(name = "serverid") String serverid) {
        Optional<Server> server = serverService.getById(serverid);
        if (!server.isPresent())
            return new Server();
        return server.get();
    }

    @RequestMapping(value = "/{serverid}/channels", method = RequestMethod.POST)
    public TextChannel createChannel(@PathVariable("serverid") String serverid, @RequestParam(name = "name") String name, @RequestParam(name = "categoryId") String categoryId) {
        
        TextChannel textChannel = new TextChannel();
        Optional<Category> category = categoryService.getById(categoryId);
        if(category.isPresent()) {
            Category cExists = category.get();
            
            textChannel.setId(IdGenerator.genId());
            textChannel.setName(name);
            textChannel.setParentId(cExists.getId());
            textChannel.setServerId(serverid);
            cExists.getTextchannels().add(textChannel);
            categoryService.store(cExists);
        }
        return textChannel;
    }

    @RequestMapping(value = "/{serverid}/delete")
    public void deleteGuild(@PathVariable("serverid") String serverid) {
        Optional<Server> server = serverService.getById(serverid);

        if(server.isPresent()) {
            serverService.deleteById(serverid);
        }
    }

    @RequestMapping(value = "/{serverid}/join", method = RequestMethod.POST)
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

    @RequestMapping(method = RequestMethod.POST)
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
            txtchannel.setServerId(server.getId());
            txtchannel.setName("Geral");

            category.getTextchannels().add(txtchannel);
            categoryService.store(category);

            server.getMembers().add(uExists);
            server.getCategories().add(category);
            uExists.getServers().add(server);
            serverService.store(server);
            userService.store(uExists);
        }
        return server;
    }

}
