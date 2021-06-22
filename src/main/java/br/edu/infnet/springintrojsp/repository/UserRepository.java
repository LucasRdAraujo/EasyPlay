package br.edu.infnet.springintrojsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.springintrojsp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User getUserById(String id);
    User getUserByEmail(String email);
}
