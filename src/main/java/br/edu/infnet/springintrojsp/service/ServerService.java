package br.edu.infnet.springintrojsp.service;

import br.edu.infnet.springintrojsp.model.Server;

public interface ServerService {
    Server getServerById(String id);
    Server getServerByUsername(String name);
}
