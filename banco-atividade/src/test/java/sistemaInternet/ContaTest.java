package sistemaInternet;

import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import user.ContaCorrente;
import user.exception.SaldoInsuficienteException;

public class ContaTest {
  private ContaCorrente conta;

  @BeforeEach
  public void setUp(){
    this.conta = new ContaCorrente("0123", "Maria");
  }

  @After
  public void sysoutInfo(){
    System.out.println("Conta : saldo - "+conta.getBalance());
  }

  @Ignore
  public void depositoEmContaTest(){
    //Conta conta = new Conta("0123", "Maria");
    conta.deposit(100.0);
    Assert.assertEquals(100.0, conta.getBalance(), 0.0);
  }

  @Disabled
  @ParameterizedTest(name = "Entrada : {0}")
  @ValueSource(doubles = {101.0, 100.0})
  public void saqueEmContaTeste(double saque) throws SaldoInsuficienteException {
    //Conta conta = new Conta("0123", "Maria");
    conta.deposit(saque);
    conta.sacar(50.0);
    Assert.assertEquals(50.0, conta.getBalance(), 0.0);
  }

  @Disabled
  public void falhaSaqueEmContaTeste() throws SaldoInsuficienteException {
    //Conta conta = new Conta("0123", "Maria");
    conta.deposit(40.0);
    Assume.assumeTrue(conta.getBalance() >= 45.0);
    conta.sacar(45.0);
    Assert.assertEquals(40.0, conta.getBalance(), 0.0);
  }

}
