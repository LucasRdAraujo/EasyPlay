package br.edu.infnet.easyplayapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.easyplayapi.model.Server;

@Repository
public interface ServerRepository extends JpaRepository<Server, String> {
    Server getServerById(String id);
}
