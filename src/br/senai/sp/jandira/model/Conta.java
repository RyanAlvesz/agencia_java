package br.senai.sp.jandira.model;

public class Conta {

   boolean avaliaSaque;
   private int numeroConta = 1234;
   private double saldo = 19.89;
   private String agencia = "000-13-XX";

   public void realizarDeposito(Double valor){
      this.saldo += valor;
      System.out.println("O saldo da conta é: " + this.saldo);
   }

   public void realizarSaque(Double valor){
      if (avaliaSaque){
         this.saldo -= valor;
      }else{
         System.out.println("Você não possui esse valor na sua conta");
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

}
