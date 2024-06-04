package com.belval.crudrest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.belval.crudrest.model.Cliente;
import com.belval.crudrest.model.Produto;
import com.belval.crudrest.repository.ClienteRepository;

//Ctrl + SHIFT + S -> Salva todos os arquivos pendentes de salvamento
//Ctrl + SHIFT + O -> Adiciona os import's e Organiza-os
@RestController
@SpringBootApplication
public class CrudrestApplication {

	public static void main(String[] args) {

		Produto p;
		// Para ir para a definição de Produto
		// posicione o cursor no meio no nome da classe
		// e pressione F3
		p = new Produto();

		SpringApplication.run(CrudrestApplication.class, args);
	}

	@GetMapping("/eco")
	public String eco() {
		return "eco";
	}

}
