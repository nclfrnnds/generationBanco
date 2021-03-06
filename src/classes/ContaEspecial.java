package classes;

public class ContaEspecial extends Conta {
	
	// Atributos
	
	private double limite = 1000;
	
	// Construtor e sobrecargas do construtor

	public ContaEspecial(int numero) {
		super(numero);
	}
	
	public ContaEspecial(int numero, double limite) {
		super(numero);
		this.limite = limite;
	}

	public ContaEspecial(int numero, String cpf, double limite) {
		super(numero, cpf);
		this.limite = limite;
	}

	public ContaEspecial(int numero, String cpf, boolean ativa, double limite) {
		super(numero, cpf, ativa);
		this.limite = limite;
	}
	
	// Encapsulamento

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	// Métodos override
	
	@Override
	public void debito(double valor) {	
		if (this.saldo >= valor) {
			this.saldo = this.saldo - valor;
		} else {
			usarLimite(valor);
		}
	}
	
	// Métodos
	
	public double usarLimite(double valor) {
		if ((this.saldo + limite) >= valor) {
			limite = limite + (this.saldo - valor);
			this.saldo = this.saldo - valor + (valor - this.saldo);
		}
		return limite;	
	}

}
