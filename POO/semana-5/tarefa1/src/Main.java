import br.estudante.iftm.elisabete.ficharios.FicharioAluno;
import br.estudante.iftm.elisabete.ficharios.FicharioEnturmacao;
import br.estudante.iftm.elisabete.ficharios.FicharioProfessor;
import br.estudante.iftm.elisabete.ficharios.FicharioTurma;
import br.estudante.iftm.elisabete.modelos.Aluno;
import br.estudante.iftm.elisabete.modelos.Professor;
import br.estudante.iftm.elisabete.modelos.Turma;

import java.util.ArrayList;
import java.util.Scanner;
// completar os menus
// todos devem ter os metodos cadastrar, alterar, excluir, consultar e relatorio

public class Main {

    public static void menuGeral(){
        System.out.println(" === ACADEMICO === ");
        System.out.println("1 - Aluno ");
        System.out.println("2 - Professor ");
        System.out.println("3 - Turmas ");
        System.out.println("4 - Enturmações ");
        System.out.println("5 - Sair ");

    }
    public static void subMenu(int posicao ){

        String[] vet ={"Aluno","Professor","Turmas"};
        posicao-=1;

        System.out.println(" ===" + vet[posicao] +"=== ");
        System.out.println("1 - Cadastrar " + vet[posicao]);
        System.out.println("2 - Alterar " + vet[posicao]);
        System.out.println("3 - Excluir " + vet[posicao]);
        System.out.println("4 - Consultar " + vet[posicao]);
        System.out.println("5 - Relatório " + vet[posicao]);
        System.out.println("6 - Voltar ao menu principal");
        System.out.println("Opção: ");
    }

    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        ArrayList<Aluno> alunos = new ArrayList<>();
        ArrayList<Professor> professores = new ArrayList<>();
        ArrayList<Turma> turmas = new ArrayList<>();
        FicharioProfessor ficharioProfessor =  new FicharioProfessor(professores);
        FicharioTurma ficharioTurma = new FicharioTurma(turmas);
        FicharioEnturmacao ficharioEnturmacao = new FicharioEnturmacao(turmas,alunos);
        FicharioAluno ficharioAluno = new FicharioAluno(alunos,ficharioEnturmacao);



        int operacaoGeral, operacaoCadastro;
        do {
            menuGeral();

            operacaoGeral = entrada.nextInt();
            entrada.skip("\n");

            switch (operacaoGeral){
                case 1: // cadastro de aluno
                    do {

                        subMenu(operacaoGeral);
                        operacaoCadastro = entrada.nextInt();
                        entrada.skip("\n");

                        switch (operacaoCadastro) {
                            case 1:
                                ficharioAluno.cadastrar();
                                break;
                            case 2:
                                ficharioAluno.alterar();
                                break;
                            case 3:
                            ficharioAluno.excluir();
                            break;
                            case 4:
                                ficharioAluno.consultar();
                                break;
                            case 5:
                                ficharioAluno.relatorio();
                                break;
                            default:
                                if (operacaoCadastro != 6) {
                                    System.out.println("Opção inválida.");
                                }
                        }

                    } while (operacaoCadastro != 6);

                    break; // fim do case aluno

                case 2:
                    do {
                        subMenu(operacaoGeral);
                        operacaoCadastro = entrada.nextInt();
                        entrada.skip("\n");

                        switch (operacaoCadastro) {
                            case 1:
                                ficharioProfessor.cadastrar();
                                break;
                            case 2:
                                ficharioProfessor.alterar();
                                break;
                            case 3:
                                ficharioProfessor.excluir();
                                break;
                            case 4:
                                ficharioProfessor.consultar();
                                break;
                            case 5:
                                ficharioProfessor.relatorio();
                                break;
                            default:
                                if (operacaoCadastro != 6) {
                                    System.out.println("Opção inválida.");
                                }
                        }

                    } while (operacaoCadastro != 6);

                    break;

                case 3:
                    do {
                        subMenu(operacaoGeral);
                        operacaoCadastro = entrada.nextInt();
                        entrada.skip("\n");

                        switch (operacaoCadastro) {
                            case 1:
                                ficharioTurma.cadastrar();
                                break;
                            case 2:
                                ficharioTurma.alterar();
                                break;
                            case 3:
                                ficharioTurma.excluir();
                                break;
                            case 4:
                                ficharioTurma.consultar();
                                break;
                            case 5:
                                ficharioTurma.relatorio();
                                break;
                            default:
                                if (operacaoCadastro != 6) {
                                    System.out.println("Opção inválida.");
                                }
                        }

                    } while (operacaoCadastro != 6);

                    break;

                case 4:
                    do {
                        System.out.println("1 - Vincular aluno a uma Turma " );
                        System.out.println("2 - Alterar aluno de turma ");
                        System.out.println("3 - Desvincular aluno da turma " );
                        System.out.println("4 - Voltar ao menu principal " );

                        operacaoCadastro = entrada.nextInt();
                        entrada.skip("\n");

                        switch (operacaoCadastro) {
                            case 1:
                               ficharioEnturmacao.vincularAlunoTurma();
                                break;
                            case 2:
//                                ficharioEnturmacao.alteraAlunoTurma
                                break;
                            case 3:
                               ficharioEnturmacao.desvincularAlunoTurma();
                                break;

                            default:
                                if (operacaoCadastro != 4) {
                                    System.out.println("Opção inválida.");
                                }
                        }

                    } while (operacaoCadastro != 4);

                    break;

                default:
                    if (operacaoGeral != 5) {
                        System.out.println("Opção inválida.");
                    }
            }
        } while ( operacaoGeral != 5);

    }
}
