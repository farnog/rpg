package com.avanade.rpg.service;

import com.avanade.rpg.config.Utilidade;
import com.avanade.rpg.exception.ResourceNotFoundException;
import com.avanade.rpg.model.Personagem;
import com.avanade.rpg.config.Utilidade;
import com.avanade.rpg.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PersonagemService implements ApplicationRunner {

    @Autowired
    private PersonagemRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        repository.deleteAll();
        //Heróis
        Personagem guerreiro = new Personagem(1,"Guerreiro",20,7,5,6,1,12,'H');
        repository.save(guerreiro);

        Personagem barbaro = new Personagem(2,"Barbaro",21,10,2,5,2,8,'H');
        repository.save(barbaro);

        Personagem cavaleiro = new Personagem(3,"Cavaleiro",26,6,8,3,2,6,'H');
        repository.save(cavaleiro);

        //Monstros
        Personagem orc = new Personagem(4,"Orc",42,7,1,2,3,4,'M');
        repository.save(orc);

        Personagem gigante = new Personagem(5,"Gigante",34,10,4,4,2,6,'M');
        repository.save(gigante);

        Personagem lobisomen = new Personagem(6,"Lobisomen",34,7,4,7,2,4,'M');
        repository.save(lobisomen);

    }
    public Personagem Criar(Personagem personagem){
        return this.repository.save(personagem);
    }
    public List<Personagem> Listar(){
        return repository.findAll();
    }

    public Personagem ListarPorId(Long id){
        return repository.findById( id ).orElseThrow( ( ) -> new ResourceNotFoundException( "Personagem não encontrado: " + id ) );
    }
    public Personagem Selecionar(){
        return null;
    }


    public void delete(Long id){
        repository.deleteById(id);
    }

    public Personagem update(Personagem personagem){
        return repository.save(personagem);
    }
    public int Ataque(long id){

        Personagem p = repository.getById(id);

        Utilidade dado = new Utilidade();
        int valAtaque = dado.JogarDado(12,1) + p.getForca() + p.getAgilidade();

        return valAtaque;
    }
    public int Defesa(long id){
        Personagem p = repository.getById(id);

        Utilidade dado = new Utilidade();

        int valDefesa = dado.JogarDado(12,1) + p.getDefesa() + p.getAgilidade();

        return valDefesa;
    }
    public int CalcularDano(long idAtq, long idDef){
        Personagem pAtq = repository.getById(idAtq);
        Personagem pDef = repository.getById(idDef);

        Utilidade dado = new Utilidade();

        int ataque = dado.JogarDado(pAtq.getTipoDado(), pAtq.getQtdDados()) + pAtq.getForca();
        int defesa = dado.JogarDado(pDef.getTipoDado(), pDef.getQtdDados());

        int valDano = ataque - defesa;

        return valDano;
    }

    public int CalcPv(int pv, int dano){
        return ((pv - dano) <= 0) ? 0 : pv - dano;
    }
}
