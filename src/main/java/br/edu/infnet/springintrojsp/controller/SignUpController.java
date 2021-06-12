package br.edu.infnet.springintrojsp.controller;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.infnet.springintrojsp.controller.dto.UserRegistrationDto;
import br.edu.infnet.springintrojsp.model.User;
import br.edu.infnet.springintrojsp.service.UserService;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    @Autowired
    private UserService userService;

    @ModelAttribute("userDto")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String signUp(Model model) {
        return "signup";
    }

    @PostMapping
    public String signUp(@ModelAttribute("userDto") @Valid UserRegistrationDto urdto, BindingResult bindingResult)
            throws NoSuchAlgorithmException {
        User user = userService.getUserByEmail(urdto.getEmail());
        if(user != null)
                bindingResult.rejectValue("email", null, "Email already exists");
        
        if(bindingResult.hasErrors())
                return "signup";
        
        userService.store(urdto);
        return "redirect:/signin";
    }
}
