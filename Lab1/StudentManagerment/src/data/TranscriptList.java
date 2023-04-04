package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import validation.validate;

public class TranscriptList {

    private final ArrayList<Transcript> trans;

    public TranscriptList() {
        trans = new ArrayList<>();
    }

    public Transcript searchTransciptIDStuAndCodeSubj(String id, String code) {
        for (Transcript t : trans) {
            if (t.getStud().getId().equalsIgnoreCase(id) && t.getSubj().getSubjectId().equalsIgnoreCase(code)) {
                return t;
            }
        }
        return null;
    }

    public void addTranscript(StudentList stu, SubjectList sub) {
        boolean flag = false;
        while (true) {
            String idStu = validate.inputNonBlankStr("input id student: ");
            if (!stu.checkId(idStu)) {
                System.out.println("Student does not exist");
            } else {
                System.out.println("Student have exist");
                Student sd = StudentList.displayStudent(idStu, stu);
                String codeSub = validate.inputNonBlankStr("Input code subject: ");
                if (!sub.checkSubjectId(codeSub)) {
                    System.out.println("Subject does not exist");
                } else {
                    System.out.println("Subject have exist");
                    Subject sj = SubjectList.displaySubjectCode(codeSub, sub);
                    Transcript t = searchTransciptIDStuAndCodeSubj(idStu, codeSub);
                    if (!checkOverWrite(t)) {
                        System.out.println("======== Input Grade ========");
                        Student newStud = StudentList.valueOfStudent(idStu, stu);
                        Subject newSubj = SubjectList.valueOfCodeSubject(codeSub, sub);
                        trans.add(new Transcript(newStud, newSubj, getlabMark(), getTestMark(), getFinalMark()));
                        System.out.println("===== Added Success =====");
                    } else {
                        String sc1 = validate.inputNonBlankStr("students have already graded this subject, you want to overwrite it[Y/N]?: ");
                        if (sc1.equalsIgnoreCase("Yes")) {
                            System.out.println("======== Input Grade ========");
                            Student newStu = StudentList.valueOfStudent(idStu, stu);
                            Subject newSub = SubjectList.valueOfCodeSubject(codeSub, sub);
                            t.setLabMark(getlabMark());
                            t.setTestMark(getTestMark());
                            t.setFinalMark(getFinalMark());
                            t.setStud(newStu);
                            t.setSubj(newSub);
                            System.out.println("===== Added Success =====");
                        } else {
                            System.out.println("====== Cancel Add Grade ======");
                        }
                    }
                }
            }
            String naem = validate.inputNonBlankStr("Do you want to continue, or go back to the menu?[Yes/No]: ");
            if (naem.equalsIgnoreCase("No")) {
                break;
            }
        }
    }

    public boolean checkOverWrite(Transcript tr) {
        if (tr != null) {
            return (tr.getLabMark() != -1 || tr.getTestMark() != -1 || tr.getFinalMark() != -1);
        }
        return false;
    }

    public double getlabMark() {
        double labMark = 0;
        boolean flag = false;
        do {
            try {
                labMark = validate.inputMark("Input labMark: ");
                flag = false;
            } catch (Exception e) {
                System.out.println("error");
                flag = true;
            }
        } while (flag);
        return labMark;
    }

    public double getTestMark() {
        double testMark = 0;
        boolean flag = false;
        do {
            try {
                testMark = validate.inputMark("Input testMark: ");
                flag = false;
            } catch (Exception e) {
                System.out.println("error");
                flag = true;
            }
        } while (flag);
        return testMark;
    }

    public double getFinalMark() {
        double finalMark = 0;
        boolean flag = false;
        do {
            try {
                finalMark = validate.inputMark("Input finalMark: ");
                flag = false;
            } catch (Exception e) {
                System.out.println("error");
                flag = true;
            }
        } while (flag);
        return finalMark;
    }

