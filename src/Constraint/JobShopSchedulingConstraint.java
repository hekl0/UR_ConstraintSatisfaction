package Constraint;

import Variable.JobShopSchedulingVariable;

public class JobShopSchedulingConstraint {
    /**
     * Initialize the Constraint
     * The constraint includes two tasks and The Types of Constraint are Before and Share Tool
     **/
    public TypeConstraint typeConstraint;
    public JobShopSchedulingVariable v1, v2;

    public JobShopSchedulingConstraint(TypeConstraint typeConstraint, JobShopSchedulingVariable v1, JobShopSchedulingVariable v2) {
        this.typeConstraint = typeConstraint;
        this.v1 = v1;
        this.v2 = v2;
    }

    public enum TypeConstraint {
        Before,
        ShareTool
    }
}
