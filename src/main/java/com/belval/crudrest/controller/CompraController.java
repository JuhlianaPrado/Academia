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

import com.belval.crudrest.model.Compra;
import com.belval.crudrest.repository.CompraRepository;

@RestController
public class CompraController {

	@Autowired
	private CompraRepository repository;

	
	@GetMapping("/compras")
	public ResponseEntity<Iterable<Compra>> obterCompras() {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(repository.findAll());
	}

	//curl POST http://localhost:8080/compras -H "Content-Type: application/json; Charset=utf-8" -d @Compra-mortadela.json
	@PostMapping("/compras")
	public ResponseEntity<Compra> criarCompra(@RequestBody Compra Compra) {
		
		repository.save(Compra);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(Compra);
	}
	
	//curl GET http://localhost:8080/compras/1
	@GetMapping("/compras/{id}")
	public ResponseEntity<Object> buscarCompraPorId(@PathVariable Integer id) {
		
		Optional<Compra> Compra = repository.findById(id);
		
		if(!Compra.isPresent()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Compra não encontrado.");
		}
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(Compra.get());
	}
	
	//curl -X DELETE http://localhost:8080/compras/1
	@DeleteMapping("/compras/{id}")
	public ResponseEntity<Object> apagar(@PathVariable Integer id) {
		
		
		Optional<Compra> Compra = repository.findById(id);
		
		if(!Compra.isPresent()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Compra não encontrado.");
		}
		
		repository.delete(Compra.get());
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Compra apagado com sucesso!");	
	}
	
	//Observação: para métodos que não sejam o GET e o POST é necessário colocar o -X(menos xis maiúsculo)
	//curl -X PUT http://localhost:8080/compras/1 -H "Content-Type: application/json; Charset=utf-8" -d @Compra-mortadela2.json
	@PutMapping("/compras/{id}")
	public ResponseEntity<Object> atualizarCompra(
			@PathVariable(value = "id")Integer id,
			@RequestBody Compra Compra) {
		
		Optional<Compra> CompraEncontrado = repository.findById(id);
		
		if (CompraEncontrado.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Compra não encontrado.");
		}
		
		Compra.setId(id);
		repository.save(Compra);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Compra atualizado com sucesso.");
	}
	
}
