package br.edu.infnet.springintrojsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.springintrojsp.controller.dto.ServerRegistrationDto;
import br.edu.infnet.springintrojsp.model.User;
import br.edu.infnet.springintrojsp.service.ServerService;
import br.edu.infnet.springintrojsp.service.TextChannelService;
import br.edu.infnet.springintrojsp.service.UserService;

@Controller
@RequestMapping("/channels")
public class AppController {

    @Autowired
    private UserService userService;

    @Autowired
    private ServerService serverService;

    @Autowired
    private TextChannelService textChannelService;

    @ModelAttribute("serverDto")
    public ServerRegistrationDto userRegistrationDto() {
        return new ServerRegistrationDto();
    }

    @GetMapping
    public String channels(Model model) {
        return "redirect:/channels/app";
    }

    @GetMapping({ "/app" })
    public String getApp(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String email = ((UserDetails) principal).getUsername();
            User user = userService.getUserByEmail(email);
            if (user != null)
                model.addAttribute("user", user);
                model.addAttribute("servers", user.getServers());
        }
        return "app";
    }

    @GetMapping({ "/{serverid}" })
    public String getServer(@PathVariable String serverid, Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String email = ((UserDetails) principal).getUsername();
            User user = userService.getUserByEmail(email);
            if (user != null) {
                // model.addAttribute("servers", user.getServers());
                model.addAttribute("user", user);
                model.addAttribute("server", serverService.getServerById(serverid));
            }
        }
        return "app";
    }

    @GetMapping({ "/{serverid}/{channelid}" })
    public String getChannelFromServer(@PathVariable String serverid, @PathVariable String channelid, Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String email = ((UserDetails) principal).getUsername();
            User user = userService.getUserByEmail(email);

            if(user != null) {
                model.addAttribute("user", user);
                model.addAttribute("server", serverService.getServerById(serverid));
                model.addAttribute("channel", textChannelService.getTextChannelById(channelid));
            }
        }
        return "app";
    }

}
