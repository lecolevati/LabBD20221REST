package br.com.leandrocolevati.JasperReportsF12014v2REST.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "piloto")
public class Piloto {
	
	@Id
	@Column(name = "numero")
	@NonNull
	private int numero;

	@Column(name = "nome", length = 50)
	@NonNull
	private String nome;
	
	@ManyToOne(targetEntity = Equipe.class)
	@JoinColumn(name = "equipe")
	@NonNull
	private Equipe equipe;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Equipe getEquipe() {
		return equipe;
	}
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	@Override
	public String toString() {
		return "Piloto [numero=" + numero + ", nome=" + nome + ", equipe=" + equipe + "]";
	}
	
}
