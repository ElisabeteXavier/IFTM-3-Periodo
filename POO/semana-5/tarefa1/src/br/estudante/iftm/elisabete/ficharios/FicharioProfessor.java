package br.estudante.iftm.elisabete.ficharios;


import br.estudante.iftm.elisabete.modelos.Professor;

import java.util.ArrayList;
import java.util.Scanner;

public class FicharioProfessor {

    // para manutencao nos professores
    // deve herdar de pessoas , acrescentar String registro
    // deve ter os metodos cadastrar, alterar, excluir, consultar e relatorio
    // não permitir exclusão de professores vinculados a turmas
    private final ArrayList<Professor> professores;
    private final Scanner entrada;
    private final Scanner scInt;


    public FicharioProfessor(ArrayList<Professor> professores){
        this.professores = professores;
        entrada = new Scanner(System.in);
        scInt = new Scanner(System.in);
    }


    public Professor buscaNome(String nomeAlterado) {

        for (int j = 0; j < professores.size(); j++) {

            if (professores.get(j) != null && professores.get(j).getNome().equals(nomeAlterado)) {
                return professores.get(j);
            }
        }
        return null;
    }

    public Professor buscacpf(String cpfAlterado) {

        for (int j = 0; j < professores.size(); j++) {

            if (professores.get(j) != null && professores.get(j).getCpf().equals(cpfAlterado)) {
                return professores.get(j);
            }
        }
        return null;
    }

    public Professor buscaRegistro(int registroAlterado) {

        for (int j = 0; j < professores.size(); j++) {

            if (professores.get(j) != null && professores.get(j).getRegistro()==(registroAlterado)) {
                return professores.get(j);
            }
        }
        return null;
    }

    public Professor tiposBuscaProfessores(){
        String nome, cpf;
        int registro;
        int opcoesBusca;
        Professor professor = new Professor();

        System.out.println("1- Nome");
        System.out.println("2- CPF");
        System.out.println("3- Registro");
        opcoesBusca = scInt.nextInt();


        switch (opcoesBusca) {
            case 1 -> {
                System.out.print("Nome: ");
                nome = entrada.nextLine();
                professor = buscaNome(nome);
            }
            case 2 -> {
                System.out.print("CPF ");
                cpf = entrada.nextLine();
                professor = buscacpf(cpf);
            }
            case 3 -> {
                System.out.print("Registro: ");
                registro = scInt.nextInt();
                professor = buscaRegistro(registro);
            }
        }
        return professor;
    }

    public Professor setarProfessor(){
        String nome, telefone, cpf, email;
        int registro;
        System.out.print("Nome: ");
        nome = entrada.nextLine();
        System.out.print("Registro: ");
        registro = scInt.nextInt();
        System.out.print("Telefone: ");
        telefone = entrada.nextLine();
        System.out.print("CPF: ");
        cpf = entrada.nextLine();
        System.out.print("Email: ");
        email = entrada.nextLine();



        return new Professor(nome,registro,telefone,cpf,email);

    }


    public void cadastrar() {

            System.out.println(" === Cadastrar Professor ==== ");
            professores.add(setarProfessor());
    }

    public void alterar() {

        String nome, telefone, cpf, email;
        int registro;
        int alteracaoFeita;
        int retorno;


        System.out.println("===BUSCAR PROFESSOR A ALTERAR POR: ===");
       Professor professor = tiposBuscaProfessores();

        if(professor != null) {


            do {

                System.out.println("O que deseja alterar? ");
                System.out.println("1 - Nome do Professor ");
                System.out.println("2 - Registro do Professor ");
                System.out.println("3 - Telefone do Professor ");
                System.out.println("4 - CPF do Professor ");
                System.out.println("5 - Email do Professor ");
                alteracaoFeita = scInt.nextInt();

                switch (alteracaoFeita) {
                    case 1 -> {
                        System.out.print("Novo Nome: ");
                        nome = entrada.nextLine();
                        professor.setNome(nome);
                    }
                    case 2 -> {
                        System.out.print("Novo Registro: ");
                        registro = scInt.nextInt();
                        professor.setRegistro(registro);
                    }
                    case 3 -> {
                        System.out.print("Novo Telefone: ");
                        telefone = entrada.nextLine();
                        professor.setTelefone(telefone);
                    }
                    case 4 -> {
                        System.out.print("Novo CPF ");
                        cpf = entrada.nextLine();
                        professor.setCpf(cpf);
                    }
                    case 5 -> {
                        System.out.print("Novo Email ");
                        email = entrada.nextLine();
                        professor.setEmail(email);
                    }
                    default -> System.out.println("Operação inválida!");

                }

                System.out.println("Deseja alterar mais alguma coisa?");
                System.out.println("1- Sim");
                System.out.println("2- Não");
                retorno = scInt.nextInt();
            } while (retorno == 1);
        }else
            System.out.println("Professor não encontrado!");

    }

    public void  excluir(){

        System.out.println("===DESEJA INFORMAR O PROFESSOR A SER EXCLUÍDO POR:===");
        Professor professor = tiposBuscaProfessores();
        System.out.println("Confirma a exclusão?");
        System.out.println("1- Sim\n2-Não");
        int confirmacao = scInt.nextInt();
        if(confirmacao==1){
        professores.remove(professor);
            System.out.println("Professor excluído");
        }else System.out.println("Operação cancelada");
    }


    public void consultar(){

        System.out.println("===DESEJA INFORMAR O PROFESSOR A SER CONSULTADO POR:===");
        Professor professor = tiposBuscaProfessores();
        System.out.println(professor != null ? professor : "Cadastro nao encontrado!!");

    }

    public void relatorio() {

        System.out.println("[Relatório de PROFESSORES]");
        for (Professor professor : professores) {
            if (professor != null) {
                System.out.println(professor);
                System.out.println("---------------------");
            }

        }

    }
}
