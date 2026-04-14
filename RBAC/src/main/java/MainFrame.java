import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JMenuItem manageUsersItem;
    private JMenuItem reportsItem;
    private JLabel statusBar;

    public MainFrame() {
        setTitle("System Obsługi Sklepu");
        setSize(500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        createMenu();
        createStatusBar();
        applyPermissions();
    }

    private void createMenu() {
        JMenuBar bar = new JMenuBar();

        JMenu menu = new JMenu("Menu");

        JMenuItem salesItem = new JMenuItem("Sprzedaż");
        reportsItem = new JMenuItem("Raporty");
        manageUsersItem = new JMenuItem("Zarządzanie Użytkownikami");

        menu.add(salesItem);
        menu.add(reportsItem);
        menu.add(manageUsersItem);

        bar.add(menu);
        setJMenuBar(bar);
    }

    private void createStatusBar() {
        statusBar = new JLabel();
        add(statusBar, BorderLayout.SOUTH);
    }

    private void applyPermissions() {
        String role = Session.getRole();

        if(role.equals("ADMIN")) {
            manageUsersItem.setVisible(true);
            reportsItem.setEnabled(true);
        } else {
            manageUsersItem.setVisible(false);  // całkowicie niewidoczne
            reportsItem.setEnabled(false);      // wyszarzone
        }

        statusBar.setText(
                "Zalogowano jako: " + Session.getUser() +
                        " | Rola: " + Session.getRole()
        );
    }
}