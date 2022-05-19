package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

public class Principal {
  /**
   * Sistema de votação.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    GerenciamentoVotacao gerenciamento = new GerenciamentoVotacao();
    short voterOption;

    System.out.println("----------- Bem-vindo ao Sistema de Votação -----------");

    do {
      System.out.println("Cadastrar pessoa candidata?\n"
          + "1 - Sim\n"
          + "2 - Não\n"
          + "Entre com o número correspondente à opção desejada:");
      voterOption = Short.parseShort(scanner.next());
      if (voterOption == 1) {
        System.out.println("Entre com o nome da pessoa candidata:");
        String nomeCandidato = scanner.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numeroCandidato = Integer.parseInt(scanner.next());
        gerenciamento.cadastrarPessoaCandidata(nomeCandidato, numeroCandidato);
      }
    } while (voterOption != 2);

    System.out.println("----------- Cadastre as pessoas eleitoras -----------");

    do {
      System.out.println("Cadastrar pessoa eleitora?\n"
          + "1 - Sim\n"
          + "2 - Não\n"
          + "Entre com o número correspondente à opção desejada:");
      voterOption = Short.parseShort(scanner.next());

      if (voterOption == 1) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        String nomeEleitor = scanner.next();
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpfEleitor = scanner.next();
        gerenciamento.cadastrarPessoaEleitora(nomeEleitor, cpfEleitor);
      }
    } while (voterOption != 2);

    System.out.println("----------- Votação iniciada! -----------");

    do {
      System.out.println("Entre com o número correspondente à opção desejada:\n"
          + "1 - Votar\n"
          + "2 - Resultado Parcial\n"
          + "3 - Finalizar Votação");
      voterOption = Short.parseShort(scanner.next());
      if (voterOption == 1) {
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpfEleitor = scanner.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numeroCandidato = Integer.parseInt(scanner.next());
        gerenciamento.votar(cpfEleitor, numeroCandidato);
      } else if (voterOption == 2) {
        gerenciamento.mostrarResultado();
      }
    } while (voterOption != 3);
    gerenciamento.mostrarResultado();
  }
}
