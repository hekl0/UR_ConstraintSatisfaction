import BacktrackSearch.JobShopSchedulingSearch;
import CSP.JobShopSchedulingCSP;
import Variable.JobShopSchedulingVariable;

import java.util.HashMap;
import java.util.Scanner;

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
        System.out.println();

        switch (choice) {
            case 1:
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
