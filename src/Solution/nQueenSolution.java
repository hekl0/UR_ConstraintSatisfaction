package Solution;

import BacktrackSearch.nQueenSearch;
import CSP.nQueenCSP;
import DomainValue.nQueenValue;
import Variable.nQueenVariable;

import java.util.HashMap;

public class nQueenSolution {
    int num;
    /**
     * Initialize the Problem and give the Solution
     **/
    public nQueenSolution(int num){
        nQueenCSP nQueenCSP = new nQueenCSP(num);
        nQueenSearch nQueenSearch = new nQueenSearch();
        HashMap<nQueenVariable, nQueenValue> nQueenAssign = nQueenSearch.BT(nQueenCSP);

        printnQueenAssignment(nQueenAssign,nQueenCSP);
    }

    //print out the solution for N-Queen Problems
    static void printnQueenAssignment(HashMap<nQueenVariable, nQueenValue> nQueenAssign, nQueenCSP nQueenCSP) {
        System.out.println();
        if (nQueenAssign == null) {
            System.out.println("Not feasible");
            return;
        }
        System.out.print("Solution is: ");
        System.out.print("{");
        System.out.print(nQueenCSP.variables.get(0).name + ":" + "(" + nQueenAssign.get(nQueenCSP.variables.get(0)).row + "," + nQueenCSP.variables.get(0).index + ")");
        for (int i = 1; i < nQueenCSP.variables.size(); i++) {
            System.out.print("," + nQueenCSP.variables.get(i).name + ":" + "(" + nQueenAssign.get(nQueenCSP.variables.get(i)).row + "," + nQueenCSP.variables.get(i).index + ")");
        }
        System.out.print("}");
    }
}
