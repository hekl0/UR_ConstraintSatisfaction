package Solution;

import BacktrackSearch.AustraliaMapSearch;
import CSP.AustraliaMapCSP;
import DomainValue.AustraliaMapValue;
import Variable.AustraliaMapVariable;

import java.util.HashMap;

public class AustraliaMapSolution {

    /**
     * Initialize the Problem and give the Solution
     **/
    public AustraliaMapSolution() {
        AustraliaMapCSP australiaMapCSP = new AustraliaMapCSP();
        AustraliaMapSearch australiaMapSearch = new AustraliaMapSearch();
        HashMap<AustraliaMapVariable, AustraliaMapValue> ausMapAssign = australiaMapSearch.BT(australiaMapCSP);

        printAustraliaMapAssignment(ausMapAssign, australiaMapCSP);
    }

    //print out the solution for Australia Map Problem
    static void printAustraliaMapAssignment(HashMap<AustraliaMapVariable, AustraliaMapValue> ausMapAssign, AustraliaMapCSP australiaMapCSP) {
        System.out.println();
        if (ausMapAssign == null) {
            System.out.println("Not feasible");
            return;
        }
        System.out.print("Solution is: ");
        System.out.print("{");
        System.out.print(australiaMapCSP.variables.get(0).name + " : " + getColorName(ausMapAssign.get(australiaMapCSP.variables.get(0))));
        for (int i = 1; i < australiaMapCSP.variables.size(); i++) {
            System.out.print(", " + australiaMapCSP.variables.get(i).name + " : " + getColorName(ausMapAssign.get(australiaMapCSP.variables.get(i))));
        }
        System.out.print("}");
    }

    //convert the Color to string
    static String getColorName(AustraliaMapValue val){
        switch (val) {
            case Blue:
                return "Blue";
            case Red:
                return "Red";
            case Green:
                return "Green";
        }
        return null;
    }
}
