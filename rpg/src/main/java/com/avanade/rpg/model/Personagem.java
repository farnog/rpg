package com.avanade.rpg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public abstract class Personagem {
    private String nome;
    private int pv;
    private int forca;
    private int defesa;
    private int agilidade;
    private int qtdDados;
    private int tipoDado;


}
