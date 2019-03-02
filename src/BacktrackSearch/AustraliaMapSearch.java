package BacktrackSearch;

import CSP.AustraliaMapCSP;
import Constraint.AustraliaMapConstraint;
import DomainValue.AustraliaMapValue;
import Variable.AustraliaMapVariable;

import java.util.HashMap;
import java.util.List;

public class AustraliaMapSearch extends BacktrackSearch<AustraliaMapCSP, AustraliaMapVariable, AustraliaMapValue, AustraliaMapConstraint>{


    @Override
    public boolean checkComplete(HashMap<AustraliaMapVariable, AustraliaMapValue> assignments, AustraliaMapCSP csp) {
        return assignments.size() == csp.variables.size();
    }

    @Override
    public AustraliaMapVariable selectUnassignedVariable(HashMap<AustraliaMapVariable, AustraliaMapValue> assignments, AustraliaMapCSP csp) {
        for (AustraliaMapVariable variable : csp.variables)
            if (!assignments.containsKey(variable))
                return variable;
        return null;
    }


    @Override
    public boolean checkConsistent(AustraliaMapVariable australiaMapVariable, AustraliaMapValue valueAssigning, HashMap<AustraliaMapVariable, AustraliaMapValue> assignments, AustraliaMapCSP csp) {
        for (AustraliaMapConstraint constraint : csp.constraints)
            if (constraint.var1 == australiaMapVariable) {
                if (assignments.get(constraint.var2) == null) continue;
                else {
                    if (assignments.get(constraint.var2) == valueAssigning) return false;
                }

            } else if (constraint.var2 == australiaMapVariable) {
                if (assignments.get(constraint.var1) == null) continue;
                else {
                    if (assignments.get(constraint.var1) == valueAssigning) return false;
                }
            }
        return true;
    }
}
