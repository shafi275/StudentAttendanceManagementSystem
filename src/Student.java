import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class Student extends Login {
    String sname, course;
    ArrayList<Subject> subjects = new ArrayList<>();

    Student(String id, String pass, String sname, String course) {
        super(id, pass);
        this.sname = sname;
        this.course = course;

        if (course.equals("CS")) {
            subjects.add(new Subject("CS101", "Data Structures", this));
            subjects.add(new Subject("CS102", "Algorithms", this));
        } else if (course.equals("IT")) {
            subjects.add(new Subject("IT201", "Networking", this));
            subjects.add(new Subject("IT202", "Databases", this));
        }
    }

    @Override
    public String toString() {
        return getId() + " (" + sname + ")";
    }

    void viewAttendance(JFrame frame) {
        StringBuilder attendanceDetails = new StringBuilder("CODE | SUB_NAME | TOTAL_DAYS | DAYS_PRESENT | DAYS_ABSENT | PERCENTAGE\n");
        attendanceDetails.append("-------------------------------------------------------------\n");
        for (Subject subject : subjects) {
            attendanceDetails.append(subject).append("\n");
        }

        JTextArea textArea = new JTextArea(attendanceDetails.toString());
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(frame, scrollPane, "Attendance Details", JOptionPane.INFORMATION_MESSAGE);
    }
}
