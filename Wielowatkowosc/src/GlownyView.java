import javax.swing.*;
import java.awt.*;

public class GlownyView extends JFrame {

    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel statusLabel;

    public GlownyView() {
        setTitle("Okienko");
        setSize(400, 220);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        loginField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Zaloguj");
        statusLabel = new JLabel(" ", SwingConstants.CENTER);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panel.add(new JLabel("Login:"));
        panel.add(loginField);
        panel.add(new JLabel("Hasło:"));
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);
        panel.add(new JLabel());
        panel.add(statusLabel);

        add(panel);
    }

    public String getLogin() {
        return loginField.getText();
    }

    public String getHaslo() {
        return new String(passwordField.getPassword());
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void ustawStatus(String msg) {
        statusLabel.setText(msg);
    }
}
