package operadora;

public class Cliente {
	
	private String nome;
	private String cpfCnpj;
	private String endereco;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Cliente(String nome, String cpfCnpj, String endereco) {
		super();
		this.nome = nome;
		this.cpfCnpj = cpfCnpj;
		this.endereco = endereco;
	}
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpfCnpj=" + cpfCnpj + ", endereco=" + endereco + "]";
	}
	
	

}
