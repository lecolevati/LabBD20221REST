package br.com.leandrocolevati.JasperReportsF12014v2REST.model.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "temp")
@IdClass(TempPK.class)
public class Temp {
	
	@Id
	@Column(name = "codigo")
	private int codigoCorrida;
	
	@Column(name = "pais")
	private String pais;

	@Id
	@Column(name = "numero")
	private int numeroPiloto;
	
	@Column(name = "nome")
	private String nomePiloto;
	
	@Column(name = "equipe")
	private String nomeEquipe;
	
	@Column(name = "posicao")
	private int posicao;
	
	@Column(name = "pontos")
	private int pontos;
	
	public int getCodigoCorrida() {
		return codigoCorrida;
	}
	public void setCodigoCorrida(int codigoCorrida) {
		this.codigoCorrida = codigoCorrida;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public int getNumeroPiloto() {
		return numeroPiloto;
	}
	public void setNumeroPiloto(int numeroPiloto) {
		this.numeroPiloto = numeroPiloto;
	}
	public String getNomePiloto() {
		return nomePiloto;
	}
	public void setNomePiloto(String nomePiloto) {
		this.nomePiloto = nomePiloto;
	}
	public String getNomeEquipe() {
		return nomeEquipe;
	}
	public void setNomeEquipe(String nomeEquipe) {
		this.nomeEquipe = nomeEquipe;
	}
	public int getPosicao() {
		return posicao;
	}
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	@Override
	public String toString() {
		return "TempDTO [codigoCorrida=" + codigoCorrida + ", pais=" + pais + ", numeroPiloto=" + numeroPiloto
				+ ", nomePiloto=" + nomePiloto + ", nomeEquipe=" + nomeEquipe + ", posicao=" + posicao + ", pontos="
				+ pontos + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigoCorrida, nomeEquipe, nomePiloto, numeroPiloto, pais, pontos, posicao);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Temp other = (Temp) obj;
		return codigoCorrida == other.codigoCorrida && Objects.equals(nomeEquipe, other.nomeEquipe)
				&& Objects.equals(nomePiloto, other.nomePiloto) && numeroPiloto == other.numeroPiloto
				&& Objects.equals(pais, other.pais) && pontos == other.pontos && posicao == other.posicao;
	}
	
	
}
