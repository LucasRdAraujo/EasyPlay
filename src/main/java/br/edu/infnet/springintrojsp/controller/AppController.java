package br.edu.infnet.springintrojsp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.springintrojsp.controller.dto.ServerRegistrationDto;
import br.edu.infnet.springintrojsp.model.Server;
import br.edu.infnet.springintrojsp.model.TextChannel;
import br.edu.infnet.springintrojsp.model.User;
import br.edu.infnet.springintrojsp.service.IApiService;
import br.edu.infnet.springintrojsp.service.UserService;

@Controller
@RequestMapping("/channels")
public class AppController {

    @Autowired
    private UserService userService;

    @Autowired
    private IApiService iApiService;

    @ModelAttribute("serverDto")
    public ServerRegistrationDto userRegistrationDto() {
        return new ServerRegistrationDto();
    }

    @GetMapping
    public String channels(Model model) {
        return "redirect:/channels/app";
    }

    @GetMapping({ "/app" })
    public String app(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String email = ((UserDetails) principal).getUsername();
            User user = userService.getUserByEmail(email);

            if (user != null)
                model.addAttribute("user", user);
            model.addAttribute("servers", iApiService.getGuildsByUserId(user.getId()));
        }
        return "app";
    }

    @GetMapping({ "/{serverid}" })
    public String getServer(@PathVariable String serverid, Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String email = ((UserDetails) principal).getUsername();
            User user = userService.getUserByEmail(email);

            Server server = iApiService.joinGuild(serverid, user.getId());
            model.addAttribute("user", user);
            model.addAttribute("server", server);
        }
        return "guild";
    }

    @GetMapping({ "/{serverid}/{channelid}" })
    public String getServerChannel(@PathVariable String serverid, @PathVariable String channelid, Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String email = ((UserDetails) principal).getUsername();

            User user = userService.getUserByEmail(email);
            Server server = iApiService.joinGuild(serverid, user.getId());
            TextChannel textChannel = server.getTextChannelById(channelid);

            model.addAttribute("user", user);
            model.addAttribute("server", server);
            model.addAttribute("channel", textChannel);
        }
        return "guild";
    }

    @RequestMapping(value = "/guilds", method = RequestMethod.POST)
    public String createGuild(@ModelAttribute("serverDto") @Valid ServerRegistrationDto srdto) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String email = ((UserDetails) principal).getUsername();
            User user = userService.getUserByEmail(email);
            if (user != null) {
                Server server = iApiService.createGuild(srdto.getName(), user.getId());
                return new StringBuilder().append("redirect:/channels/").append(server.getId()).toString();
            }
        }
        return "redirect:/app";
    }
}
