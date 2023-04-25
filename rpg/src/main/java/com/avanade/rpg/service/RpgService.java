package com.avanade.rpg.service;

import com.avanade.rpg.model.Personagem;
import org.springframework.stereotype.Service;

@Service
public class RpgService {
    public int JogarDado(int TipoDado, int Qtd){
        int valor;

        valor=0;

        for (int i = 0; i<Qtd; i++) {
            valor += (int) (Math.random() * TipoDado) + 1;
        }
		return valor;
    }

    public Personagem Ataque(Personagem personagem){
        return null;
    }
    public Personagem Defesa(Personagem personagem){
        return null;
    }

}