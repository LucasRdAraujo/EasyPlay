package br.edu.infnet.easyplay.repository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.infnet.easyplay.model.User;

@Repository
public class UserRepository {

    // SIMULANDO BANCO DE DADOS COM DADO MOCKADO!!
    private List<User> users = new ArrayList<>(Arrays.asList(
        new User(Long.toString(Instant.now().toEpochMilli()), "Apparatus", "l.araujjo@hotmail.com.br", "123123123")
    ));

    public User getUser(String email, String senha) {
        return users.stream().filter(u -> u.getEmail().equals(email) && u.getSenha().equals(senha)).findAny().orElse(null);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUser(User user) {
        users.add(user);
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    
}
