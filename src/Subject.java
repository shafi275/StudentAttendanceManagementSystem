import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
 public class Subject {
    private String scode, sname;
    Attendance att = new Attendance();
    public static Map<String, ArrayList<Student>> subStudDict = new HashMap<>();

    Subject(String scode, String sname, Student student) {
        this.scode = scode;
        this.sname = sname;
        subStudDict.computeIfAbsent(scode, k -> new ArrayList<>()).add(student);
    }

    String getSubCode() {
        return scode;
    }

    Attendance getAttendance() {
        return att;
    }

    @Override
    public String toString() {
        return scode + " | " + sname + "\t\t\t " + att;
    }
}

