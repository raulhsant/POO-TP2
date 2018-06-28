package operadora;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import dto.FaturaCreditoDTO;
import excecoes.CelularException;
import excecoes.ClienteException;
import excecoes.PlanoException;

import javax.swing.*;

public class Operadora implements Serializable{
	
	private String nome;
	private List<Cliente> clientes;
	private List<Celular> celulares;
	private List<Plano> planos;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public List<Celular> getCelulares() {
		return celulares;
	}
	public void setLigacoes(List<Celular> celulares) {
		this.celulares = celulares;
	}

	public void setCelulares(List<Celular> celulares) {
		this.celulares = celulares;
	}

	public List<Plano> getPlanos() {
		return planos;
	}

	public void setPlanos(List<Plano> planos) {
		this.planos = planos;
	}
	
	public Operadora(String nome, List<Cliente> clientes, List<Celular> celulares, List<Plano> planos) {
		super();
		this.nome = nome;
		this.clientes = clientes;
		this.celulares = celulares;
		this.planos = planos;
	}
	
	public Operadora(String nome) {
		super();
		this.nome = nome;
		this.clientes = new ArrayList<Cliente>();
		this.celulares = new ArrayList<Celular>();
		this.planos = new ArrayList<Plano>();
	}
	
	
	@Override
	public String toString() {
		return "Operadora [nome=" + nome + ", clientes=" + clientes + ", celulares=" + celulares + ", planos=" + planos
				+ "]";
	}
	
	
	public void cadastrarCliente(String nome, String cpfCnpj, String endereco) throws ClienteException {
		Cliente cliente = new Cliente(nome, cpfCnpj, endereco);
		
		if (clientes.contains(cliente)) {
			throw new ClienteException("O cliente informado já existe.", cliente);
		} else
			clientes.add(cliente);		
	}
	
	public void cadastrarPlano(String nome, double valorMinuto) throws PlanoException {
		
		for (Plano plano : planos) {
			if (plano.getNome().equals(nome))
				throw new PlanoException(String.format("Um plano com nome %s já existe", nome));
		}
		
		Plano plano =  new Plano(nome, valorMinuto);
		
		planos.add(plano);
		
	}
	
	
	public void adicionarCelular(String tipo, Plano plano, Cliente cliente, Integer validade) throws Exception {
		
		Celular celular;
		
		if(!clientes.contains(cliente))
			throw new ClienteException("Cliente não encontrado");
		
		if (!this.planos.contains(plano))
			throw new PlanoException("Plano não existe.");
		else {
			if (tipo.equals("Cartao")) {
				
				celular = new Cartao(cliente, plano);
				
			} else if (tipo.equals("Conta")) {
				
				celular = new Conta(cliente, plano, validade);
				
			}else
				throw new Exception("Tipo de celular incorreto");
		}
	}
	
	public void excluirCelular(Integer numero) throws CelularException {
		
//		Boolean celFound = false;
		Celular celular = null;
		
		for (Celular cel : celulares) {
			if (cel.getNumero().equals(numero)) {
				celular = cel;
			}
		}
		
		if(celular == null)
			throw new CelularException(String.format("Celular com número %d não encontrado", numero));	
		else {
			if (celular.getValor() == 0) {
				this.celulares.remove(celular);
			} else
				throw new CelularException("Celular não pode ser excluído");
		}
	}
	
