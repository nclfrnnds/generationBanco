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
	

	
	// Métodos
	
	public double pedirEmprestimo(double valor) {
		return this.saldo;
	}

}
