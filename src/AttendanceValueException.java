import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class AttendanceValueException extends Exception {
    AttendanceValueException() {
        super("Invalid attendance value. Only 0 (Absent) or 1 (Present) allowed.");
    }
}
