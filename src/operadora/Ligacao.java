package operadora;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ligacao implements Serializable {
	
	private GregorianCalendar data;
	private Integer duracao; //em minutos
	private double valor;
//	private Integer destinatario;
	
	public GregorianCalendar getData() {
		return data;
	}
	public void setData(GregorianCalendar data) {
		this.data = data;
	}
	public Integer getDuracao() {
		return duracao;
	}
	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
//	public Integer getDestinatario() {
//		return destinatario;
//	}
//	public void setDestinatario(Integer destinatario) {
//		this.destinatario = destinatario;
//	}
//	
	public Ligacao(GregorianCalendar data, Integer duracao, double valor) {
		super();
		this.data = data;
		this.duracao = duracao;
		this.valor = valor;
	}
	
	public Ligacao() {
		super();
	}
	
	@Override
	public String toString() {
		return "Ligacao [data=" + data + ", duracao=" + duracao + ", valor=" + valor + "]";
	}
	
	

}
