import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class Faculty extends Login {
    String fname, dept;
    String[] subjects;

    Faculty(String id, String pass, String fname, String dept, String[] subjects) {
        super(id, pass);
        this.fname = fname;
        this.dept = dept;
        this.subjects = subjects;
    }

    void markAttendance(String subCode, JFrame frame) {
        if (!Arrays.asList(subjects).contains(subCode)) {
            JOptionPane.showMessageDialog(frame, "Incorrect Subject Code!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ArrayList<Student> studentList = Subject.subStudDict.get(subCode);
        if (studentList == null || studentList.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No students found for the subject.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        for (Student student : studentList) {
            for (Subject subject : student.subjects) {
                if (subject.getSubCode().equals(subCode)) {
                    boolean valid = false;
                    while (!valid) {
                        String input = JOptionPane.showInputDialog(frame, student + " - Present/Absent (1=Present, 0=Absent):");
                        if (input == null) return; // If cancel is clicked
                        try {
                            int attend = Integer.parseInt(input);
                            if (attend != 1 && attend != 0) throw new AttendanceValueException();
                            subject.att.totalDays++;
                            if (attend == 1) subject.att.present++;
                            else subject.att.absent++;
                            valid = true; // Valid input, break the loop
                        } catch (AttendanceValueException e) {
                            JOptionPane.showMessageDialog(frame, e.getMessage(), "Invalid Input", JOptionPane.WARNING_MESSAGE);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(frame, "Please enter a valid number (1 or 0).", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(frame, "Attendance marked successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    void viewAttendance(String subCode, JFrame frame) {
        if (!Arrays.asList(subjects).contains(subCode)) {
            JOptionPane.showMessageDialog(frame, "Incorrect Subject Code!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ArrayList<Student> studentList = Subject.subStudDict.get(subCode);
        if (studentList == null || studentList.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No attendance records found.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder attendanceDetails = new StringBuilder("REG.NO | TOTAL_DAYS | DAYS PRESENT | DAYS ABSENT | PERCENTAGE\n");
        attendanceDetails.append("-------------------------------------------------------------\n");

        for (Student student : studentList) {
            for (Subject subject : student.subjects) {
                if (subject.getSubCode().equals(subCode)) {
                    attendanceDetails.append(student).append("\t\t").append(subject.getAttendance()).append("\n");
                }
            }
        }

        JTextArea textArea = new JTextArea(attendanceDetails.toString());
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(frame, scrollPane, "Attendance Details", JOptionPane.INFORMATION_MESSAGE);
    }
}

