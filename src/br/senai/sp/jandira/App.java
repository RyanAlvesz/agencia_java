package br.senai.sp.jandira;

import br.senai.sp.jandira.model.Menu;

public class App {

    public static void main(String[] args) {

        Menu menu = new Menu();
        System.out.println("---------------------------------");
        System.out.println("    BEM VINDO A AGÊNCIA SENAI");
        System.out.println("---------------------------------");
        System.out.println("");
        menu.executarMenu();

    }

}
