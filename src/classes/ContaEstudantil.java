package classes;

public class ContaEstudantil extends Conta {
	
	// Atributos
	
	private double limiteEstudantil = 5000;
	
	// Construtor e sobrecargas do construtor
	
	public ContaEstudantil(int numero) {
		super(numero);
	}

	public ContaEstudantil(int numero, double limiteEstudantil) {
		super(numero);
		this.limiteEstudantil = limiteEstudantil;
	}

	public ContaEstudantil(int numero, String cpf, double limiteEstudantil) {
		super(numero, cpf);
		this.limiteEstudantil = limiteEstudantil;
	}

	public ContaEstudantil(int numero, String cpf, boolean ativa, double limiteEstudantil) {
		super(numero, cpf, ativa);
		this.limiteEstudantil = limiteEstudantil;
	}
	
	// Encapsulamento

	public double getLimiteEstudantil() {
		return limiteEstudantil;
	}

	public void setLimiteEstudantil(double limiteEstudantil) {
		this.limiteEstudantil = limiteEstudantil;
	}
	
	// Métodos override
	

	
	// Métodos
	
	public double usarEstudantil(double valor) {
		return this.saldo;
	}

}
