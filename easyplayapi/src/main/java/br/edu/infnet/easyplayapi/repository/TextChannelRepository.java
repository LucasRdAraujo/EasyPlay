package br.edu.infnet.easyplayapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.infnet.easyplayapi.model.TextChannel;

public interface TextChannelRepository extends JpaRepository<TextChannel, String> {
}
