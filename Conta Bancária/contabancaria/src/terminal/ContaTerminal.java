package terminal;

import java.util.Scanner;

import conta.Conta;

public class ContaTerminal {

    public static void main(String[] args) throws Exception {

        Scanner leitor = new Scanner(System.in);

        Conta conta = null;
        while(true) {
            System.out.print("Por favor, digite o ID, o número, da conta: ");
            int id = Integer.parseInt(leitor.nextLine());

            System.out.print("Por favor, digite a agência da conta, no formato XXX-X: ");
            String agencia = leitor.nextLine();

            System.out.print("Por favor, digite o nome do cliente, titular da conta: ");
            String nome_titular = leitor.nextLine();

            try {
                conta = new Conta(id, nome_titular, agencia);
                break;
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Por favor, digite o saldo inicial da conta: ");
        double saldo = Double.parseDouble(leitor.nextLine());
        conta.setSaldo(saldo);

        System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência\n" +
                        "é %s, conta %d, e seu saldo R$ %.2f já está disponível\n" +
                        "para saque.", conta.getNomeTitular(), conta.getAgencia(), conta.getId(), conta.getSaldo());

        leitor.close();
    }
}
