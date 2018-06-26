package operadora;

import java.util.Date;

public class Ligacao {
	
	private Date data;	
	private Integer duracao; //em minutos
	private double valor;
//	private Integer destinatario;
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
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
	public Ligacao(Date data, Integer duracao, double valor) {
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
