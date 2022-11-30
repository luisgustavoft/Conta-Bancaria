package user;

import user.exception.SaldoInsuficienteException;

public abstract class ContaGeral {
  protected String accountNumber;
  protected double balance;
  protected String clientName;

  public ContaGeral (String accountNumber, String clientName){
    this.accountNumber = accountNumber;
    this.balance = 0;
    this.clientName = clientName;
  }

  public abstract void deposit( double value);

  public abstract void sacar(double value) throws SaldoInsuficienteException;

  public double getBalance(){
    return this.balance;
  }

  public String getAccountNumber(){
    return this.accountNumber;
  }

}
