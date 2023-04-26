package com.avanade.rpg.config;

import com.avanade.rpg.model.Jogador;

public class Utilidade {
    public int JogarDado(int TipoDado, int Qtd){
        int valor;

        valor=0;

        for (int i = 0; i<Qtd; i++) {
            valor += (int) (Math.random() * TipoDado) + 1;
        }
        return valor;
    }
    public void Iniciativa(Jogador j1, Jogador j2){
        int r1 = JogarDado(20,1);
        int r2 = JogarDado(20,1);

        while (r1 == r2){
            r1 = JogarDado(20,1);
            r2 = JogarDado(20,1);
        }
    }
}
