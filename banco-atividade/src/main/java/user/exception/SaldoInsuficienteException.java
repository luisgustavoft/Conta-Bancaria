package user.exception;

public class SaldoInsuficienteException extends Exception{
  private double saldo;
  private String numConta;

  public SaldoInsuficienteException(double saldo, String numConta){
    super("Saldo Insuficiente por conta de "+saldo+" na conta "+numConta);
    this.numConta = numConta;
    this.saldo = saldo;
  }

  public SaldoInsuficienteException(){
    super();
  }

  public double getSaldo() {
    return saldo;
  }
}
