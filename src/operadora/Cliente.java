package operadora;

import java.io.Serializable;

public class Cliente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6836327164268109614L;
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
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpfCnpj == null) ? 0 : cpfCnpj.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Cliente other = (Cliente) obj;
		
		if (cpfCnpj == null) {
			if (other.cpfCnpj != null)
				return false;
			
		} else if (!cpfCnpj.equals(other.cpfCnpj))
			return false;
		
		if (endereco == null) {
			if (other.endereco != null)
				return false;
			
		} else if (!endereco.equals(other.endereco))
			return false;
		
		if (nome == null) {
			if (other.nome != null)
				return false;
			
		} else if (!nome.equals(other.nome))
			return false;
		
		return true;
	}
	


	
	

}
