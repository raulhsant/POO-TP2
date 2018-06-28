package dto;

import java.util.Date;
import java.util.GregorianCalendar;

import operadora.Celular;

public class FaturaCreditoDTO {

	private GregorianCalendar validadeVencimento;
	private double Value;
	private Celular celular;
	
	
	public GregorianCalendar getValidadeVencimento() {
		return validadeVencimento;
	}

	public void setValidadeVencimento(GregorianCalendar validadeVencimento) {
		this.validadeVencimento = validadeVencimento;
	}

	public double getValue() {
		return Value;
	}
	public void setValue(double value) {
		Value = value;
	}
	public Celular getCelular() {
		return celular;
	}
	public void setCelular(Celular celular) {
		this.celular = celular;
	}
	
	public FaturaCreditoDTO(GregorianCalendar validadeVencimento, double value, Celular celular) {
		super();
		this.validadeVencimento = validadeVencimento;
		Value = value;
		this.celular = celular;
	}
	public FaturaCreditoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
