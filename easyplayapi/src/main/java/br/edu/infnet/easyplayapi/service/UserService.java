package br.edu.infnet.easyplayapi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.infnet.easyplayapi.model.User;

@Service
public interface UserService {
    public void store(User user);
    public Iterable<User> getAll();
    public Optional<User> getById(String id);
}
