package main;

import data.DepartmentList;
import data.DoctorList;
import data.InputHopitalManagerment;

public class MenuProgram {

    public static void main(String[] args) {
        String docFilename = "doctor.dat";
        String depFilename = "depart.dat";

        DoctorList hashDoctor = new DoctorList();
        DepartmentList hashDepart = new DepartmentList();

        InputHopitalManagerment hopital = new InputHopitalManagerment(hashDoctor, hashDepart);

        String[] options = {"Show All", "Add New", "Update Information", "Delete", "Search Information", "Store Data to File"};
        String[] showOptions = {"Show Doctor List", "Show Department List"};
        String[] addOptions = {"Add New Doctor", "Add New Department"};
        String[] updateOptions = {"Update Information Doctor", "Update Information Department"};
        String[] deleteOptions = {"Delete Doctor", "Delete Department"};
        String[] searchOptions = {"Search Information Doctor By Name", "Search Information Department By ID"};
        String[] saveOptions = {"Save Doctor to File .dat", "Save Department to File .dat"};

        int choice;
        do {
            System.out.println("\n~~~~~~~ HOPITAL MANAGEMENT ~~~~~~~");
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1: {
                    System.out.println("\nShow All");
                    int getSubChoice = Menu.getChoice(showOptions);
                    switch (getSubChoice) {
                        case 1:
                            try {
                            hopital.loadDataDoctor(docFilename);
                        } catch (Exception e) {
                            System.out.println("error");
                        }
                        hopital.showProfileDoctor();
                        break;
                        case 2:
                            try {
                            hopital.loadDataDepartment(depFilename);
                        } catch (Exception e) {
                            System.out.println("error");
                        }
                        hopital.showProfileDepart();
                        break;
                    }
                    break;
                }
                case 2: {
                    System.out.println("\nAdd New");
                    int getSubChoice = Menu.getChoice(addOptions);
                    switch (getSubChoice) {
                        case 1:
                            hopital.createDoctor();
                            break;
                        case 2:
                            hopital.createDepartment();
                    }
                    break;
                }
                case 3: {
                    System.out.println("\nUpdate Information");
                    int getSubChoice = Menu.getChoice(updateOptions);
                    switch (getSubChoice) {
                        case 1:
                            hopital.updateDoctor();
                            break;
                        case 2:
                            hopital.updateDepartment();
                            break;
                    }
                    break;
                }
                case 4: {
                    System.out.println("\nDelete");
                    int getSubChoice = Menu.getChoice(deleteOptions);
                    switch (getSubChoice) {
                        case 1:
                            hopital.deleteDoctor();
                            break;
                        case 2:
                            hopital.deleteDepartment();
                            break;
                    }
                    break;
                }
                case 5: {
                    System.out.println("\nSearch Information");
                    int getSubChoice = Menu.getChoice(searchOptions);
                    switch (getSubChoice) {
                        case 1:
                            hopital.searchInformationDoctor();
                            break;
                        case 2:
                            hopital.searchInformationDepartment();
                            break;
                    }
                    break;
                }
                case 6: {
                    System.out.println("\nStore Data to File");
                    int getSubChoice = Menu.getChoice(saveOptions);
                    switch (getSubChoice) {
                        case 1:
                            hopital.initDoctor(docFilename);
                            break;
                        case 2:
                            hopital.initDepart(depFilename);
                            break;
                    }
                    break;
                }
            }
        } while (choice > 0 && choice < 7);
    }
}
