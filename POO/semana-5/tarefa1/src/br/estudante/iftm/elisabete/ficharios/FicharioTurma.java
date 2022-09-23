package br.estudante.iftm.elisabete.ficharios;

import br.estudante.iftm.elisabete.modelos.Turma;

import java.util.ArrayList;
import java.util.Scanner;

public class FicharioTurma {
    // para manutencao nas turmas
    // deve ter os metodos cadastrar, alterar, excluir, consultar e relatorio

    private final ArrayList<Turma> turmas;
    private final Scanner entrada;

    public FicharioTurma(ArrayList<Turma> turmas) {
        this.turmas = turmas;
        entrada = new Scanner(System.in);

    }



    public Turma buscaNome(String nome) {

        for (Turma turma : turmas) {

            if (turma != null && turma.getNome().equals(nome)) {
                return turma;
            }
        }
        return null;
    }



    public Turma buscaCodigo(String codigo) {

        for (Turma turma : turmas) {

            if (turma != null && turma.getCodigo().equals(codigo)) {
                return turma;
            }
        }
        return null;
    }

    public Turma tiposBuscaTurmas(){
        int opcoesBusca;
        String nome,codigo;
        Turma retornoTurma = null;

        System.out.println("1- Nome");
        System.out.println("2- Código");
        opcoesBusca = entrada.nextInt();
        entrada.skip("\n");

        switch (opcoesBusca) {
            case 1 -> {
                System.out.print("Nome: ");
                nome = entrada.nextLine();
                retornoTurma = buscaNome(nome);
            }
            case 2 -> {
                System.out.print("Código ");
                codigo = entrada.nextLine();
                retornoTurma = buscaCodigo(codigo);

            }
        }
        return retornoTurma;
    }


    public Turma setarTurmas() {

        String nome, codigo;
        System.out.print("Nome: ");
        nome = entrada.nextLine();
        System.out.print("Código: ");
        codigo = entrada.nextLine();
        return new Turma(nome, codigo);

    }

    public void cadastrar() {

        System.out.println("===CADASTRO DA TURMA===");

        turmas.add(setarTurmas());

    }


    public void consultar() {

        System.out.println("===INFORME O CÓDIGO DA TURMA:===");
        String retornoCodigo = entrada.nextLine();
        for (Turma turma : turmas) {
            if (turma.getCodigo().equals(retornoCodigo))
                System.out.println(turma.consultarAlunosTurma());
        }


    }

    public void alterar() {
        String nome, codigo;
        int alteracaoFeita;


        System.out.println("===BUSCAR TURMA A ALTERAR POR: ===");
        Turma turma = tiposBuscaTurmas();

        if(turma != null){


            System.out.println("O que deseja alterar? ");
            System.out.println("1 - Nome da turma ");
            System.out.println("2 - Código da turma ");

            alteracaoFeita = entrada.nextInt();
            entrada.skip("\n");

            switch (alteracaoFeita) {
                case 1 -> {
                    System.out.print("Novo Nome: ");
                    nome = entrada.nextLine();
                    turma.setNome(nome);
                }
                case 2 -> {
                    System.out.print("Novo Código: ");
                    codigo = entrada.nextLine();
                    turma.setCodigo(codigo);
                }
            }
            }
        else
            System.out.println("Turma não encontrada!");
    }

    private boolean turmaVazia(Turma turma){
        return turma.getAlunosTurmas().isEmpty();
    }

    public void excluir(){

        Turma turma = tiposBuscaTurmas();
        if(turmaVazia(turma)) {
            System.out.println("Confirma a exclusão?");
            System.out.println("1- Sim\n 2-Não");
            int confirmacao = entrada.nextInt();
            entrada.skip("\n");
            if (turma != null) {
                if (confirmacao == 1) {
                    turmas.remove(turma);
                    System.out.println("Turma excluída!");
                } else System.out.println("Operação cancelada, turma não excluída!");
            } else
                System.out.println("Turma não encontrada!");
        }else System.out.println("Não foi possível excluir a turma pois ela contém alunos vinculados!");
    }


    public void relatorio() {

        System.out.println("[Relatório de TURMAS]");
        for (Turma turma : turmas) {
            if (turma != null) {
                System.out.println(turma);
                System.out.println("---------------------");
            }

        }
    }
}





