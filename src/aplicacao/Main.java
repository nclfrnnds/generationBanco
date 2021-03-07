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
		
		double movimentos[] = new double[10];
		char opcaoConta, opcaoMovimento, opcaoContinuar = '0';
		int contador = 0, conta = 0, dia = 0;
		Conta contaSelecionada = new Conta(conta);
		String nomeTipo = "\nCONTA ";

		// MOSTRA LOGO DO BANCO E MENU INICIAL
		
		System.out.printf("[BANCO G6T18]\n"
				+ "[TECNOLOGIA PRA VOCÊ]\n\n");	
				
		System.out.printf("MENU\n"
				+ "1 - CONTA POUPANÇA\n"
				+ "2 - CONTA CORRENTE\n"
				+ "3 - CONTA ESPECIAL\n"
				+ "4 - CONTA EMPRESA\n"
				+ "5 - CONTA ESTUDANTIL\n"
				+ "6 - SAIR\n\n");
		
		// DIGITA O TIPO DE CONTA
		
		System.out.printf("Informe o tipo de conta: ");
		opcaoConta = ler.next().toUpperCase().charAt(0);
		
		if (opcaoConta == '1' || opcaoConta == '2' || opcaoConta == '3'
				|| opcaoConta == '4' || opcaoConta == '5') {
			
			// DIGITA O NÚMERO DA CONTA
			
			System.out.printf("Informe o número da conta: ");
			conta = ler.nextInt();
			
			// SELECIONA CONTA
			
			if (opcaoConta == '1') {
				
				System.out.printf("Informe o dia de aniversário da conta [1-31]: ");
				dia = ler.nextInt();
				
				nomeTipo += "POUPANÇA";			
				contaSelecionada = new ContaPoupanca(conta, dia);
				
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
			
			// MOSTRA DADOS DA CONTA
			
			System.out.printf("%s\n\nConta: %d\n", nomeTipo, contaSelecionada.getNumero());
			contaSelecionada.exibir();
			
			// LAÇO COM OS MOVIMENTOS DA CONTA
			
			while (opcaoContinuar != 'N' && contador < movimentos.length) {
				
				if (opcaoConta == '2') {
					
					System.out.printf("\n[%d] Informe o tipo de operação: D-débito / C-crédito / T-talão de cheque: ", (contador + 1));
					opcaoMovimento = ler.next().toUpperCase().charAt(0);
					
				} 
				else if (opcaoConta == '4' || opcaoConta == '5') {
					
					System.out.printf("\n[%d] Informe o tipo de operação: D-débito / C-crédito / E-empréstimo: ", 
							(contador + 1));
					opcaoMovimento = ler.next().toUpperCase().charAt(0);
					
				} 
				else {
					
					System.out.printf("\n[%d] Informe o tipo de operação: D-débito / C-crédito: ", (contador + 1));
					opcaoMovimento = ler.next().toUpperCase().charAt(0);
					
				}
				
				if (((opcaoMovimento != 'C' && opcaoMovimento != 'D') 
						&& (opcaoConta == '1' || opcaoConta == '3')) 
				|| ((opcaoMovimento != 'C' && opcaoMovimento != 'D' && opcaoMovimento != 'E') 
						&& (opcaoConta == '4' || opcaoConta == '5')) 
				|| ((opcaoMovimento != 'C' && opcaoMovimento != 'D' && opcaoMovimento != 'T')
						&& (opcaoConta == '2'))) {
					
					System.out.printf("\nOPÇÃO INVÁLIDA!\n");
					
				} 
				else if (opcaoMovimento == 'T') {
					
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
						
							((ContaEmpresa) contaSelecionada).pedirEmprestimo(movimentos[contador]);
							
						} 
						else if (opcaoConta == '5') {
							
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
				
				((ContaPoupanca) contaSelecionada).correcao();
				
			}
			
			// MOSTRA DADOS DA CONTA
			
			contaSelecionada.exibir();
			
		} else if (opcaoConta == '6') {
			
			System.out.printf("\nSAINDO...\n");
			
		} else {
			
			System.out.printf("\nOPÇÃO INVÁLIDA!\n");
			
		}
		
		if (opcaoConta == '5') {
			
		}
				
		System.out.printf("\nFIM DE PROGRAMA!");
		
		ler.close();
		
	}

}
