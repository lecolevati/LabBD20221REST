package br.com.leandrocolevati.JasperReportsF12014v2REST.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "temporada")
@IdClass(TemporadaPK.class)
public class Temporada {

	@Id
	@ManyToOne(targetEntity = Piloto.class)
	@JoinColumn(name = "numero_piloto")
	@NonNull
	private Piloto piloto;

	@Id
	@ManyToOne(targetEntity = Corrida.class)
	@JoinColumn(name = "codigo_corrida")
	@NonNull
	private Corrida corrida;
	
	@Column(name = "posicao")
	@NonNull
	private int posicao;
	
	@Column(name = "pontos")
	@NonNull
	private int pontos;
	
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
