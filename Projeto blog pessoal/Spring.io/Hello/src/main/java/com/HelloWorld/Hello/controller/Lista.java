package com.HelloWorld.Hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ListaBSMs")
public class Lista {

	
	@GetMapping	
	public String HelloWorld() {
		return "Mentalidade de crescimento, Percistencia,"
				+ "Responsabilidade pessoal, Orientação ao Futuro,"
				+ "Comunicação, Orientação ao Detalhe, Proatividade eTrabalho em Equipe";
	}
	
}