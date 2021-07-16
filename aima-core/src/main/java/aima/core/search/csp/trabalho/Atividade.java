package aima.core.search.csp.trabalho;

abstract class Atividade {
    final  private String name;
    Atividade(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
