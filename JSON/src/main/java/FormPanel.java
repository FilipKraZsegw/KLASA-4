import javax.swing.*;
import java.awt.*;

public class FormPanel extends JPanel {
    private JTextField firstNameField = new JTextField(15);
    private JTextField lastNameField = new JTextField(15);
    private JTextField emailField = new JTextField(15);

    public FormPanel(MainFrame frame) {
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Imię:"));
        add(firstNameField);

        add(new JLabel("Nazwisko:"));
        add(lastNameField);

        add(new JLabel("Email:"));
        add(emailField);

        JButton saveBtn = new JButton("Zapisz i Dalej");
        add(saveBtn);

        saveBtn.addActionListener(e -> {
            UserProfile profile = new UserProfile(
                    firstNameField.getText(),
                    lastNameField.getText(),
                    emailField.getText()
            );

            StorageManager.save(profile);
            frame.refreshView();
            frame.showCard(MainFrame.VIEW);
        });
    }
}