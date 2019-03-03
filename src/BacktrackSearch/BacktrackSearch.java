package BacktrackSearch;

import CSP.CSP;

import java.util.HashMap;

public abstract class BacktrackSearch<Problem extends CSP<Variable, DomainValue, Constraint>, Variable, DomainValue, Constraint> {
    /**
     * The general implementation for Back Track Search
     **/

    //Return the Assignment for Problem if possible
    public HashMap<Variable, DomainValue> BT(Problem csp) {
        HashMap<Variable, DomainValue> assignments = new HashMap<>();
        return backtrack(assignments, csp);
    }

    //return null = return failure
    public HashMap<Variable, DomainValue> backtrack(HashMap<Variable, DomainValue> assignments, Problem csp) {
        if (checkComplete(assignments, csp)) return assignments;

        Variable variable = selectUnassignedVariable(assignments, csp);
        for (DomainValue domainValue: csp.domains.get(variable))
            if (checkConsistent(variable, domainValue, assignments, csp)) {
                assignments.put(variable, domainValue);
                HashMap<Variable, DomainValue> result = backtrack(assignments, csp);
                if (result != null)
                    return result;
                assignments.remove(variable);
            }

        return null;
    }

    //check if the assignment have completed
    public abstract boolean checkComplete(HashMap<Variable, DomainValue> assignments, Problem csp);

    //select the Unassigned Variable
    public abstract Variable selectUnassignedVariable(HashMap<Variable, DomainValue> assignments, Problem csp);

    //check the Constraints to see if the Assignment satisfies
    public abstract boolean checkConsistent(Variable variable, DomainValue valueAssigning, HashMap<Variable, DomainValue> assignments, Problem csp);
}
