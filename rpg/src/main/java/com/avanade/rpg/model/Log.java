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
    private long idAtq;
    private long idDef;
    private String turno;

    @Override
    public String toString() {
        return "Log{" +
                "ID=" + id +
                ", idPersonagemAtq='" + idAtq +
                ", idPersonagemDef='" + idDef +
                ", Turno='" + turno +
                '}';
    }
}
