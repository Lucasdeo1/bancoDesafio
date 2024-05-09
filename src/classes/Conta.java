package classes;
import java.util.Objects;

import interfaces.InterfaceConta;

public class Conta implements InterfaceConta {
    
    private String agencia;
    private String numConta;
    private String proprietario;
    protected float saldo;

    public Conta() {
    }

    public Conta(String agencia, String numConta, String proprietario, float saldo) {
        super();
        setAgencia(agencia);
        setNumConta(numConta);
        setProprietario(proprietario);
        setSaldo(saldo);
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

   
    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = (saldo >= 0 ? saldo : 0);
    }

    @Override
    public boolean sacar(float valor) {
        if(saldo >= valor && valor > 0){
            saldo -= valor;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean depositar(float valor) {
        if(valor > 0){
            saldo += valor;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Dados da conta \n");
        System.out.println("Agencia: " + agencia);
        System.out.println("Número da conta: " + numConta);
        System.out.println("Proprietário: "+ proprietario);
        System.out.println("Saldo: " + saldo);
    }

    @Override
    public boolean equals(Object obj) {
        //return ((Conta) obj).getAgencia().equalsIgnoreCase(agencia) && ((Conta)obj).getNumConta().equalsIgnoreCase(numConta); 
        return ((Conta) obj).hashCode() == hashCode();
    
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.agencia);
        hash = 89 * hash + Objects.hashCode(this.numConta);
        return hash;
    }

    
}