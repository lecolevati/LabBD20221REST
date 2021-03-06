package br.com.leandrocolevati.JasperReportsF12014v2REST.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "equipe")
public class Equipe {
	
	@Id
	@Column(name = "codigo")
	@NonNull
	private int codigo;
	
	@Column(name = "nome", length = 200)
	@NonNull
	private String nome;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Equipe [codigo=" + codigo + ", nome=" + nome + "]";
	}
	
}
