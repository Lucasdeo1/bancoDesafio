package banco;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import classes.Conta;
import classes.ContaCorrente;
import classes.ContaInvestimento;
import classes.ContaPoupanca;
import enums.TipoInvestimento;

public class Banco {

    public static void cadastrarConta(Conta conta) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Entre com a agência bancária: ");
        String agencia = scan.nextLine();
        conta.setAgencia(agencia);

        System.out.print("Entre com o número da conta: ");
        String numConta = scan.nextLine();
        conta.setNumConta(numConta);

        System.out.print("Entre com o proprietário da conta: ");
        String proprietario = scan.nextLine();
        conta.setProprietario(proprietario);
        
        System.out.print("Entre com o saldo da conta: ");
        float saldo = scan.nextFloat();
        conta.setSaldo(saldo);
        

    }

    public static void cadastrarContaCorrente(ContaCorrente conta) {
        cadastrarConta(conta);

        Scanner scan = new Scanner(System.in);
        System.out.print("Entre com o limite da conta: ");
        float limite = scan.nextFloat();
        conta.setLimite(limite);
        
    }

    public static void cadastrarContaPoupanca(ContaPoupanca conta) {
        cadastrarConta(conta);

        Scanner scan = new Scanner(System.in);
        System.out.print("Entre com o dia de rendimento: ");
        int dia = scan.nextInt();
        conta.setDiaRendimento(dia);

        System.out.print("Entre com o rendimento da poupança: ");
        float rendimento = scan.nextFloat();
        conta.setRendimento(rendimento);
        
    }

    public static void cadastrarContaInvestimento(ContaInvestimento conta) {
        cadastrarContaCorrente(conta);

        var scan = new Scanner(System.in);

        TipoInvestimento tipo = null;
        int op;

        do {
            System.out.print("Entre com o tipo do investimento (1 - CDB, 2 - Ações, 3 - Fundo Imobiliário): ");
            op = scan.nextInt();

            if (op < 1 || op > 3) {
                System.out.println("Favor, entrar com uma opção valida!");
            }
        } while (op < 1 || op > 3);

        switch (op) {
            case 1:
                tipo = TipoInvestimento.CDB;
                break;
            case 2:
                tipo = TipoInvestimento.ACAO;
                break;
            case 3:
                tipo = TipoInvestimento.IMOBILIARIO;
                break;
        }

        conta.setTipo(tipo);

        System.out.print("Entre com o saldo do investimento: ");
        float saldoInvestimento = scan.nextFloat();
        conta.setSaldoInvestimento(saldoInvestimento);

        System.out.print("Entre com o rendimento do investimento: ");
        float rentimentoInvestimento = scan.nextFloat();
        conta.setRendimentoInvestimento(rentimentoInvestimento);

        scan = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        boolean dateOk = false;
        do {

            System.out.print("Entre com a data de retirada do investimento: ");
            String dataInvest = scan.nextLine();
            try {
                Date date = df.parse(dataInvest);
                conta.setDataLimiteInvestimento(date);
                dateOk = true;
            } catch (ParseException ex) {
                System.out.println("Favor, entrar com uma data valida!\n");
                dateOk = false;
            }

        } while (dateOk == false);
        
    }

    public static void imprimirExtrato(ArrayList<Conta> listConta) {

        Conta conta = buscarConta(listConta);
        if(conta == null){
            System.out.println("Conta não identificada! \n");
        }else{
            System.out.println("Dados da conta      \n");
            conta.imprimirExtrato();
        }
        
    }

    public static void depositarConta(ArrayList<Conta> listConta) {
        Conta conta = buscarConta(listConta);
        if(conta == null){
            System.out.println("Conta não identificada! \n");
        }else{
            Scanner scan = new Scanner(System.in);
            
            System.out.println("Deposito de conta      \n");
            System.out.print("Entre com o valor a ser depositado: ");
            float deposito = scan.nextFloat();
            
            if(conta.depositar(deposito)){
                System.out.println("Deposito efetado com sucesso!");
            }else{
                System.out.println("Não foi possível efetuar o deposito!");
            }
            
        }
        
    }

    public static void sacarConta(ArrayList<Conta> listConta) {
        Conta conta = buscarConta(listConta);
        if(conta == null){
            System.out.println("Conta não identificada! \n");
        }else{
            Scanner scan = new Scanner(System.in);
            
            System.out.println("Saque de conta      \n");
            System.out.print("Entre com o valor a ser sacado: ");
            float saque = scan.nextFloat();
            
            if(conta.sacar(saque)){
                System.out.println("Saque efetado com sucesso!");
            }else{
                System.out.println("Não foi possível efetuar o saque!");
            }
            
        }
    }

    public static void menuCadastrarConta(ArrayList<Conta> listConta) {
        Scanner scan = new Scanner(System.in);
        int op;

        do {

            do {
                System.out.println("            Cadastro de conta   \n\n");
                System.out.println("1 - Conta corrente");
                System.out.println("2 - Conta poupança");
                System.out.println("3 - Conta investimento");
                System.out.println("4 - Sair");
                System.out.print("Entre com a opção desejada: ");
                op = scan.nextInt();
                
                if (op < 1 || op > 4) {
                    System.out.println("Favor, inserir uma opção valida!\n");
                }
                
            } while (op < 1 || op > 4);

            switch (op) {
                case 1:
                    System.out.println("        Cadastrar conta corrente    \n");
                    ContaCorrente cc = new ContaCorrente();
                    cadastrarContaCorrente(cc);
                    listConta.add(cc);
                    break;
                case 2:
                    System.out.println("        Cadastrar conta poupança    \n");
                    ContaPoupanca cp = new ContaPoupanca();
                    cadastrarContaPoupanca(cp);
                    listConta.add(cp);
                    break;
                case 3:
                    System.out.println("        Cadastrar conta investimento    \n");
                    ContaInvestimento ci = new ContaInvestimento();
                    cadastrarContaInvestimento(ci);
                    listConta.add(ci);
                    break;
            }

        } while (op != 4);

    }
    
    private static Conta buscarConta(ArrayList<Conta> listConta){
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("    Buscar conta        \n");
        System.out.print("Entre com a agência: ");
        String agencia = scan.nextLine();
        
        System.out.print("Entre com o número da conta: ");
        String numConta = scan.nextLine();
        
        Conta conta = new Conta();
        conta.setAgencia(agencia);
        conta.setNumConta(numConta);
        
        int index = listConta.indexOf(conta);
        
        if(index < 0){
            return null;
        }else{
            Conta ret = listConta.get(index);
            return ret;
        }
        
    }

    public static void main(String[] args) {

        ArrayList<Conta> listConta = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        int op;

        do {
            do {
                System.out.println("            Sistema Bancário   \n\n");
                System.out.println("1 - Cadastrar conta");
                System.out.println("2 - Sacar de conta");
                System.out.println("3 - Depositar em conta");
                System.out.println("4 - Imprimir extrato");
                System.out.println("5 - Sair");
                System.out.print("Entre com a opção desejada: ");
                op = scan.nextInt();

                if (op < 1 || op > 5) {
                    System.out.println("Favor, inserir uma opção valida!\n");
                }

            } while (op < 1 || op > 5);

            switch (op) {
                case 1:
                    menuCadastrarConta(listConta);
                    break;
                case 2:
                    sacarConta(listConta);
                    break;
                case 3:
                    depositarConta(listConta);
                    break;
                case 4:
                    imprimirExtrato(listConta);
                    break;
                case 5:
                    System.err.println("Obrigado por utilizar o nosso sistema! \n");
                    break;
            }
        } while (op != 5);
        scan.close();
    }

}
