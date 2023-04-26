package com.avanade.rpg.controller;

import com.avanade.rpg.model.Personagem;
import com.avanade.rpg.service.RpgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/rpg")
@Api(value= "RPG API REST")
@CrossOrigin(origins = "*")
public class RpgController {
    @Autowired
    private RpgService service;



}
