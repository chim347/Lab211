package data;

import validation.validate;

public class Subject {

    private String subjectId;
    private String subjectName;
    private int credit;

    public Subject() {
    }

    public Subject(String subjectId, String subjectName, int credit) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.credit = credit;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void inputSubject() {
        boolean check = false;
        do {
            try {
                subjectId = validate.inputString("Subject ID: ");
                subjectName = validate.inputString("Subject name: ");
                credit = validate.inputNumber("Credit: ");
                check = false;
            } catch (Exception e) {
                System.out.println("error");
                check = true;
            }
        } while (check);
    }

    public void displaySubject() {
        System.out.println("|++ SubjectId  ++|+++    SubjectName    +++|+ Credit +|");
        System.out.printf("|%-16s|%-25s|%10s|\n", subjectId, subjectName, credit);
    }

}
