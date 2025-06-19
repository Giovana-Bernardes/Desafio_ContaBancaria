import java.util.Locale;
import java.util.Scanner;

public class ContaBancaria {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useLocale(Locale.getDefault());
        String nomeCliente = "Giovana";
        String tipoDeConta = "Corrente";
        double saldo = 2500.90;
        int operacoes = 0;


        System.out.println("***********************************************");
        System.out.println("\nInformações Bancárias");
        System.out.println("\nNome do cliente: " +nomeCliente);
        System.out.println("Conta: " +tipoDeConta);
        System.out.printf("Saldo disponível: R$ %.2f%n", saldo);
        System.out.println("\n***********************************************");



        System.out.println("\n============== MENU ==============");
        String menu = """
                
                 1- Consultar saldo
                 2- Depositar valor
                 3- Transferir valor
                 4- Sair
                
                 Digite a opção desejada:
                
                """;

        while (operacoes != 4) {
            System.out.println(menu);
            operacoes = scanner.nextInt();

            switch (operacoes) {
                case 1:
                    System.out.printf("Seu saldo atual é de R$ %.2f%n", saldo);
                    break;

                case 2:
                    System.out.println("Digite o valor a ser depositado: ");
                    double deposito = scanner.nextDouble();
                    if (deposito <= 0) {
                        System.out.println("Valor inválido para depósito. Digite outro valor");
                    }else {
                        saldo += deposito;
                        System.out.printf("Depósito realizado! Novo saldo: R$  %.2f%n", saldo);
                    }
                    break;

                case 3:
                    System.out.println("Digite o valor a ser transferido: ");
                    double transferencia = scanner.nextDouble();
                    if (transferencia <= 0) {
                        System.out.println("Digite um valor válido para transferência");
                    } else if (transferencia > saldo) {
                        System.out.println("Saldo insufficient para realizar a tranferência!");
                    } else {
                        saldo -= transferencia;
                        System.out.printf("Transferência realizada! Novo saldo: R$  %.2f%n", saldo);
                    }
                    break;

                case 4:
                    System.out.println("Encerrando operações. Agradecemos por usar o nosso sistema! 🌟");
                    System.out.printf("Cliente: %s | Saldo final: R$ %.2f%n", nomeCliente, saldo);
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente!");
                    break;

            }
            System.out.println("\n***********************************************");
        }

        scanner.close();
    }
}