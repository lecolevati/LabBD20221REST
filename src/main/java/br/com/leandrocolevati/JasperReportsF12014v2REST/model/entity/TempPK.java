package br.com.leandrocolevati.JasperReportsF12014v2REST.model.entity;

import java.io.Serializable;

public class TempPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int codigoCorrida;
	private int numeroPiloto;
	
	public int getCodigoCorrida() {
		return codigoCorrida;
	}
	public void setCodigoCorrida(int codigoCorrida) {
		this.codigoCorrida = codigoCorrida;
	}
	public int getNumeroPiloto() {
		return numeroPiloto;
	}
	public void setNumeroPiloto(int numeroPiloto) {
		this.numeroPiloto = numeroPiloto;
	}
	
	@Override
	public String toString() {
		return "TempPK [codigoCorrida=" + codigoCorrida + ", numeroPiloto=" + numeroPiloto + "]";
	}
	
}
