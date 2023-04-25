package com.avanade.rpg;

import com.avanade.rpg.model.Heroi;
import com.avanade.rpg.model.Personagem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RpgApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpgApplication.class, args);
		Heroi heroi = new Heroi();
		heroi.setTipoPersonagem('H');


	}

}
