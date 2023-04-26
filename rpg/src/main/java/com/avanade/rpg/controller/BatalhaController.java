package com.avanade.rpg.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.avanade.rpg.config.Utilidade;

@RestController
@RequestMapping(value="/rpg")
@Api(value= "Batalha AVA-RPG")
@CrossOrigin(origins = "*")
public class BatalhaController {
    private void Fluxo(){
        Utilidade util = new Utilidade();

        util.Iniciativa();
    }
}
