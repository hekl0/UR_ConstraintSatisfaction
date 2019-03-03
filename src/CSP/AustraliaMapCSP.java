package CSP;

import Constraint.AustraliaMapConstraint;
import DomainValue.AustraliaMapValue;
import Variable.AustraliaMapVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AustraliaMapCSP extends CSP<AustraliaMapVariable, AustraliaMapValue, AustraliaMapConstraint> {

    public AustraliaMapCSP() {
        variables = new ArrayList<>();
        domains = new HashMap<>();
        constraints = new ArrayList<>();

        //TODO: Create a demo
        //init variables
        variables.add(new AustraliaMapVariable("SA"));
        variables.add(new AustraliaMapVariable("WA"));
        variables.add(new AustraliaMapVariable("NT"));
        variables.add(new AustraliaMapVariable("Q"));
        variables.add(new AustraliaMapVariable("NSW"));
        variables.add(new AustraliaMapVariable("V"));
        variables.add(new AustraliaMapVariable("T"));

        //init domains
        for (int i = 0; i < variables.size(); i++){
            List<AustraliaMapValue> domain = new ArrayList<>();
            domain.add(AustraliaMapValue.Red);
            domain.add(AustraliaMapValue.Blue);
            domain.add(AustraliaMapValue.Green);
            domains.put(variables.get(i),domain);
        }

        //init constraints
        constraints.add(new AustraliaMapConstraint(variables.get(0), variables.get(1)));
        constraints.add(new AustraliaMapConstraint(variables.get(0), variables.get(2)));
        constraints.add(new AustraliaMapConstraint(variables.get(0), variables.get(3)));
        constraints.add(new AustraliaMapConstraint(variables.get(0), variables.get(4)));
        constraints.add(new AustraliaMapConstraint(variables.get(0), variables.get(5)));
        constraints.add(new AustraliaMapConstraint(variables.get(1), variables.get(2)));
        constraints.add(new AustraliaMapConstraint(variables.get(2), variables.get(3)));
        constraints.add(new AustraliaMapConstraint(variables.get(3), variables.get(4)));
        constraints.add(new AustraliaMapConstraint(variables.get(4), variables.get(5)));

        printProblem();
    }

    @Override
    public void printProblem() {
        System.out.print("There are " + this.variables.size() + " variables: ");
        System.out.print("{");
        System.out.print(variables.get(0).name);
        for (int i = 1; i < variables.size(); i++) {
            System.out.print(", " + variables.get(i).name);
        }
        System.out.print("}");
        System.out.println();
        System.out.println("The Initial Domain for each Variable is {Red,Blue,Green}");
        System.out.print("There are " + this.constraints.size() + " constraints:");
        System.out.print("{");
        System.out.print(constraints.get(0).var1.name + " != " + constraints.get(0).var2.name);
        for (int i = 1; i < constraints.size(); i++) {
            System.out.print(", " + constraints.get(i).var1.name + " != " + constraints.get(i).var2.name);
        }
        System.out.print("}");
    }
}
