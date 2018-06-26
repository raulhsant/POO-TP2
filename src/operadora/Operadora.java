package operadora;

import java.util.ArrayList;
import java.util.List;

public class Operadora {
	
	private String nome;
	private List<Cliente> clientes;
	private List<Ligacao> ligacoes;
	
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
	public List<Ligacao> getLigacoes() {
		return ligacoes;
	}
	public void setLigacoes(List<Ligacao> ligacoes) {
		this.ligacoes = ligacoes;
	}
	
	public Operadora(String nome, List<Cliente> clientes, List<Ligacao> ligacoes) {
		super();
		this.nome = nome;
		this.clientes = clientes;
		this.ligacoes = ligacoes;
	}
	
	public Operadora() {
		super();
		this.clientes = new ArrayList<Cliente>();
		this.ligacoes =  new ArrayList<Ligacao>();
	}
	
	@Override
	public String toString() {
		return "Operadora [nome=" + nome + ", clientes=" + clientes + ", ligacoes=" + ligacoes + "]";
	}
	
}
