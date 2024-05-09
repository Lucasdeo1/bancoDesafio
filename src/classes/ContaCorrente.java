package classes;


public class ContaCorrente extends Conta {

    private float limite;

    public ContaCorrente() {
    }

    public ContaCorrente(float limite, String agencia, String numConta, String proprietario, float saldo) {
        super(agencia, numConta, proprietario, saldo);
        setLimite(limite);
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = (limite >= 0 ? limite : 0);
    }

    @Override
    public boolean sacar(float valor) {
        if ((saldo + limite) >= valor && valor > 0) {
            saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void imprimirExtrato() {
        super.imprimirExtrato();
        System.out.println("Limite: " + limite);
    }

}
