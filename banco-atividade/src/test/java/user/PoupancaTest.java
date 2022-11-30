package user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PoupancaTest {

  @Test
  public void depositoContaTest(){
    ContaCorrente conta = new Poupanca("0123", "João");
    conta.deposit(500.0);
    ((Poupanca) conta).renderJuros();
    Assertions.assertEquals(505.0, conta.getBalance());
  }
}
