package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.model.Conta;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        // Criar(instanciando) um Objeto da classe Conta
        Conta c1 = new Conta(1, 123, 1, "Wesley", 500000);
        c1.visualizar();
        
        //saque
        c1.sacar(100);
        c1.visualizar();
        
        //deposito
        c1.depositar(1000);
        c1.visualizar();
        
        // alterar a propriedade titular com o set(alterar)
        c1.setTitular("Wesley Lima");
        c1.visualizar();
        
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
                    System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND + ">> Criando conta..." + Cores.TEXT_RESET);
                    break;
                case 2:
                    System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND + ">> Listando contas..." + Cores.TEXT_RESET);
                    break;
                case 3:
                    System.out.println(Cores.TEXT_PURPLE + Cores.ANSI_BLACK_BACKGROUND + ">> Buscando conta..." + Cores.TEXT_RESET);
                    break;
                case 4:
                    System.out.println(Cores.TEXT_RED + Cores.ANSI_BLACK_BACKGROUND + ">> Atualizando dados da conta..." + Cores.TEXT_RESET);
                    break;
                case 5:
                    System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND + ">> Apagando conta..." + Cores.TEXT_RESET);
                    break;
                case 6:
                    System.out.println(Cores.TEXT_BLUE + Cores.ANSI_BLACK_BACKGROUND + ">> Realizando saque..." + Cores.TEXT_RESET);
                    break;
                case 7:
                    System.out.println(Cores.TEXT_PURPLE + Cores.ANSI_BLACK_BACKGROUND + ">> Realizando depósito..." + Cores.TEXT_RESET);
                    break;
                case 8:
                    System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND + ">> Realizando transferência..." + Cores.TEXT_RESET);
                    break;
                case 9:
                	System.out.println(Cores.TEXT_GREEN_BOLD + Cores.ANSI_BLACK_BACKGROUND +"********************************************");
                    System.out.println(Cores.TEXT_YELLOW_BOLD + Cores.ANSI_BLACK_BACKGROUND + "     O Banco Santander com S agradece!      " + Cores.TEXT_RESET);
                    System.out.println(Cores.TEXT_YELLOW_BOLD + Cores.ANSI_BLACK_BACKGROUND + "              VOLTE SEMPRE!                 " + Cores.TEXT_RESET);
                    sobre();
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println(Cores.TEXT_RED_BOLD + Cores.ANSI_BLACK_BACKGROUND + "Opção incorreta!" + Cores.TEXT_RESET);
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
}
