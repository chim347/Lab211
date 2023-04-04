package data;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;

public class DepartmentList extends HashMap<String, Department> {

    public DepartmentList() {
    }

    public void writeData(String filename, HashMap<String, Department> depart) throws Exception {
        PrintWriter w = new PrintWriter(filename);
        Collection<Department> values = depart.values();
        for (Department d : values) {
            if (d != null) {
                w.println(d);
            }
        }
        w.close();
    }
}
