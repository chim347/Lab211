package data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import validation.validate;
import static validation.validate.isValidDate;

public class StudentList {

    private final ArrayList<Student> list;

    public StudentList() {
        super();
        list = new ArrayList<>();
    }

    public ArrayList<Student> getList() {
        return list;
    }

    public void addStudent() {
        boolean flag = false;
        Student stu = new Student();
        String id;
        String firstName;
        String lastName;
        String gender = "";
        LocalDate dateOfBirth;
        String email;
        String phoneNumber;

        do {
            id = validate.inputNonBlankStr("Input id of Student: ");
            if (checkId(id)) {
                System.out.println("duplicated");
            }
        } while (checkId(id));

        firstName = validate.inputName("Intput first name student: ");

        lastName = validate.inputName("Input last name student: ");

        do {
            try {
                gender = validate.inputGenderOfStudent("Input gender of student: ");
                flag = false;
            } catch (Exception e) {
                System.out.println("error!!! please try again");
                flag = true;
            }
        } while (flag);

        String date = null;
        do {
            date = validate.inputNonBlankStr("Student date of Birth (uuuu-MM-dd): ");
            if (!isValidDate(date)) {
                System.out.println("Invald Date");
            }
        } while (!isValidDate(date));
        dateOfBirth = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);

        email = validate.inputEmail("Input email of Student: ");

        phoneNumber = validate.inputPhoneNumber("input phone number of Student: ");
        list.add(new Student(id, firstName, lastName, gender, dateOfBirth, email, phoneNumber));
    }

    public boolean checkId(String id) {
        return search(id) != null;
    }

    public Student search(String id) {
        for (Student x : list) {
            if (x.getId().equalsIgnoreCase(id)) {
                return x;
            }
        }
        return null;
    }

    public void displayAll() {
        System.out.println("|++ Student ID ++|++First Name++|++Last Name++|++ Gender ++|++ Date Of Birth ++|++++++++++ Email ++++++++++|+++ Phone Number +++|");
        for (Student o : list) {
            System.out.printf("|%-16s|%-14s|%-13s|%-12s|%19s|%-27s|%20s|\n", o.getId(), o.getFirstName(), o.getLastName(), o.getGender(), o.getDateOfBirth(), o.getEmail(), o.getPhoneNumber());
        }
    }

    public void updateStudent() {
        boolean check = false;

        System.out.println("========    Update Student    ========");
        int key = 0;
        do {
            System.out.println("     1. Update Student");
            System.out.println("     2. Delete Student");
            System.out.println("     3. Enter to printAll");
            try {
                key = validate.inputNumber("Input your choice update student: ");
            } catch (Exception e) {
                System.out.println("errror");
            }
            switch (key) {
                case 1:
                    String idm1 = "";
                    while (true) {
                        idm1 = validate.inputNonBlankStr("Find student id Student you want update: ");
                        if (!checkId(idm1)) {
                            System.out.println("Student id does not exist");
                        } else {
                            System.out.println("Student id exist");
                            search(idm1).displayStudent();
                            String flag = "";
                            flag = validate.inputNonBlankStr("Do you want update student (Yes/No)?: ");
                            if (flag.equalsIgnoreCase("Yes")) {
                                updateStudentList(idm1);
                                System.out.println("=====  Update Success  =====");
                            } else {
                                System.out.println("======   Update Fail   ======");
                            }
                        }
                        String userChoice = "";
                        userChoice = validate.inputNonBlankStr("Do you want to update more student [Yes/No]?: ");
                        if (userChoice.equalsIgnoreCase("No")) {
                            break;
                        }
                    }
                    break;

                case 2:
                    String id1 = "";
                    String flag = "";
                    do {
                        id1 = validate.inputNonBlankStr("Input id to need delete Student: ");
                        if (!checkId(id1)) {
                            System.out.println("Student ID does not exist");
                        } else {
                            System.out.println("Student ID exist!!!!");
                            search(id1).displayStudent();
                            flag = validate.inputNonBlankStr("Do you want delete subject Yes/No: ");
                            if (flag.equalsIgnoreCase("Yes")) {
                                deleteStudent(id1);
                                System.out.println("====  Delete Success  ====");
                            } else {
                                System.out.println("====  Cancel Delete  ====");
                            }
                        }
                        String check1 = "";
                        check1 = validate.inputNonBlankStr("Do you want delete to more time? (Yes/No): ");
                        if (check1.equalsIgnoreCase("No")) {
                            break;
                        }
                    } while (true);
                    break;
            }
        } while (key <= 2);

    }

    public void updateStudentList(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id)) {

                String firstName;
                firstName = validate.inputNameStudentUpdate("Input NEW first name of student: ", list.get(i).getFirstName());
                list.get(i).setFirstName(firstName);
                String lastName;
                lastName = validate.inputNameStudentUpdate("input NEW last name of student: ", list.get(i).getLastName());
                list.get(i).setLastName(lastName);

                String gender = "";
                gender = validate.inputUpdateGenderOfStudent("Input NEW gender of student: ", list.get(i).getGender());
                list.get(i).setGender(gender);

                LocalDate dateOfBirth;
                String date;
                Scanner sc = new Scanner(System.in);
                do {
                    System.out.print("Input NEW Student date of birth (yyyy-mm-dd): ");
                    date = sc.nextLine();
                    if (date.isEmpty()) {
                        System.out.println(list.get(i).getDateOfBirth());
                        break;
                    }
                    if (!isValidDate(date)) {
                        System.out.println("Invalid date off birth");
                    }
                } while (!isValidDate(date));
                if (!date.isEmpty()) {
                    dateOfBirth = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
                    list.get(i).setDateOfBirth(dateOfBirth);
                }

                String email;
                email = validate.inputUpdateEmail("Input NEW email of student: ", list.get(i).getEmail());
                list.get(i).setEmail(email);

                String phone;
                phone = validate.inputUpdatePhoneNumberStudent("Input NEW phone number of student: ", list.get(i).getPhoneNumber());
                list.get(i).setPhoneNumber(phone);
            }
        }
    }

    public void deleteStudent(String id) {
        Student stu = new Student();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id)) {
                stu = list.get(i);
            }
        }
        if (stu != null) {
            list.remove(stu);
        } else {
            System.out.println("not existed");
        }
    }

    public static Student valueOfStudent(String id, StudentList x) {
        for (Student student : x.getList()) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }
        return null;
    }

    public static Student displayStudent(String id, StudentList x) {
        for (Student o : x.getList()) {
            if (o.getId().equalsIgnoreCase(id)) {
                o.displayStudent();
            }
        }
        return null;
    }

}
