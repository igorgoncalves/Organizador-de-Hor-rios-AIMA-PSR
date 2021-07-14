package aima.core.search.csp.trabalho;

import aima.core.search.csp.CSP;
import aima.core.search.csp.Domain;
import aima.core.search.csp.Variable;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um Problema de Satisfação de Restrições (PSR, ou Constraint Satisfaction Problem, CSP).
 *
 * Um CSP é composto por três conjuntos: O conjunto X, de variáveis, o conjunto D, de domínio e
 * o conjunto C de restrições.
 *
 * Neste problema, o conjunto X é formado pelos blocos de horários (em dia e hora), D é formado
 * pelas atividades acadêmicas e C diz que duas disciplinas não podem ser alocadas no mesmo
 * horário, que nada pode ser marcado antes das 8h (considerando o horário para café da manhã),
 * nem das 12 às 13h, nem das 18h às 19h. PIBIC, PIBITI e PIBIEX serão realizados durante as
 * manhãs e são atividades mutuamente excludentes. Estágio e trabalho também devem ser realizados
 * durante a manhã e também são mutuamente excludentes.
 *
 * O programa deve ter como entrada quantas disciplinas o discente está cursando, quais as atividades
 * extra curriculares e quantos blocos o discente quer dedicar ao estudo dessas disciplinas.
 *
 * O programa terá como saída esses blocos organizados em horários, junto com as atividades extra
 * curriculares.
 *
 * O programa deve resolver 3 casos:
 * 1. O discente está fazendo 3 disciplinas
 * 2. O discente está fazendo 5 disciplinas
 * 3. O discente está fazendo 8 disciplinas
 *
 * Para cada caso, são opcionais as tarefas extra curriculares.
 *
 * Conjunto X (variáveis): horários
 * Conjunto D (domínio): disciplinas e atividades
 */
public class HorariosDiscente extends CSP<Variable, String> {
    // horarios é o conjunto de variáveis
    private final ArrayList<Horario> horarios = new ArrayList<>();
    // materias é o domínio, o conjunto de valores que horarios podem assumir
    private Domain<Disciplina> materias;

    /**
     *
     * @param numDisciplinas o número de disciplinas que o discente está cursando.
     */
    public HorariosDiscente(int numDisciplinas) {
        // Os vetores dias e horas são usados apenas para a construção da tabela de horários,
        // que é o que será efetivamente utilizado no programa.
        String[] dias = {"Seg", "Ter", "Qua", "Qui", "Sex", "Sab"};
        String[] horas = {
                "8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30",
                "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30",
                "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30",
                "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00"
        };
        // Representa uma variável x do domínio X de variáveis
        // Um horário é composto por dia e hora
        Horario horario;

        /* O vetor horas tem 32 elementos, 32 blocos de horário por dia, sendo 8 do turno
        da manhã (das 8h às 12h), 10 do turno da tarde (13h às 18h) e 9 do turno da noite
        (das 19h às 23h). Portanto, os índices em formato {dia: [manhã, tarde, noite]} são:

        Seg: [0 a 9, 10 a 21, 22 a 31]
        Ter: [31 a 40, 41 a 52, 53 a 62]
        Qua: [62 a 71, 72 a 83, 84 a 93]
        Qui: [93 a 102, 103 a 114, 115 a 124]
        Sex: [124 a 133, 134 a 145, 146 a 155]
        Sab: [155 a 164, 165 a 176, 177 a 186]
         */
        for (String dia : dias) {
            for (String hora : horas) {
                horario = new Horario(dia + " " + hora);
                addVariable(horario);
                horarios.add(horario);
            }
        }

        // Representa o conjunto D (domínio)
        ArrayList<Disciplina> materias = new ArrayList<>();

        switch (numDisciplinas) {
            // Caso de 3 disciplinas
            case 3 -> {
                Disciplina comp0408 = new Disciplina("COMP0408", horarios.subList(26, 31));
                comp0408.adicionarHorario(horarios.subList(88, 93));
                Disciplina comp0455 = new Disciplina("COMP0455", horarios.subList(45, 50));
                comp0455.adicionarHorario(horarios.subList(109, 114));
                Disciplina comp0481 = new Disciplina("COMP0481", horarios.subList(115, 120));
                materias.add(comp0408);
                materias.add(comp0455);
                materias.add(comp0481);

                this.materias = new Domain<>(materias);
            }
            // Caso de 5 disciplinas
            case 5 -> {
                Disciplina comp409 = new Disciplina("COMP0409", horarios.subList(10, 15));
                comp409.adicionarHorario(horarios.subList(72, 77));
                Disciplina comp04085 = new Disciplina("COMP0408", horarios.subList(18, 23));
                comp04085.adicionarHorario(horarios.subList(80, 85));
                Disciplina comp0461 = new Disciplina("COMP0461", horarios.subList(24, 29));
                comp0461.adicionarHorario(horarios.subList(86, 91));
                Disciplina comp0412 = new Disciplina("COMP0412", horarios.subList(45, 50));
                comp0412.adicionarHorario(horarios.subList(107, 112));
                Disciplina comp0438 = new Disciplina("COMP0438", horarios.subList(134, 143));
                materias.add(comp409);
                materias.add(comp04085);
                materias.add(comp0461);
                materias.add(comp0412);
                materias.add(comp0438);

                this.materias = new Domain<>(materias);
            }
            // Caso de 8 disciplinas
            case 8 -> {
                Disciplina elet0043 = new Disciplina("ELET0043", horarios.subList(10, 15));
                Disciplina estat0011 = new Disciplina("ESTAT0011", horarios.subList(14, 19));
                estat0011.adicionarHorario(horarios.subList(76, 81));
                Disciplina comp0415 = new Disciplina("COMP0415", horarios.subList(18, 23));
                comp0415.adicionarHorario(horarios.subList(80, 85));
                Disciplina mat0096 = new Disciplina("MAT0096", horarios.subList(41, 46));
                mat0096.adicionarHorario(horarios.subList(103, 108));
                Disciplina comp0409 = new Disciplina("COMP0409", horarios.subList(45, 50));
                comp0409.adicionarHorario(horarios.subList(107, 112));
                Disciplina comp04121 = new Disciplina("COMP0412", horarios.subList(49, 54));
                comp04121.adicionarHorario(horarios.subList(111, 116));
                Disciplina mat0154 = new Disciplina("MAT0154", horarios.subList(72, 77));
                mat0154.adicionarHorario(horarios.subList(134, 139));
                Disciplina comp0417 = new Disciplina("COMP0417", horarios.subList(142, 147));
                materias.add(elet0043);
                materias.add(estat0011);
                materias.add(comp0415);
                materias.add(mat0096);
                materias.add(comp0409);
                materias.add(comp04121);
                materias.add(mat0154);
                materias.add(comp0417);

                this.materias = new Domain<>(materias);
            }
            default -> throw new IllegalArgumentException(
                    "Número de disciplinas inválido. Você deve escolher entre 3, 5 ou 8 disciplinas!"
            );
        }
    }

