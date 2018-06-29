package operadora;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import excecoes.CelularException;
import sun.util.calendar.Gregorian;

public class Conta extends Celular {

	private Integer diaVencimento;
//	private List<Ligacao> ligacoes;
	
	public Conta(Cliente cliente, Plano plano, Integer diaValidade) {
		super(cliente, plano);
		this.diaVencimento = diaValidade;
	}
	
	
	public void adicionarCreditos(double valor, GregorianCalendar validade) throws CelularException {
		throw new CelularException("Não é possível adicionar crédito a celular de conta");
	}

	public void resgistrarLigacao(GregorianCalendar dataLigacao, Integer minutos) throws Exception {

		List<Ligacao> ligacoes = this.getLigacoes();

		GregorianCalendar nowGregCal = new GregorianCalendar();
		GregorianCalendar vencimento = new GregorianCalendar( nowGregCal.get(GregorianCalendar.YEAR), nowGregCal.get(GregorianCalendar.MONTH), this.diaVencimento);


		if(dataLigacao.getTime().getTime() > new Date().getTime())
			throw new Exception("Não é possível registrar uma ligação que ainda não ocorreu.");
		else if(vencimento.getTimeInMillis() > dataLigacao.getTimeInMillis()){
			throw new Exception("A data informada não corresponde à fatura atual.");
		}
		else {
			double valor = minutos * this.getPlano().getValorMinuto();
			
			Ligacao lig = new Ligacao(dataLigacao, minutos, valor);
			
			ligacoes.add(lig);
			
//			this.setValor(this.getValor() + valor); //valor nesse caso é quanto será cobrado na fatura
													//NOPE
		}

		this.setLigacoes(ligacoes);

	}
	
	
	public double getCreditos() throws CelularException {
		throw new CelularException("Celular de conta, não possui créditos");
	}
	
	public GregorianCalendar getVencimentoValidade() {
		
		GregorianCalendar nowGregCal = new GregorianCalendar();
		GregorianCalendar vencimento = new GregorianCalendar( nowGregCal.get(GregorianCalendar.YEAR), nowGregCal.get(GregorianCalendar.MONTH), this.diaVencimento);

		int teste = nowGregCal.get(GregorianCalendar.DAY_OF_MONTH);
		int teste2 = nowGregCal.get(GregorianCalendar.YEAR);

		if(nowGregCal.get(GregorianCalendar.DAY_OF_MONTH) > this.diaVencimento) {

			vencimento.set(GregorianCalendar.MONTH, nowGregCal.get(GregorianCalendar.MONTH)+1);
			return vencimento;
		}

		return vencimento;
	}
	
	public double getConta() throws CelularException {

		double resposta = 0;

		GregorianCalendar now = new GregorianCalendar();
		GregorianCalendar vencimento = null;

		if(now.get(GregorianCalendar.DAY_OF_MONTH) > this.diaVencimento){
			vencimento = new GregorianCalendar(now.get(GregorianCalendar.YEAR), now.get(GregorianCalendar.MONTH), this.diaVencimento);
		} else{
			vencimento = new GregorianCalendar(now.get(GregorianCalendar.YEAR), now.get(GregorianCalendar.MONTH) - 1, this.diaVencimento);
		}

		for (Ligacao ligacao : this.getLigacoes()){
			if(vencimento!=null && ligacao.getData().getTimeInMillis() > vencimento.getTimeInMillis()){
				resposta += ligacao.getValor();
			}

		}


		return this.getValor();
	}
	
}
