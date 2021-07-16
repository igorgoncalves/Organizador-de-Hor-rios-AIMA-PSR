package aima.core.search.csp.trabalho;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Disciplina extends Atividade {
    private String codigo;
    private int numHorarios;
    private final ArrayList<Horario> horarios = new ArrayList<>();

    public Disciplina() {
        super("name");
    }

    public Disciplina(String codigo) {
        super(codigo);
        this.codigo = codigo;
    }

    public Disciplina(String codigo, int numHorarios) {
        super(codigo);
        this.codigo = codigo;
        this.numHorarios = numHorarios;
    }

    public Disciplina(String codigo, Horario horario) {
        super(codigo);
        this.codigo = codigo;
        this.horarios.add(horario);
        this.numHorarios = this.horarios.size();
    }

    public Disciplina(String codigo, List<Horario> horarios) {
        super(codigo);
        this.codigo = codigo;
        this.horarios.addAll(horarios);
        this.numHorarios = this.horarios.size();
    }

    public void adicionarHorario(Horario horario) {
        this.horarios.add(horario);
    }

    public void adicionarHorario(List<Horario> horario) {
        this.horarios.addAll(horario);
        this.numHorarios = this.horarios.size();
    }

    @Override
    public String toString() {
        return codigo ;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    public void setHorario(Horario horario) {
        this.horarios.add(horario);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return  Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}