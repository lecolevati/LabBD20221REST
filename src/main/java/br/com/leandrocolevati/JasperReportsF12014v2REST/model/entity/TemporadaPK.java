package br.com.leandrocolevati.JasperReportsF12014v2REST.model.entity;

import java.io.Serializable;

public class TemporadaPK implements Serializable {

	private static final long serialVersionUID = 1L;

	private Piloto piloto;
	private Corrida corrida;
	
	public Piloto getPiloto() {
		return piloto;
	}
	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}
	public Corrida getCorrida() {
		return corrida;
	}
	public void setCorrida(Corrida corrida) {
		this.corrida = corrida;
	}
	
	@Override
	public String toString() {
		return "TemporadaPK [piloto=" + piloto + ", corrida=" + corrida + "]";
	}
	
}
