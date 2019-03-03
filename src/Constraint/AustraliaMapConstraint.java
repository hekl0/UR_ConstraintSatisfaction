package Constraint;

import Variable.AustraliaMapVariable;

public class AustraliaMapConstraint {
    /**
     * Initialize the Constraint
     * The constraint includes two Regions and The Type of Constraint is NotEqual (can not have the same color)
     **/
    public AusMapCon con;
    public AustraliaMapVariable var1, var2;

    public AustraliaMapConstraint(AustraliaMapVariable var1, AustraliaMapVariable var2){
        this.var1 = var1;
        this.var2 = var2;
        this.con = AusMapCon.NotEqual;
    }

    public enum AusMapCon{
        NotEqual
    }

}
