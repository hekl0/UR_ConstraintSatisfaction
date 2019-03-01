package BacktrackSearch;

import CSP.JobShopSchedulingCSP;
import Constraint.JobShopSchedulingConstraint;
import Variable.JobShopSchedulingVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JobShopSchedulingSearch extends BacktrackSearch<JobShopSchedulingCSP, JobShopSchedulingVariable, Integer, JobShopSchedulingConstraint> {
    @Override
    public boolean checkComplete(HashMap<JobShopSchedulingVariable, Integer> assignments) {
        return false;
    }

    @Override
    public JobShopSchedulingVariable selectUnassignedVariable(HashMap<JobShopSchedulingVariable, Integer> assignments, JobShopSchedulingCSP csp) {
        return null;
    }

    @Override
    public boolean checkConsistent(JobShopSchedulingVariable jobShopSchedulingVariable, Integer valueAssigning, JobShopSchedulingCSP csp) {
        return false;
    }
}
