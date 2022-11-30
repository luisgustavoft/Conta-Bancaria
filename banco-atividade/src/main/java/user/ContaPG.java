package user;

import user.exception.SaldoInsuficienteException;

public class ContaPG extends ContaCorrente {

  public ContaPG(String accountNumber, String clientName) {
    super(accountNumber, clientName);
  }

  @Override
  public void deposit( double value){
    int balance = 0;
    this.balance += (value * 0.99);
  }

  @Override
  public void sacar(double value) throws SaldoInsuficienteException {
    if (balance >= value){
      balance -= (value * 0.99);
    }else{
      throw new SaldoInsuficienteException(value, this.accountNumber);
    }
  }
}
