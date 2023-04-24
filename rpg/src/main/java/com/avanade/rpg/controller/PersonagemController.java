package com.avanade.rpg.controller;

import com.avanade.rpg.service.PersonagemService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/rpg")
@Api(value= "Personagens API REST")
@CrossOrigin(origins = "*")
public class PersonagemController {
    @Autowired
    private PersonagemService service;


}
