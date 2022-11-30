package user;

import user.exception.SaldoInsuficienteException;

public class ContaCorrente extends ContaGeral{

  //Construtor
  public ContaCorrente(String accountNumber, String clientName){
    super(accountNumber, clientName);
  }

  @Override
  public void deposit(double value) {
    this.balance += value;
  }

  @Override
  public void sacar(double value) throws SaldoInsuficienteException {
    if(this.balance >= value){
      this.balance -= value;
    }else{
      throw new SaldoInsuficienteException(value, this.accountNumber);
    }
  }

  /*public void sacar (double value){
    if (balance >= value){
      balance -= value;
    }
  }*/

}
