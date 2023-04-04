package main;

import validation.validate;

public class Menu<T> {

    public static int getChoice(Object[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + " ." + options[i]);
        }
        int number = 0;
        boolean flag = false;
        do {
            try {
                number = validate.inputNumber("Enter your choice: ");
                flag = false;
            } catch (Exception e) {
                System.out.println("Error!! choice again.");
                flag = true;
            }
        } while (flag);
        return number;
    }
    
}
