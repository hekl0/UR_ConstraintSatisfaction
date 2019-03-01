package Constraint;

import Variable.JobShopSchedulingVariable;

public class JobShopSchedulingConstraint {
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
