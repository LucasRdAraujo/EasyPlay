package br.edu.infnet.springintrojsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.springintrojsp.model.Server;
import br.edu.infnet.springintrojsp.repository.ServerRepository;

@Service
public class ServerServiceImpl implements ServerService {

    @Autowired
    private ServerRepository serverRepository;

    @Override
    public Server getServerById(String id) {
        return serverRepository.getServerById(id);
    }

    @Override
    public Server getServerByUsername(String name) {
        return serverRepository.getServerByName(name);
    }

}
