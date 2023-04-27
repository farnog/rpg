package com.avanade.rpg.controller;

import com.avanade.rpg.model.Turno;
import com.avanade.rpg.service.BatalhaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/rpg")
@Api(value= "Batalha AVA-RPG")
@CrossOrigin(origins = "*")

public class BatalhaController {
    @Autowired
    private BatalhaService service;

    @PostMapping("/rpg/turno/{idAtq},{idDef}")
    @ApiOperation("Iniciar Turno")
    //public ResponseEntity<Turno> create (@RequestBody Turno turno) {
    public ResponseEntity<String> create (@RequestBody Turno turno) {
        return new ResponseEntity<>(service.Rodada(turno), HttpStatus.CREATED);
    }

    @GetMapping("/rpg/inicio")
    @ApiOperation("Iniciativa")
    public ResponseEntity<String> Iniciativa (){
        return new ResponseEntity<>(Integer.toString(service.Iniciativa()), HttpStatus.OK);
    }
}
