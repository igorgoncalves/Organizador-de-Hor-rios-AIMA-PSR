package aima.core.search.csp.trabalho;

import aima.core.search.csp.Assignment;
import aima.core.search.csp.Constraint;
import aima.core.search.csp.Variable;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;


/**
 * Represents a binary constraint which forbids equal values.
 * 
 * @author Ruediger Lunde
 */
public class StudyConstraint<VAR extends Variable, VAL> implements Constraint<VAR, VAL> {

	private VAR var;

	private List<VAR> scope;

	public StudyConstraint(VAR var ){
		this.var = var;
		scope = new ArrayList<>(1);
		scope.add(var);

	}

	@Override
	public List<VAR> getScope() {
		return scope;
	}

	@Override
	public boolean isSatisfiedWith(Assignment<VAR, VAL> assignment) {
		long count = 0;
		var currentValue  = assignment.getValue(var);
		if(currentValue instanceof AtividadeDefinidaDiscente){
			var variables = assignment.getVariables();
			List<VAL> values = variables.stream().map(var1 -> assignment.getValue(var1)).collect(Collectors.toList());
			for (int i = 0; i < values.size(); i++) {
				var current = values.get(i);
				if (current instanceof AtividadeDefinidaDiscente && (currentValue).equals(current)) {
					count++;
				}
			}

			return count <= ((AtividadeDefinidaDiscente) currentValue).numberBlock;
		}
		return true;

	}
}
