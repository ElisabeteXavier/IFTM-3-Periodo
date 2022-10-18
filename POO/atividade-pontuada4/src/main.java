import br.com.iftm.elisabete.fichario.FicharioConsulta;
import br.com.iftm.elisabete.fichario.FicharioMedico;
import br.com.iftm.elisabete.fichario.FicharioPaciente;
import br.com.iftm.elisabete.modelo.Consulta;
import br.com.iftm.elisabete.modelo.Medico;
import br.com.iftm.elisabete.modelo.Paciente;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void menuGeral() {
        System.out.println(" === SISTEMA DE CONSULTAS === ");
        System.out.println("1 - Paciente ");
        System.out.println("2 - Medico ");
        System.out.println("3 - Consultas ");
        System.out.println("4 - Sair ");

    }
    public static void submenuGeral() {
        System.out.println(" === === ");
        System.out.println("1 - Cadastrar ");
        System.out.println("2 - Alterar ");
        System.out.println("3 - Excluir ");
        System.out.println("4 - Consultar ");
        System.out.println("5 - Relatório ");
        System.out.println("6 - Sair ");

    }

    public enum EnumOperacaoCRUD {Cadastrar, Alterar, Excluir, Consultar, Relatorio}

    public enum EnumOperacaoGeral {Paciente, Medico, Consulta}

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Paciente> pacientes = new ArrayList<>();
        ArrayList<Medico> medicos = new ArrayList<>();
        ArrayList<Consulta> consultas = new ArrayList<>();
        FicharioPaciente ficharioPaciente = new FicharioPaciente();
        FicharioMedico ficharioMedico = new FicharioMedico();
        FicharioConsulta ficharioConsulta = new FicharioConsulta();


        int operacaoGeral, operacaoCRUD;
        do {
            menuGeral();
            operacaoGeral = entrada.nextInt();

            EnumOperacaoGeral enumOperacaoGeral = EnumOperacaoGeral.values()[operacaoGeral - 1];

            switch (enumOperacaoGeral) {

                case Paciente ->{
                    submenuGeral();
                    operacaoCRUD = entrada.nextInt();
                    EnumOperacaoCRUD enumOperacaoCRUD = EnumOperacaoCRUD.values()[operacaoCRUD-1];

                    switch (enumOperacaoCRUD){

                        case Cadastrar -> {
                            System.out.println("poo");

                        }
                        case Alterar -> {}
                        case Excluir -> {}
                        case Consultar -> {}
                        case Relatorio -> {}
                        default -> {}

                    }
                } case Medico -> {

                    submenuGeral();
                    operacaoCRUD = entrada.nextInt();
                    EnumOperacaoCRUD enumOperacaoCRUD = EnumOperacaoCRUD.values()[operacaoCRUD - 1];

                    switch (enumOperacaoCRUD){

                        case Cadastrar -> {}
                        case Alterar -> {}
                        case Excluir -> {}
                        case Consultar -> {}
                        case Relatorio -> {}
                        default -> {}

                    }
                }
                case Consulta ->{

                    submenuGeral();
                    operacaoCRUD = entrada.nextInt();
                    EnumOperacaoCRUD enumOperacaoCRUD = EnumOperacaoCRUD.values()[operacaoCRUD-1];

                    switch (enumOperacaoCRUD){

                        case Cadastrar -> {
                            System.out.println();
                        }
                        case Alterar -> {}
                        case Excluir -> {}
                        case Consultar -> {
                            System.out.println("hello");
                        }
                        case Relatorio -> {}
                        default -> {
                        }

                    }
                }
                default -> {
                if(operacaoGeral!=4){
                    System.out.println("operação inválida");
                }

                }


            }

        } while (operacaoGeral != 4);
    }
}