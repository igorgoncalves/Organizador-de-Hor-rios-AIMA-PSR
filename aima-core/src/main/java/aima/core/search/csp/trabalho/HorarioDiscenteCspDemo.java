package aima.core.search.csp.trabalho;

import aima.core.search.csp.*;
import aima.core.search.csp.examples.MapCSP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Demonstrates the performance of different constraint solving strategies.
 * The map coloring problem from the textbook is used as CSP.
 * 
 * @author Ruediger Lunde
 */


public class HorarioDiscenteCspDemo {
	public static void main(String[] args) {
		CSP<Horario, Atividade> csp = (CSP) new HorariosDiscente(3);
		CspListener.StepCounter<Horario, Atividade> stepCounter = new CspListener.StepCounter<>();
		CspSolver<Horario, Atividade> solver;
		Optional<Assignment<Horario, Atividade>> solution;
		
		solver = new MinConflictsSolver<>(1000);
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Map Coloring (Minimum Conflicts)");
		solution = solver.solve(csp);
//		solution.ifPresent(System.out::println);
		solution.ifPresent(horarioAtividadeAssignment -> showSolution(horarioAtividadeAssignment));
		System.out.println(stepCounter.getResults() + "\n");
//
		solver = new FlexibleBacktrackingSolver<Horario, Atividade>().setAll();
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Map Coloring (Backtracking + MRV & DEG + LCV + AC3)");
		solution = solver.solve(csp);
		solution.ifPresent(horarioAtividadeAssignment -> showSolution(horarioAtividadeAssignment));
		System.out.println(stepCounter.getResults() + "\n");
//
		solver = new FlexibleBacktrackingSolver<Horario, Atividade>().set(CspHeuristics.mrvDeg());
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Map Coloring (Backtracking + MRV & DEG)");
		solution = solver.solve(csp);
//		solution.ifPresent(System.out::println);
		solution.ifPresent(horarioAtividadeAssignment -> showSolution(horarioAtividadeAssignment));
		System.out.println(stepCounter.getResults() + "\n");
//
		solver = new FlexibleBacktrackingSolver<>();
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		System.out.println("Map Coloring (Backtracking)");
		solution = solver.solve(csp);
//		solution.ifPresent(System.out::println);
		solution.ifPresent(horarioAtividadeAssignment -> showSolution(horarioAtividadeAssignment));
		System.out.println(stepCounter.getResults() + "\n");
	}

	public static void showSolution(Assignment<Horario, Atividade> solution){
		var variables = solution.getVariables();
		Collections.sort(variables, Horario::compareTo);
		var value = variables.stream().map(
				variable -> {
					return solution.getValue(variable).getName(); }
		).collect(Collectors.toList());
		printTable(new ArrayList<>(value));
	}

	 public static void printTable(ArrayList<String> values){
		 String[] dias = {"Seg", "Ter", "Qua", "Qui", "Sex", "Sab"};
		 String[] horas = {
				 "8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30",
				 "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30",
				 "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30",
				 "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00"
		 };

		 System.out.print("|");
		 int sizeTable = (horas.length * 14) + 100;
		 for (int i = 0; i < sizeTable; i++) {
			 System.out.print("-");
		 }
		 System.out.print("|");
		 System.out.println();
		 System.out.print("| ");
		 System.out.print("D/H");
		 System.out.print(" | ");
		 for (int i = 0; i < horas.length; i++) {
			 System.out.print(centerString(14, horas[i]));
			 System.out.print(" | ");
		 }
		 for (int i = 0; i < dias.length; i++) {
			 System.out.print("|");
			 System.out.println();
			 System.out.print("| ");
			 System.out.print(dias[i]);
			 System.out.print(" | ");
			 for (int j = 0; j < horas.length; j++) {
				 String cel = centerString(14, values.get(i * horas.length + j));
				 System.out.print(cel);
				 System.out.print(" | ");
			 }

		 }
	 }

	 public static String centerString (int width, String s) {
		return String.format("%-" + width  + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
	}
}
