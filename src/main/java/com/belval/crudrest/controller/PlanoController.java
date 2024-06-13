package com.belval.crudrest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.belval.crudrest.model.Plano;
import com.belval.crudrest.repository.PlanoRepository2;

@RestController
public class PlanoController {

//	private static List<Plano> listaPlanos = new ArrayList<>();
//	private static Integer proxId = 1;
	
//	private static PlanoRepository repository = 
//			new PlanoRepository();
	@Autowired
	private PlanoRepository2 repository;
	

	static {
//		Plano prod = new Plano(1, "Pão", "Pão Francês", 0.5);
//		listaPlanos.add(prod);
	}
	
	@GetMapping("/Planos")
	public ResponseEntity<Iterable<Plano>> obterPlanos() {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(repository.findAll());
	}

	//curl POST http://localhost:8080/Planos -H "Content-Type: application/json; Charset=utf-8" -d @Plano-mortadela.json
	
	@PostMapping("/Planos")
	public ResponseEntity<Plano> criarPlano(@RequestBody Plano Plano) {
		
		repository.save(Plano);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(Plano);
	}
	
	//curl GET http://localhost:8080/Planos/1
	@GetMapping("/Planos/{id}")
	public ResponseEntity<Object> buscarPlanoPorId(@PathVariable Integer id) {
		
		Optional<Plano> Plano = repository.findById(id);
		
		if(!Plano.isPresent()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Plano não encontrado.");
		}
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(Plano.get());
	}
	
	//curl -X DELETE http://localhost:8080/Planos/1
	@DeleteMapping("/Planos/{id}")
	public ResponseEntity<Object> apagar(@PathVariable Integer id) {
		
		
		Optional<Plano> Plano = repository.findById(id);
		
		if(!Plano.isPresent()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Plano não encontrado.");
		}
		
		repository.delete(Plano.get());
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Plano apagado com sucesso!");	
	}
	
	//Observação: para métodos que não sejam o GET e o POST é necessário colocar o -X(menos xis maiúsculo)
	//curl -X PUT http://localhost:8080/Planos/1 -H "Content-Type: application/json; Charset=utf-8" -d @Plano-mortadela2.json
	@PutMapping("/Planos/{id}")
	public ResponseEntity<Object> atualizarPlano(
			@PathVariable(value = "id")Integer id,
			@RequestBody Plano Plano) {
		
		Optional<Plano> PlanoEncontrado = repository.findById(id);
		
		if (PlanoEncontrado.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Plano não encontrado.");
		}
		
		Plano.setId(id);
		repository.save(Plano);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Plano atualizado com sucesso.");
	}
	
}
