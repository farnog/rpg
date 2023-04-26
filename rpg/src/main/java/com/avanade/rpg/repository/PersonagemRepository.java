package com.avanade.rpg.repository;

import com.avanade.rpg.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonagemRepository  extends JpaRepository<Personagem, Long> {
}
