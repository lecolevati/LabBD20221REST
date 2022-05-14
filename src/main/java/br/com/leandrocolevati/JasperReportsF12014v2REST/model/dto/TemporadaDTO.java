package br.com.leandrocolevati.JasperReportsF12014v2REST.model.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName(value = "temporada")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class TemporadaDTO {

	private PilotoDTO piloto;
	private CorridaDTO corrida;
	private int posicao;
	private int pontos;
	
	public PilotoDTO getPiloto() {
		return piloto;
	}
	public void setPiloto(PilotoDTO piloto) {
		this.piloto = piloto;
	}
	public CorridaDTO getCorrida() {
		return corrida;
	}
	public void setCorrida(CorridaDTO corrida) {
		this.corrida = corrida;
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
		return "Temporada [piloto=" + piloto + ", corrida=" + corrida + ", posicao=" + posicao + ", pontos=" + pontos
				+ "]";
	}
	
}
