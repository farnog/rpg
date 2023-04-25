package com.avanade.rpg.service;

import com.avanade.rpg.exception.InvalidInputException;
import com.avanade.rpg.exception.ResourceNotFoundException;
import com.avanade.rpg.model.Personagem;
import com.avanade.rpg.model.Dado;
import com.avanade.rpg.repository.RpgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonagemService {
    @Autowired
    private RpgRepository repository;

    public Personagem Criar(Personagem personagem){
        //cravado criação do guerreiro

        Dado dado = new Dado();
        dado.setQtdDados(1);
        dado.setTipoDado(12);

        personagem.setNome("Guerreiro");
        personagem.setPv(20);
        personagem.setForca(7);
        personagem.setDefesa(5);
        personagem.setAgilidade(6);
        personagem.setDado(dado);

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
        //if (null == personagem.getId()) {
        //    throw new InvalidInputException( "There is no ID.");
        //}
        return repository.save(personagem);
    }
}
