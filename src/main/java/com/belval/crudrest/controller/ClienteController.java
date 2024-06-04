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

import com.belval.crudrest.model.Cliente;
import com.belval.crudrest.repository.ClienteRepository;

@RestController
public class ClienteController {

	@Autowired
	private ClienteRepository repository;

	
	@GetMapping("/clientes")
	public ResponseEntity<Iterable<Cliente>> obterClientes() {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(repository.findAll());
	}

	//curl POST http://localhost:8080/clientes -H "Content-Type: application/json; Charset=utf-8" -d @Cliente-mortadela.json
	@PostMapping("/clientes")
	public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
		
		repository.save(cliente);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(cliente);
	}
	
	//curl GET http://localhost:8080/clientes/1
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Object> buscarClientePorId(@PathVariable Integer id) {
		
		Optional<Cliente> Cliente = repository.findById(id);
		
		if(!Cliente.isPresent()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Cliente não encontrado.");
		}
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(Cliente.get());
	}
	
	//curl -X DELETE http://localhost:8080/clientes/1
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<Object> apagar(@PathVariable Integer id) {
		
		
		Optional<Cliente> Cliente = repository.findById(id);
		
		if(!Cliente.isPresent()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Cliente não encontrado.");
		}
		
		repository.delete(Cliente.get());
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Cliente apagado com sucesso!");	
	}
	
	//Observação: para métodos que não sejam o GET e o POST é necessário colocar o -X(menos xis maiúsculo)
	//curl -X PUT http://localhost:8080/clientes/1 -H "Content-Type: application/json; Charset=utf-8" -d @Cliente-mortadela2.json
	@PutMapping("/clientes/{id}")
	public ResponseEntity<Object> atualizarCliente(
			@PathVariable(value = "id")Integer id,
			@RequestBody Cliente Cliente) {
		
		Optional<Cliente> ClienteEncontrado = repository.findById(id);
		
		if (ClienteEncontrado.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Cliente não encontrado.");
		}
		
		Cliente.setId(id);
		repository.save(Cliente);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Cliente atualizado com sucesso.");
	}
	
}