	public void adicionarCréditos(Integer numero, double valor) throws CelularException {
		
		Celular celular = null;
		
		for (Celular cel : celulares) {
			if (cel.getNumero().equals(numero)) {
				celular = cel;
			}
		}
		
		if(celular == null)
			throw new CelularException(String.format("Celular com número %d não encontrado", numero));	
		else {
			
//			Date agora = new Date();
//			long centoeOitentaDiasEmMillis = 86400L * 1000L * 180L;
//
//			long validadeEmMillis =  agora.getTime() + centoeOitentaDiasEmMillis;

			GregorianCalendar validade = new GregorianCalendar();

//			Date val = new Date(validadeEmMillis);
//
//			validade.setTime(val);

			validade.set(GregorianCalendar.DAY_OF_YEAR, validade.get(GregorianCalendar.DAY_OF_YEAR) + 180);
			
			celular.adicionarCreditos(valor, validade);
		}
		
	}
	
	
	public void registrarLigacao(Integer numero, GregorianCalendar dataLigacao, Integer minutos ) throws CelularException {
		Celular celular = null;
		
		for (Celular cel : celulares) {
			if (cel.getNumero().equals(numero)) {
				celular = cel;
			}
		}
		
		if(celular == null)
			throw new CelularException(String.format("Celular com número %d não encontrado", numero));	
		else {
			try {
				celular.resgistrarLigacao(dataLigacao, minutos);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public FaturaCreditoDTO listaConta(Integer numero) throws CelularException {

		Celular celular = null;
		FaturaCreditoDTO resposta = new FaturaCreditoDTO();

		for (Celular cel : celulares) {
			if (cel.getNumero().equals(numero)) {
				celular = cel;
			}
		}

		if(celular == null)
			throw new CelularException(String.format("Celular com número %d não encontrado", numero));
		else {
			resposta.setCelular(celular);
			resposta.setValidadeVencimento(celular.getVencimentoValidade());
			resposta.setValue(celular.getConta());
		}

		return resposta;
	}

	public FaturaCreditoDTO listaCreditos(Integer numero) throws CelularException {

		Celular celular = null;
		FaturaCreditoDTO resposta = new FaturaCreditoDTO();

		for (Celular cel : celulares) {
			if (cel.getNumero().equals(numero)) {
				celular = cel;
			}
		}

		if(celular == null)
			throw new CelularException(String.format("Celular com número %d não encontrado", numero));
		else {
			resposta.setCelular(celular);
			resposta.setValidadeVencimento(celular.getVencimentoValidade());
			resposta.setValue(celular.getCreditos());
		}

		return resposta;

	}


	public List<Ligacao> getExtratoLigacoes( Integer numero, GregorianCalendar desde) throws CelularException {

		Celular celular = null;

		for (Celular cel : celulares) {
			if (cel.getNumero().equals(numero)) {
				celular = cel;
			}
		}

		if(celular == null)
			throw new CelularException(String.format("Celular com número %d não encontrado", numero));
		else {
			return celular.getLigacoes(desde);
		}

	}

	public List<Celular> getVencidos(){

		List<Celular> celularesComVencimento = new ArrayList<Celular>();

		for(Celular celular : this.celulares){
			if(celular.getVencimentoValidade().getTime().getTime() < new Date().getTime() ){
				celularesComVencimento.add(celular);
			}
		}

		return celularesComVencimento;
	}



	public void writeFile() {

		try {
			FileOutputStream f = new FileOutputStream(new File("OperData.dat"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			o.writeObject(this);

			o.close();
			f.close();
			System.out.println("Alterações salvas com sucesso!\n");

		} catch (IOException e) {
			System.out.println("Error initializing stream");
			System.out.println("\nNão foi possível salvar as Alterações!\n");
		}
	}

	public static Operadora readFile() {

		try {
			FileInputStream fi = new FileInputStream(new File("OperData.dat"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			Operadora operadora = (Operadora) oi.readObject();

			oi.close();
			fi.close();

			Celular.setproxNum(operadora.getCelulares().get(operadora.getCelulares().size()-1).getNumero());
			return operadora;

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
			if (createOperadoraObjectWithDefaultName())
			System.out.println("Default Bank Created. Try again!");
			JOptionPane.showMessageDialog(null, "Operadora padrão criada.", "Erro ao iniciar operadora", 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Boolean createOperadoraObjectWithDefaultName() {

		Operadora op1 = new Operadora("Minha Operadora");

		try {
			FileOutputStream f = new FileOutputStream(new File("OperData.dat"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			o.writeObject(op1);

			o.close();
			f.close();
			return true;
		} catch (IOException e) {
			System.out.println("Error initializing stream");
			return false;
		}
	}
}
