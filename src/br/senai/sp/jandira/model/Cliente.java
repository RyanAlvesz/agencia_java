package br.senai.sp.jandira.model;

import java.util.*;

public class Cliente {

    private String nome;

    private long cpf, rg, telefone;

    Scanner scanner = new Scanner(System.in);

    List <Cliente> listaClientes = new ArrayList<>();

    public void listarClientes(){
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente.getNome());
        }
    }

    public Cliente pesquisarCliente(long cpf){
        for (Cliente cliente : listaClientes) {
            long cpfPesquisado = cliente.getCpf();
            if (cpfPesquisado == cpf){
                return cliente;
            }
        }
        return null;
    }

    public void adicionarCliente(Cliente cliente){
        listaClientes.add(cliente);

    }

    public void setNome(String nome){

        this.nome = nome;

    }
    public String getNome(){
     return nome;
    }

    public void setCpf(long cpf){
        this.cpf = cpf;
    }

    public long getCpf(){
        return cpf;
    }

    public void setRg(long rg){
        this.rg = rg;
    }

    public long getRg(){
        return rg;
    }

    public void setTelefone(long telefone){
        this.telefone = telefone;
    }

    public long getTelefone(){
        return telefone;
    }

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
        System.out.println("");

    }

}
