import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Attendance {
    public int totalDays, present, absent;
    float percentage;

    Attendance() {
        totalDays = 0;
        present = 0;
        absent = 0;
        percentage = 0;
    }

    float getPercentage() {
        if (totalDays == 0) return 0; // Avoid division by zero
        percentage = ((float) present / totalDays) * 100;
        return percentage;
    }

    @Override
    public String toString() {
        return totalDays + "\t\t" + present + "\t\t" + absent + "\t\t" + getPercentage() + "%";
    }
}

