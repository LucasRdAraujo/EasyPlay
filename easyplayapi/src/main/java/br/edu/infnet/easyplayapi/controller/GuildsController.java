package br.edu.infnet.easyplayapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.easyplayapi.model.Category;
import br.edu.infnet.easyplayapi.model.Member;
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

    @RequestMapping(method = RequestMethod.GET)
    public List<Server> getGuildByUserId(@RequestParam(name = "userId") String userId) {
        Optional<User> exists = userService.getById(userId);

        if(exists.isPresent()) {
            User user = exists.get();
            
            List<Server> server = serverService.getServersByUserId(user.getId());
            if(server != null)
                return server;
        }
        return new ArrayList<>();
    }

    @RequestMapping(value = "/{serverid}/channels", method = RequestMethod.POST)
    public TextChannel createChannel(@PathVariable("serverid") String serverid,
            @RequestParam(name = "name") String name, @RequestParam(name = "categoryId") String categoryId) {

        TextChannel textChannel = new TextChannel();
        Optional<Category> category = categoryService.getById(categoryId);
        if (category.isPresent()) {
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

    @RequestMapping(value = "/{serverid}/join", method = RequestMethod.POST)
    public Server joinGuild(@PathVariable(name = "serverid") String serverid, @RequestParam(name = "id") String id) {
        Optional<User> userexist = userService.getById(id);

        if (userexist.isPresent()) {
            User user = userexist.get();

            Optional<Server> serverexist = serverService.getById(serverid);
            if (serverexist.isPresent()) {
                Server server = serverexist.get();

                if (!server.memberExists(user.getId())) {

                    Member member = new Member();
                    member.setId(user.getId());
                    member.setUsername(user.getUsername());

                    server.getMembers().add(member);
                    serverService.store(server);

                    user.getServers().add(server);
                    userService.store(user);
                }
                return server;
            }
            return new Server();
        }
        return new Server();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Server createGuild(@RequestParam(name = "name") String name, @RequestParam(name = "id") String id) {
        Optional<User> exist = userService.getById(id);
        Server server = new Server();

        if (exist.isPresent()) {
            User user = exist.get();

            server.setId(IdGenerator.genId());
            server.setOwnerId(user.getId());
            server.setName(name);

            Category category = new Category();
            category.setId(IdGenerator.genId());
            category.setName("Canais de texto");

            TextChannel textChannel = new TextChannel();
            textChannel.setId(IdGenerator.genId());
            textChannel.setServerId(server.getId());
            textChannel.setParentId(category.getId());
            textChannel.setName("Geral");

            category.getTextchannels().add(textChannel);
            categoryService.store(category);
            server.getCategories().add(category);

            Member member = new Member();
            member.setId(user.getId());
            member.setUsername(user.getUsername());

            server.getMembers().add(member);
            serverService.store(server);

            user.getServers().add(server);
            userService.store(user);
        }
        return server;
    }

    @RequestMapping(value = "/{serverid}/delete", method = RequestMethod.DELETE)
    public void deleteGuild(@PathVariable("serverid") String serverid) {
        Optional<Server> server = serverService.getById(serverid);

        if (server.isPresent()) {
            serverService.deleteById(serverid);
        }
    }

}
