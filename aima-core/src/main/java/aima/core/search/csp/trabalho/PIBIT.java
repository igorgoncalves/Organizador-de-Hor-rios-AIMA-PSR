package aima.core.search.csp.trabalho;

import java.util.Objects;

class PIBIT extends  Atividade {
    final Disciplina disciplina;
    final int numberBlock;

    PIBIT(Disciplina disciplina, int numberBlock) {
        super("Study " + disciplina.getCodigo());
        this.disciplina = disciplina;
        this.numberBlock = numberBlock;
    }

    @Override
    public String toString() {
        return "Study to " + this.disciplina.getCodigo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PIBIT studyTIme = (PIBIT) o;
        return numberBlock == studyTIme.numberBlock && Objects.equals(disciplina.getCodigo(), studyTIme.disciplina.getCodigo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(disciplina, numberBlock);
    }
}
