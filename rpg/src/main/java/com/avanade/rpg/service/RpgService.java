package com.avanade.rpg.service;

import com.avanade.rpg.model.Jogador;
import com.avanade.rpg.model.Personagem;
import com.avanade.rpg.model.Turno;
import com.avanade.rpg.repository.PersonagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class RpgService {
    private PersonagemRepository personagemRepository;

    public void Fluxo(){
        //CarregarPersonagensPadrao;
        //SelecionarPersonagens;
        Jogador jog1 = new Jogador();
        Jogador jog2 = new Jogador();
        jog1.getPersonagem().setTipoPersonagem('H');
        jog2.getPersonagem().setTipoPersonagem('M');
        Iniciativa(jog1, jog2);
        //GravarLog
        Turno(jog1, jog2);


    }
    public void Turno(Jogador j1, Jogador j2){
        Turno turno = new Turno();
    }
    public void Iniciativa(Jogador j1, Jogador j2){
        int p1 = JogarDado(20,1);
        int p2 = JogarDado(20,1);

        while (p1 == p2){
            p1 = JogarDado(20,1);
            p2 = JogarDado(20,1);
        }
        j1.setIniciativa(p1);
        j2.setIniciativa(p2);
    }
    public int JogarDado(int TipoDado, int Qtd){
        int valor;

        valor=0;

        for (int i = 0; i<Qtd; i++) {
            valor += (int) (Math.random() * TipoDado) + 1;
        }
		return valor;
    }

    public int CalcularDano(Personagem pAtq, Personagem pDef){
        int ataque = JogarDado(pAtq.getTipoDado(), pAtq.getQtdDados()) + pAtq.getForca();
        int defesa = JogarDado(pDef.getTipoDado(), pDef.getQtdDados()) + pDef.getDefesa();

        return ataque - defesa;
    }
    public int CalcPv(int pv, int dano){
        return ((pv - dano) <= 0) ? 0 : pv - dano;
    }


}