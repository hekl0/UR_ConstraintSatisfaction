package Constraint;

import Variable.nQueenVariable;

public class nQueenConstraint {
    /**
     * Initialize the Constraint
     * The constraint includes two queens and The Type of Constraint is NotAttack
     **/
    public nQueenVariable q1, q2;

    public nQueenCon con;

    public nQueenConstraint(nQueenVariable q1, nQueenVariable q2) {
        this.q1 = q1;
        this.q2 = q2;
        this.con = nQueenCon.NotAttack;
    }

    public enum nQueenCon {
        NotAttack
    }


}
