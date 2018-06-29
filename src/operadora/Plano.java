package operadora;

import java.io.Serializable;

public class Plano implements Serializable {

	private String nome;
	private double valorMinuto;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValorMinuto() {
		return valorMinuto;
	}
	public void setValorMinuto(double valorMinuto) {
		this.valorMinuto = valorMinuto;
	}
	
	
	public Plano(String nome, double valorMinuto) {
		super();
		this.nome = nome;
		this.valorMinuto = valorMinuto;
	}
	
	
	public Plano() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Plano [nome=" + nome + ", valorMinuto=" + valorMinuto + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorMinuto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Plano other = (Plano) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(valorMinuto) != Double.doubleToLongBits(other.valorMinuto))
			return false;
		return true;
	}
	
	
	
		
	
}
