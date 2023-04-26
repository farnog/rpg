package com.avanade.rpg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TURNO")
@Entity
public class Turno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable=false)
    private long id;
    private String jogadorInicio;
    private long idAtq;
    private long idDef;
    private int forcaAtaque;
    private int forcaDefesa;
    private int dano;
    private int pvAtualizado;

    @Override
    public String toString() {
        return "Turno{" +
                "numTurno=" + id +
                ", jogadorInicio='" + jogadorInicio +
                ", idAtq='" + idAtq +
                ", idDef='" + idDef +
                ", forcaAtaque='" + forcaAtaque +
                ", forcaDefesa='" + forcaDefesa +
                ", dano='" + dano +
                ", pvAtualizadoAposAtq='" + pvAtualizado +
                '}';
    }
}
