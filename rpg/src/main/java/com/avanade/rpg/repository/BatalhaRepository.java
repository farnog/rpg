package com.avanade.rpg.repository;

import com.avanade.rpg.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatalhaRepository extends JpaRepository<Turno, Long> {
}
