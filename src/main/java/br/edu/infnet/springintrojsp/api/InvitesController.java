// package br.edu.infnet.springintrojsp.api;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;

// import br.edu.infnet.springintrojsp.service.ServerService;

// @Controller
// @RequestMapping("/api/v1/invites")
// public class InvitesController {
    
//     @Autowired
//     private ServerService serverService;

//     @GetMapping("/{code}")
//     public String joinGuild(@PathVariable String code, Model model) {
//         return "app";
//     }
// }