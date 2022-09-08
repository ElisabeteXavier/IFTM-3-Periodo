package br.estudante.iftm.elisabete.ficharios;

import br.estudante.iftm.elisabete.modelos.Aluno;


import java.util.Scanner;

// adicionar os metodos alterar, excluir e consultar
// não permitir exclusão de alunos vinculados a turmas
public class FicharioAluno {
    private Aluno alunos[];
    private Scanner entrada;
    private  Scanner scInt;


    public FicharioAluno(Aluno alunos[]) {
        this.alunos = alunos;
        entrada = new Scanner(System.in);
       scInt = new Scanner(System.in);
    }


    public int buscaNome(String nomeAlterado) {

        for (int j = 0; j < alunos.length; j++) {

            if (alunos[j] != null && alunos[j].getNome().equals(nomeAlterado)) {
                return j;
            }
        }
       return -1;
    }

    public int buscacpf(String cpfAlterado) {

        for (int j = 0; j < alunos.length; j++) {

            if (alunos[j] != null && alunos[j].getCpf().equals(cpfAlterado)) {
                return j;
            }
        }
        return -1;
    }

    public int buscaMatricula(String matriculaAlterada) {

        for (int j = 0; j < alunos.length; j++) {

            if (alunos[j] != null && alunos[j].getMatricula().equals(matriculaAlterada)) {
                return j;
            }
        }
        return -1;
    }

    public int tiposBuscaAlunos(){
        int opcoesBusca;
        String nome, cpf, matricula;
        int retornoBusca =-1;

        System.out.println("1- Nome");
        System.out.println("2- CPF");
        System.out.println("3- Matrícula");
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
                System.out.print("Matricula: ");
                matricula = entrada.nextLine();
              retornoBusca= buscaMatricula(matricula);
                break;


        }
        return retornoBusca;
    }

    public Aluno setarAluno(){
        String nome, matricula, telefone, cpf, email;

        System.out.print("Nome: ");
        nome = entrada.nextLine();
        System.out.print("Matricula: ");
        matricula = entrada.nextLine();
        System.out.print("Telefone: ");
        telefone = entrada.nextLine();
        System.out.print("CPF: ");
        cpf = entrada.nextLine();
        System.out.print("Email: ");
        email = entrada.nextLine();


        return new Aluno(nome,matricula,telefone,cpf,email);

    }

    public void cadastrar() {

        int contador = 0;

        while (alunos[contador] != null) {
            contador++;
        }

        if (contador < 40) {
            System.out.println(" === Cadastrar ALUNO ==== ");
            Aluno aluno = setarAluno();
            alunos[contador] = aluno;
        } else {
            System.out.println("Cadastros esgotados!");
        }

    }

    public void alterar() {
        String nome, matricula, telefone, cpf, email;
        int alteracaoFeita;
        int retorno;


        System.out.println("===BUSCAR ALUNO A ALTERAR POR: ===");
       int indiceAluno= tiposBuscaAlunos();


        do {

            System.out.println("O que deseja alterar? ");
            System.out.println("1 - Nome do Aluno ");
            System.out.println("2 - Matricula do Aluno ");
            System.out.println("3 - Telefone do Aluno ");
            System.out.println("4 - CPF do Aluno ");
            System.out.println("5 - Email do Aluno ");
            alteracaoFeita = scInt.nextInt();

                    switch (alteracaoFeita) {
                        case 1 -> {
                            System.out.print("Novo Nome: ");
                            nome = entrada.nextLine();
                            alunos[indiceAluno].setNome(nome);
                        }
                        case 2 -> {
                            System.out.print("Nova Matricula: ");
                            matricula = entrada.nextLine();
                            alunos[indiceAluno].setMatricula(matricula);
                        }
                        case 3 -> {
                            System.out.print("Novo Telefone: ");
                            telefone = entrada.nextLine();
                            alunos[indiceAluno].setTelefone(telefone);
                        }
                        case 4 -> {
                            System.out.print("Novo CPF ");
                            cpf = entrada.nextLine();
                            alunos[indiceAluno].setCpf(cpf);
                        }
                        case 5 -> {
                            System.out.print("Novo Email ");
                            email = entrada.nextLine();
                            alunos[indiceAluno].setEmail(email);
                        }

                    }

            System.out.println("Deseja alterar mais alguma coisa?");
            System.out.println("1- Sim");
            System.out.println("2- Não");
            retorno = scInt.nextInt();
        } while (retorno == 1);

    }
  public void  excluir(){

      System.out.println("===DESEJA INFORMAR O ALUNO A SER EXCLUÍDO POR:===");
      int indiceAluno= tiposBuscaAlunos();
      System.out.println("Confirma a exclusão?");
      System.out.println("1- Sim\n 2-Não");
      int confirmacao = scInt.nextInt();
      if(confirmacao==1){
          alunos[indiceAluno]= null;
          System.out.println("Aluno excluído");
      }else System.out.println("Operação cancelada");

  }

  public void consultar(){

      System.out.println("===DESEJA INFORMAR O ALUNO A SER CONSULTADO POR:===");
      int indiceAluno= tiposBuscaAlunos();
      System.out.println(indiceAluno >= 0 ? alunos[indiceAluno].toString() : "Cadastro nao encontrado!!");

  }


    public void relatorio() {

        System.out.println("[Relatório de ALUNOS]");
        for (int j = 0; j < alunos.length; j++) {
            if (alunos[j] != null) {
                System.out.println(alunos[j]);
                System.out.println("---------------------");
            }

        }

    }

}
