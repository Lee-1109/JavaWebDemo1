package model;

public class Course {
    private String name;
    private double credit;
    private int period;
    private int term;
    private int assessment;
    private String brief;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCredit(double credit){
        this.credit=credit;
    }

    public double getCredit() {
        return credit;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getPeriod() {
        return period;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getTerm() {
        return term;
    }

    public void setAssessment(int assessment) {
        this.assessment = assessment;
    }

    public int getAssessment(){
        return assessment;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getBrief() {
        return brief;
    }
}
