package com.avanade.rpg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PERSONAGEM")
@Entity
public class Personagem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", nullable=false)
    private long id;
    private String nome;
    private int pv;
    private int forca;
    private int defesa;
    private int agilidade;
    private int qtdDados;
    private int tipoDado;
}
