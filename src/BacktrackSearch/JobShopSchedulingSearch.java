package BacktrackSearch;

import CSP.JobShopSchedulingCSP;
import Constraint.JobShopSchedulingConstraint;
import Variable.JobShopSchedulingVariable;

import java.util.HashMap;

public class JobShopSchedulingSearch extends BacktrackSearch<JobShopSchedulingCSP, JobShopSchedulingVariable, Integer, JobShopSchedulingConstraint> {

    @Override
    public boolean checkComplete(HashMap<JobShopSchedulingVariable, Integer> assignments, JobShopSchedulingCSP csp) {
        return (assignments.size() == csp.variables.size());
    }

    @Override
    public JobShopSchedulingVariable selectUnassignedVariable(HashMap<JobShopSchedulingVariable, Integer> assignments, JobShopSchedulingCSP csp) {
        for (JobShopSchedulingVariable variable : csp.variables)
            if (!assignments.containsKey(variable))
                return variable;
        return null;
    }

    @Override
    public boolean checkConsistent(JobShopSchedulingVariable variable, Integer valueAssigning, HashMap<JobShopSchedulingVariable, Integer> assignments, JobShopSchedulingCSP csp) {
        for (JobShopSchedulingConstraint constraint : csp.constraints)
            if (constraint.v1 == variable) {
                if (assignments.get(constraint.v2) == null) continue;
                if (constraint.typeConstraint == JobShopSchedulingConstraint.TypeConstraint.Before
                        && valueAssigning + variable.duration > assignments.get(constraint.v2)) return false;
                if (constraint.typeConstraint == JobShopSchedulingConstraint.TypeConstraint.ShareTool
                        && valueAssigning + variable.duration > assignments.get(constraint.v2)
                        && assignments.get(constraint.v2) + constraint.v2.duration > valueAssigning) return false;
            } else if (constraint.v2 == variable) {
                if (assignments.get(constraint.v1) == null) continue;
                if (constraint.typeConstraint == JobShopSchedulingConstraint.TypeConstraint.Before
                        && assignments.get(constraint.v1) + constraint.v1.duration > valueAssigning) return false;
                if (constraint.typeConstraint == JobShopSchedulingConstraint.TypeConstraint.ShareTool
                        && valueAssigning + variable.duration > assignments.get(constraint.v1)
                        && assignments.get(constraint.v1) + constraint.v1.duration > valueAssigning) return false;
            }
        return true;
    }
}
