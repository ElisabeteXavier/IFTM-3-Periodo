package br.estudante.iftm.elisabete.modelos;

public class Professor extends Pessoa{

    private int registro;
    public Professor(){

    }
    public Professor(String nome, int registro, String telefone, String cpf, String email){
        this.nome = nome;
        this.registro = registro;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;


    }
    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public String toString(){
        return "PROFESSOR{" +
                "\nregistro= " + registro +
                "\n nome= " + nome +
                "\n cpf= " + cpf +
                "\n telefone= " + telefone +
                "\n email= " + email +
                "}";
    }


}
