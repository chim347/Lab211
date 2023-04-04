package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;
import validation.validate;

public class InputHopitalManagerment {

    DoctorList hashDoctor;
    DepartmentList hashDepart;

    public InputHopitalManagerment() {
        hashDoctor = new DoctorList();
        hashDepart = new DepartmentList();
    }

    public InputHopitalManagerment(DoctorList hashDoctor, DepartmentList hashDepart) {
        this.hashDoctor = hashDoctor;
        this.hashDepart = hashDepart;
    }

    public void createDoctor() {
        boolean flag = false;
        while (true) {
            String id;
            do {
                id = validate.inputID("input ID of doctor: ");
                if (checkID(id)) {
                    System.out.println("duplicated!!!!!");
                }
            } while (checkID(id));

            String name;
            name = validate.inputNameDoctorDepartment("input name of doctor: ");

            String sex = "";
            do {
                try {
                    sex = validate.sexDoctor("input sex for doctor: ");
                    flag = false;
                } catch (Exception e) {
                    System.out.println("error!! Try again bro.");
                    flag = true;
                }
            } while (flag);

            String address = "";
            address = validate.inputName("Input address of doctor: ");

            String departmentID = "";
            do {
                departmentID = validate.inputID("innput id of department: ");
                if (!depatSearchID(departmentID)) {
                    System.out.println("The department ID is not existed in the department list. "
                            + "Input another one!");
                    
                }
            } while (!depatSearchID(departmentID));

            LocalDateTime date = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
            String createDate = date.format(formatter);
            System.out.println(createDate);

            String lastUpdateDate = "";

            hashDoctor.put(id, new Doctor(id, name, sex, address, departmentID, createDate, lastUpdateDate));
            System.out.println("Add Succesfully!!!");
            String userChoice;
            userChoice = validate.inputYesNo("Do you want to ADD more student [Yes/No]?: ");
            if (userChoice.equalsIgnoreCase("No")) {
                break;
            }
        }
    }

    public Doctor searchDoctorID(String id) {
        return hashDoctor.get(id);
    }

    // cách 1 duyệt id
    public boolean checkID(String id) {
        if (hashDoctor.containsKey(id)) {
            return true;
        }
        return false;
    }

