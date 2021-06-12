package br.edu.infnet.springintrojsp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.springintrojsp.model.Code;
import br.edu.infnet.springintrojsp.model.Server;
import br.edu.infnet.springintrojsp.service.ServerService;
import br.edu.infnet.springintrojsp.util.IdGenerator;

@Controller
@RequestMapping("/api/v1/channels")
public class ChannelsController {
    
    @Autowired
    private ServerService serverService;

    @PostMapping("/{serverid}/invites")
    public String createInvite(@PathVariable String serverid, Model model) {
        // Server server = serverService.getServerById(serverid);
        // if(server != null) {
        //     Code code = new Code(IdGenerator.genId(), IdGenerator.genId());
        //     server.getInviteCodes().add(code);
        // }
        return "app";
    }
}
