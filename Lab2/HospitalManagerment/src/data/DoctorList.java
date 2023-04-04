package data;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;


public class DoctorList extends HashMap<String, Doctor> {

    public DoctorList() {
    }

    public void writeData(String filename, HashMap<String, Doctor> dtList) throws Exception {
        File f = new File(filename);
        FileWriter fw = new FileWriter(f);
        PrintWriter w = new PrintWriter(fw);
        Collection<Doctor> values = dtList.values();
        for (Doctor t : values) {
            if (t != null) {
                w.println(t);
            }
        }
        w.close();
        fw.close();
    }
}
