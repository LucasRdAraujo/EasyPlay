package br.edu.infnet.easyplayapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.easyplayapi.model.Server;
import br.edu.infnet.easyplayapi.repository.ServerRepository;

@Service
public class ServerServiceImp implements ServerService {

    @Autowired
    private ServerRepository serverRepository;

    @Override
    public void store(Server server) {
        serverRepository.save(server);
    }

    @Override
    public void deleteById(String id) {
        serverRepository.deleteById(id);
    }

    @Override
    public Iterable<Server> getAll() {
        return serverRepository.findAll();
    }

    @Override
    public Optional<Server> getById(String id) {
        return serverRepository.findById(id);
    }
    
}
