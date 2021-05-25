package br.edu.infnet.easyplay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.easyplay.model.AuthForm;
import br.edu.infnet.easyplay.model.User;
import br.edu.infnet.easyplay.repository.UserRepository;

@Controller
public class SignInController {
    
    @Autowired
    private UserRepository userRepository;

    @ModelAttribute("AuthForm")
	public AuthForm setAuthForm() {
		return new AuthForm();
	}

    @RequestMapping("/signin")
	public String app() {
		return "signin";
	}

	@RequestMapping(value = "/signinuser", method = RequestMethod.POST)
    public String signInUser(@ModelAttribute("AuthForm") AuthForm authForm, Model model) {
        String senha = authForm.getSenha();
        String email = authForm.getEmail();

        if (senha.length() < 5 || email.isEmpty())
            return "signin";

        User user = userRepository.getUser(email, senha);
		if(user == null)
			return "signin";
		
		model.addAttribute("username", user.getUsername());
		model.addAttribute("email", user.getEmail());
        return "app";
    }

}
