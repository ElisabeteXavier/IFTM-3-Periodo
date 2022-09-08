package br.estudante.iftm.elisabete.ficharios;


import br.estudante.iftm.elisabete.modelos.Professor;

import java.util.Scanner;

public class FicharioProfessor {

    // para manutencao nos professores
    // deve herdar de pessoas , acrescentar String registro
    // deve ter os metodos cadastrar, alterar, excluir, consultar e relatorio
    // não permitir exclusão de professores vinculados a turmas
    private Professor professores[];
    private Scanner entrada;
    private  Scanner scInt;


    public FicharioProfessor(Professor professores[]){
        this.professores = professores;
        entrada = new Scanner(System.in);
        scInt = new Scanner(System.in);
    }


    public int buscaNome(String nomeAlterado) {

        for (int j = 0; j < professores.length; j++) {

            if (professores[j] != null && professores[j].getNome().equals(nomeAlterado)) {
                return j;
            }
        }
        return -1;
    }

    public int buscacpf(String cpfAlterado) {

        for (int j = 0; j < professores.length; j++) {

            if (professores[j] != null && professores[j].getCpf().equals(cpfAlterado)) {
                return j;
            }
        }
        return -1;
    }

    public int buscaRegistro(int registroAlterado) {

        for (int j = 0; j < professores.length; j++) {

            if (professores[j] != null && professores[j].getRegistro()==(registroAlterado)) {
                return j;
            }
        }
        return -1;
    }

    public int tiposBuscaProfessores(){
        String nome, cpf;
        int registro;
        int opcoesBusca;
        int retornoBusca =-1;

        System.out.println("1- Nome");
        System.out.println("2- CPF");
        System.out.println("3- Registro");
        opcoesBusca = scInt.nextInt();


        switch (opcoesBusca){

            case 1:
                System.out.print("Nome: ");
                nome = entrada.nextLine();
                retornoBusca= buscaNome(nome);
                break;

            case 2:
                System.out.print("CPF ");
                cpf = entrada.nextLine();
                retornoBusca= buscacpf(cpf);
                break;

            case 3:
                System.out.print("Registro: ");
                registro = scInt.nextInt();
                retornoBusca= buscaRegistro(registro);
                break;


        }
        return retornoBusca;
    }

    public Professor setarProfessor(){
        String nome, telefone, cpf, email;
        int registro;
        System.out.print("Nome: ");
        nome = entrada.nextLine();
        System.out.print("Registro: ");
        registro = scInt.nextInt();
        System.out.print("Telefone: "); //modificado
        telefone = entrada.nextLine();
        System.out.print("CPF: "); //modificado
        cpf = entrada.nextLine();
        System.out.print("Email: "); //modificado
        email = entrada.nextLine();



        return new Professor(nome,registro,telefone,cpf,email);

    }


    public void cadastrar() {
        int contador = 0;

        while (professores[contador] != null) {
            contador++;
        }

        if (contador < 6) {
            System.out.println(" === Cadastrar Professor ==== ");
            Professor professor = setarProfessor();
            professores[contador] = professor;

        } else {
            System.out.println("Cadastros esgotados!");
        }

    }

    public void alterar() {

        String nome, telefone, cpf, email;
        int registro;
        int alteracaoFeita;
        int retorno;


        System.out.println("===BUSCAR PROFESSOR A ALTERAR POR: ===");
        int indiceProfessor= tiposBuscaProfessores();


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
                    professores[indiceProfessor].setNome(nome);
                }
                case 2 -> {
                    System.out.print("Novo Registro: ");
                    registro = scInt.nextInt();
                    professores[indiceProfessor].setRegistro(registro);
                }
                case 3 -> {
                    System.out.print("Novo Telefone: ");
                    telefone = entrada.nextLine();
                    professores[indiceProfessor].setTelefone(telefone);
                }
                case 4 -> {
                    System.out.print("Novo CPF ");
                    cpf = entrada.nextLine();
                    professores[indiceProfessor].setCpf(cpf);
                }
                case 5 -> {
                    System.out.print("Novo Email ");
                    email = entrada.nextLine();
                    professores[indiceProfessor].setEmail(email);
                }
                default -> System.out.println("Operação inválida!");

            }

            System.out.println("Deseja alterar mais alguma coisa?");
            System.out.println("1- Sim");
            System.out.println("2- Não");
            retorno = scInt.nextInt();
        } while (retorno == 1);

    }

    public void  excluir(){

        System.out.println("===DESEJA INFORMAR O PROFESSOR A SER EXCLUÍDO POR:===");
        int indiceProfessor= tiposBuscaProfessores();
        System.out.println("Confirma a exclusão?");
        System.out.println("1- Sim\n2-Não");
        int confirmacao = scInt.nextInt();
        if(confirmacao==1){
        professores[indiceProfessor]= null;
            System.out.println("Professor excluído");
        }else System.out.println("Operação cancelada");
    }


    public void consultar(){

        System.out.println("===DESEJA INFORMAR O PROFESSOR A SER CONSULTADO POR:===");
        int indiceProfessor= tiposBuscaProfessores();
        System.out.println(indiceProfessor >= 0 ? professores[indiceProfessor].toString() : "Cadastro nao encontrado!!");

    }

    public void relatorio() {

        System.out.println("[Relatório de PROFESSORES]");
        for (int j = 0; j < professores.length; j++) {
            if (professores[j] != null) {
                System.out.println(professores[j]);
                System.out.println("---------------------");
            }

        }

    }
}
