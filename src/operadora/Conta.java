package operadora;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import excecoes.CelularException;

public class Conta extends Celular {

	private Date vencimento;
	private List<Ligacao> ligacoes;
	
	public Conta(Cliente cliente, Plano plano, Date vencimento) {
		super(cliente, plano);
		this.vencimento = vencimento;
	}
	
	
	public void adicionarCreditos(double valor, Date validade) throws CelularException {
		throw new CelularException("N�o � poss�vel adicionar cr�dito a celular de conta");
	}

	public void resgistrarLigacao(Date dataLigacao, Integer minutos) throws Exception {
		
		if(dataLigacao.getTime() > new Date().getTime())
			throw new Exception("N�o � poss�vel registrar uma liga��o que ainda n�o ocorreu");
		else {
			double valor = minutos * this.getPlano().getValorMinuto();
			
			Ligacao lig = new Ligacao(dataLigacao, minutos, valor);
			
			this.ligacoes.add(lig);
			
			this.setValor(this.getValor() + valor); //valor nesse caso � quanto ser� cobrado na fatura
		}
	}
	
	
	public double getCreditos() throws CelularException {
		throw new CelularException("Celular de conta, n�o possui cr�ditos");
	}
	
	public Date getVencimentoValidade() {	
		return this.vencimento; 
	}
	
	public double getConta() throws CelularException {
		return this.getValor();
	}
	
}
