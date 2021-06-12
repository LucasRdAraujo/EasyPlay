package br.edu.infnet.springintrojsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.infnet.springintrojsp.model.TextChannel;

public interface TextChannelRepository extends JpaRepository<TextChannel, String>  {
    TextChannel getTextChannelById(String id);
}
