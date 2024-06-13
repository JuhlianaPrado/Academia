package com.belval.crudrest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.belval.crudrest.model.Plano;

public interface PlanoRepository2 extends CrudRepository<Plano, Integer> {
	
	//Select * from Plano where descricao = <parametro>
	List<Plano> findByDescricao(String descricao);

}
