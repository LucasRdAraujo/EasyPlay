package br.edu.infnet.easyplayapi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.infnet.easyplayapi.model.Server;

@Service
public interface ServerService {
    public void store(Server server);
    public void deleteById(String id);
    public Iterable<Server> getAll();
    public Optional<Server> getById(String id);
}
