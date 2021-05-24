package br.edu.infnet.easyplay.controller;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.easyplay.model.AuthForm;
import br.edu.infnet.easyplay.model.User;
import br.edu.infnet.easyplay.repository.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    @Autowired
    private UserRepository userRepository;

    /*@Autowired
    private UserDAO userdao;*/

    @ModelAttribute("AuthForm")
    public AuthForm setAuthForm() {
        return new AuthForm();
    }

    @RequestMapping("/signup")
    public String app() {
        return "signup";
    }

    @PostMapping("/signupuser")
    public String signUpUser(@ModelAttribute("AuthForm") AuthForm authForm, Model model) {
        String username = authForm.getUsername();
        String senha = authForm.getSenha();
        String email = authForm.getEmail();

        if (username.isEmpty() || senha.length() < 5 || email.isEmpty())
            return "signup";

        long i = Instant.now().toEpochMilli();
        userRepository.setUser(new User(Long.toString(i), username, senha, email));


        // TENTATIVA BANCO DE DADOS
        
        // userdao.persistUser(new User(Long.toString(i), username, senha, email));
        /*model.addAttribute("username", username);
        model.addAttribute("email", email);*/

       /* long i = Instant.now().toEpochMilli();
        User user = new User(Long.toString(((i - Instant.now().toEpochMilli()) << 12)*-1), authForm.getUsername(), authForm.getEmail(), authForm.getSenha());
        
        model.addAttribute("id", user.getId());
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());*/
        return "home";
    }

}
