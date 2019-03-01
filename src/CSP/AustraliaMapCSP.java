package CSP;

import Constraint.AustraliaMapConstraint;
import DomainValue.AustraliaMapValue;
import Variable.AustraliaMapVariable;

import java.util.ArrayList;
import java.util.List;

public class AustraliaMapCSP extends CSP<AustraliaMapVariable, AustraliaMapValue, AustraliaMapConstraint> {
    public AustraliaMapCSP() {
        variables = new ArrayList<AustraliaMapVariable>();

    }
}
