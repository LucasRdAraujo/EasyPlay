package br.edu.infnet.springintrojsp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.springintrojsp.model.Server;
import br.edu.infnet.springintrojsp.repository.ServerRepository;

@Service
public class ServerServiceImpl implements ServerService {

    @Autowired
    private ServerRepository serverRepository;

    @Override
    public Optional<Server> getServerById(String id) {
        return serverRepository.findById(id);
    }

}
