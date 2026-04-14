import javax.swing.*;
import java.awt.*;

public class LoginDialog extends JDialog {

    private JTextField loginField = new JTextField(10);
    private JPasswordField passField = new JPasswordField(10);

    public LoginDialog(JFrame parent) {
        super(parent, "Logowanie", true);
        setLayout(new GridLayout(3,2,5,5));

        add(new JLabel("Login:"));
        add(loginField);
        add(new JLabel("Hasło:"));
        add(passField);

        JButton loginBtn = new JButton("Zaloguj");
        add(loginBtn);

        loginBtn.addActionListener(e -> authenticate());

        pack();
        setLocationRelativeTo(parent);
    }

    private void authenticate() {
        String login = loginField.getText();
        String pass = new String(passField.getPassword());

        if(login.equals("admin") && pass.equals("admin123")) {
            Session.login(login, "ADMIN");
            dispose();
        }
        else if(login.equals("user") && pass.equals("user123")) {
            Session.login(login, "USER");
            dispose();
        }
        else {
            JOptionPane.showMessageDialog(this, "Błędne dane!");
        }
    }
}