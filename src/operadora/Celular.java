	package operadora;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import excecoes.CelularException;


public class Celular implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -517118110091602025L;
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
	
	
	

	public void adicionarCreditos(double valor, GregorianCalendar validade) throws CelularException {}
	public void resgistrarLigacao(GregorianCalendar dataLigacao, Integer minutos) throws Exception {}
	public double getCreditos() throws CelularException { return (Double) null; }
	public GregorianCalendar getVencimentoValidade() {	return null; }
	public double getConta() throws CelularException { return (Double) null; }


	public List<Ligacao> getLigacoes(GregorianCalendar desde) {

		List <Ligacao> ligacoesToReturn = new ArrayList<Ligacao>();

		for(Ligacao ligacao : this.ligacoes){

			if(ligacao.getData() != null && ligacao.getData().getTimeInMillis() > desde.getTimeInMillis()){
				ligacoesToReturn.add(ligacao);
			}
		}

		return ligacoesToReturn;
	}

	
	
	
	
}
