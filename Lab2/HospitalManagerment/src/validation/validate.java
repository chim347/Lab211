package validation;

import java.util.Scanner;

public class validate {

    public static int inputNumber(String msg) throws Exception {
        Scanner sc = new Scanner(System.in);
        int data = 0;
        System.out.print(msg);
        data = sc.nextInt();
        if (data < 0) {
            throw new Exception();
        }
        return data;
    }

    public static String inputName(String msg) {
        Scanner sc = new Scanner(System.in);
        String name = "";
        do {
            System.out.print(msg);
            name = sc.nextLine().trim();
        } while (name.length() < 1);
        return name;
    }

    public static String inputID(String msg) {
        Scanner sc = new Scanner(System.in);
        String data = "";
        do {
            System.out.print(msg);
            data = sc.nextLine().toUpperCase().trim();
        } while (data.length() < 1);
        return data;
    }

    public static String inputNameUpdate(String msg, String oldData) {
        Scanner sc = new Scanner(System.in);
        String name;
        String s;
        System.out.print(msg);
        name = sc.nextLine();
        if (name.isEmpty()) {
            s = oldData;
            System.out.println(s);
        } else {
            s = name;
        }
        return s;
    }

    public static String inputNameDoctorDepartment(String msg) {
        Scanner sc = new Scanner(System.in);
        String data = "";
        String result = "";
        do {
            System.out.print(msg);
            data = sc.nextLine().toLowerCase().trim();
            String arr[] = data.split(" ");
            for (String str : arr) {
                if (!str.equals("")) {
                    result += String.valueOf(str.charAt(0)).toUpperCase() + str.substring(1) + " ";
                }
            }
        } while (data.length() < 1);
        return result.substring(0, result.length() - 1);
    }

    public static String inputUpdateNameDoctor(String msg, String oldData) {
        Scanner sc = new Scanner(System.in);
        String rs = "";
        String data = "";
        String s;
        System.out.print(msg);
        data = sc.nextLine().toLowerCase();
        if (!data.isEmpty()) {
            String arr[] = data.split(" ");
            for (String str : arr) {
                if (!str.equals("")) {
                    rs += String.valueOf(str.charAt(0)).toUpperCase() + str.substring(1) + " ";
                }
            }
            s = rs.substring(0, rs.length() - 1);
        }else {
            s = oldData;
            System.out.println(s);
        }
        return s;
    }

    public static String sexDoctor(String msg) throws Exception {
        Scanner sc = new Scanner(System.in);
        String data = "";
        System.out.print(msg);
        data = sc.nextLine().trim();
        if (!data.equalsIgnoreCase("female") && !data.equalsIgnoreCase("male")) {
            throw new Exception();
        }
        return data;
    }

    public static String sexDoctorUpdate(String msg, String oldData) {
        Scanner sc = new Scanner(System.in);
        String data;
        String s;
        System.out.print(msg);
        data = sc.nextLine();
        if (!data.equalsIgnoreCase("female") && !data.equalsIgnoreCase("male") || data.isEmpty()) {
            s = oldData;
            System.out.println(s);
        } else {
            s = data;
        }
        return s;
    }

    public static String inputYesNo(String msg) {
        Scanner sc = new Scanner(System.in);
        String data = "";
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();
        } while (!data.equalsIgnoreCase("Yes") && !data.equalsIgnoreCase("No"));
        return data;
    }

}
