package data;


public class Transcript {

    private Student stud;
    private Subject subj;
    private double labMark;
    private double testMark;
    private double finalMark;

    public Transcript() {
    }

    public Transcript(Student stud, Subject subj, double labMark, double testMark, double finalMark) {
        this.stud = stud;
        this.subj = subj;
        this.labMark = labMark;
        this.testMark = testMark;
        this.finalMark = finalMark;
    }

    public Subject getSubj() {
        return subj;
    }

    public void setSubj(Subject subj) {
        this.subj = subj;
    }

    public Student getStud() {
        return stud;
    }

    public void setStud(Student stud) {
        this.stud = stud;
    }

    public double getLabMark() {
        return labMark;
    }

    public void setLabMark(double labMark) {
        this.labMark = labMark;
    }

    public double getTestMark() {
        return testMark;
    }

    public void setTestMark(double testMark) {
        this.testMark = testMark;
    }

    public double getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(double finalMark) {
        this.finalMark = finalMark;
    }

    public double average() {
        return labMark * 0.3 + testMark * 0.3 + finalMark * 0.4;
    }

}
