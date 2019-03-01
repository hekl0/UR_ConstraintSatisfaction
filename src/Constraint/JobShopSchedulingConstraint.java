package Constraint;

import Variable.JobShopSchedulingVariable;

public class JobShopSchedulingConstraint {
    public TypeConstraint typeConstraint;
    public JobShopSchedulingVariable v1, v2;

    enum TypeConstraint {
        Before,
        ShareTool
    }
}
