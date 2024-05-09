package classes;
import java.util.Date;
import java.util.Scanner;

import enums.TipoInvestimento;


public class ContaInvestimento extends ContaCorrente {

    private TipoInvestimento tipo;
    private float saldoInvestimento;
    private float rendimentoInvestimento;
    private Date dataLimiteInvestimento;

    public ContaInvestimento() {
    }

    public ContaInvestimento(TipoInvestimento tipo, float saldoInvestimento, float rendimentoInvestimento, Date dataLimiteInvestimento, float limite, String agencia, String numConta, String proprietario, float saldo) {
        super(limite, agencia, numConta, proprietario, saldo);
        setTipo(tipo);
        setSaldoInvestimento(saldoInvestimento);
        setRendimentoInvestimento(rendimentoInvestimento);
        setDataLimiteInvestimento(dataLimiteInvestimento);
    }

    public TipoInvestimento getTipo() {
        return tipo;
    }

    public void setTipo(TipoInvestimento tipo) {
        this.tipo = tipo;
    }

    public float getSaldoInvestimento() {
        return saldoInvestimento;
    }

    public void setSaldoInvestimento(float saldoInvestimento) {
        this.saldoInvestimento = saldoInvestimento;
    }

    public float getRendimentoInvestimento() {
        return rendimentoInvestimento;
    }

    public void setRendimentoInvestimento(float rendimentoInvestimento) {
        this.rendimentoInvestimento = rendimentoInvestimento;
    }

    public Date getDataLimiteInvestimento() {
        return dataLimiteInvestimento;
    }


    public void setDataLimiteInvestimento(Date dataLimiteInvestimento) {
        this.dataLimiteInvestimento = dataLimiteInvestimento;
    }

    @Override
    public boolean depositar(float valor) {

        if (valor > 0) {
            int op;
            Scanner scan = new Scanner(System.in);

            do {
                System.out.print("Aonde você deseja fazer esse deposito? (1 - Conta, 2 - Investimento): ");
                op = scan.nextInt();
            } while (op < 1 && op > 2);
            
            switch(op){
                case 1 -> saldo += valor;
                case 2 -> saldoInvestimento += valor;
            }
            scan.close();
            return true;

        } else {
            return false;
        }

    }

    @Override
    public void imprimirExtrato() {
        super.imprimirExtrato(); 
        System.out.println("Tipo de investimento: " + tipo.getDescricao());
        System.out.println("Saldo de investimento: " + saldoInvestimento);
        System.out.println("Rendimento do  investimento: " + rendimentoInvestimento);
        System.out.println("Data limite do investimento: " + dataLimiteInvestimento);
    }
    
    

}
