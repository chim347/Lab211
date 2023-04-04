package studentmanagerment;

import data.StudentList;
import data.Student;
import data.SubjectList;
import data.TranscriptList;
import validation.validate;

public class StudentManagerment {

    public static void main(String[] args) {
        int choice = 0;
        StudentList my = new StudentList();
        SubjectList subject = new SubjectList();
        TranscriptList list = new TranscriptList();
        do {
            System.out.println("1. Add new student");
            System.out.println("2. Update student");
            System.out.println("   2.1 Update Student");
            System.out.println("   2.2 Delete Student");
            System.out.println("3. Add new Subject");
            System.out.println("4. Update Subject");
            System.out.println("   4.1 Update Subject");
            System.out.println("   4.2 Delete Subject");
            System.out.println("5. Enter Grade");
            System.out.println("6. Student Grade Report");
            System.out.println("7. Subject Grade Report");
            System.out.println("8. Other - Quit");
            boolean flag = false;
            do {
                try {
                    choice = validate.inputNumber("Number you want to choice is: ");
                    flag = false;
                } catch (Exception e) {
                    System.out.println("error");
                    flag = true;
                }
            } while (flag);
            switch (choice) {
                case 1:
                    my.addStudent();
                    my.displayAll();
                    break;
                case 2:
                    my.updateStudent();
                    my.displayAll();
                    break;
                case 3:
                    subject.addSubject();
                    subject.display();
                    break;
                case 4:
                    subject.updateSubjectList();
                    subject.display();
                    break;
                case 5:
                    list.addTranscript(my, subject);
                    break;
                case 6:
                    list.displayStudentTranscript(my);
                    break;
                case 7:
                    list.displaySubjectTranscript(subject);
                    break;
            }
        } while (choice <= 7);

    }

}
