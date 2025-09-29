package br.senai.sp.jandira.ds1m.jokenpo.model;

import java.util.Scanner;
import java.util.Random;

public class JokenpoJogo {

    int escolhaDoUsuario;
    String escolhaDoComputador;


    public void obterDados() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("-----------------------------------------");
        System.out.println("            VAMOS JOGAR JOKENPÔ          ");
        System.out.println("-----------------------------------------");
        System.out.println("Escolha uma opção: ");
        System.out.println("(1) Pedra ");
        System.out.println("(2) Papel ");
        System.out.println("(3) Tesoura ");
        System.out.println("-----------------------------------------");
        System.out.println("Digite sua escolha: ");

        escolhaDoUsuario = leitor.nextInt();
        rodarJogo();
    }

    public void rodarJogo() {
        Random random = new Random();
        String[] escolhas = {"Pedra", "Papel", "Tesoura"};

        int indice = random.nextInt(escolhas.length);
        escolhaDoComputador = escolhas[indice];

        exibirResultado();
    }

    public void exibirResultado() {
        System.out.println("");
        String usuario = "";
        if (escolhaDoUsuario == 1){
            usuario = "Pedra";
        } else if (escolhaDoUsuario == 2) {
            usuario = "Papel";
        } else if (escolhaDoUsuario == 3){
            usuario = "Tesoura";
        } else {
            System.out.println("Escolha inválida!");
            obterDados();
        }

        System.out.println("Você escolheu: " + usuario);
        System.out.println("O computador escolheu: " + escolhaDoComputador);

        if (usuario == (escolhaDoComputador)) {
            System.out.println("Empate!");
        } else if (
                (usuario == ("Pedra") && escolhaDoComputador == ("Tesoura")) ||
                        (usuario == ("Papel") && escolhaDoComputador == ("Pedra")) ||
                        (usuario == ("Tesoura") && escolhaDoComputador == ("Papel"))
        ) {
            System.out.println("Você venceu!");
        } else {
            System.out.println("O computador venceu!");
        }

        reiniciarPrograma();

    }
    public void reiniciarPrograma() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Jogar novamente (S/N)? ");
        String reinicioDePrograma = leitor.nextLine();
        if (reinicioDePrograma.equals("S") || reinicioDePrograma.equals("s")){
            obterDados();
        } else {
            System.out.println("Obrigado por usar o programa!");
            System.out.println("Finalizando o programa...");
        }
    }
}
