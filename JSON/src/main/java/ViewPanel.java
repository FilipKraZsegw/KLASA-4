import javax.swing.*;
import java.awt.*;

public class ViewPanel extends JPanel {
    private JLabel nameLabel = new JLabel();
    private JLabel lastNameLabel = new JLabel();
    private JLabel emailLabel = new JLabel();

    public ViewPanel(MainFrame frame) {
        setLayout(new GridLayout(4, 1));

        add(nameLabel);
        add(lastNameLabel);
        add(emailLabel);

        JButton backBtn = new JButton("Powrót");
        add(backBtn);

        backBtn.addActionListener(e -> {
            frame.showCard(MainFrame.FORM);
        });
    }

    public void loadData() {
        UserProfile profile = StorageManager.load();

        if (profile != null) {
            nameLabel.setText("Imię: " + profile.getFirstName());
            lastNameLabel.setText("Nazwisko: " + profile.getLastName());
            emailLabel.setText("Email: " + profile.getEmail());
        }
    }
}