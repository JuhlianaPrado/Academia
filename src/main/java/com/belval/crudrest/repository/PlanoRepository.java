package com.belval.crudrest.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.belval.crudrest.model.Plano;

//Criar uma classe PlanoRepository
//Atributos:
//	listaPlanos do tipo List<Plano> :
//		Copie a classe Plano do projeto principal
//	proxId do tipo int : 
//		deve armazenar o proximo ID utlizado no processo de criação de 
//		novo Plano
//Métodos:
//	findById:
//		Criar método público findById que retorna o tipo Plano e recebe como parâmetro
//		um Integer id. 
//		Esse método deve retornar o Plano presente em listaPlano cujo o atributo id é
//		igual ao parâmetro passado.
//	removeById:
//		Criar método público removeById que remove o primeiro objeto Plano e 
//		cujo o valor do atributo id é igual ao valor recebido como parâmetro
public class PlanoRepository {

	private List<Plano> listaPlanos;
	private int proxId;
	
	public PlanoRepository() {
		this.listaPlanos = new ArrayList<>();
		this.proxId = 1;
	}
	
	public List<Plano> findAll() {
		return new ArrayList<>(listaPlanos);
	}
	
	
//	findById:
//	Criar método público findById que retorna o tipo Plano e recebe como parâmetro
//	um Integer id. 
//	Esse método deve retornar o Plano presente em listaPlano cujo o atributo id é
//	igual ao parâmetro passado.

	public Plano findById(Integer id) {
		for(Plano p : listaPlanos) {
			if (p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}
	
//	removeById:
//	Criar método público removeById que remove o primeiro objeto Plano e 
//	cujo o valor do atributo id é igual ao valor recebido como parâmetro
	
	public boolean removeById(Integer id) {
		Iterator<Plano> it = listaPlanos.iterator();
		while(it.hasNext()) {
			Plano p = it.next();
			if (p.getId().equals(id)) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	public void add(Plano Plano) {
		Plano.setId(proxId++);
		this.listaPlanos.add(Plano);
	}


	
	
	
	
	
	
	
	
}
