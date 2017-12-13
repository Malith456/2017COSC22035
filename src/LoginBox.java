import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DBConnect.*;

public class LoginBox {
    private JPanel panel1;
    private JTextField UserField;
    private JPasswordField pwField;
    private JButton exitButton;
    private JButton loginButton;
    public static JFrame loginFR = new JFrame("Login Box");

    public LoginBox() {
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = UserField.getText();
                String pw = String.valueOf(pwField.getPassword());
                loginCheck(username,pw);
                //JOptionPane.showMessageDialog(null,username+"System not ready yet");
            }
        });
    }

    public static void main(String[] args){
        loginFR.setContentPane(new LoginBox().panel1);
        loginFR.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loginFR.pack();
        loginFR.setVisible(true);
    }

    private  void loginCheck(String frUsername, String frPW){
        String inPW = null;
        String inUsername = null;
        dbConnect dbcon = new dbConnect();
        Statement stml = null;
        try{
            String query = "Select * from userdetails where UserName = '"+frUsername+"'";
            stml = dbcon.Conn2DB();
            ResultSet RS = stml.executeQuery(query);
            RS.first();
            inUsername = frUsername;
            inPW = RS.getString("Password");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        //String inUsername = "COSC";
        //String inPW = "22035";
        if (frUsername.equals(inUsername)&&frPW.equals(inPW)) {
            JOptionPane.showMessageDialog(null, "Username and Password Correct");
            loginFR.setVisible(false);
            new UserDetails(frUsername);
        }
        else JOptionPane.showMessageDialog(null, "Incorrect");
    }
}
