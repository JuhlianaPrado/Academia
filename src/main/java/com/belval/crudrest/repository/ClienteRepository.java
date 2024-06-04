package com.belval.crudrest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.belval.crudrest.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
	
	//Select * from Cliente where descricao = <parametro>
	List<Cliente> findByNome(String nome);

}
