import BacktrackSearch.AustraliaMapSearch;
import BacktrackSearch.JobShopSchedulingSearch;
import BacktrackSearch.nQueenSearch;
import CSP.AustraliaMapCSP;
import CSP.JobShopSchedulingCSP;
import CSP.nQueenCSP;
import DomainValue.AustraliaMapValue;
import DomainValue.nQueenValue;
import Variable.AustraliaMapVariable;
import Variable.JobShopSchedulingVariable;
import Variable.nQueenVariable;

import java.util.HashMap;
import java.util.Scanner;

import static DomainValue.AustraliaMapValue.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please choose Problem: ");
        System.out.println("   1. Australia Map");
        System.out.println("   2. Job Shop Scheduling");
        System.out.println("   3. N-Queens");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                AustraliaMapCSP australiaMapCSP = new AustraliaMapCSP();
                AustraliaMapSearch australiaMapSearch = new AustraliaMapSearch();
                HashMap<AustraliaMapVariable, AustraliaMapValue> ausMapAssign = australiaMapSearch.BT(australiaMapCSP);

                printAustraliaMapAssignment(ausMapAssign, australiaMapCSP);
                break;
            case 2:
                JobShopSchedulingCSP jobShopSchedulingCSP = new JobShopSchedulingCSP();
                JobShopSchedulingSearch jobShopSchedulingSearch = new JobShopSchedulingSearch();
                HashMap<JobShopSchedulingVariable, Integer> assignments = jobShopSchedulingSearch.BT(jobShopSchedulingCSP);

                printJobShopSchedulingAssignment(assignments, jobShopSchedulingCSP);
                break;
            case 3:
                System.out.print("The number of Queen (Recommend 8): ");
                int num = scanner.nextInt();
                nQueenCSP nQueenCSP = new nQueenCSP(num);
                nQueenSearch nQueenSearch = new nQueenSearch();
                HashMap<nQueenVariable, nQueenValue> nQueenAssign = nQueenSearch.BT(nQueenCSP);

                printnQueenAssignment(nQueenAssign,nQueenCSP);
                break;
        }
    }

    static void printnQueenAssignment(HashMap<nQueenVariable, nQueenValue> nQueenAssign, nQueenCSP nQueenCSP) {
        System.out.println();
        if (nQueenAssign == null) {
            System.out.println("Not feasible");
            return;
        }
        System.out.print("Solution is: ");
        System.out.print("{");
        System.out.print(nQueenCSP.variables.get(0).name + ":" + "(" + nQueenAssign.get(nQueenCSP.variables.get(0)).row + "," + nQueenAssign.get(nQueenCSP.variables.get(0)).col + ")");
        for (int i = 1; i < nQueenCSP.variables.size(); i++) {
            System.out.print("," + nQueenCSP.variables.get(i).name + ":" + "(" + nQueenAssign.get(nQueenCSP.variables.get(i)).row + "," + nQueenAssign.get(nQueenCSP.variables.get(i)).col + ")");
        }
        System.out.print("}");
    }

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
    static void printJobShopSchedulingAssignment(HashMap<JobShopSchedulingVariable, Integer> assignments, JobShopSchedulingCSP jobShopSchedulingCSP) {
        System.out.println();
        if (assignments == null) {
            System.out.println("Not feasible");
            return;
        }
        System.out.println("Solution is:");
        for (JobShopSchedulingVariable variable: jobShopSchedulingCSP.variables)
            System.out.printf("    %-10s%d\n", variable.name, assignments.get(variable));
    }
}
