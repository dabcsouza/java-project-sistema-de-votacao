package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

public class GerenciamentoVotacao {
  private final ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<>();
  private final ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<>();
  private final ArrayList<String> cpfComputado = new ArrayList<>();
  private int totalVotos = 0;

  /**
   * Cadastra pessoa candidata.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    boolean existeNumero = false;
    for (PessoaCandidata pessoasCandidata : pessoasCandidatas) {
      if (pessoasCandidata.getNumero() == numero) {
        existeNumero = true;
        break;
      }
    }
    if (existeNumero) {
      System.out.println("Número pessoa candidata já utilizado!");
    } else {
      PessoaCandidata novoCandidato = new PessoaCandidata(nome, numero);
      pessoasCandidatas.add(novoCandidato);
    }
  }

  /**
   * Cadastra Pessoa Eleitora.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    boolean existeCpf = false;
    for (PessoaEleitora pessoasEleitora : pessoasEleitoras) {
      if (pessoasEleitora.getCpf().equals(cpf)) {
        existeCpf = true;
        break;
      }
    }
    if (existeCpf) {
      System.out.println("Pessoa eleitora já cadastrada!");
    } else {
      PessoaEleitora novoEleitor = new PessoaEleitora(nome, cpf);
      pessoasEleitoras.add(novoEleitor);
    }
  }

  /**
   * Executa a votação.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (cpfComputado.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
    } else {
      for (PessoaCandidata pessoasCandidata : pessoasCandidatas) {
        if (pessoasCandidata.getNumero() == numeroPessoaCandidata) {
          pessoasCandidata.receberVoto();
          totalVotos += 1;
        }
      }
      cpfComputado.add(cpfPessoaEleitora);
      System.out.println(cpfComputado);
    }
  }

  /**
   * Mostra resultado da votação.
   */
  public void mostrarResultado() {
    if (totalVotos > 0) {
      for (int i = 0; i < pessoasCandidatas.size(); i += 1) {
        System.out.printf("Nome: %s - %d votos ( %.1f",
            pessoasCandidatas.get(i).getNome(),
            pessoasCandidatas.get(i).getVotos(),
            this.calcularPorcentagemVotos(i));
        System.out.println("% )");
      }
      System.out.println("Total de votos: " + totalVotos);
    } else {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    }
  }

  private double calcularPorcentagemVotos(int index) {
    return ((double) pessoasCandidatas.get(index).getVotos() / totalVotos) * 100;
  }
}
