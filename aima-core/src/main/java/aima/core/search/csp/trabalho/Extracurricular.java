package aima.core.search.csp.trabalho;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Extracurricular extends Atividade {
    final int numberBlock;


    Extracurricular(String name,  int numberBlock) {
        super(name);
        this.numberBlock = numberBlock;
    }

    @Override
    public String toString() {
        return super.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Extracurricular studyTIme = (Extracurricular) o;
        return numberBlock == studyTIme.numberBlock && super.getName() == studyTIme.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getName(), numberBlock);
    }
}