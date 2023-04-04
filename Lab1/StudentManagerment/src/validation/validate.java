package validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Calendar;
import java.util.Scanner;

public class validate {

    public static int inputNumber(String msg) throws Exception {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        System.out.print(msg);
        num = sc.nextInt();
        if (num < 0) {
            throw new Exception();
        }
        return num;
    }

    // input id, name
    public static String inputNonBlankStr(String msg) {
        Scanner sc = new Scanner(System.in);
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();
        } while (data.length() < 1);
        return data;
    }

    //input name Student
    public static String inputName(String msg) {
        Scanner sc = new Scanner(System.in);
        String data = "";
        String result = "";
        do {
            System.out.print(msg);
            data = sc.nextLine().toLowerCase().trim();
            String[] arr = data.split(" ");
            for (String x : arr) {
                if (!x.equals("")) {
                    result += String.valueOf(x.charAt(0)).toUpperCase() + x.substring(1) + " ";
                }
            }
        } while (data.length() < 1);
        return result.substring(0, result.length() - 1);
    }

    public static String inputGenderOfStudent(String smg) throws Exception {
        Scanner sc = new Scanner(System.in);
        String data;
        System.out.print(smg);
        data = sc.nextLine().trim();
        if (!data.equalsIgnoreCase("Female") && !data.equalsIgnoreCase("Male")) {
            throw new Exception();
        }
        return data;
    }

    public static boolean isValidDate(String date) {
        boolean valid;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        try {
            // ResolverStyle.STRICT for 30, 31 days checking, and also leap year.
            LocalDate.parse(date, DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT));
            if (Integer.parseInt(date.split("-")[0]) < 1900 || Integer.parseInt(date.split("-")[0]) > currentYear) {
                valid = false;
            } else {
                valid = true;
            }
        } catch (DateTimeParseException e) {
            //e.printStackTrace();
            valid = false;
        }
        return valid;
    }

    public static String inputEmail(String msg) {
        Scanner sc = new Scanner(System.in);
        boolean flag;
        String em = "";
        do {
            String email = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
            System.out.print(msg);
            em = sc.nextLine().trim();
            flag = em.matches(email);
            if (!flag) {
                System.out.println("invalid");
            }
        } while (!flag);
        return em;
    }

    public static String inputPhoneNumber(String phone) {
        Scanner sc = new Scanner(System.in);
        boolean flag;
        String ph;
        do {
            String phoneNumber = "[0-9]{10,12}";
            System.out.print(phone);
            ph = sc.nextLine().trim();
            flag = ph.matches(phoneNumber);
            if (!flag) {
                System.out.println("invalid");
            }
        } while (!flag);
        return ph;
    }

    public static String inputString(String msg) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        String name = sc.nextLine().trim();
        if (name.isEmpty()) {
            throw new Exception();
        }
        return name;
    }

    public static int inputCredit(String msg) throws Exception {
        Scanner sc = new Scanner(System.in);
        int cre;
        System.out.print(msg);
        cre = sc.nextInt();
        if (cre < 1 || cre > 5) {
            throw new Exception();
        }
        return cre;
    }

    public static double inputMark(String msg) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        double mark = 0;
        mark = sc.nextDouble();
        if (mark < 0.0 || mark > 10.0) {
            throw new Exception();
        }
        return mark;
    }

    public static String inputYesNo(String smg) throws Exception {
        Scanner sc = new Scanner(System.in);
        String data;
        System.out.print(smg);
        data = sc.nextLine().trim();
        if (!data.equalsIgnoreCase("Yes") && !data.equalsIgnoreCase("No")) {
            throw new Exception();
        }
        return data;
    }

    // validate for updateStudent and Subject
    public static String inputUpdateGenderOfStudent(String smg, String oldData) {
        Scanner sc = new Scanner(System.in);
        String s;
        System.out.print(smg);
        String data = sc.nextLine();
        if (!data.equalsIgnoreCase("Female") && !data.equalsIgnoreCase("Male") || data.isEmpty()) {
            s = oldData;
            System.out.println(s);
        } else {
            s = data;
        }
        return s;
    }

    public static String inputUpdateStringSubject(String newData, String oldData) {
        Scanner sc = new Scanner(System.in);
        String s;
        String data = "";
        System.out.print(newData);
        data = sc.nextLine();
        if (!data.isEmpty()) {
            s = data;
        } else {
            s = oldData;
            System.out.println(s);
        }
        return s;
    }

    public static String inputNameStudentUpdate(String msg, String oldData) {
        Scanner sc = new Scanner(System.in);
        String data = "";
        String result = "";
        String s;
        System.out.print(msg);
        data = sc.nextLine().toLowerCase();
        if (!data.isEmpty()) {
            String[] arr = data.split(" ");
            for (String x : arr) {
                if (!x.equals("")) {
                    result += String.valueOf(x.charAt(0)).toUpperCase() + x.substring(1) + " ";
                }
            }
            s = result.substring(0, result.length() - 1);
        } else {
            s = oldData;
            System.out.println(s);
        }
        return s;
    }

    public static String inputUpdateEmail(String msg, String oldData) {
        Scanner sc = new Scanner(System.in);
        boolean flag;
        String em = "";
        String s;
        String email = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        System.out.print(msg);
        em = sc.nextLine().trim();
        flag = em.matches(email);
        if (flag) {
            s = em;
        } else {
            s = oldData;
            System.out.println(s);
        }
        return s;
    }

    public static String inputUpdatePhoneNumberStudent(String phone, String oldData) {
        Scanner sc = new Scanner(System.in);
        boolean flag;
        String s;

        String phoneNumber = "[0-9]{10,12}";
        System.out.print(phone);
        String ph = sc.nextLine().trim();
        flag = ph.matches(phoneNumber);
        if (flag) {
            s = ph;
        } else {
            s = oldData;
            System.out.println(s);
        }
        return s;
    }
    
    public static boolean checkCreditRange(int credit) {
        if (credit < 1 || credit > 5) return false;
        return true;
    }
}
