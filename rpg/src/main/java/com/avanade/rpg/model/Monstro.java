package com.avanade.rpg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="MONSTRO")
@Entity

public final class Monstro extends Personagem{
    @Autowired
    private Personagem monstro;
    public void setMonstro(Personagem monstro) {
        this.monstro.setTipoPersonagem('M');
    }
}
