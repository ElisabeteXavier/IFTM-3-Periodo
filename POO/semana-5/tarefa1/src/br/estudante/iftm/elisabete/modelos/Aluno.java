package br.estudante.iftm.elisabete.modelos;

import java.time.LocalDate;

public class Aluno extends Pessoa{
    private String matricula;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


    public Aluno(){

    }

    public Aluno(String nome, String matricula, String telefone, String cpf, String email){
        this.nome = nome;
        this.matricula = matricula;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
//        this.dataNascimento = dataNascimento;
    }

    public String toString(){
        return "Aluno{" +
                "\nmatricula= " + matricula +
                "\n nome= " + nome +
                "\n cpf= " + cpf +
                "\n telefone= " + telefone +
                "\n email= " + email +
//                "\n Data de Nascimento= " + dataNascimento +
               "}";
    }

}
