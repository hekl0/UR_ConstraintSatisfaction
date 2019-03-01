package CSP;

import java.util.List;

public abstract class CSP<Variable, Domain, Constraint> {
    List<Variable> variables;
    List<List<Domain>> domains;
    List<Constraint> constraints;
}
