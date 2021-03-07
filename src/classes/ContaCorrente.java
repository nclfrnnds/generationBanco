package classes;

public class ContaCorrente extends Conta {
	
	// Atributos
	
	private int contadorTalao = 3;

	// Construtor e sobrecargas do construtor
	
	public ContaCorrente(int numero) {
		super(numero);
	}
	
	public ContaCorrente(int numero, int contadorTalao) {
		super(numero);
		this.contadorTalao = contadorTalao;
	}

	public ContaCorrente(int numero, String cpf, int contadorTalao) {
		super(numero, cpf);
		this.contadorTalao = contadorTalao;
	}

	public ContaCorrente(int numero, String cpf, boolean ativa, int contadorTalao) {
		super(numero, cpf, ativa);
		this.contadorTalao = contadorTalao;
	}
	
	// Encapsulamento

	public int getContadorTalao() {
		return contadorTalao;
	}

	public void setContadorTalao(int contadorTalao) {
		this.contadorTalao = contadorTalao;
	}
	
	// Métodos override
	
	@Override
	public void exibir() {
		System.out.printf("\nSaldo: R$ %.2f\n", getSaldo());
		System.out.printf("Talões disponíveis: %d\n", getContadorTalao());
	}
	
	// Métodos
	
	public void pedirTalao() {
		if (contadorTalao > 0) {
			contadorTalao--;
			System.out.printf("\nVocê solicitou um talão!\nTalões disponíveis: %d\n", contadorTalao);
		} 
		else {
			System.out.printf("\nVocê já atingiu seu limite de talões "
					+ "e não pode solicitar novos.\n");
		}	
	}

}
