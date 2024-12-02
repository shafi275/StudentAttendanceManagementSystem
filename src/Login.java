import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Login {
    private String id, password;

    Login(String user, String pass) {
        this.id = user;
        this.password = pass;
    }

    public String getId() {
        return id;
    }

    public String getPass() {
        return password;
    }

    int checkCredentials(ArrayList<? extends Login> list, String uname, String pwd) {
        for (int i = 0; i < list.size(); i++) {
            if (uname.equals(list.get(i).getId()) && pwd.equals(list.get(i).getPass())) {
                return i;
            }
        }
        return -1;
    }
}
