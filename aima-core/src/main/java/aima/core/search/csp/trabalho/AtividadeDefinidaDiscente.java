package aima.core.search.csp.trabalho;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AtividadeDefinidaDiscente extends Atividade {
    final int numberBlock;
    AtividadeDefinidaDiscente(String name, int numberBlock) {
        super(name);
        this.numberBlock = numberBlock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtividadeDefinidaDiscente ativ = (AtividadeDefinidaDiscente) o;
        return numberBlock == ativ.numberBlock && Objects.equals(getName(), ativ.getName());
    }
}
