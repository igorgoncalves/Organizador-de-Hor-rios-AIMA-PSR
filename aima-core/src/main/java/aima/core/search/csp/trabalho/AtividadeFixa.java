package aima.core.search.csp.trabalho;

import java.util.ArrayList;
import java.util.List;

public class AtividadeFixa extends Atividade {
    private final ArrayList<Horario> horarios = new ArrayList<>();

    public AtividadeFixa(String name, List<Horario> horarios) {
        super(name);
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
        return super.getName();
    }

    public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios.clear();
        this.horarios.addAll(horarios);
    }


    public void setHorario(Horario horario) {
        this.horarios.add(horario);
    }
}