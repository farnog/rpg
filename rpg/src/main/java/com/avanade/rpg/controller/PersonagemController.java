package com.avanade.rpg.controller;

import com.avanade.rpg.model.Personagem;
import com.avanade.rpg.service.PersonagemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/rpg")
@Api(value= "Personagens API REST")
@CrossOrigin(origins = "*")
public class PersonagemController {
    @Autowired
    private PersonagemService service;

    @GetMapping("/rpg")
    @ApiOperation("Procurando personagem")
    public ResponseEntity<List<Personagem>> getAll (){
        return new ResponseEntity<>(service.Listar(), HttpStatus.OK);
    }
    @PostMapping("/rpg")
    @ApiOperation("Criar personagem")
    public ResponseEntity<Personagem> create (@RequestBody Personagem personagem) {
        return new ResponseEntity<>(service.Criar(personagem), HttpStatus.CREATED);
    }

    @PostMapping("/rpg")
    @ApiOperation("Update personagem")
    public ResponseEntity<Personagem> update (@RequestBody Personagem personagem) {
        service.update(personagem);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/rpg")
    @ApiOperation("Delete personagem")
    public ResponseEntity<Personagem> update (@RequestBody Long personagemId) {
        service.delete(personagemId);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

}
