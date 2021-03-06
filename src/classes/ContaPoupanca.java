package classes;

public class ContaPoupanca extends Conta {
	
	// Atributos
	
	private int aniversarioPoupanca = 6;
	
	// Construtor e sobrecargas do construtor
	
	public ContaPoupanca(int numero) {
		super(numero);
	}

	public ContaPoupanca(int numero, int aniversarioPoupanca) {
		super(numero);
		this.aniversarioPoupanca = aniversarioPoupanca;
	}

	public ContaPoupanca(int numero, String cpf, int aniversarioPoupanca) {
		super(numero, cpf);
		this.aniversarioPoupanca = aniversarioPoupanca;
	}

	public ContaPoupanca(int numero, String cpf, boolean ativa, int aniversarioPoupanca) {
		super(numero, cpf, ativa);
		this.aniversarioPoupanca = aniversarioPoupanca;
	}

	// Encapsulamento
	
	public int getAniversarioPoupanca() {
		return aniversarioPoupanca;
	}

	public void setAniversarioPoupanca(int aniversarioPoupanca) {
		this.aniversarioPoupanca = aniversarioPoupanca;
	}
	
	// Métodos override
	

	
	// Métodos
	
	public double correcao() {
		return this.saldo;
	}

}
