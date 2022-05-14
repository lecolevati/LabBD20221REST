package br.com.leandrocolevati.JasperReportsF12014v2REST.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "corrida")
public class Corrida {

	@Id
	@Column(name = "codigo")
	@NonNull
	private int codigo;
	
	@Column(name = "pais", length = 100)
	@NonNull
	private String pais;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Corrida [codigo=" + codigo + ", pais=" + pais + "]";
	} 
	
}
