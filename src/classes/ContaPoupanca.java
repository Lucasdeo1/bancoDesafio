package classes;

public class ContaPoupanca extends Conta{
    
    private float rendimento;
    private int diaRendimento;

    public ContaPoupanca() {
    }

    public ContaPoupanca(float rendimento, int diaRendimento, String agencia, String numConta, String proprietario, float saldo) {
        super(agencia, numConta, proprietario, saldo);
        setRendimento(rendimento);
        setDiaRendimento(diaRendimento);
    }

    public float getRendimento() {
        return rendimento;
    }

    public void setRendimento(float rendimento) {
        this.rendimento = (rendimento > 0 ? rendimento : .01f);
    }

    public int getDiaRendimento() {
        return diaRendimento;
    }

    public void setDiaRendimento(int diaRendimento) {
        this.diaRendimento = (diaRendimento >= 1 && diaRendimento <= 31 ? diaRendimento : 1);
    }

    @Override
    public void imprimirExtrato() {
        super.imprimirExtrato(); 
        System.out.println("Rendimento: " + rendimento);
        System.out.println("Dia do rendimento: " + diaRendimento);
    }
    
    
    
}
