package br.com.iftm.elisabete.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta {

    protected Medico medico;
    protected Paciente paciente;
    private LocalDate data;
    private LocalTime hora;

    public Consulta(Medico medico, Paciente paciente){
        this.medico = medico;
        this.paciente = paciente;
    }

}
