
package data;



public class Doctor {
    private String dotorID;
    private String name;
    private String sex;
    private String address;
    private String departmentID;
    private String createDate;
    private String lastUpdateDate;

    public Doctor() {
    }

    public Doctor(String dotorID, String name, String sex, String address, String departmentID, String createDate, String lastUpdateDate) {
        this.dotorID = dotorID;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.departmentID = departmentID;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getDotorID() {
        return dotorID;
    }

    public void setDotorID(String dotorID) {
        this.dotorID = dotorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public String toString() {
        return dotorID + " | " + name + " | " + sex + " | " + address + " | " + departmentID + " | " + createDate + " | " + lastUpdateDate + " |";
    }
    
    public void showProfileOneDoctor() {
        System.out.println("|---ID---|------ Name of Doctor -------|--- SEX ---|-------- Address  -------|--- DepartmentID ---|-------- CreateDate --------|-------- LastUpdateDate --------|");
        System.out.printf("|%-8s|%-29s|%-11s|%-25s|%-20s|%-28s|%-32s|\n", dotorID, name, sex, address, departmentID, createDate, lastUpdateDate);
    }
    
}
