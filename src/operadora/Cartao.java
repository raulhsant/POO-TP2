package operadora;

import java.util.Date;
import java.util.List;

import dto.FaturaCreditoDTO;
import excecoes.CelularException;

public class Cartao extends Celular {
	
	private Date validade;
	private List<Ligacao> ligacoes;

	public Cartao(Cliente cliente, Plano plano, Date validade) {
		super(cliente, plano);
		this.validade = validade;
	}

	public Cartao(Cliente cliente, Plano plano) {
		super(cliente, plano);
		//this.validade is null
	}
	
	
	public void adicionarCreditos(double valor, Date validade) throws CelularException {
		this.setValor(valor);
		this.validade = validade;
	}
	
	
	public void resgistrarLigacao(Date dataLigacao, Integer minutos) throws Exception {
		
		double valor = minutos * this.getPlano().getValorMinuto();
		
		if (valor > this.getValor())
			throw new CelularException("Saldo insuficiente!");
		else if (this.validade.getTime() < new Date().getTime())
			throw new CelularException("Saldo vencido!");
		else {
			Ligacao lig = new Ligacao(dataLigacao, minutos, valor);
			
			this.ligacoes.add(lig);
			
			this.setValor(this.getValor() - valor);
		}

	}
	
	public double getCreditos() throws CelularException {	
		return this.getValor();
	}
	
	public Date getVencimentoValidade() {	
		return this.validade; 
	}
	
	public double getConta() throws CelularException {
		throw new CelularException("Celular de cartão, não possui conta");
	}
	
	
	
	

}
