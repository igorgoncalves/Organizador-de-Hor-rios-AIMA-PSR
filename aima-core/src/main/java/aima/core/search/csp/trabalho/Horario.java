package aima.core.search.csp.trabalho;

import aima.core.search.csp.Variable;

import java.util.ArrayList;
import java.util.Arrays;

public class Horario extends Variable implements Comparable< Horario > {
    private String dia;
    private String hora;

    public Horario(String dia, String hora) {
        super(dia + " " + hora);
        this.dia = dia;
        this.hora = hora;
    }

    public String getDia() {
        return this.dia;
    }

    public String getHora() {
        return this.hora;
    }

    @Override
    public String toString() {
        return "\nHorario{" +
                "dia='" + dia + '\'' +
                ", hora='" + hora + '\'' +
                '}';
    }

    @Override
    public int compareTo(Horario o) {
        ArrayList<String> diasList = new ArrayList<String>(Arrays.asList("Seg", "Ter", "Qua", "Qui", "Sex", "Sab"));
        var compare = Integer.compare(diasList.indexOf(this.dia), diasList.indexOf(o.dia)) ;
        if(compare == 0){
            compare = this.hora.compareTo(o.hora) * -1;
        }

        return compare;
    }


}
