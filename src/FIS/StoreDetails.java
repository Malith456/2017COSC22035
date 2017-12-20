package FIS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import DBConnect.*;


public class StoreDetails extends JFrame{
    private JPanel panel1;
    private JTextField txtUname;
    private JTextField txtEmail;
    private JTextField txtUID;
    private JPasswordField txtPW;
    private JButton btnInsert;
    private JButton btnLogout;
    private JButton storeDetailsButton;

    public StoreDetails() {
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }
        });

        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertDB();
            }
        });
    }

    public void insertDB(){
        String query = "INSERT INTO userdetails VALUE("+txtUID.getText()+",'"+txtUname.getText()+"','"+txtEmail.getText()+"','"+String.valueOf(txtPW.getPassword())+"',5)";
        System.out.println(query);
        dbConnect DB = new dbConnect();
        Statement stnt = null;
        try{
            stnt = DB.Conn2DB();
            stnt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Stared Details");
        }
        catch (SQLException se){
            se.printStackTrace();
        }
        DB.closeDB();
    }
}
