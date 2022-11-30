package user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import user.exception.SaldoInsuficienteException;

public class ContaTest {

  @Test
  public void depositoContaTest(){
    ContaCorrente conta = new Poupanca("0123", "João");
    conta.deposit(500.0);
    Assertions.assertEquals(500.0, conta.getBalance());
  }

  @Test
  public void depositoContaPGTest(){
    ContaCorrente conta = new ContaPG("0123", "João");
    conta.deposit(500.0);
    Assertions.assertEquals(495.0, conta.getBalance());
  }

  @Test
  public void saqueContaTest() throws SaldoInsuficienteException {
    ContaCorrente conta = new ContaCorrente("0123", "João");
    conta.deposit(500.0);
    conta.sacar(500.0);
    Assertions.assertEquals(400.0, conta.getBalance());
  }

}
