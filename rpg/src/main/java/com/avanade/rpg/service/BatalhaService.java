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
    private PersonagemService personagemService;
    @Autowired
    private BatalhaRepository batalhaRepository;
    @Autowired
    private PersonagemRepository personagemRepository;
    @Autowired
    private LogRepository logRepository;

    public String Rodada(long idAtq, long idDef){

        Turno t = new Turno();

        Personagem pAtq = personagemRepository.getById(idAtq);
        Personagem pDef = personagemRepository.getById(idDef);

        t.setJogadorInicio(pAtq.getNome());
        t.setIdAtq(idAtq);
        t.setIdDef(idDef);
        t.setForcaAtaque(personagemService.Ataque(idAtq));
        t.setForcaDefesa(personagemService.Defesa(idDef));
        t.setDano(personagemService.CalcularDano(idAtq, idDef));
        t.setPvAtualizado(personagemService.CalcPv(t.getDano(), idDef));

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
        l.setTurno(t.toString());
        logRepository.save(l);
    }
    public int Iniciativa() {
        Utilidade util = new Utilidade();
        return util.JogarDado(20, 1);
    }
}
