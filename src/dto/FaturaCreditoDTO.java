package dto;

import java.util.Date;

import operadora.Celular;

public class FaturaCreditoDTO {

	private Date validadeVencimento;
	private double Value;
	private Celular celular;
	
	
	public Date getValidadeVencimento() {
		return validadeVencimento;
	}
	public void setValidadeVencimento(Date validadeVencimento) {
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
	
	public FaturaCreditoDTO(Date validadeVencimento, double value, Celular celular) {
		super();
		this.validadeVencimento = validadeVencimento;
		Value = value;
		this.celular = celular;
	}
	public FaturaCreditoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
