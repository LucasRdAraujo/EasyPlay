package br.edu.infnet.easyplayapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.easyplayapi.model.User;
import br.edu.infnet.easyplayapi.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void store(User user) {
        userRepository.save(user);
    }

    @Override
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(String id) {
        return userRepository.findById(id); // userRepository.findById(id).orElse(null);
    }
    
}
