package br.estudante.iftm.elisabete.modelos;

import java.util.ArrayList;

public class Turma {
    private String codigo;
    private String nome;

    private ArrayList<Aluno> alunosTurmas;

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

    public ArrayList<Aluno> getAlunosTurmas() {
        return alunosTurmas;
    }

    public Turma(){};

    public Turma(String nome, String codigo){
        this.nome = nome;
        this.codigo = codigo;
        this.alunosTurmas = new ArrayList<>();
    }
    public String toString(){
        return "TURMA{" +
                "\n nome= " + nome +
                "\n código= " + codigo +
                "}";
    }

    public String consultarAlunosTurma(){
        return "TURMA" +
                " nome= " + nome +
                " código= " + codigo +
                "\n Alunos{ " + alunosTurmas +
                "}";
    }



}
