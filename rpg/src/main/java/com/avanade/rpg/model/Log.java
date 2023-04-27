package com.avanade.rpg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="LOG")
@Entity
public class Log implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable=false)
    private long id;
    @Column(name="idAtq", nullable=true)
    private long idAtq;
    @Column(name="idDef", nullable=true)
    private long idDef;
    @Column(name="rodada", nullable=true)
    private String rodada;

    @Override
    public String toString() {
        return "Log{" +
                "ID=" + id +
                ", idPersonagemAtq=" + idAtq +
                ", idPersonagemDef=" + idDef +
                ", rodada=" + rodada +
                "}";
    }
}
