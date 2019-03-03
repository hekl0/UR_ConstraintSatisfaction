package Solution;

import BacktrackSearch.JobShopSchedulingSearch;
import CSP.JobShopSchedulingCSP;
import Variable.JobShopSchedulingVariable;

import java.util.HashMap;

public class JobShopSchedulingSolution {

    /**
     * Initialize the Problem and give the Solution
     **/
    public JobShopSchedulingSolution(){
        JobShopSchedulingCSP jobShopSchedulingCSP = new JobShopSchedulingCSP();
        JobShopSchedulingSearch jobShopSchedulingSearch = new JobShopSchedulingSearch();
        HashMap<JobShopSchedulingVariable, Integer> assignments = jobShopSchedulingSearch.BT(jobShopSchedulingCSP);

        printJobShopSchedulingAssignment(assignments, jobShopSchedulingCSP);
    }

    //print out the solution for Job Scheduling Problem
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
