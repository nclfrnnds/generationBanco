package aplicacao;

import java.util.Scanner;

import classes.Conta;
import classes.ContaCorrente;
import classes.ContaEmpresa;
import classes.ContaEspecial;
import classes.ContaEstudantil;
import classes.ContaPoupanca;

public class Main {

	public static void main(String[] args) {
		
		// DECLARA VARIÁVEIS
		
		Scanner ler = new Scanner(System.in);
		
		char opcaoConta;
		char opcaoMovimento;
		char opcaoContinuar;
		
		final int QTDMOVIMENTOS = 10;
		double movimentos[] = new double[QTDMOVIMENTOS];
		
		int conta = 0;
		Conta contaSelecionada = new Conta(conta);

		// MOSTRA LOGO DO BANCO
		
		System.out.printf("[BANCO G6 - G6]\n"
				+ "[SLOGAN DO BANCO]\n\n");	
		
		// MOSTRA MENU INICIAL
		
		System.out.printf("MENU\n"
				+ "1 - CONTA POUPANÇA\n"
				+ "2 - CONTA CORRENTE\n"
				+ "3 - CONTA ESPECIAL\n"
				+ "4 - CONTA EMPRESA\n"
				+ "5 - CONTA ESTUDANTIL\n"
				+ "6 - SAIR\n\n"
				+ "Informe o tipo de conta: ");
		opcaoConta = ler.next().toUpperCase().charAt(0);
		
		// LÊ DADOS DA CONTA
		
		System.out.printf("Informe o número da conta: ");
		conta = ler.nextInt();
		
		// CRIA TEXTO INFORMANDO O TIPO DE CONTA
		
		String nomeTipo = "\nCONTA ";
		
		// SELECIONA CONTA
		
		if (opcaoConta == '1') {	
			nomeTipo += "POUPANÇA";			
			contaSelecionada = new ContaPoupanca(conta);
		} 
		else if (opcaoConta == '2') {
			nomeTipo += "CORRENTE";
			contaSelecionada = new ContaCorrente(conta);
		} 
		else if (opcaoConta == '3') {
			nomeTipo += "ESPECIAL";
			contaSelecionada = new ContaEspecial(conta);			
		}
		else if (opcaoConta == '4') {
			nomeTipo += "EMPRESA";
			contaSelecionada = new ContaEmpresa(conta);
		}
		else if (opcaoConta == '5') {
			nomeTipo += "ESTUDANTIL";
			contaSelecionada = new ContaEstudantil(conta);
		}
		else if (opcaoConta == '6') {
			nomeTipo = "SAINDO...";
		}
		else {
			nomeTipo = "ERRO DE DIGITAÇÃO";
		}
		
		// MOSTRA DADOS DA CONTA
		
		System.out.printf("%s\n\n", nomeTipo);
		System.out.printf("Conta: %d\nSaldo atual: R$ %.2f\n\n", 
				contaSelecionada.getNumero(), contaSelecionada.getSaldo());
		
		// MOVIMENTA CONTA
		
		for (int cont = 0; cont < movimentos.length; cont++) {
			
			System.out.printf("[%d] Informe o tipo de movimento: D-débito ou C-crédito: ", (cont+1));
			opcaoMovimento = ler.next().toUpperCase().charAt(0);
			
			System.out.printf("Informe o valor do movimento: ");
			movimentos[cont] = ler.nextDouble();
			
			System.out.println();
			
			String ultimoMovimento = "";
			
			if (opcaoMovimento == 'C') {
				ultimoMovimento = "crédito";
				contaSelecionada.credito(movimentos[cont]);
			} 
			else if (opcaoMovimento == 'D') {
				ultimoMovimento = "débito";
				contaSelecionada.debito(movimentos[cont]);
			} 
			else {
				System.out.printf("Opção inválida!");
			}
			
			// MOSTRA VALOR DO ÚLTIMO MOVIMENTO E D0 NOVO SALDO
			
			System.out.printf("Último movimento (%s): R$ %.2f\nNovo saldo: R$ %.2f\n", 
					ultimoMovimento, movimentos[cont], contaSelecionada.getSaldo());

			// MOSTRA AS ESPECIFICAÇÕES DAS CLASSES
			
			if (opcaoConta == '1') {
				
			} 
			else if (opcaoConta == '2') {
				
			}
			else if (opcaoConta == '3') {
				double limiteRestante = ((classes.ContaEspecial) contaSelecionada).getLimite();
				System.out.printf("Limite restante: R$ %.2f\n", limiteRestante);
			}
			else if (opcaoConta == '4') {
				double emprestimoDisponivel = ((classes.ContaEmpresa) contaSelecionada).getEmprestimoEmpresa();
				System.out.printf("Empréstimo disponível: R$ %.2f\n", emprestimoDisponivel);
			}
			else if (opcaoConta == '5') {
				double emprestimoDisponivel = ((classes.ContaEstudantil) contaSelecionada).getLimiteEstudantil();
				System.out.printf("Empréstimo disponível: R$ %.2f\n", emprestimoDisponivel);
			}
			
			System.out.println();
			
			// PERGUNTA SE DESEJA CONTINUAR ATÉ ALCANÇAR OS 10 MOVIMENTOS
			// OU SE DESEJA PARAR ANTES
			
			if (cont < movimentos.length - 1) {
				System.out.printf("Continuar? S/N: ");
				opcaoContinuar = ler.next().toUpperCase().charAt(0);
				System.out.println();
				
				if (opcaoContinuar == 'N') {
					System.out.println("Saindo...");
					break;
				}
			}

		}
		
		ler.close();
		
	}

}
