package com.avanade.rpg.service;

import com.avanade.rpg.model.Personagem;
import com.avanade.rpg.repository.RpgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonagemService {
    @Autowired
    private RpgRepository repository;

    public List<Personagem> Listar(){
        return repository.findAll();
    }

    public List<Personagem> ListarPorId(Long id){
        return null; //repository.findById(id);
    }
    public Personagem Selecionar(){
        return null;
    }

    public Personagem Ataque(){
        return null;
    }
    public Personagem Defesa(){
        return null;
    }

}
