package excecoes;

public class CelularException extends Exception {
	
	private double valor;
	
	public CelularException(String msg) {
		super(msg);
	}
	
	public CelularException() {
		super();
	}
}
