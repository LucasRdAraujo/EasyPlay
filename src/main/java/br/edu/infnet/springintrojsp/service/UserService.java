package br.edu.infnet.springintrojsp.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.edu.infnet.springintrojsp.controller.dto.UserRegistrationDto;
import br.edu.infnet.springintrojsp.model.User;

public interface UserService extends UserDetailsService {
    User store(UserRegistrationDto urdto);
    User store(User user);
    User getUserById(String id);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    
}
