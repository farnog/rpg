package com.avanade.rpg.controller;

import com.avanade.rpg.service.BatalhaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/rpg")
@Api(value= "Batalha AVA-RPG")
@CrossOrigin(origins = "*")

public class BatalhaController {
    private BatalhaService service;

    @PostMapping("/rpg/turno/{idAtq},{idDef}")
    @ApiOperation("Iniciar Turno")
    //public ResponseEntity<Turno> create (@RequestBody Turno turno) {
    public ResponseEntity<String> create (@PathVariable( value = "idAtq" ) long idAtq, @PathVariable( value = "idDef" ) long idDef) {
        return new ResponseEntity<>(service.Rodada(idAtq, idDef), HttpStatus.CREATED);
    }

    @GetMapping("/rpg/inicio")
    @ApiOperation("Iniciativa")
    public ResponseEntity<String> Iniciativa (){
        return new ResponseEntity<>(Integer.toString(service.Iniciativa()), HttpStatus.OK);
    }
}
