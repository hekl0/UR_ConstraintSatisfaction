package BacktrackSearch;

import CSP.CSP;
import jdk.nashorn.internal.ir.Assignment;

import java.util.HashMap;
import java.util.List;

public abstract class BacktrackSearch<Problem extends CSP<Variable, DomainValue, Constraint>, Variable, DomainValue, Constraint> {
    public HashMap<Variable, DomainValue> BT(Problem csp) {
        HashMap<Variable, DomainValue> assignments = new HashMap<>();
        return backtrack(assignments, csp);
    }

    //return null = return failure
    public HashMap<Variable, DomainValue> backtrack(HashMap<Variable, DomainValue> assignments, Problem csp) {
        if (checkComplete(assignments, csp)) return assignments;

        Variable variable = selectUnassignedVariable(assignments, csp);
        for (DomainValue domainValue: csp.domains.get(variable))
            if (checkConsistent(variable, domainValue, csp)) {
                assignments.put(variable, domainValue);
                HashMap<Variable, DomainValue> result = backtrack(assignments, csp);
                if (result != null)
                    return result;
                assignments.remove(variable);
            }

        return null;
    }

    public abstract boolean checkComplete(HashMap<Variable, DomainValue> assignments, Problem csp);
    public abstract Variable selectUnassignedVariable(HashMap<Variable, DomainValue> assignments, Problem csp);
    public abstract boolean checkConsistent(Variable variable, DomainValue valueAssigning, HashMap<Variable, DomainValue> assignments, Problem csp);
}
