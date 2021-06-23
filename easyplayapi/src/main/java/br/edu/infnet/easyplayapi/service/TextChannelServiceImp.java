package br.edu.infnet.easyplayapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.easyplayapi.model.TextChannel;
import br.edu.infnet.easyplayapi.repository.TextChannelRepository;

@Service
public class TextChannelServiceImp implements TextChannelService {

    @Autowired
    private TextChannelRepository textChannelRepository;

    @Override
    public void store(TextChannel textChannel) {
        textChannelRepository.save(textChannel);
    }

    @Override
    public void deleteById(String id) {
        textChannelRepository.deleteById(id);
    }

    @Override
    public Iterable<TextChannel> getAll() {
        return textChannelRepository.findAll();
    }

    @Override
    public Optional<TextChannel> getById(String id) {
        return textChannelRepository.findById(id);
    }
    
}