    //cách 2 duyệt id bằng fore
    public boolean depatSearchID(String id) {
        Collection<Department> depart = hashDepart.values();
        for (Department x : depart) {
            if (x.getDepartmentID().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public void updateDoctor() {
        boolean flag = false;
        while (true) {
            String id;
            id = validate.inputID("input ID of doctor to need find: ");
            if (!hashDoctor.containsKey(id)) {
                System.out.println("ID not found!!!!!");
                return;
            }

            String name;
            name = validate.inputUpdateNameDoctor("input NEW name of doctor: ", this.hashDoctor.get(id).getName());
            this.hashDoctor.get(id).setName(name);

            String sex;
            sex = validate.sexDoctorUpdate("input NEW sex for doctor: ", this.hashDoctor.get(id).getSex());
            this.hashDoctor.get(id).setSex(sex);

            String address;
            address = validate.inputNameUpdate("Input NEW address of doctor: ", this.hashDoctor.get(id).getAddress());
            this.hashDoctor.get(id).setAddress(address);

            String departmentID;
            departmentID = validate.inputNameUpdate("innput NEW id of department: ", this.hashDoctor.get(id).getDepartmentID());
            if (depatSearchID(departmentID)) {
                this.hashDoctor.get(id).setDepartmentID(departmentID);
            } else {
                System.out.println("The department ID is not existed in the department list. "
                        + "Get old data!!");
                this.hashDoctor.get(id).getDepartmentID();
            }

            String createDate = "";
            if (createDate.isEmpty()) {
                this.hashDoctor.get(id).getCreateDate();
            }

            LocalDateTime lastDate = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
            String lastUpdateDate = lastDate.format(formatter);
            if (!lastUpdateDate.isEmpty()) {
                this.hashDoctor.get(id).setLastUpdateDate(lastUpdateDate);
            }

            System.out.println("Update Doctor Successfully!!!");
            showProfileDoctor();

            String userChoice;
            userChoice = validate.inputYesNo("Do you want to update more doctor [Yes/No]?: ");
            if (userChoice.equalsIgnoreCase("No")) {
                break;
            }
        }
    }

    public void deleteDoctor() {
        while (true) {
            String id;
            id = validate.inputID("Input ID of Doctor find to need DELETE: ");
            if (!hashDoctor.containsKey(id)) {
                System.out.println("ID not found!!!");
                return;
            }
            System.out.println("Doctor exist");
            System.out.println(hashDoctor.get(id).toString());
            String flag = validate.inputYesNo("Are you sure DELETE doctor Yes/No: ");
            if (flag.equalsIgnoreCase("Yes")) {
                hashDoctor.remove(id);
                System.out.println("Delete Doctor Successfully!!!");
                showProfileDoctor();
            } else {
                System.out.println("~~~~DELETE Cancel~~~~");
            }

            String userChoice = validate.inputYesNo("Do you want to delete more doctor [Yes/No]?: ");
            if (userChoice.equalsIgnoreCase("No")) {
                break;
            }
        }

    }

    // cách 1
    public void searchInformationDoctor1() {
        String nameDoctor;
        boolean flag = false;
        nameDoctor = validate.inputNameDoctorDepartment("input name of Docotr want to show profile: ");
        for (String str : this.hashDoctor.keySet()) {
            String key = str;
            if (this.hashDoctor.get(key).getName().equalsIgnoreCase(nameDoctor)) {
                System.out.println(this.hashDoctor.get(key).toString());
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Doctor does not exist");
        }
    }

//    private ArrayList<String> searchNameDoctor(String name) {
//        String arr[] = name.split(" ");
//        Collection<Doctor> dtlist = hashDoctor.values();
//        String rs = "";
//        for (String str : arr) {
//            rs += String.valueOf(str.charAt(0)) + str.substring(1) + " ";
//            return rs.substring(0 , rs.length() - 1);
//        }
//    }
    // cách 2
    public void searchInformationDoctor() {
        Collection<Doctor> docList = hashDoctor.values();
        String nameDoctor;
        boolean flag = false;
        nameDoctor = validate.inputName("input name of Docotr want to show profile: ");
//        System.out.println("|---ID---|------ Name of Doctor -------|--- SEX ---|-------- Address  -------|--- DepartmentID ---|-------- CreateDate --------|-------- LastUpdateDate --------|");
        for (Doctor doctor : docList) {
            if(doctor.getName().contains(nameDoctor)) {
//                doctor.showProfileOneDoctor();
                System.out.println(doctor);
            }
            flag = true;
        }
        
        if (flag == false) {
            System.out.println("Doctor does not exist");
        }
    }

    public void showProfileDoctor() {
        Collection<Doctor> dt = hashDoctor.values();
        System.out.println("=========  DOCTOR LIST  ==========");
        System.out.println("|---ID---|------ Name of Doctor -------|--- SEX ---|-------- Address  -------|--- DepartmentID ---|-------- CreateDate --------|-------- LastUpdateDate --------|");
        for (Doctor doctor : dt) {
            System.out.printf("|%-8s|%-29s|%-11s|%-25s|%-20s|%-28s|%-32s|\n", doctor.getDotorID(), doctor.getName(), doctor.getSex(), doctor.getAddress(), doctor.getDepartmentID(), doctor.getCreateDate(), doctor.getLastUpdateDate());
//            System.out.println(doctor.toString());
        }
    }

    public void createDepartment() {
        String departmentID = "";
        while (true) {
            do {
                departmentID = validate.inputID("Input Code department: ");
                if (checkCodeDepartment(departmentID)) {
                    System.out.println("Code department duplicated!!!");
                }
            } while (checkCodeDepartment(departmentID));

            String nameDepartment = "";
            nameDepartment = validate.inputNameDoctorDepartment("Input name department: ");

            LocalDateTime date = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
            String createDate = formatter.format(date);
            System.out.println(createDate);

            String lastUpdateDate = "";

            hashDepart.put(departmentID, new Department(departmentID, nameDepartment, createDate, lastUpdateDate));
            System.out.println("Add Department Successfully!!!");

            String userChocie;
            userChocie = validate.inputYesNo("Do you want to ADD more department [Yes/No]?: ");
            if (userChocie.equalsIgnoreCase("No")) {
                break;
            }
        }
    }

    public void updateDepartment() {
        while (true) {
            String departmentID = "";
            departmentID = validate.inputID("Input code Department need to find Update: ");
            if (!this.hashDepart.containsKey(departmentID)) {
                System.out.println("code Department not to found!!!");
                return;
            }

            String nameDepartment;
            nameDepartment = validate.inputUpdateNameDoctor("Input NEW name department: ", this.hashDepart.get(departmentID).getNameDepartment());
            this.hashDepart.get(departmentID).setNameDepartment(nameDepartment);

            String createDate = "";
            if (createDate.isEmpty()) {
                this.hashDepart.get(departmentID).getCreateDate();
            }
            LocalDateTime date = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
            String lastUpdateDate = date.format(formatter);
            if (!lastUpdateDate.isEmpty()) {
                this.hashDepart.get(departmentID).setLastUpdateDate(lastUpdateDate);
            }
            System.out.println("Update Department Successfully");
            showProfileDepart();

            String userChoice;
            userChoice = validate.inputYesNo("Do you want to UPDATE more department [Yes/No]?: ");
            if (userChoice.equalsIgnoreCase("No")) {
                break;
            }
        }
    }

    public boolean checkDoctorHaveDepartment(String id) {
        for (String str : hashDoctor.keySet()) {
            if (hashDoctor.get(str).getDepartmentID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void deleteDepartment() {
        while (true) {
            String departmentID;
            departmentID = validate.inputID("Input ID department need to DELETE: ");
            if (checkDoctorHaveDepartment(departmentID)) {
                System.out.println("Doctor have id Department, you must delete all doctor depend DepartmentID ");
            } else {
                if (!this.hashDepart.containsKey(departmentID)) {
                    System.out.println("Not exist Department");
                    return;
                }
                System.out.println("Exist Department!!!");
                System.out.println(hashDepart.get(departmentID).toString());
                String flag = validate.inputYesNo("Are you sure DELETE doctor Yes/No: ");
                if (flag.equalsIgnoreCase("Yes")) {
                    hashDepart.remove(departmentID);
                    System.out.println("------- DELETE Successfully -------");
                    showProfileDepart();
                } else {
                    System.out.println("-------- CANCEL DELETE DEPARTMENT --------");
                }
            }
            String userChoice = validate.inputYesNo("Do you want to DELETE more department [Yes/No]?: ");
            if (userChoice.equalsIgnoreCase("No")) {
                break;
            }
        }
    }

    // funtion5:
    public void searchInformationDepartment() {
        String departmentID;
        departmentID = validate.inputID("Search ID department need to showProfile: ");
        if (!checkCodeDepartment(departmentID)) {
            System.out.println("Department not exist");
        } else {
            searchCodeDepartment(departmentID).showProfileOneDepartment();
        }
    }

    public void showProfileDepart() {
        Collection<Department> dp = hashDepart.values();
        System.out.println("=========  DEPARTMENT LIST  ==========");
        System.out.println("|---ID---|------ Name of Department -------|-------- CreateDate --------|-------- LastUpdateDate --------|");
        for (Department depart : dp) {
            System.out.printf("|%-8s|%-33s|%-28s|%-32s|\n", depart.getDepartmentID(), depart.getNameDepartment(), depart.getCreateDate(), depart.getLastUpdateDate());
//            System.out.println(depart.toString());
        }
    }

    public Department searchCodeDepartment(String id) {
        return this.hashDepart.get(id);
    }

    public boolean checkCodeDepartment(String id) {
        if (this.hashDepart.containsKey(id)) {
            return true;
        }
        return false;
    }

    public void initDoctor(String filename) {
        try {
            hashDoctor.writeData(filename, hashDoctor);
            System.out.println("done!!!");
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public void initDepart(String filename) {
        try {
            hashDepart.writeData(filename, hashDepart);
            System.out.println("done!!!");
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public void loadDataDoctor(String filename) throws Exception {
        FileReader f = new FileReader(filename);
        BufferedReader bf = new BufferedReader(f);
        String line;
        while (((line = bf.readLine()) != null)) {
            StringTokenizer stk = new StringTokenizer(line, "|");
            String dotorID = stk.nextToken().trim();
            String name = stk.nextToken().trim();
            String sex = stk.nextToken().trim();
            String address = stk.nextToken().trim();
            String departmentID = stk.nextToken().trim();
            String createDate = stk.nextToken().trim();
            String lastUpdateDate = stk.nextToken().trim();
            Doctor newDoc = new Doctor(dotorID, name, sex, address, departmentID, createDate, lastUpdateDate);
            hashDoctor.put(dotorID, newDoc);
        }
        System.out.println("Completed");
        bf.close();
        f.close();
    }

    public void loadDataDepartment(String filename) throws Exception {
        FileReader f = new FileReader(filename);
        BufferedReader bf = new BufferedReader(f);
        String line;
        while (((line = bf.readLine()) != null)) {
            StringTokenizer stk = new StringTokenizer(line, "|");
            String departmentID = stk.nextToken().trim();
            String nameDepartment = stk.nextToken().trim();
            String createDate = stk.nextToken().trim();
            String lastUpdateDate = stk.nextToken().trim();
            Department newDep = new Department(departmentID, nameDepartment, createDate, lastUpdateDate);
            hashDepart.put(departmentID, newDep);
        }
        System.out.println("Completed");
        bf.close();
        f.close();
    }

}
