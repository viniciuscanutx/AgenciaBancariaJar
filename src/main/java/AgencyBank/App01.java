
package AgencyBank;

import java.util.ArrayList;
import java.util.Scanner;

public class App01 {
     static Scanner input = new Scanner(System.in);
     static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes() {

        System.out.println("\n\n");
        System.out.println("Bem-vindo a agência!");
        System.out.println("\n");
        System.out.println("Selecione a operação que deseja fazer: ");
        System.out.println("1 - Criar Conta");
        System.out.println("2 - Depositar");
        System.out.println("3 - Sacar");
        System.out.println("4 - Transferir");
        System.out.println("5 - Listar");
        System.out.println("6 - Sair");
        System.out.println("\n");

        int operacao = input.nextInt();

        switch(operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarcontas();
                break;
            case 6:
                System.out.println("Obrigado por ultilizar a agência!");
                System.exit(0);
            default:
                System.out.println("Opção Inválida!");
                operacoes();

        }

    }

    public static void criarConta() {

    }

    public static void depositar() {

    }

    public static void sacar() {

    }

    public static void transferir() {

    }

    public static void listarcontas() {

    }

}
