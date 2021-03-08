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
		
		do {
			
			char opcaoMovimento, opcaoContinuar = '0';
			double movimentos[] = new double[10];
			int contador = 0, conta = 0, dia = 0;
			Conta contaSelecionada = new Conta(conta);
			String nomeTipo = "\nConta ";
			
			// MOSTRA LOGO DO BANCO E MENU INICIAL
			
			System.out.printf("Seja bem-vindo(a) ao Banco G6T18!\n"
					+ "Tecnologia pra você :)\n\n");	
					
			System.out.printf("Menu\n"
					+ "1 - Conta Poupança\n"
					+ "2 - Conta Corrente\n"
					+ "3 - Conta Especial\n"
					+ "4 - Conta Empresa\n"
					+ "5 - Conta Estudantil\n"
					+ "6 - Sair\n\n");
			
			// DIGITA O TIPO DE CONTA
			
			System.out.printf("Informe o tipo de conta: ");
			opcaoConta = ler.next().toUpperCase().charAt(0);
			
			if (opcaoConta == '1' || opcaoConta == '2' || opcaoConta == '3'
					|| opcaoConta == '4' || opcaoConta == '5') {
				
				// DIGITA O NÚMERO DA CONTA
				
				System.out.printf("Informe o código da opção desejada: ");
				conta = ler.nextInt();
				
				// SELECIONA CONTA
				
				if (opcaoConta == '1') {
					
					System.out.printf("Informe o dia de aniversário da conta [1-31]: ");
					dia = ler.nextInt();
					
					// VITOR HUGO
					nomeTipo += "Poupança";			
					contaSelecionada = new ContaPoupanca(conta, dia);
					
				} 
				else if (opcaoConta == '2') {
					
					// RICARDO
					nomeTipo += "Corrente";
					contaSelecionada = new ContaCorrente(conta);
					
				} 
				else if (opcaoConta == '3') {
					
					// NICOLI
					nomeTipo += "Especial";
					contaSelecionada = new ContaEspecial(conta);
					
				}
				else if (opcaoConta == '4') {
					
					// FELIPE
					nomeTipo += "Empresa";
					contaSelecionada = new ContaEmpresa(conta);
					
				}
				else if (opcaoConta == '5') {
					
					// MARIANA
					nomeTipo += "Estudantil";
					contaSelecionada = new ContaEstudantil(conta);
					
				}
				
				// MOSTRA DADOS DA CONTA
				
				System.out.printf("%s\n\nConta: %d\n", nomeTipo, contaSelecionada.getNumero());
				contaSelecionada.exibir();
				
				// LAÇO COM OS MOVIMENTOS DA CONTA
				
				while (opcaoContinuar != 'N' && contador < movimentos.length) {
					
					if (opcaoConta == '2') {
						
						// RICARDO
						
						System.out.printf("\n[%d] Informe o tipo de operação: D-débito / C-crédito / T-talão de cheque: ", (contador + 1));
						opcaoMovimento = ler.next().toUpperCase().charAt(0);
						
					} 
					else if (opcaoConta == '4' || opcaoConta == '5') {
						
						// FELIPE E MARIANA
						
						System.out.printf("\n[%d] Informe o tipo de operação: D-débito / C-crédito / E-empréstimo: ", 
								(contador + 1));
						opcaoMovimento = ler.next().toUpperCase().charAt(0);
						
					} 
					else {
						
						// NICOLI
						
						System.out.printf("\n[%d] Informe o tipo de operação: D-débito / C-crédito: ", (contador + 1));
						opcaoMovimento = ler.next().toUpperCase().charAt(0);
						
					}
					
					if (((opcaoMovimento != 'C' && opcaoMovimento != 'D') 
							&& (opcaoConta == '1' || opcaoConta == '3')) 
					|| ((opcaoMovimento != 'C' && opcaoMovimento != 'D' && opcaoMovimento != 'E') 
							&& (opcaoConta == '4' || opcaoConta == '5')) 
					|| ((opcaoMovimento != 'C' && opcaoMovimento != 'D' && opcaoMovimento != 'T')
							&& (opcaoConta == '2'))) {
						
						System.out.printf("\nOpção inválida!\n");
						
					} 
					else if (opcaoMovimento == 'T') {
						
						// RICARDO
						
						((ContaCorrente) contaSelecionada).pedirTalao();
						
						contador++;
						
					}
					else {
						
						System.out.printf("Informe o valor da movimentação: ");
						movimentos[contador] = ler.nextDouble();
						System.out.println();
									
						if (opcaoMovimento == 'C') {
							
							contaSelecionada.credito(movimentos[contador]);
							
						} 
						else if (opcaoMovimento == 'D') {
							
							contaSelecionada.debito(movimentos[contador]);
							
						}
						else if (opcaoMovimento == 'E') {
							
							if (opcaoConta == '4') {
								
								// FELIPE
							
								((ContaEmpresa) contaSelecionada).pedirEmprestimo(movimentos[contador]);
								
							} 
							else if (opcaoConta == '5') {
								
								// MARIANA
								
								((ContaEstudantil) contaSelecionada).usarEstudantil(movimentos[contador]);
								
							}
							
						}
						
						contador++;
						
					}
												
					// PERGUNTA SE DESEJA CONTINUAR ATÉ ALCANÇAR O LIMITE DE MOVIMENTOS
					// OU SE DESEJA PARAR ANTES
					
					if (contador < movimentos.length) {
						
						System.out.printf("\nDeseja continuar? S/N: ");
						opcaoContinuar = ler.next().toUpperCase().charAt(0);
						
					}
						
				}
				
				if (opcaoConta == '1') {
					
					// VITOR HUGO
					
					((ContaPoupanca) contaSelecionada).correcao();
					
				}
				
				// MOSTRA DADOS DA CONTA
				
				contaSelecionada.exibir();
				System.out.println("\n------------------------------\n");
				
			} else if (opcaoConta == '6') {
				
				System.out.printf("\nSaindo...\n");
				
			} else {
				
				System.out.printf("\nOpção inválida!\n\n");
				
			}
			
			if (opcaoConta == '5') {
				
			}
			
		} while (opcaoConta != '6');
				
		System.out.printf("\nFim de programa!");
		
		ler.close();
		
	}

}
