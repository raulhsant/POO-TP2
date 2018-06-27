package excecoes;

import operadora.Cliente;

public class ClienteException extends Exception {
	
	private Cliente cliente;

	public Cliente getCliente() {
		return cliente;
	}

	public ClienteException(String msg) {
		super(msg);
	}
	
	public ClienteException() {
		super();
	}

	public ClienteException(String msg, Cliente cliente) {
		super(msg);
		this.cliente =  cliente;
	}
}
