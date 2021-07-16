package aima.core.search.csp.trabalho;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Disciplina extends AtividadeFixa {
    private String codigo;
    private int numHorarios;


    public Disciplina(String codigo, List<Horario> horarios) {
        super(codigo, horarios);
        this.codigo = codigo;
        super.setHorarios(horarios);
        this.numHorarios = this.getHorarios().size();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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