package BacktrackSearch;

import CSP.CSP;
import jdk.nashorn.internal.ir.Assignment;

import java.util.List;

public abstract class BacktrackSearch<Assignment, CSP> {
    public abstract List<Assignment> BT(CSP csp);
    public abstract List<Assignment> backtrack(List<Assignment> assignment, CSP csp);
}
