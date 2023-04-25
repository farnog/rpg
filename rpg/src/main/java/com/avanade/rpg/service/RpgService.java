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

    public int CalcularDano(Personagem heroi, Personagem monstro){
        int ataque = JogarDado(heroi.getTipoDado(),heroi.getQtdDados()) + heroi.getForca();
        int defesa = JogarDado(monstro.getTipoDado(),monstro.getQtdDados()) + monstro.getDefesa();

        return ataque - defesa;
    }
    public int CalcPv(Personagem monstro, int dano){
        return ((monstro.getPv() - dano) <= 0) ? 0 : monstro.getPv() - dano;

    }

    public Personagem Ataque(Personagem heroi, Personagem monstro){
        int forcaAtaque = JogarDado(12, 1) + heroi.getForca() + heroi.getAgilidade();
        int forcaDefesa = JogarDado(12,1) + monstro.getDefesa() + monstro.getAgilidade();
        int dano;

        if (forcaAtaque > forcaDefesa) {
            dano = CalcularDano(heroi, monstro);
        }
        return heroi;
    }
    public Personagem Defesa(Personagem heroi, Personagem monstro){
        return heroi;
    }

}