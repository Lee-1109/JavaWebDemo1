package model;

import java.util.Date;

/**
 * ½èÊéÏêÇéÀà
 */
public class Lend {

    private LendPK lendPK;

    private Date date;

    public Lend(){}


    public LendPK getLendPK() {
        return lendPK;
    }

    public void setLendPK(LendPK lendPK) {
        this.lendPK = lendPK;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
