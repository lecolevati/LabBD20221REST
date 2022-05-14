package br.com.leandrocolevati.JasperReportsF12014v2REST.model.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(value = "piloto")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class PilotoDTO {
	
	private int numero;
	private String nome;
	private EquipeDTO equipe;
	
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
	public EquipeDTO getEquipe() {
		return equipe;
	}
	public void setEquipe(EquipeDTO equipe) {
		this.equipe = equipe;
	}

	@Override
	public String toString() {
		return "Piloto [numero=" + numero + ", nome=" + nome + ", equipe=" + equipe + "]";
	}
	
}
