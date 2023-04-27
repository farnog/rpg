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
    @Column(name="jogadorInicial", nullable=true)
    private String jogadorInicio;
    @Column(name="idAtq", nullable=false)
    private long idAtq;
    @Column(name="idDef", nullable=false)
    private long idDef;
    @Column(name="forcaAtaque", nullable=true)
    private int forcaAtaque;
    @Column(name="forcaADefesa", nullable=true)
    private int forcaDefesa;
    @Column(name="dano", nullable=true)
    private int dano;
    @Column(name="pvAtualizado", nullable=true)
    private int pvAtualizado;
    @Column(name="Descricao", nullable=true)
    private String Descricao;

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
                ", Descricao:'" + Descricao +
                '}';
    }
}
