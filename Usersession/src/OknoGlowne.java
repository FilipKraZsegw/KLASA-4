import javax.swing.*;

public class OknoGlowne extends JFrame {

    JMenuItem sprzedazItem;
    JMenuItem raportyItem;
    JMenuItem usersItem;

    JLabel statusBar;

    public OknoGlowne() {

        setTitle("System Sklepu");
        setSize(500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Menu");

        sprzedazItem = new JMenuItem("Sprzedaż");
        raportyItem = new JMenuItem("Raporty");
        usersItem = new JMenuItem("Zarządzanie użytkownikami");

        menu.add(sprzedazItem);
        menu.add(raportyItem);
        menu.add(usersItem);

        menuBar.add(menu);
        setJMenuBar(menuBar);

        statusBar = new JLabel();
        add(statusBar, "South");

        setupPermissions();

        setVisible(true);
    }

    private void setupPermissions() {

        String role = Session.getRole();

        if(role.equals("ADMIN")) {

            sprzedazItem.setVisible(true);
            raportyItem.setEnabled(true);
            usersItem.setVisible(true);

        }
        else if(role.equals("USER")) {

            sprzedazItem.setVisible(true);

            raportyItem.setEnabled(false); // wyszarzone
            usersItem.setVisible(false);   // ukryte
        }

        statusBar.setText(
                "Zalogowano jako: " + Session.getLogin() +
                        " | Rola: " + Session.getRole()
        );
    }
}