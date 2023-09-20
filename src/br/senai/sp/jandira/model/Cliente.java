package br.senai.sp.jandira.model;

import java.util.Scanner;

public class Cliente {

    public String nome;

    public long cpf, rg, telefone;

    Scanner scanner = new Scanner(System.in);
    public void cadastrarCliente(){

        System.out.println("---------------------------------");
        System.out.println("         Cadastro Cliente");
        System.out.println("---------------------------------");
        System.out.print("Nome: ");
        nome = scanner.nextLine();
        System.out.print("CPF: ");
        cpf = scanner.nextLong();
        System.out.print("RG: ");
        rg = scanner.nextLong();
        System.out.print("Telefone: ");
        telefone = scanner.nextLong();
        scanner.nextLine();
        System.out.println("---------------------------------");

    }

}
