package br.senai.sp.jandira.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conta {

   boolean avaliaSaque;

   private int numeroConta;

   private double saldo = 0, transferencia;

   private String agencia = "000-13-XX";

   private Cliente cliente;

   private long pix;

   List<Conta> listaConta = new ArrayList<>();

   public void adicionarContaLista(Conta conta){
      listaConta.add(conta);
   }

   public void gerarConta(Cliente cliente){
      numeroConta = (int) (Math.random()*10000);
      this.cliente = cliente;
   }

   public Conta pesquisarConta(long cpf){
      for (Conta conta : listaConta) {
         long validaCpf = conta.cliente.getCpf();
         if (validaCpf == cpf){
            return conta;
         }
      }
      return null;
   }

   public Conta pesquisarPix(long pix){
      for (Conta conta : listaConta) {
         long validaPix = conta.getPix();
         if (validaPix == pix){
            return conta;
         }
      }
      return null;
   }

   public int getNumeroConta(){
      return numeroConta;
   }

   public double getSaldo() {
      return saldo;
   }

   public double getTransferencia() {
      return transferencia;
   }

   public void setTransferencia(double transferencia) {
      this.transferencia = transferencia;
   }

   public void setSaldo(double saldo) {
      this.saldo = saldo;
   }

   public void setPix(long pix) {
      this.pix = pix;
   }

   public long getPix() {
      return pix;
   }

   public Cliente getCliente() {
      return cliente;
   }
   public void realizarDeposito(Double valor){
      this.saldo += valor;
      System.out.println("O saldo da conta é: " + this.saldo);
   }

   public void realizarSaque(Double valor){
      if (avaliaSaque){
         this.saldo -= valor;
      }else{
         System.out.println("Você não possui esse valor na sua conta");
         System.out.println("");
      }
   }

   public void consutarSaldo(){
      System.out.println("Seu saldo é: " + this.saldo);
   }

   public void verificarSaque(Double valor){
      if (valor <= this.saldo){
         avaliaSaque = true;
      } else{
         avaliaSaque = false;
      }
   }

   public void realizarTransferencia(Conta contaRemetente, Conta contaDestinatario){

      if (avaliaSaque){
         double valorTransferencia =  contaRemetente.getTransferencia();
         double saldoDestinatario = contaDestinatario.getSaldo();
         double novoSaldo = saldoDestinatario + valorTransferencia;
         contaDestinatario.setSaldo(novoSaldo);

         System.out.println("Foram transferidos " + valorTransferencia + " para a conta do titular com CPF " + contaDestinatario.cliente.getCpf());
         System.out.println("");

      }else{

         System.out.println("Você não possui esse valor para transferência");
         System.out.println("");

      }

   }

}

