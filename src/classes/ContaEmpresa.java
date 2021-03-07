package classes;

public class ContaEmpresa extends Conta {
	
	// Atributos
	
	private double emprestimoEmpresa = 10000;
	
	// Construtor e sobrecargas do construtor

	public ContaEmpresa(int numero) {
		super(numero);
	}
	
	public ContaEmpresa(int numero, double emprestimoEmpresa) {
		super(numero);
		this.emprestimoEmpresa = emprestimoEmpresa;
	}

	public ContaEmpresa(int numero, String cpf, double emprestimoEmpresa) {
		super(numero, cpf);
		this.emprestimoEmpresa = emprestimoEmpresa;
	}

	public ContaEmpresa(int numero, String cpf, boolean ativa, double emprestimoEmpresa) {
		super(numero, cpf, ativa);
		this.emprestimoEmpresa = emprestimoEmpresa;
	}
	
	// Encapsulamento

	public double getEmprestimoEmpresa() {
		return emprestimoEmpresa;
	}

	public void setEmprestimoEmpresa(double emprestimoEmpresa) {
		this.emprestimoEmpresa = emprestimoEmpresa;
	}
	
	// Métodos override
	
	@Override
	public void exibir() {
		System.out.printf("\nSaldo: R$ %.2f\n", getSaldo());
		System.out.printf("Empréstimo disponível: R$ %.2f\n", getEmprestimoEmpresa());
	}
	
	// Métodos
	
	public double pedirEmprestimo(double valor) {
		if (emprestimoEmpresa >= valor) {
			emprestimoEmpresa = emprestimoEmpresa - valor;
			saldo = saldo + valor;
			System.out.printf("Empréstimo no valor de %.2f realizado com sucesso!\n", valor);
		}
		else {
			System.out.printf("Você não possui limite de empréstimo suficiente para realizar a m.\n");
		}
		exibir();
		return emprestimoEmpresa;	
	}

}
