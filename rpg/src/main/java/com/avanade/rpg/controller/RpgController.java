package com.avanade.rpg.controller;

import com.avanade.rpg.model.Personagem;
import com.avanade.rpg.service.RpgService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class RpgController {
    @Autowired
    private RpgService service;
    @PostMapping("/rpg")
    @ApiOperation("Atacando")
    public ResponseEntity<Personagem> Ataque (@RequestBody Personagem personagem) {
        service.Ataque(personagem);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Personagem> Defesa (@RequestBody Personagem personagem) {
        service.Defesa(personagem);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
