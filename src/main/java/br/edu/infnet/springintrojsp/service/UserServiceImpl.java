package br.edu.infnet.springintrojsp.service;

import java.util.ArrayList;
// import java.util.Collection;
import java.util.Optional;
// import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

// import br.edu.infnet.springintrojsp.controller.dto.UserRegistrationDto;
// import br.edu.infnet.springintrojsp.model.Server;
import br.edu.infnet.springintrojsp.model.User;
import br.edu.infnet.springintrojsp.repository.UserRepository;
// import br.edu.infnet.springintrojsp.util.IdGenerator;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void store(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findAll().stream().filter(u -> u.getEmail().equals(email)).findAny().orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(email);
        if(user == null)
            throw new UsernameNotFoundException("Invalid username or password");
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }

    // @Override
    // public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    //     User user = userRepository.getUserByEmail(email);

    //     if(user == null)
    //         throw new UsernameNotFoundException("Invalid username or password");
    //     return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapServersToAuthorities(user.getServers()));
    // }

    // private Collection<? extends GrantedAuthority> mapServersToAuthorities(Collection<Server> servers) {
    //     return servers.stream().map(s -> new SimpleGrantedAuthority(s.getName())).collect(Collectors.toList());
    // }
    
}
