package br.estudante.iftm.elisabete.ficharios;

import br.estudante.iftm.elisabete.modelos.Aluno;
import br.estudante.iftm.elisabete.modelos.Turma;

import java.util.Scanner;

public class FicharioTurma {
    // para manutencao nas turmas
    // deve ter os metodos cadastrar, alterar, excluir, consultar e relatorio

    private Turma turmas[];

    private Aluno alunos[];
    private Scanner entrada;

    public FicharioTurma(Turma turmas[], Aluno alunos[]) {
        this.alunos = alunos;
        this.turmas = turmas;
        entrada = new Scanner(System.in);

    }


    public Turma setarTurmas() {

        String nome, codigo;
        System.out.print("Nome: ");
        nome = entrada.nextLine();
        System.out.print("Código: ");
        codigo = entrada.nextLine();
        return new Turma(nome, codigo);

    }

    public void Cadastrar() {

        System.out.println("===CADASTRO DA TURMA===");
        int contador = 0;

        while (turmas[contador] != null) {
            contador++;
        }
        Turma turma = setarTurmas();
        turmas[contador] = turma;

    }


    public void consultar() {

        System.out.println("===INFORME O CÓDIGO DA TURMA:===");
        String retornoCodigo = entrada.nextLine();
        for (int i = 0; i < turmas.length; i++) {
            if (turmas[i].getCodigo().equals(retornoCodigo))
                System.out.println(turmas[i]);
        }


    }


    public void relatorio() {

        System.out.println("[Relatório de TURMAS]");
        for (int j = 0; j < turmas.length; j++) {
            if (turmas[j] != null) {
                System.out.println(turmas[j]);
                System.out.println("---------------------");
            }

        }

    }

    public void enturmar() {

        System.out.println("Qual aluno deseja enturmar?");
        String alunoEnturmar = entrada.nextLine();
        System.out.println("Escolha uma Turma:");
        for (int j = 0; j < turmas.length; j++) {
            if (turmas[j] != null) {
                System.out.println((j + 1) + "- " + turmas[j].getNome());
                System.out.println("---------------------");
            }
        }
        System.out.println("Em qual turma ele vai?");
        int operacaoturma = entrada.nextInt();
        entrada.skip("\n");
        for (int j = 0; j < alunos.length; j++) {

            if (alunos[j].getNome().equals(alunoEnturmar)) {
                turmas[operacaoturma - 1].setAlunosTurma(alunos[j]);


            }
        }

    }

}


