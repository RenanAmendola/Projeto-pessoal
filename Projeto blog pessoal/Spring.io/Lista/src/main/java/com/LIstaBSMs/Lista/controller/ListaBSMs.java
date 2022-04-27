package com.LIstaBSMs.Lista.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ListaBSMs")
public class ListaBSMs {

	
	@GetMapping	
	public String ListaBSMs() {
		return "Mentalidade de crescimento, Percistencia,"
				+ "Responsabilidade pessoal, Orientação ao Futuro,"
				+ "Comunicação, Orientação ao Detalhe, Proatividade eTrabalho em Equipe";
	}
	
}
