package com.belval.crudrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.belval.crudrest.model.Plano;

//Ctrl + SHIFT + S -> Salva todos os arquivos pendentes de salvamento
//Ctrl + SHIFT + O -> Adiciona os import's e Organiza-os
@RestController
@SpringBootApplication
public class CrudrestApplication {

	private static Plano p;

	public static void main(String[] args) {

		// Para ir para a definição de Plano
		// posicione o cursor no meio no nome da classe
		// e pressione F3
		setP(new Plano());

		SpringApplication.run(CrudrestApplication.class, args);
	}

	@GetMapping("/eco")
	public String eco() {
		return "eco";
	}

	public static Plano getP() {
		return p;
	}

	public static void setP(Plano p) {
		CrudrestApplication.p = p;
	}

}
