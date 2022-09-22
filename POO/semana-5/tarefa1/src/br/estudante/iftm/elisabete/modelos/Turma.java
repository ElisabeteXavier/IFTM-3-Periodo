package br.estudante.iftm.elisabete.modelos;

import br.estudante.iftm.elisabete.modelos.Aluno;

public class Turma {
    private String codigo;

    private String nome;
    private int indiceAlunoTurma = 0;

    private Aluno alunosTurma[];
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Aluno[] getAlunosTurma() {
        return alunosTurma;
    }

    public void setAlunosTurma(Aluno aluno) {

        alunosTurma[indiceAlunoTurma]=aluno;
        indiceAlunoTurma += 1;

    }

    // deve ter um codigo, um nome e um vetor de alunos

    public Turma(){};

    public Turma(String nome, String codigo){
        this.nome = nome;
        this.codigo = codigo;
    }
    public String toString(){
        return "TURMA{" +
                "\n nome= " + nome +
                "\n código= " + codigo +
                "}";
    }


}
