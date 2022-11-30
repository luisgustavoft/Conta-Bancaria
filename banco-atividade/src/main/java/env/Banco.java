package env;

import java.util.ArrayList;
import user.*;
import user.exception.SaldoInsuficienteException;

public class Banco implements IBanco{
  private ArrayList<ContaCorrente> accounts;

  public Banco() {
    this.accounts = new ArrayList();
  }

  private boolean contaExistente(String accountNumber){
    if(getConta(accountNumber) == null){
      return false;
    }
    return true;
  }

  public void realizarDepositoEmConta(double valor, String nConta){
    ContaCorrente conta = getConta(nConta);
    if (conta != null){
      conta.deposit(valor);
    }
  }

  private ContaCorrente getConta(String nConta) {
    for(ContaCorrente conta: accounts){
      if(conta.getAccountNumber() == nConta){
        return conta;
      }
    }
    return null;
  }

  public void realizarSaqueEmConta (double valor, String nConta) {
    ContaCorrente conta = getConta(nConta);
    if (conta != null){
      try {
        conta.sacar(valor);
        //
        //
      }catch (SaldoInsuficienteException s1){
        System.out.println(s1.getMessage());
      }
    }
  }


  public void criarConta(String accountNumber, String userName){
    if (!contaExistente(accountNumber)){
      ContaCorrente conta = new ContaCorrente(accountNumber, userName);
      accounts.add(conta);
    }
  }

  private double getTotalDeSaldoBanco(){
    double saldo = 0;
    for(ContaCorrente conta: accounts){
      saldo += conta.getBalance();
    }
    return saldo;
}

  public boolean removerConta(String numeroConta){
    ContaCorrente conta = getConta(numeroConta);
    if (conta != null){
      accounts.remove(conta);
      return true;
    }
    return false;
  }

  @Override
  public double saldoTotal() {
    return this.getTotalDeSaldoBanco();
  }

  @Override
  public int numeroContas() {
    return accounts.size();
  }

  public static void main(String[] args) throws SaldoInsuficienteException {
    Banco bank = new Banco();
    bank.criarConta("1234","Geraldao");
    bank.criarConta("12345","Geraldao");
    bank.realizarSaqueEmConta(100, "12345");
    ContaPG geraldao = new ContaPG("1234","Geraldao");
    System.out.println(geraldao.getBalance());
    geraldao.deposit(10000);
    System.out.println(geraldao.getBalance());
    try {
      geraldao.sacar(15000);
    }catch (SaldoInsuficienteException s1){
      System.out.println(s1.getMessage());
      System.out.println("O saldo insuficiente foi de "+s1.getSaldo());
    }
    System.out.println(geraldao.getBalance());
  }

}
