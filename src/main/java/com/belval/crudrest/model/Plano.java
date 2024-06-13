package com.belval.crudrest.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Plano")
public class Plano {
	
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_Plano") 
	private Integer id;
	
	@Column(name = "Plano")
	private String Plano;
	
	@Column(name = "desc_Plano")
	private String descricao;
	
	@Column(name = "preco")
	private double preco;
	
	//Método construtor padrão, isto é, sem parâmetros
	public Plano() {
		
	}

	//Alt + SHIFT + S > Generate contructor using Fields
	public Plano(Integer id, String Plano, String descricao, double preco) {
		this.id = id;
		this.Plano = Plano;
		this.descricao = descricao;
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlano() {
		return Plano;
	}

	public void setPlano(String Plano) {
		this.Plano = Plano;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, id, Plano, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plano other = (Plano) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id)
				&& Objects.equals(Plano, other.Plano)
				&& Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco);
	}

	@Override
	public String toString() {
		return "Plano [id=" + id + ", Plano=" + Plano + ", descricao=" + descricao + ", preco=" + preco + "]";
	}

	
	
}
