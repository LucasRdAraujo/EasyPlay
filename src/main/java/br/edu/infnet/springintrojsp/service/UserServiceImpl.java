package br.edu.infnet.springintrojsp.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.infnet.springintrojsp.controller.dto.UserRegistrationDto;
import br.edu.infnet.springintrojsp.model.Server;
import br.edu.infnet.springintrojsp.model.User;
import br.edu.infnet.springintrojsp.repository.UserRepository;
import br.edu.infnet.springintrojsp.util.IdGenerator;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User store(UserRegistrationDto urdto) {
        User user = new User(IdGenerator.genId(), urdto.getUsername(), urdto.getEmail(), passwordEncoder.encode(urdto.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User store(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(String id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(email);

        if(user == null)
            throw new UsernameNotFoundException("Invalid username or password");
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapServersToAuthorities(user.getServers()));
    }

    private Collection<? extends GrantedAuthority> mapServersToAuthorities(Collection<Server> servers) {
        return servers.stream().map(s -> new SimpleGrantedAuthority(s.getName())).collect(Collectors.toList());
    }
    
}
