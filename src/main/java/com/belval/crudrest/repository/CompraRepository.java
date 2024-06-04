package com.belval.crudrest.repository;

import org.springframework.data.repository.CrudRepository;

import com.belval.crudrest.model.Compra;

public interface CompraRepository extends CrudRepository<Compra, Integer> {
	
	//Select * from Compra where descricao = <parametro>
	//List<Compra> findByNome(String nome);

}
