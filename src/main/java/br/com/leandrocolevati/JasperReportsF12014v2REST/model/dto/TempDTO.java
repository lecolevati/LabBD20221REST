package br.com.leandrocolevati.JasperReportsF12014v2REST.model.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(value = "temporada")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class TempDTO {
	
	private int codigoCorrida;
	private String pais;
	private int numeroPiloto;
	private String nomePiloto;
	private String nomeEquipe;
	private int posicao;
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
	
}
