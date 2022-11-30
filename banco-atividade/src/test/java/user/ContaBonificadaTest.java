package user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaBonificadaTest {

  @Test
  public void renderBonusTest(){
    ContaBonificada conta = new ContaBonificada("123", "João");
    conta.deposit(100);
    conta.renderBonus();
    Assertions.assertEquals(101, conta.getBalance());
  }

  @Test
  public void zerarBonusAposRenderBonusTest(){
    ContaBonificada conta = new ContaBonificada("123", "João");
    conta.deposit(100);
    conta.renderBonus();
    Assertions.assertEquals(0.0, conta.getBonus());
  }

}
