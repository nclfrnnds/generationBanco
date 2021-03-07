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
			System.out.printf("Débito no valor de R$ %.2f realizado com sucesso.\n", valor);
		} 
		else {
			usarLimite(valor);
		}
		exibir();
	}
	
	@Override
	public void exibir() {
		System.out.printf("\nSaldo: R$ %.2f\n", getSaldo());
		System.out.printf("Limite disponível: R$ %.2f\n", getLimite());
	}
	
	// Métodos
	
	public double usarLimite(double valor) {
		if ((saldo + limite) >= valor) {
			double saldoAntigo = saldo;
			double limiteUtilizado = valor - saldo;
			limite = limite + (saldo - valor);
			saldo = saldo - valor + limiteUtilizado;
			System.out.printf("Você utilizou R$ %.2f do seu saldo e R$ %.2f do limite disponível, "
					+ "totalizando o débito de R$ %.2f.\n", saldoAntigo, limiteUtilizado, valor);
		} else {
			System.out.printf("Você não possui saldo ou limite suficiente para realizar a movimentação.\n");
		}
		return limite;	
	}

}
