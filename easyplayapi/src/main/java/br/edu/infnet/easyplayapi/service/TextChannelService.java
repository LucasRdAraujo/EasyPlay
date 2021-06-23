package br.edu.infnet.easyplayapi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.infnet.easyplayapi.model.TextChannel;

@Service
public interface TextChannelService {
    public void store(TextChannel textChannel);
    public void deleteById(String id);
    public Iterable<TextChannel> getAll();
    public Optional<TextChannel> getById(String id);
}
