package conta_bancaria;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);
        
        ContaController contas = new ContaController();
        
        int opcao, numero, agencia, tipo, aniversario;
        String titular;
        float saldo, limite;
        
        // Dados para teste
        
        ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000.00f, 100.00f);
		contas.cadastrar(cc1);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 123, 2, "Maria da Silva", 1000.00f, 12);
		contas.cadastrar(cp1);
        
        while (true) {
            System.out.println(Cores.TEXT_GREEN_BOLD + Cores.ANSI_BLACK_BACKGROUND + "============================================");
            System.out.println(Cores.TEXT_GREEN_BOLD + Cores.ANSI_BLACK_BACKGROUND + "              BEM VINDO AO                  ");
            System.out.println(Cores.TEXT_GREEN_BOLD + Cores.ANSI_BLACK_BACKGROUND + "          BANCO SANTANDER COM S             ");
            System.out.println(Cores.TEXT_GREEN_BOLD + Cores.ANSI_BLACK_BACKGROUND + "============================================" + Cores.TEXT_RESET);

            // Opções (formatadas com mesmo tamanho de linha)
            System.out.println(Cores.TEXT_BLUE_BOLD + Cores.ANSI_BLACK_BACKGROUND + String.format("%-44s", "1 - Criar Conta") + Cores.TEXT_RESET);
            System.out.println(Cores.TEXT_CYAN_BOLD + Cores.ANSI_BLACK_BACKGROUND + String.format("%-44s", "2 - Listar todas as Contas") + Cores.TEXT_RESET);
            System.out.println(Cores.TEXT_PURPLE_BOLD + Cores.ANSI_BLACK_BACKGROUND + String.format("%-44s", "3 - Buscar Conta por Numero") + Cores.TEXT_RESET);
            System.out.println(Cores.TEXT_YELLOW_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + String.format("%-44s", "4 - Atualizar Dados da Conta") + Cores.TEXT_RESET);
            System.out.println(Cores.TEXT_YELLOW_BOLD + Cores.ANSI_BLACK_BACKGROUND + String.format("%-44s", "5 - Apagar Conta") + Cores.TEXT_RESET);
            System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + String.format("%-44s", "6 - Sacar") + Cores.TEXT_RESET);
            System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + String.format("%-44s", "7 - Depositar") + Cores.TEXT_RESET);
            System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + String.format("%-44s", "8 - Transferir valores entre Contas") + Cores.TEXT_RESET);
            System.out.println(Cores.TEXT_RED_BOLD + Cores.ANSI_BLACK_BACKGROUND + String.format("%-44s", "9 - |Sair|") + Cores.TEXT_RESET);

            // Input
            System.out.println(Cores.TEXT_GREEN_BOLD + Cores.ANSI_BLACK_BACKGROUND +"********************************************");
            System.out.print(Cores.TEXT_YELLOW_BOLD + Cores.ANSI_BLACK_BACKGROUND + "Escolha uma opção:                          " + Cores.TEXT_RESET);
            opcao = scanner.nextInt();

            // Lógica de escolha
            switch (opcao) {
                case 1:
                    System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND + "Digite o número da conta: " + Cores.TEXT_RESET);
                    
                    System.out.println(Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + "Digite o número da Agência:");
                    agencia = scanner.nextInt();
                    
                    System.out.println(Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + "Digite o nome do Titular:");
                    scanner.skip("\\R");
                    titular = scanner.nextLine();
                    
                    System.out.println(Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + "Digite o tipo da conta (1 - CC | 2 - CP):");
                    tipo = scanner.nextInt();
                    
                    System.out.println(Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + "Digite o saldo inicial da conta:");
                    saldo = scanner.nextFloat();
                    
                    switch(tipo)
                    {
                    case 1 ->
                    	{
                    		System.out.println(Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + "Digite o limite da conta: ");
                    		limite = scanner.nextFloat();
                    		contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular , saldo, limite));
                    	}
                    case 2 ->
                		{
                			System.out.println(Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + "Digite o dia do aniversário da conta: ");
                			aniversario = scanner.nextInt();
                			contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular , saldo, aniversario));
                		}
                    }
                    
                    keyPress();
                    break;
                case 2:
                    System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND + ">> Listando contas: " + Cores.TEXT_RESET);
                    contas.listarTodas();
                    keyPress();
                    break;
                case 3:
                    System.out.println(Cores.TEXT_PURPLE + Cores.ANSI_BLACK_BACKGROUND + ">> Consultar dados da conta - por número:   " + Cores.TEXT_RESET);
                   
                    System.out.println(Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + "Digite o número da conta:                   ");
                    numero = scanner.nextInt();
                    
                    contas.procurarPorNumero(numero);
                    
                    keyPress();
                    break;
                case 4:
                    System.out.println(Cores.TEXT_RED + Cores.ANSI_BLACK_BACKGROUND + ">> Atualizando dados da conta..." + Cores.TEXT_RESET);
                    
                    //informar o numero da conta
                    System.out.println(Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + "Digite o número da conta:                   ");
                    numero = scanner.nextInt();
                    
                    // checar se a conta existe
                    Optional<Conta> conta = contas.buscarNaCollection(numero);
                    
                    // existe?
                    if(conta.isPresent())
                    {
                    	
                    	// atualizar os dados
                    	System.out.println(Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + "Digite o número da Agência:");
                        agencia = scanner.nextInt();
                        
                        System.out.println(Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + "Digite o nome do Titular:");
                        scanner.skip("\\R");
                        titular = scanner.nextLine();
                        
                        // recuperar o tipo da conta
                        tipo = conta.get().getTipo();
                        
                        System.out.println(Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + "Digite o novo saldo da conta:");
                        saldo = scanner.nextFloat();
                        
                        // identificar o tipo
                        switch(tipo)
                        {
                         case 1 -> // se for conta corrente
                        	{
                        		System.out.println(Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + "Digite o limite da conta: ");
                        		limite = scanner.nextFloat();
                        		contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular , saldo, limite));
                        	}
                         case 2 -> // se for conta poupança
                    		{
                    			System.out.println(Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + "Digite o dia do aniversário da conta: ");
                    			aniversario = scanner.nextInt();
                    			contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular , saldo, aniversario));
                    		}
                        }
                    	
                    }else // caso não existe a conta
                    	System.out.printf("\n Aconta número %d não existe!", numero);
                    
                    keyPress();
                    break;
                case 5:
                    System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND + ">> Apagando conta..." + Cores.TEXT_RESET);
                    System.out.println(Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND + "Digite o número da conta:                   ");
                    numero = scanner.nextInt();
                    
                    contas.deletar(numero);
                    keyPress();
                    break;
                case 6:
                    System.out.println(Cores.TEXT_BLUE + Cores.ANSI_BLACK_BACKGROUND + ">> Realizando saque..." + Cores.TEXT_RESET);
                    keyPress();
                    break;
                case 7:
                    System.out.println(Cores.TEXT_PURPLE + Cores.ANSI_BLACK_BACKGROUND + ">> Realizando depósito..." + Cores.TEXT_RESET);
                    keyPress();
                    break;
                case 8:
                    System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND + ">> Realizando transferência..." + Cores.TEXT_RESET);
                    keyPress();
                    break;
                case 9:
                	System.out.println(Cores.TEXT_GREEN_BOLD + Cores.ANSI_BLACK_BACKGROUND +"********************************************");
                    System.out.println(Cores.TEXT_YELLOW_BOLD + Cores.ANSI_BLACK_BACKGROUND + "     O Banco Santander com S agradece!      " + Cores.TEXT_RESET);
                    System.out.println(Cores.TEXT_YELLOW_BOLD + Cores.ANSI_BLACK_BACKGROUND + "              VOLTE SEMPRE!                 " + Cores.TEXT_RESET);
                    sobre();
                    scanner.close();
                    keyPress();
                    System.exit(0);
                default:
                    System.out.println(Cores.TEXT_RED_BOLD + Cores.ANSI_BLACK_BACKGROUND + "Opção incorreta!" + Cores.TEXT_RESET);
                    keyPress();
            }

            System.out.println();
        }
	}
	
			public static void sobre() {
			System.out.println(Cores.TEXT_GREEN_BOLD + Cores.ANSI_BLACK_BACKGROUND + "********************************************");
			System.out.println("Projeto Desenvolvido por:                  *");
			System.out.println("Wesley Lima - Dev                          *");
			System.out.println("github.com/Wezzlim                         *");
			System.out.println("********************************************" + Cores.TEXT_RESET);
   }
			
			public static void keyPress() {
				 
				try {
		 
					System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
					System.in.read();
		 
				} catch (IOException e) {
		 
					System.err.println("Ocorreu um erro ao tentar ler o teclado");
		 
				}
			}
		 
}
