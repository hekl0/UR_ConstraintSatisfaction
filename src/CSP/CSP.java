package CSP;

import java.util.HashMap;
import java.util.List;

public abstract class CSP<Variable, DomainValue, Constraint> {
    /**
     * Initialize the CSP by Variables, Domain Values, and Constraints
     * List of Variables and Constraints
     * HashMap of Variables and Domain Value for each one
     **/
    public List<Variable> variables;
    public HashMap<Variable, List<DomainValue>> domains;
    public List<Constraint> constraints;

    //print out the problem
    public abstract void printProblem();
}
