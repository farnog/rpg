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
    @ApiOperation("Retornar todos personagens")
    public ResponseEntity<List<Personagem>> getAll (){
        return new ResponseEntity<>(service.Listar(), HttpStatus.OK);
    }

    @GetMapping( "/rpg/{id}" )
    @ApiOperation( "Buscar personagem pelo ID" )
    public ResponseEntity< Personagem > getById( @PathVariable( value = "id" ) Long Id ) {
        return new ResponseEntity<>( service.ListarPorId( Id ), HttpStatus.OK );
    }

    @PostMapping("/rpg")
    @ApiOperation("Criar personagem")
    public ResponseEntity<Personagem> create (@RequestBody Personagem personagem) {
        return new ResponseEntity<>(service.Criar(personagem), HttpStatus.CREATED);
    }

    @PutMapping("/rpg")
    @ApiOperation("Atualizar personagem")
    public ResponseEntity<Personagem> update (@RequestBody Personagem personagem) {
        service.update(personagem);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/rpg")
    @ApiOperation("Deletar personagem")
    public ResponseEntity<HttpStatus> update (@RequestHeader Long pId) {
        service.delete(pId);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
    @GetMapping("/rpg/ataque/{id}")
    @ApiOperation("Informação do Ataque")
    public ResponseEntity<String> Ataque (@PathVariable( value = "id" ) long id) {
        service.Ataque(id);
        return new ResponseEntity<>(Integer.toString(service.Ataque(id)), HttpStatus.OK);
    }

    @GetMapping("/rpg/defesa/{id}")
    @ApiOperation("Informação da Defesa")
    public ResponseEntity<String> Defesa (@PathVariable( value = "id" ) long id) {
        return new ResponseEntity<>(Integer.toString(service.Defesa(id)), HttpStatus.OK);
    }

    @GetMapping("/rpg/dano/{idAtq},{idDef}")
    @ApiOperation("Calculo do dano")
    public ResponseEntity<String> Dano (@PathVariable( value = "idAtq" ) long idAtq, @PathVariable( value = "idDef" ) long idDef) {
        return new ResponseEntity<>(Integer.toString(service.CalcularDano(idAtq, idDef)),HttpStatus.OK);
    }
}
