package com.avanade.rpg.service;

import com.avanade.rpg.config.Utilidade;
import com.avanade.rpg.exception.InvalidInputException;
import com.avanade.rpg.model.Log;
import com.avanade.rpg.model.Personagem;
import com.avanade.rpg.model.Turno;
import com.avanade.rpg.repository.BatalhaRepository;
import com.avanade.rpg.repository.LogRepository;
import com.avanade.rpg.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatalhaService {
    @Autowired
    private PersonagemService personagemService;
    @Autowired
    private BatalhaRepository batalhaRepository;
    @Autowired
    private PersonagemRepository personagemRepository;
    @Autowired
    private LogRepository logRepository;

    public String Rodada(Turno t){

        Personagem pAtq = personagemRepository.getById(t.getIdAtq());
        Personagem pDef = personagemRepository.getById(t.getIdDef());

        t.setJogadorInicio(pAtq.getNome());
        t.setForcaAtaque(personagemService.Ataque(t.getIdAtq()));
        t.setForcaDefesa(personagemService.Defesa(t.getIdDef()));
        t.setDano(personagemService.CalcularDano(t.getIdAtq(), t.getIdDef()));
        t.setPvAtualizado(personagemService.CalcPv(t.getDano(), t.getIdDef()));
        t.setDescricao("Rodada: " + t.getId() +
                       ", Atacante " + pAtq.getNome() +
                        " vs Defensor: " + pDef.getNome() +
                        ", força ataque: " + t.getForcaAtaque() +
                        ", força defesa: " + t.getForcaDefesa() +
                        ", dano: " + t.getDano() +
                        ", pv restante defesa: " + t.getPvAtualizado()
                      );

        //Atualiza pv do personagem de defesa
        pDef.setPv(t.getPvAtualizado());
        personagemRepository.save(pDef);

        //Gravar log desta rodada da batalha
        GravaLog(t);

        if (pDef.getPv() <= 0) {
            // não sei como encerrar a batalha ..rsss
            this.batalhaRepository.save(t);
            throw new InvalidInputException( "Batalha vencida por:" + pAtq.getNome());
        }

        return this.batalhaRepository.save(t).toString();
    }
    public void GravaLog(Turno t){

        Log l = new Log();

        l.setId(t.getId());
        l.setIdAtq(t.getIdAtq());
        l.setIdDef(t.getIdDef());
        l.setTurno(t.getDescricao());
        logRepository.save(l);
    }
    public int Iniciativa() {
        Utilidade util = new Utilidade();
        return util.JogarDado(20, 1);
    }
}
