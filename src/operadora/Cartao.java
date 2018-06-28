package operadora;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import excecoes.CelularException;

public class Cartao extends Celular {
	
	private GregorianCalendar validade;
//	private List<Ligacao> ligacoes;

	public Cartao(Cliente cliente, Plano plano, GregorianCalendar validade) {
		super(cliente, plano);
		this.validade = validade;
	}

	public Cartao(Cliente cliente, Plano plano) {
		super(cliente, plano);
		//this.validade is null
	}
	
	
	public void adicionarCreditos(double valor, GregorianCalendar validade) throws CelularException {
		this.setValor(valor);
		this.validade = validade;
	}
	
	
	public void resgistrarLigacao(GregorianCalendar dataLigacao, Integer minutos) throws Exception {
		
		double valor = minutos * this.getPlano().getValorMinuto();

		List<Ligacao> ligacoes = this.getLigacoes();
		
		if (valor > this.getValor())
			throw new CelularException("Saldo insuficiente!");
		else if (this.validade.getTime().getTime() < new Date().getTime())
			throw new CelularException("Saldo vencido!");
		else {
			Ligacao lig = new Ligacao(dataLigacao, minutos, valor);
			
			ligacoes.add(lig);
			
			this.setValor(this.getValor() - valor);
		}

		this.setLigacoes(ligacoes);

	}
	
	public double getCreditos() throws CelularException {	
		return this.getValor();
	}
	
	public GregorianCalendar getVencimentoValidade() {
		return this.validade; 
	}
	
	public double getConta() throws CelularException {
		throw new CelularException("Celular de cartão, não possui conta");
	}


}
