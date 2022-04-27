package com.AprendizagemSemanal.Aprendizagem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Aprendizagem")

public class Aprendizagem {
	
	
	@GetMapping	
	public String HelloWorld() {
		
		return "MySQL, DER, Springtool,";
		
	}

}
