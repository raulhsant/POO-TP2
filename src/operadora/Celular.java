package operadora;

import java.util.Date;
import java.util.List;

public class Celular {

	private Cliente cliente;
	private List<Ligacao> ligacoes;
	private String numero;
	private Date validade;
	private double valor;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Ligacao> getLigacoes() {
		return ligacoes;
	}
	public void setLigacoes(List<Ligacao> ligacoes) {
		this.ligacoes = ligacoes;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}	
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public Celular(Cliente cliente, List<Ligacao> ligacoes, String numero) {
		super();
		this.cliente = cliente;
		this.ligacoes = ligacoes;
		this.numero = numero;
	}
	
	public Celular() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Celular [cliente=" + cliente + ", ligacoes=" + ligacoes + ", numero=" + numero + "]";
	}
	
	
	
	
	
	
	
}
