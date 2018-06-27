package operadora;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.FaturaCreditoDTO;
import excecoes.CelularException;


public class Celular {
	
	
	private static int proxNum = 990000001;
	
	public static void setproxNum(int numCels) {
		proxNum = numCels+1; 
	}
	

	private Cliente cliente;
	private List<Ligacao> ligacoes;
	private Integer numero;
//	private Date validade;
	private double valor;
	private Plano plano;
	
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
	public Integer getNumero() {
		return numero;
	}
//	public void setNumero(Integer numero) {
//		this.numero = numero;
//	}	
//	public Date getValidade() {
//		return validade;
//	}
//	public void setValidade(Date validade) {
//		this.validade = validade;
//	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Plano getPlano() {
		return plano;
	}
	public void setPlano(Plano plano) {
		this.plano = plano;
	}
	
	public Celular(Cliente cliente, Plano plano) {
		super();
		this.cliente = cliente;
		this.ligacoes = new ArrayList<Ligacao>();
		this.plano = plano;
		this.numero = proxNum;
		this.valor = 0;
		proxNum++;
	}
	
	public Celular() {
		super();
		this.ligacoes =  new ArrayList<Ligacao>();
	}
	
	
	@Override
	public String toString() {
		return "Celular [cliente=" + cliente + ", ligacoes=" + ligacoes + ", numero=" + numero + ", valor=" + valor
				+ ", plano=" + plano + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void adicionarCreditos(double valor, Date validade) throws CelularException {}
	public void resgistrarLigacao(Date dataLigacao, Integer minutos) throws Exception {}
	public double getCreditos() throws CelularException { return (Double) null; }
	public Date getVencimentoValidade() {	return null; }
	public double getConta() throws CelularException { return (Double) null; }
	
	
	

	
	
	
	
}