    /**
     *
     * @param numDisciplinas o número de disciplinas que o discente está cursando.
     * @param atividadesExtra as atividades extracurriculares do discente.
     */
    public HorariosDiscente(int numDisciplinas, ArrayList<Disciplina> atividadesExtra) {
        this(numDisciplinas);

        // copiamos os valores já presentes no domínio. Ou seja, as disciplinas obrigatórias
        List<Disciplina> dominioAtual =  this.materias.asList();
        ArrayList<Disciplina> atividadesEMaterias = new ArrayList<>();
        ArrayList<String> codigosAtividadesExtra = new ArrayList<>();

        atividadesEMaterias.addAll(dominioAtual);

        // verificamos se há alguma inconsistência do tipo o aluno faz PIBIC e PIBITI ou estágio e trabalho
        for (Disciplina disciplina : atividadesExtra) {
            codigosAtividadesExtra.add(disciplina.getCodigo());
        }

        // Caso exista inconsistência de duas ou mais atividades de iniciação
        if (
                (codigosAtividadesExtra.contains("PIBIC") && codigosAtividadesExtra.contains("PIBITI"))
                || (codigosAtividadesExtra.contains("PIBIC") && codigosAtividadesExtra.contains("PIBIEX"))
                || (codigosAtividadesExtra.contains("PIBITI") && codigosAtividadesExtra.contains("PIBIEX"))
        ) { System.out.println("Não são permitidas duas ou mais atividades de iniciação"); }
        // Caso haja inconsistência de estágio e trabalho
        if (codigosAtividadesExtra.contains("Estágio") && codigosAtividadesExtra.contains("Trabalho")) {
            System.out.println("Não é permitido fazer estágio e trabalho");
        }
        // Caso contrário essa lista de atividades junto com as matérias obrigatórias será o domínio
        else {
            atividadesEMaterias.addAll(atividadesExtra);
            this.materias = new Domain<>(atividadesEMaterias);
        }
    }

    public void definirAtividadeENumDeBlocos(Disciplina atividade, int numBlocos) {
        // TODO: Implementar a lógica para lidar com os pares (atividade, numDeBlocos)
    }

    public static void main(String[] args) {
        ArrayList<Disciplina> atividadesExtra = new ArrayList<>();
        Disciplina pibic = new Disciplina("PIBIC");
        Disciplina pibiti = new Disciplina("PIBITI");
        Disciplina estagio = new Disciplina("Estágio");
        Disciplina trabalho = new Disciplina("Trabalho");

        atividadesExtra.add(pibic);
        // atividadesExtra.add(pibiti);
        atividadesExtra.add(estagio);
        // atividadesExtra.add(trabalho);

        HorariosDiscente horariosDiscente = new HorariosDiscente(8, atividadesExtra);
        System.out.println("Variáveis: " + horariosDiscente.getVariables());
    }
}