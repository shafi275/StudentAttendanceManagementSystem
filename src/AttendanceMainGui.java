
import  javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class AttendanceMainGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ArrayList<Faculty> facultyList = new ArrayList<>();
            facultyList.add(new Faculty("f101", "pass123", "dipok", "CS", new String[]{"CS101", "CS102"}));
            facultyList.add(new Faculty("f102", "pass124", "sumon", "IT", new String[]{"IT201", "IT202"}));

            ArrayList<Student> studentList = new ArrayList<>();
            studentList.add(new Student("s001", "pass123", "nisha", "CS"));
            studentList.add(new Student("s002", "pass124", "imran", "IT"));
            studentList.add(new Student("s003", "pass125", "shafi", "CS"));
            studentList.add(new Student("s004", "pass126", "adiba", "IT"));
            studentList.add(new Student("s005", "pass127", "raju", "CS"));

            JFrame frame = new JFrame("Attendance Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 300);
            frame.setLayout(new GridLayout(3, 1));

            JButton studentLoginBtn = new JButton("Student Login");
            JButton facultyLoginBtn = new JButton("Faculty Login");
            JButton exitBtn = new JButton("Exit");

            studentLoginBtn.addActionListener(e -> {
                String uname = JOptionPane.showInputDialog(frame, "Enter Student ID:");
                String pwd = JOptionPane.showInputDialog(frame, "Enter Password:");
                Login studentLogin = new Login("", "");
                int studentIndex = studentLogin.checkCredentials(studentList, uname, pwd);
                if (studentIndex >= 0) {
                    studentList.get(studentIndex).viewAttendance(frame);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid credentials for student!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            facultyLoginBtn.addActionListener(e -> {
                String uname = JOptionPane.showInputDialog(frame, "Enter Faculty ID:");
                String pwd = JOptionPane.showInputDialog(frame, "Enter Password:");
                Login facultyLogin = new Login("", "");
                int facultyIndex = facultyLogin.checkCredentials(facultyList, uname, pwd);
                if (facultyIndex >= 0) {
                    Faculty faculty = facultyList.get(facultyIndex);
                    String subCode = JOptionPane.showInputDialog(frame, "Enter Subject Code:");
                    faculty.markAttendance(subCode, frame);
                    faculty.viewAttendance(subCode, frame);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid credentials for faculty!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            exitBtn.addActionListener(e -> {
                JOptionPane.showMessageDialog(frame, "Exiting Application.", "Info", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            });

            frame.add(studentLoginBtn);
            frame.add(facultyLoginBtn);
            frame.add(exitBtn);

            frame.setVisible(true);
        });
    }
}

