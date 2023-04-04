package data;

import java.util.ArrayList;
import java.util.Scanner;
import validation.validate;

public class SubjectList {

    private final ArrayList<Subject> list;

    public SubjectList() {
        super();
        list = new ArrayList<>();
    }

    public ArrayList<Subject> getList() {
        return list;
    }

    public void addSubject() {
        String subjectId;
        do {
            subjectId = validate.inputNonBlankStr("Input subject id: ");
            if (checkSubjectId(subjectId)) {
                System.out.println("duplicated");
            }
        } while (checkSubjectId(subjectId));

        String subjectName;
        subjectName = validate.inputNonBlankStr("Input subject name: ");

        int credit = 0;
        boolean flag = false;
        do {
            try {
                credit = validate.inputCredit("input creadit: ");
                flag = false;
            } catch (Exception e) {
                System.out.println("error");
                flag = true;
            }
        } while (flag);

        list.add(new Subject(subjectId, subjectName, credit));
    }

    public void display() {
        System.out.println("|++ SubjectId  ++|+++    SubjectName    +++|+ Credit +|");
        for (Subject x : list) {
            System.out.printf("|%-16s|%-25s|%10s|\n", x.getSubjectId(), x.getSubjectName(), x.getCredit());
        }
    }

    public boolean checkSubjectId(String id) {
        return search(id) != null;
    }

    public Subject search(String id) {
        for (Subject x : list) {
            if (x.getSubjectId().equalsIgnoreCase(id)) {
                return x;
            }
        }
        return null;
    }

    public void updateSubject(String id) {
        boolean check = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSubjectId().equalsIgnoreCase(id)) {
                String name = "";
                name = validate.inputNameStudentUpdate("Input NEW name Subject: ", list.get(i).getSubjectName());
                list.get(i).setSubjectName(name);

                int creadit = 0;
                Scanner sc = new Scanner(System.in);
                System.out.print("Input new Creadit: ");
                try {
                    creadit = Integer.parseInt(sc.nextLine());
                } catch (Exception e) {
                    creadit = -1;
                    System.out.println(list.get(i).getCredit());
                }
                if (validate.checkCreditRange(creadit)) {
                    list.get(i).setCredit(creadit);
                }
            }
        }
    }

    public void removeSubject(String id) {
        Subject sbj = new Subject();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSubjectId().equalsIgnoreCase(id)) {
                sbj = list.get(i);
            }
        }
        if (sbj != null) {
            list.remove(sbj);
        } else {
            System.out.println("no existed!!!");
        }
    }

    public void updateSubjectList() {
        int choice = 0;
        boolean flag = false;
        do {
            System.out.println("=========== UPDATE SUBJECT ===========");
            System.out.println("     1. Update Subject");
            System.out.println("     2. Delete Subject");
            System.out.println("     3. Enter to printAll");
            try {
                choice = validate.inputNumber("Input your choice: ");
            } catch (Exception e) {
                System.out.println("error!!! Input Again");
            }
            switch (choice) {
                case 1:
                    String id = "";
                    do {
                        id = validate.inputNonBlankStr("Input Subject ID to need update: ");
                        if (!checkSubjectId(id)) {
                            System.out.println("Subject ID does not exist");
                        } else {
                            System.out.println("Subject ID exsit!!!!!!!");
                            search(id).displaySubject();
                            String check = "";
                            check = validate.inputNonBlankStr("Do you want to update ID Subject (Yes/No)?: ");
                            if (check.equalsIgnoreCase("Yes")) {
                                updateSubject(id);
                                System.out.println("======= Update Success =======");
                            } else {
                                System.out.println("======== Update Fail =========");
                            }
                        }
                        String check1 = "";
                        check1 = validate.inputNonBlankStr("Do you want to update ID Subject more time (Yes/No)?: ");
                        if (check1.equalsIgnoreCase("No")) {
                            break;
                        }
                    } while (true);
                    break;
                case 2:
                    String id1 = "";
                    do {
                        id1 = validate.inputNonBlankStr("Input subject ID you need delete: ");
                        if (!checkSubjectId(id1)) {
                            System.out.println("Subject ID does not exist");
                        } else {
                            System.out.println("Subject ID exist!!!!!");
                            search(id1).displaySubject();
                            String check = "";
                            check = validate.inputNonBlankStr("Do you want to delete Subject have id (Yes/No)?: ");
                            if (check.equalsIgnoreCase("Yes")) {
                                removeSubject(id1);
                                System.out.println("======= Delete Success =======");
                            } else {
                                System.out.println("======== Cancel Delete ==========");
                            }
                            String name = "";
                            name = validate.inputNonBlankStr("Do you want delete Subject more times (Yes/No)?: ");
                            if (name.equalsIgnoreCase("No")) {
                                break;
                            }
                        }
                    } while (true);
                    break;
            }

        } while (choice <= 2);
    }

    public static Subject valueOfCodeSubject(String code, SubjectList sub) {
        for (Subject subject : sub.getList()) {
            if (subject.getSubjectId().equalsIgnoreCase(code)) {
                return subject;
            }
        }
        return null;
    }

    public static Subject displaySubjectCode(String code, SubjectList sub) {
        for (Subject subject : sub.getList()) {
            if (subject.getSubjectId().equalsIgnoreCase(code)) {
                subject.displaySubject();
            }
        }
        return null;
    }
}
