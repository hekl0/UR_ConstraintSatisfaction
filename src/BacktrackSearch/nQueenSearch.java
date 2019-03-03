package BacktrackSearch;

import CSP.nQueenCSP;
import Constraint.nQueenConstraint;
import DomainValue.nQueenValue;
import Variable.nQueenVariable;

import java.util.HashMap;

public class nQueenSearch extends BacktrackSearch<nQueenCSP, nQueenVariable, nQueenValue, nQueenConstraint> {
    @Override
    public boolean checkComplete(HashMap<nQueenVariable, nQueenValue> assignments, nQueenCSP csp) {
        return (assignments.size() == csp.variables.size());
    }

    @Override
    public nQueenVariable selectUnassignedVariable(HashMap<nQueenVariable, nQueenValue> assignments, nQueenCSP csp) {
        for (nQueenVariable variable : csp.variables)
            if (!assignments.containsKey(variable))
                return variable;
        return null;
    }

    @Override
    public boolean checkConsistent(nQueenVariable nQueenVariable, nQueenValue valueAssigning, HashMap<nQueenVariable, nQueenValue> assignments, nQueenCSP csp) {
        for (nQueenConstraint constraint : csp.constraints) {
            int col1 = nQueenVariable.index;
            int row1 = valueAssigning.row;
            if (constraint.q1 == nQueenVariable) {
                if (assignments.get(constraint.q2) == null) continue;
                else {
                    int col2 = constraint.q2.index;
                    int row2 = assignments.get(constraint.q2).row;
                    if (checkAttacking(col1, row1, col2, row2)) return false;
                }
            } else if (constraint.q2 == nQueenVariable) {
                if (assignments.get(constraint.q1) == null) continue;
                else {
                    int col2 = constraint.q1.index;
                    int row2 = assignments.get(constraint.q1).row;
                    if (checkAttacking(col1, row1, col2, row2)) return false;
                }
            }
        }
        return true;
    }

    public boolean checkAttacking(int col1, int row1, int col2, int row2){
        if (col1 == col2) return true;
        if (row1 == row2) return true;
        if (Math.abs(row1 - row2) == Math.abs(col1 - col2)) return true;
        return false;
    }
}
