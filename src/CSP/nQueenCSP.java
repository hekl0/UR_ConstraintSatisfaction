package CSP;

import Constraint.nQueenConstraint;
import DomainValue.nQueenValue;
import Variable.nQueenVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class nQueenCSP extends CSP<nQueenVariable,nQueenValue,nQueenConstraint> {
    public int num;
    public nQueenCSP(int num) {
        this.num = num;

        variables = new ArrayList<>();
        domains = new HashMap<>();
        constraints = new ArrayList<>();

        //init variables
        for (int i = 1; i <= num; i++){
            variables.add(new nQueenVariable("Q" + i));
        }

        //init domains
        for (nQueenVariable variable : variables){
            List<nQueenValue> domain = new ArrayList<>();
            for (int row = 1; row <= 8; row++){
                for (int col = 1; col <= 8; col++){
                    domain.add(new nQueenValue(row,col));
                }
            }
            domains.put(variable,domain);
        }

        //init constraints
        for (int i = 0; i < num; i++){
            for (int j = i+1; j < num; j++){
                constraints.add(new nQueenConstraint(variables.get(i), variables.get(j)));
            }
        }

        printProblem();
    }

    @Override
    public void printProblem() {
        System.out.println("The index on the Board start from 1 to 8");
        System.out.print("There are " + this.variables.size() + " variables: ");
        System.out.print("{");
        System.out.print(variables.get(0).name);
        for (int i = 1; i < variables.size(); i++) {
            System.out.print(", " + variables.get(i).name);
        }
        System.out.print("}");
        System.out.println();
        System.out.println("The Initial Domain for each Variable is any position on the 8x8 Board");
        System.out.print("There are " + this.constraints.size() + " constraints:");
        System.out.print("{");
        System.out.print(constraints.get(0).q1.name + " X " + constraints.get(0).q2.name);
        for (int i = 1; i < constraints.size(); i++) {
            System.out.print(", " + constraints.get(i).q1.name + " X " + constraints.get(i).q2.name);
        }
        System.out.println("}");
        System.out.println("Note: The symbol \"X\" means \"does not attack\"");
        System.out.println("For example: \"Q1 X Q2\" means Q1 does not attack Q2");
    }
}
