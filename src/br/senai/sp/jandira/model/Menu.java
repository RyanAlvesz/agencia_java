package br.senai.sp.jandira.model;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    Conta conta = new Conta();
    Cliente cliente = new Cliente();

    boolean continuar = true;

        public void executarMenu() {

        do {

        System.out.println("---------------------------------");
        System.out.println("                Menu");
        System.out.println("---------------------------------");
        System.out.println("1- Cadastrar Cliente");
        System.out.println("2- Consultar Saldo");
        System.out.println("3- Realizar Depósito");
        System.out.println("4- Realizar Saque");
        System.out.println("5- Sair");
        System.out.println("---------------------------------");

        int opicaoCliente = scanner.nextInt();
        scanner.nextLine();

            switch (opicaoCliente) {

                case 1:
                    cliente.cadastrarCliente();
                    break;

                case 2:
                    conta.consutarSaldo();
                    break;

                case 3:
                    System.out.print("Informe o valor para depósito: ");
                    double valorDepoisto = scanner.nextDouble();
                    scanner.nextLine();
                    conta.realizarDeposito(valorDepoisto);
                    break;

                case 4:
                    System.out.print("Informe o valor para saque: ");
                    double valorSaque = scanner.nextDouble();
                    scanner.nextLine();
                    conta.verificarSaque(valorSaque);
                    conta.realizarSaque(valorSaque);
                    break;

                case 5:
                    continuar = false;
                    break;
            }

        } while (continuar);

    }
}

