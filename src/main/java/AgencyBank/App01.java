
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

        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("\nE-mail: ");
        String email = input.next();

        Pessoa pessoa = new Pessoa(nome, cpf, email);
        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);
        System.out.println("Sua conta foi criada!");

        operacoes();

    }

    private static Conta encontrarConta(int numeroConta) {

        Conta conta = null;
        if (contasBancarias.size() > 0) {
            for (Conta c : contasBancarias) {
                if(c.getAccountnumber() == numeroConta) {
                    conta = c;
                }
            }
        }
        return conta;
    }

    public static void depositar() {

        System.out.println("Número da Conta: ");
        int numConta = input.nextInt();
        Conta conta = encontrarConta(numConta);

        if(conta != null){
            System.out.println("Valor para Deposito: ");
            double valorDepositado = input.nextDouble();
            conta.depositar(valorDepositado);
            System.out.println("Valor depositado com sucesso!");
        } else {
            System.out.println("A conta não existe");
        }
        operacoes();
    }

    public static void sacar() {

        System.out.println("Número da Conta: ");
        int numConta = input.nextInt();
        Conta conta = encontrarConta(numConta);

        if(conta != null){
            System.out.println("Valor para sacar: ");
            double valorsaque = input.nextDouble();
            conta.sacar(valorsaque);
        } else {
            System.out.println("A conta não existe");
        }
        operacoes();
    }

    public static void transferir() {

        System.out.println("Número da Conta de Origem: ");
        int numOrigem = input.nextInt();
        Conta origem = encontrarConta(numOrigem);

        if(origem != null) {
            System.out.println("Número da Conta Destino: ");
            int destino = input.nextInt();
            Conta destino2 = encontrarConta(destino);
            if(destino2 != null) {
                System.out.println("Quantia a ser Transferida: ");
                double quantidadeTransferida = input.nextDouble();
                origem.transferir(destino2, quantidadeTransferida);
            }  
        } 
        operacoes();     
    }

    public static void listarcontas() {
        if(contasBancarias.size() > 0 ){
            for(Conta conta: contasBancarias) {
                System.out.println(conta);
            }
        } else {
                System.out.println("Não há contas cadastradas!");
            }
            operacoes();
        }


}

