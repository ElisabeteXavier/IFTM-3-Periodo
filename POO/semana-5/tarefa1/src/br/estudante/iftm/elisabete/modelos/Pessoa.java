package br.estudante.iftm.elisabete.modelos;

import java.time.LocalDate;

public class Pessoa {
    protected String nome;
    protected String cpf;
    protected String telefone;
    protected String email;
    protected LocalDate dataNascimento;

    public Pessoa(){

    }
    public Pessoa(String nome) {
        this.nome = nome;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
