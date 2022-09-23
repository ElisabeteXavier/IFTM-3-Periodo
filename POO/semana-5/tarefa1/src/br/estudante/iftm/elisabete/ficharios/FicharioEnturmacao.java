package br.estudante.iftm.elisabete.ficharios;

import br.estudante.iftm.elisabete.modelos.Aluno;
import br.estudante.iftm.elisabete.modelos.Turma;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class FicharioEnturmacao {

    private ArrayList<Turma> turmas;
    private ArrayList<Aluno> alunos;


    private final Scanner entrada;

    public FicharioEnturmacao(ArrayList<Turma> turmas, ArrayList<Aluno> alunos) {
        this.turmas = turmas;
        this.alunos = alunos;
        entrada = new Scanner(System.in);
    }


    private Turma buscaNomeTurma(String nome) {
        for (Turma turma : turmas) {
            if (Objects.equals(turma.getNome(), nome)) {
                return turma;
            }
        }
        return null;
    }

    private Aluno buscaNomeAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (Objects.equals(aluno.getNome(), nome)) {
                return aluno;
            }
        }
        return null;

    }

    protected boolean alunoVinculadoTurma(Aluno aluno){
        for(int i=0 ;i<turmas.size();i++) {
            if (turmas.get(i).getAlunosTurmas().contains(aluno))

                return true;
        }
       return false;
    }

    protected Turma bucarTurmaAlunoVinculado(Aluno aluno){
        for(int i=0;i<turmas.size();i++){
            if (turmas.get(i).getAlunosTurmas().contains(aluno))
                return turmas.get(i);

        }
        return null;
    }




    public void vincularAlunoTurma() {


        String nomeAluno, nomeTurma;

        System.out.println(" === Cadastrar ENTURMAÇÃO === ");
        System.out.println("Nome da turma: ");
        nomeTurma = entrada.nextLine();

        System.out.println("Nome do aluno: ");
        nomeAluno = entrada.nextLine();

        Turma turma = buscaNomeTurma(nomeTurma);
        Aluno aluno = buscaNomeAluno(nomeAluno);
        if(aluno != null) {

            try {

                if (!alunoVinculadoTurma(aluno)) {
                    turma.getAlunosTurmas().add(aluno);
                    System.out.println("Aluno vinculado a turma");
                } else
                    System.out.println("Aluno ja vinculado a uma turma");

            } catch (NullPointerException e) {
                System.out.println("Turma não encontrada!"+ e.getMessage());
            }
        }else System.out.println("Aluno não encontrado!");
    }


    public void alteraAlunoTurma(){};


    public void desvincularAlunoTurma(){

        System.out.println(" ===DESVINCULAR ALUNO === ");

        System.out.println("Informe o Nome do aluno: ");
        String nomeAluno = entrada.nextLine();

        Aluno aluno = buscaNomeAluno(nomeAluno);

        if(aluno != null){

            if(alunoVinculadoTurma(aluno)){

                Turma turma = bucarTurmaAlunoVinculado(aluno);

                assert turma != null;
                System.out.println("Confirma a remoção do aluno na Turma? \n1-Sim \n2-Não");
                int confirmacao = entrada.nextInt();
                entrada.skip("\n");
                if(confirmacao==1){
                turma.getAlunosTurmas().remove(aluno);
                    System.out.println("Aluno removido da turma!");
                }else System.out.println("Exclusão cancelada!");

            }
        }else System.out.println("Aluno inexistente!");
    }



}