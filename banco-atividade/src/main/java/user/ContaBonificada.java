package user;

public class ContaBonificada extends ContaCorrente {
  private double bonus;

  public ContaBonificada(String accountNumber, String clientName) {
    super(accountNumber, clientName);
  }

  @Override
  public void deposit(double value){
    super.deposit(value);
    this.bonus += (value * 0.01);
  }

  public void renderBonus(){
    this.balance += bonus;
    this.bonus = 0;
  }

  public double getBonus() {
    return this.bonus;
  }
}
