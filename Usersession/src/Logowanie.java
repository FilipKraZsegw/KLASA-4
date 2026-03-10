import javax.swing.*;
import java.awt.event.*;

public class Logowanie extends JDialog {

    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Logowanie() {

        setTitle("Logowanie");
        setSize(300,200);
        setLayout(null);
        setModal(true);

        JLabel loginLabel = new JLabel("Login:");
        loginLabel.setBounds(30,30,80,25);
        add(loginLabel);

        loginField = new JTextField();
        loginField.setBounds(120,30,120,25);
        add(loginField);

        JLabel passLabel = new JLabel("Hasło:");
        passLabel.setBounds(30,70,80,25);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(120,70,120,25);
        add(passwordField);

        loginButton = new JButton("Zaloguj");
        loginButton.setBounds(90,110,100,30);
        add(loginButton);

        loginButton.addActionListener(e -> login());

        setLocationRelativeTo(null);
    }

    private void login() {

        String login = loginField.getText();
        String pass = new String(passwordField.getPassword());

        if(login.equals("admin") && pass.equals("admin123")) {

            Session.login(login,"ADMIN");
            dispose();
            new OknoGlowne();

        } else if(login.equals("user") && pass.equals("user123")) {

            Session.login(login,"USER");
            dispose();
            new OknoGlowne();

        } else {

            JOptionPane.showMessageDialog(this,"Błędne dane logowania");

        }
    }
}