    public void displayStudentTranscript(StudentList stu) {
        while (true) {
            String id = validate.inputNonBlankStr("Input id Student to need show profile Transcript: ");
            if (!stu.checkId(id)) {
                System.out.println("Student does not exist");
            } else {
                System.out.println("Student exist");
                if (trans.size() > 0) {
                    Student s = StudentList.valueOfStudent(id, stu);
                    displayStudentGrade(s);
                    System.out.println("|++  No  ++|++++++++   Subject name   ++++++++|++   Average mark   ++|++    Status    ++|");
                    ArrayList<Transcript> tr = returnTransciptStudent(trans, id);
                    Comparator compare = new Comparator<Transcript>() {
                        @Override
                        public int compare(Transcript o1, Transcript o2) {
                            String name1 = o1.getSubj().getSubjectName().substring(0, 1);
                            String name2 = o2.getSubj().getSubjectName().substring(0, 1);
                            if (name1.compareToIgnoreCase(name2) == 0) {
                                return 0;
                            }
                            if (name1.compareToIgnoreCase(name2) < 0) {
                                return -1;
                            } else {
                                return 1;
                            }
                        }
                    };
                    Collections.sort(tr, compare);
                    int count = 1;
                    for (Transcript tran : tr) {
                        System.out.printf("     %-6s       %-25s              %-10.2f         %-10s\n", count, tran.getSubj().getSubjectName(), tran.average(), checkStatus(tran));
                        count++;
                    }
                } else {
                    System.out.println("Transcpript is empty!!!");
                }
            }
            String name = validate.inputNonBlankStr("You want show other Student Transcript[Yes/No]: ");
            if (name.equalsIgnoreCase("No")) {
                break;
            }
        }
    }

    public ArrayList<Transcript> returnTransciptStudent(ArrayList<Transcript> tr, String id) {
        ArrayList<Transcript> tr2 = new ArrayList<>();
        for (Transcript transcript : trans) {
            if (transcript.getStud().getId().equalsIgnoreCase(id)) {
                tr2.add(transcript);
            }
        }
        return tr2;
    }

    public ArrayList<Transcript> returnTranscriptSubject(ArrayList<Transcript> tr, String code) {
        ArrayList<Transcript> tr2 = new ArrayList<>();
        for (Transcript tran : trans) {
            if (tran.getSubj().getSubjectId().equalsIgnoreCase(code)) {
                tr2.add(tran);
            }
        }
        return tr2;
    }

    public void displaySubjectTranscript(SubjectList x) {
        while (true) {
            String code = validate.inputNonBlankStr("Input code Subject to need show profile Transcript: ");
            if (!x.checkSubjectId(code)) {
                System.out.println("Subject does not exist");
            } else {
                System.out.println("Subject exist!!!");
                if (trans.size() > 0) {
                    Subject s = SubjectList.valueOfCodeSubject(code, x);
                    System.out.println("==========  Subject Grade report  =========");
                    System.out.println("Subject Code: " + s.getSubjectId());
                    System.out.println("Subject Name: " + s.getSubjectName());
                    System.out.println("|++  Student ID  ++|++++++++   Student Name   ++++++++|++   Average mark   ++|++    Status    ++|");
                    ArrayList<Transcript> tr = returnTranscriptSubject(trans, code);
                    Comparator compare = new Comparator<Transcript>() {
                        @Override
                        public int compare(Transcript o1, Transcript o2) {
                            if (o1.getStud().getFirstName().substring(0, 1).compareToIgnoreCase(o2.getStud().getFirstName().substring(0, 1)) == 0) {
                                return 0;
                            }
                            if (o1.getStud().getFirstName().substring(0, 1).compareToIgnoreCase(o2.getStud().getFirstName().substring(0, 1)) < 0) {
                                return -1;
                            } else {
                                return 1;
                            }
                        }
                    };
                    Collections.sort(tr, compare);
                    for (Transcript t : tr) {
                        System.out.printf("       %-6s           %-8s%-17s              %-10.2f          %-10s\n", t.getStud().getId(), t.getStud().getFirstName(), t.getStud().getLastName(), t.average(), checkStatus(t));
                    }
                } else {
                    System.out.println("Transcript of Subject id empty!!!");
                }
            }
            String name = validate.inputNonBlankStr("You want show other Subject Transcript[Yes/No]: ");
            if (name.equalsIgnoreCase("No")) {
                break;
            }
        }
    }

    public String checkStatus(Transcript x) {
        if (x.average() > 4.0) {
            return "Pass";
        }
        return "Not Pass";
    }

    public void displayStudentGrade(Student x) {
        System.out.println("==========  Student Grade report  =========");
        System.out.println("Student ID: " + x.getId());
        System.out.println("Student name: " + x.getFirstName() + " " + x.getLastName());
    }

}
