package Constraint;

import Variable.nQueenVariable;

public class nQueenConstraint {
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
