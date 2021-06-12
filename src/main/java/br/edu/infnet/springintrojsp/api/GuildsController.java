package br.edu.infnet.springintrojsp.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.springintrojsp.controller.dto.ServerRegistrationDto;
import br.edu.infnet.springintrojsp.model.Category;
import br.edu.infnet.springintrojsp.model.Server;
import br.edu.infnet.springintrojsp.model.TextChannel;
import br.edu.infnet.springintrojsp.model.User;
import br.edu.infnet.springintrojsp.service.CategoryService;
import br.edu.infnet.springintrojsp.service.ServerService;
import br.edu.infnet.springintrojsp.service.UserService;
import br.edu.infnet.springintrojsp.util.IdGenerator;

@Controller
@RequestMapping("/api/v1/guilds")
public class GuildsController {

    @Autowired
    public UserService userService;

    @Autowired
    public ServerService serverService;

    @Autowired
    public CategoryService categoryService;

    @PostMapping
    public String createGuild(@ModelAttribute("serverDto") @Valid ServerRegistrationDto srdto) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        StringBuilder redirect = new StringBuilder().append("redirect:/channels/");
        Server server = new Server(IdGenerator.genId(), srdto.getName());

        if (principal instanceof UserDetails) {
            String email = ((UserDetails) principal).getUsername();
            User user = userService.getUserByEmail(email);

            if (user != null) {
                server.setOwnerId(user.getId());

                Category category = new Category(IdGenerator.genId(), "Canais de texto");
                category.getTextchannels().add(new TextChannel(IdGenerator.genId(), "Geral"));
                categoryService.store(category);

                server.getMembers().add(user);
                server.getCategories().add(category);
                user.getServers().add(server);

                userService.store(user);
                redirect.append(server.getId());
            } else
                redirect.append("app");
        } else
            redirect.append("app");

        return redirect.toString();
    }

    @DeleteMapping("/{guildid}")
    public String removeGuild(@PathVariable String guildid, Model model) {
        // Get Logged In User (Always...)
        return "app";
    }
}
