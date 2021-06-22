package br.edu.infnet.springintrojsp.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.edu.infnet.springintrojsp.model.User;

public interface UserService extends UserDetailsService {
    void store(User user);

    Optional<User> getUserById(String id);

    User getUserByEmail(String email);
}
