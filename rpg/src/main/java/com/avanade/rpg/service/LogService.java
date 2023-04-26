package com.avanade.rpg.service;

import com.avanade.rpg.model.Log;
import com.avanade.rpg.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    @Autowired
    private LogRepository repository;
    public Log Criar(Log l){
        return this.repository.save(l);
    }

    public List<Log> Listar(){
        return repository.findAll();
    }
}
