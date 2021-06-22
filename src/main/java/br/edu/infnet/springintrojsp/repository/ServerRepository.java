package br.edu.infnet.springintrojsp.repository;

import br.edu.infnet.springintrojsp.model.Server;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerRepository extends JpaRepository<Server, String> {
    Server getServerById(String id);
}
