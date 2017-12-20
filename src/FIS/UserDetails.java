package FIS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserDetails extends JFrame{
    private JPanel panel1;
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtConNo;
    private JTextField txtGPA;
    private JButton coursesButton;
    private JButton logoutButton;

    public UserDetails(student user) {
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        txtName.setText(user.name);
        txtEmail.setText(user.email);
        txtConNo.setText(String.valueOf(user.phoneNumber));

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StoreDetails();
                setVisible(false);
            }
        });
    }
}
