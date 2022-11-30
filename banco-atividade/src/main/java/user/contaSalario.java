package user;

public class contaSalario extends Conta {

    private double salario;
    private String dataDePagamento;

    public contaSalario(String accountNumber, String clientName) {
        super(accountNumber, clientName);
        //TODO Auto-generated constructor stub
    }

    public void aumento(double porcentagemDoAumento){

        this.salario += (porcentagemDoAumento/100)* this.salario;



    }

    
}
