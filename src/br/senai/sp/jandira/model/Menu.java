package br.senai.sp.jandira.model;

import java.lang.invoke.VarHandle;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    Conta referenciaConta = new Conta();
    Cliente referenciaCliente = new Cliente();

    boolean continuar = true;

        public void executarMenu() {

        do {

        System.out.println("---------------------------------");
        System.out.println("               Menu");
        System.out.println("---------------------------------");
        System.out.println("1- Cadastrar Cliente");
        System.out.println("2- Gerar Conta");
        System.out.println("3- Consultar Saldo");
        System.out.println("4- Realizar Depósito");
        System.out.println("5- Realizar Saque");
        System.out.println("6- Cadastrar Pix");
        System.out.println("7- Consultar Pix");
        System.out.println("8- Transferência");
        System.out.println("9- Sair");
        System.out.println("---------------------------------");

        int opicaoCliente = scanner.nextInt();
        scanner.nextLine();

        System.out.println("");

            switch (opicaoCliente) {

                case 1:
                    Cliente cliente = new Cliente();
                    cliente.cadastrarCliente();
                    referenciaCliente.adicionarCliente(cliente);
                    break;

                case 2:
                    System.out.print("Informe o CPF do cliente Titular: ");
                    long cpfPesquisado = scanner.nextLong();
                    scanner.nextLine();

                    System.out.println("");

                    Cliente clienteConta = referenciaCliente.pesquisarCliente(cpfPesquisado);

                    if(clienteConta != null){
                        Conta conta = new Conta();
                        conta.gerarConta(clienteConta);
                        referenciaConta.adicionarContaLista(conta);
                        System.out.println("Conta criada com sucesso!");
                        System.out.println("");
                    } else {
                        System.out.println("Usuário não cadastrado!");
                        System.out.println("");
                    }

                    break;

                case 3:
                    System.out.print("Informe o CPF do cliente Titular: ");
                    long cpfConsulta = scanner.nextLong();
                    scanner.nextLine();

                    System.out.println("");

                    Conta contaConsulta = referenciaConta.pesquisarConta(cpfConsulta);

                    if (contaConsulta != null){
                        double saldoConta = contaConsulta.getSaldo();
                        System.out.println("O valor disponível é: " + saldoConta);
                        System.out.println("");
                    }else {
                        System.out.println("O usuário informado não possui uma conta");
                        System.out.println("");
                    }

                    break;

                case 4:
                    System.out.print("Informe o CPF do cliente Titular: ");
                    long cpfDeposito = scanner.nextLong();
                    scanner.nextLine();

                    System.out.println("");

                    Conta contaDeposito = referenciaConta.pesquisarConta(cpfDeposito);

                    if (contaDeposito != null){
                        System.out.print("Informe o valor para o depósito: ");
                        System.out.println("");
                        double valorDeposito = scanner.nextDouble();
                        scanner.nextLine();
                        contaDeposito.realizarDeposito(valorDeposito);
                    }else {
                        System.out.println("O usuário informado não possui uma conta");
                        System.out.println("");
                    }

                    break;

                case 5:
                    System.out.print("Informe o CPF do cliente Titular: ");
                    long cpfSaque = scanner.nextLong();
                    scanner.nextLine();

                    System.out.println("");

                    Conta contaSaque = referenciaConta.pesquisarConta(cpfSaque);

                    if (contaSaque != null){
                        System.out.print("Informe o valor para o saque: ");
                        double valorSaque = scanner.nextDouble();
                        scanner.nextLine();
                        contaSaque.verificarSaque(valorSaque);
                        contaSaque.realizarSaque(valorSaque);
                    }else {
                        System.out.println("O usuário informado não possui uma conta");
                        System.out.println("");
                    }

                    break;

                case 6:
                    System.out.print("Informe o CPF do cliente Titular: ");
                    long cpfPix = scanner.nextLong();
                    scanner.nextLine();

                    System.out.println("");

                    Conta contaPix = referenciaConta.pesquisarConta(cpfPix);

                    if (contaPix != null){

                        System.out.println("Qual chave você deseja adicionar?");
                        System.out.println("[1- Telefone]");
                        System.out.println("[2- CPF]");
                        int respostaPix = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("");

                        switch (respostaPix){

                            case 1:
                                contaPix.setPix(contaPix.getCliente().getTelefone());
                                break;

                            case 2:
                                contaPix.setPix(contaPix.getCliente().getCpf());
                                break;

                        }

                        System.out.println("Pix cadastrado com sucesso!");
                        System.out.println("");

                    }else {
                        System.out.println("O usuário informado não possui uma conta");
                        System.out.println("");
                    }

                    break;

                case 7:
                    System.out.print("Informe o CPF do cliente Titular: ");
                    long cpfConsultaPix = scanner.nextLong();
                    scanner.nextLine();

                    System.out.println("");

                    Conta contaConsultaPix = referenciaConta.pesquisarConta(cpfConsultaPix);;

                    if (contaConsultaPix.getPix() != 0){
                        double pix = contaConsultaPix.getPix();
                        System.out.print("O pix de " + contaConsultaPix.getCliente().getNome() + " é: ");
                        System.out.printf("%.0f %n", pix);
                        System.out.println("");
                    }else {
                        System.out.println("O usuário informado não possui um pix cadastrado");
                        System.out.println("");
                    }

                    break;

                case 8:
                    System.out.println("Informe o CPF do cliente Titular: ");
                    long cpfTransferencia = scanner.nextLong();
                    scanner.nextLine();

                    System.out.println("");

                    Conta contaRemetente = referenciaConta.pesquisarConta(cpfTransferencia);

                    if (contaRemetente != null){

                        System.out.print("Informe o CPF ou o Pix da conta que deseja transferir: ");
                        long escolhaTransferencia = scanner.nextLong();
                        scanner.nextLine();

                        System.out.println("");

                        Conta contaDestinario = null;

                        if (referenciaConta.pesquisarConta(escolhaTransferencia) != null) {

                            contaDestinario = referenciaConta.pesquisarConta(escolhaTransferencia);

                            System.out.print("Informe o valor para transferência: ");
                            double valorTransferencia = scanner.nextDouble();
                            scanner.nextLine();
                            contaRemetente.setTransferencia(valorTransferencia);
                            contaRemetente.verificarSaque(valorTransferencia);
                            contaRemetente.realizarTransferencia(contaRemetente, contaDestinario);

                        }else if (referenciaConta.pesquisarContaPix(escolhaTransferencia) != null) {

                            contaDestinario = referenciaConta.pesquisarContaPix(escolhaTransferencia);

                            System.out.print("Informe o valor para transferência: ");
                            System.out.println("");
                            double valorTransferencia = scanner.nextDouble();
                            scanner.nextLine();
                            contaRemetente.setTransferencia(valorTransferencia);
                            contaRemetente.verificarSaque(valorTransferencia);
                            contaRemetente.realizarTransferencia(contaRemetente, contaDestinario);

                        }else {
                            System.out.println("O usuário informado não possui uma conta");
                            System.out.println("");
                        }

                    }else {
                        System.out.println("O usuário informado não possui uma conta");
                        System.out.println("");
                    }

                    break;

                case 9:
                    continuar = false;
                    break;
            }

        } while (continuar);

    }
}

