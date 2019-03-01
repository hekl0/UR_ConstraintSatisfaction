package CSP;

import java.util.HashMap;
import java.util.List;

public abstract class CSP<Variable, DomainValue, Constraint> {
    public List<Variable> variables;
    public HashMap<Variable, List<DomainValue>> domains;
    public List<Constraint> constraints;

    public abstract void printProblem();
}
