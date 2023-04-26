package com.avanade.rpg.controller;

import com.avanade.rpg.model.Log;
import com.avanade.rpg.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/rpg")
@Api(value= "Batalha AVA-RPG")
@CrossOrigin(origins = "*")

public class LogController {
    private LogService service;
    @GetMapping("/rpg/log")
    @ApiOperation("Exibir logs dos turnos")
    public ResponseEntity<List<Log>> getAll (){
        return new ResponseEntity<>(service.Listar(), HttpStatus.OK);
    }

    @PostMapping("/rpg/log")
    @ApiOperation("Gravar Log")
    public ResponseEntity<Log> create (@RequestBody Log l) {
        return new ResponseEntity<>(service.Criar(l), HttpStatus.CREATED);
    }
}
