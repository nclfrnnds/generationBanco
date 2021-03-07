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
	
	@Override
	public void exibir() {
		System.out.printf("\nSaldo: R$ %.2f\n", getSaldo());
		System.out.printf("Empréstimo disponível: R$ %.2f\n", getLimiteEstudantil());
	}
	
	// Métodos
	
	public double usarEstudantil(double valor) {
		if (limiteEstudantil >= valor) {
			limiteEstudantil = limiteEstudantil - valor;
			saldo = saldo + valor;
			System.out.printf("Empréstimo no valor de %.2f realizado com sucesso!\n", valor);
		}
		else {
			System.out.printf("Você não possui limite de empréstimo suficiente para realizar a movimentação.\n");
		}
		exibir();
		return limiteEstudantil;
	}

}
