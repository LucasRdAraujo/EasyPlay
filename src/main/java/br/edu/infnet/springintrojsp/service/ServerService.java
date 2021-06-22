package br.edu.infnet.springintrojsp.service;

import java.util.Optional;

import br.edu.infnet.springintrojsp.model.Server;

public interface ServerService {
    Optional<Server> getServerById(String id);
}
