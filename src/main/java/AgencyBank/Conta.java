package AgencyBank;

import Utilities.Util;

public class Conta {

    private static int accountcounter = 1;
    private int accountnumber;
    private Pessoa pessoa;
    private Double saldo = 0.0;

    public Conta(Pessoa pessoa) {

        this.accountnumber = accountcounter;
        this.pessoa = pessoa;
        accountcounter += 1;

    }

    public int getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(int accountnumber) {
        this.accountnumber = accountnumber;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String toString(){

        return "\nNumero da Conta: " + this.getAccountnumber() +
               "\nNome: " + this.pessoa.getName() +
                "\nCPF: " + this.pessoa.getCpf() +
                "\nE-mail: " + this.pessoa.getEmail() +
                "\nSaldo: " + Util.doubletoString(this.getSaldo()) +
                "\n";

    }

    public void depositar(Double valor){
        if (valor > 0 ){
          setSaldo(getSaldo() + valor);
          System.out.println("Seu depósito foi realizado!");
        } else {
            System.out.println("Erro ao fazer depósito.");
        }
    }

    public void sacar(Double valor){
        if (valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Seu saque foi realizado!");
        } else {
            System.out.println("Erro ao fazer saque.");
        }
    }

    public void transferir(Conta contaParaDeposito, Double valor){
        if (valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Não foi possível realizar a transferência");
        }
    }

}
