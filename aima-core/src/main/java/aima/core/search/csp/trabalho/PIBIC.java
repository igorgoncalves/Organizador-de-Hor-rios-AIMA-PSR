package aima.core.search.csp.trabalho;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PIBIC extends Atividade {
    private final ArrayList<Horario> horarios = new ArrayList<>();

    public PIBIC(List<Horario> horarios) {
        super("PIBIC");
        this.horarios.addAll(horarios);
    }

    public void adicionarHorario(Horario horario) {
        this.horarios.add(horario);
    }

    public void adicionarHorario(List<Horario> horario) {
        this.horarios.addAll(horario);
    }

    @Override
    public String toString() {
        return "pibic" ;
    }

    public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    public void setHorario(Horario horario) {
        this.horarios.add(horario);
    }
}