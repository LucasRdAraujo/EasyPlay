package br.edu.infnet.springintrojsp.service;

import br.edu.infnet.springintrojsp.model.TextChannel;

public interface TextChannelService {
    TextChannel store(TextChannel textChannel);
    TextChannel getTextChannelById(String id);
}
