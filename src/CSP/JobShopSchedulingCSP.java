package CSP;

import Constraint.JobShopSchedulingConstraint;
import Variable.JobShopSchedulingVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JobShopSchedulingCSP extends CSP<JobShopSchedulingVariable, Integer, JobShopSchedulingConstraint> {

    public JobShopSchedulingCSP() {
        this.variables = new ArrayList<>();
        this.domains = new HashMap<>();
        this.constraints = new ArrayList<>();

        //TODO: Create a demo
        //init variables
        this.variables.add(new JobShopSchedulingVariable("AxleF", 10));
        this.variables.add(new JobShopSchedulingVariable("AxleB", 10));
        this.variables.add(new JobShopSchedulingVariable("WheelRF", 1));
        this.variables.add(new JobShopSchedulingVariable("WheelLF", 1));
        this.variables.add(new JobShopSchedulingVariable("WheelRB", 1));
        this.variables.add(new JobShopSchedulingVariable("WheelLB", 1));
        this.variables.add(new JobShopSchedulingVariable("NutsRF", 2));
        this.variables.add(new JobShopSchedulingVariable("NutsLF", 2));
        this.variables.add(new JobShopSchedulingVariable("NutsRB", 2));
        this.variables.add(new JobShopSchedulingVariable("NutsLB", 2));
        this.variables.add(new JobShopSchedulingVariable("CapRF", 1));
        this.variables.add(new JobShopSchedulingVariable("CapLF", 1));
        this.variables.add(new JobShopSchedulingVariable("CapRB", 1));
        this.variables.add(new JobShopSchedulingVariable("CapLB", 1));
        this.variables.add(new JobShopSchedulingVariable("Inspect", 3));

        //init domains
        for (JobShopSchedulingVariable variable : this.variables) {
            List<Integer> domain = new ArrayList<>();
            if (!variable.name.equals("Inspect"))
                for (int i = 1; i <= 30; i++) domain.add(i);
            else
                for (int i = 1; i <= 27; i++) domain.add(i);
            this.domains.put(variable, domain);
        }

        //init constraints
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.Before, this.variables.get(0), this.variables.get(2)));
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.Before, this.variables.get(0), this.variables.get(3)));
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.Before, this.variables.get(1), this.variables.get(4)));
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.Before, this.variables.get(1), this.variables.get(5)));
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.Before, this.variables.get(2), this.variables.get(6)));
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.Before, this.variables.get(3), this.variables.get(7)));
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.Before, this.variables.get(4), this.variables.get(8)));
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.Before, this.variables.get(5), this.variables.get(9)));
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.Before, this.variables.get(6), this.variables.get(10)));
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.Before, this.variables.get(7), this.variables.get(11)));
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.Before, this.variables.get(8), this.variables.get(12)));
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.Before, this.variables.get(9), this.variables.get(13)));
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.ShareTool, this.variables.get(0), this.variables.get(1)));
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.Before, this.variables.get(0), this.variables.get(14)));
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.Before, this.variables.get(1), this.variables.get(14)));
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.Before, this.variables.get(2), this.variables.get(14)));
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.Before, this.variables.get(3), this.variables.get(14)));
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.Before, this.variables.get(4), this.variables.get(14)));
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.Before, this.variables.get(5), this.variables.get(14)));
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.Before, this.variables.get(6), this.variables.get(14)));
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.Before, this.variables.get(7), this.variables.get(14)));
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.Before, this.variables.get(8), this.variables.get(14)));
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.Before, this.variables.get(9), this.variables.get(14)));
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.Before, this.variables.get(10), this.variables.get(14)));
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.Before, this.variables.get(11), this.variables.get(14)));
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.Before, this.variables.get(12), this.variables.get(14)));
        this.constraints.add(new JobShopSchedulingConstraint(JobShopSchedulingConstraint.TypeConstraint.Before, this.variables.get(13), this.variables.get(14)));

        printProblem();
    }

    @Override
    public void printProblem() {
        System.out.println("There are " + this.variables.size() + " variables:");
        for (JobShopSchedulingVariable variable : this.variables)
            System.out.printf("    %-10s duration: %-3d Domain: %d-%d\n", variable.name, variable.duration, this.domains.get(variable).get(0), this.domains.get(variable).get(this.domains.get(variable).size() - 1));
        System.out.println();
        System.out.println("There are " + this.constraints.size() + " constraints:");
        for (JobShopSchedulingConstraint constraint : this.constraints)
            System.out.printf("    %-10s %-10s %-10s\n", constraint.v1.name, ((constraint.typeConstraint == JobShopSchedulingConstraint.TypeConstraint.Before) ? "Before" : "ShareTool"), constraint.v2.name);
    }
}
