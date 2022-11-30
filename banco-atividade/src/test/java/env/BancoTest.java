package env;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BancoTest {

  @Test
  public void contasEmBancoTest(){
    Banco banco = new Banco();
    banco.criarConta("0123", "João");
    banco.criarConta("0123", "João");
    //Assertions.assertEquals(1, banco.getNumeroContas());
  }

  @Test
  public void contasEmBancoAposRemocaoTest(){
    Banco banco = new Banco();
    banco.criarConta("0123", "João");
    banco.removerConta("0123");
    //Assertions.assertEquals(0, banco.getNumeroContas());
  }

  @Test
  public void totalEmContasTest(){
    Banco banco = new Banco();
    banco.criarConta("0123", "João");
    banco.realizarDepositoEmConta(100.0, "0123");
    //banco.realizarSaqueEmConta(150.0, "0123");
    Assertions.assertEquals(100.0, banco.saldoTotal());
  }

}
