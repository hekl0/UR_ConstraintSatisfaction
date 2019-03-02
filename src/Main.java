import BacktrackSearch.AustraliaMapSearch;
import BacktrackSearch.JobShopSchedulingSearch;
import CSP.AustraliaMapCSP;
import CSP.JobShopSchedulingCSP;
import DomainValue.AustraliaMapValue;
import Variable.AustraliaMapVariable;
import Variable.JobShopSchedulingVariable;

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
                HashMap<AustraliaMapVariable, AustraliaMapValue> assign = australiaMapSearch.BT(australiaMapCSP);

                printAustraliaMapAssignment(assign, australiaMapCSP);
                break;
            case 2:
                JobShopSchedulingCSP jobShopSchedulingCSP = new JobShopSchedulingCSP();
                JobShopSchedulingSearch jobShopSchedulingSearch = new JobShopSchedulingSearch();
                HashMap<JobShopSchedulingVariable, Integer> assignments = jobShopSchedulingSearch.BT(jobShopSchedulingCSP);

                printJobShopSchedulingAssignment(assignments, jobShopSchedulingCSP);
                break;
            case 3:
                break;
        }
    }

    static void printAustraliaMapAssignment(HashMap<AustraliaMapVariable, AustraliaMapValue> assign, AustraliaMapCSP australiaMapCSP) {
        System.out.println();
        if (assign == null) {
            System.out.println("Not feasible");
            return;
        }
        System.out.print("Solution is: ");
        System.out.print("{");
        System.out.print(australiaMapCSP.variables.get(0).name + " : " + getColorName(assign.get(australiaMapCSP.variables.get(0))));
        for (int i = 1; i < australiaMapCSP.variables.size(); i++) {
            System.out.print(", " + australiaMapCSP.variables.get(i).name + " : " + getColorName(assign.get(australiaMapCSP.variables.get(i))));
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
