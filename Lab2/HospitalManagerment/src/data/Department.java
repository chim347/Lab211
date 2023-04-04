package data;

public class Department {

    private String departmentID;
    private String nameDepartment;
    private String createDate;
    private String lastUpdateDate;

    public Department() {
    }

    public Department(String departmentID, String nameDepartment, String createDate, String lastUpdateDate) {
        this.departmentID = departmentID;
        this.nameDepartment = nameDepartment;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
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
        return departmentID + " | " + nameDepartment + " | " + createDate + " | " + lastUpdateDate + " | ";
    }
    
    public void showProfileOneDepartment() {
        System.out.println("|---ID---|------ Name of Department -------|-------- CreateDate --------|-------- LastUpdateDate --------|");
        System.out.printf("|%-8s|%-33s|%-28s|%-32s|\n", departmentID, nameDepartment, createDate, lastUpdateDate);
    }
}
