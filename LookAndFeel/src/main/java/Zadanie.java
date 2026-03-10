import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Zadanie extends JFrame {

    public Zadanie() {

        setTitle("Zadanie");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createMenu();
        createUI();
    }

    private void createMenu() {

        JMenuBar menuBar = new JMenuBar();

        JMenu viewMenu = new JMenu("Widok");

        JMenuItem lightMode = new JMenuItem("Light Mode");
        JMenuItem darkMode = new JMenuItem("Dark Mode");

        lightMode.addActionListener(e -> changeTheme(true));
        darkMode.addActionListener(e -> changeTheme(false));

        viewMenu.add(lightMode);
        viewMenu.add(darkMode);

        menuBar.add(viewMenu);

        setJMenuBar(menuBar);
    }

    private void createUI() {

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel();

        JTextField textField = new JTextField(15);
        JButton button = new JButton("Zatwierdź");
        JCheckBox checkBox = new JCheckBox("Aktywna opcja");

        topPanel.add(new JLabel("Wpisz tekst:"));
        topPanel.add(textField);
        topPanel.add(button);
        topPanel.add(checkBox);

        mainPanel.add(topPanel, BorderLayout.NORTH);

        String[] columns = {"ID","Imię","Status"};

        Object[][] data = {
                {"1","Anna","Aktywny"},
                {"2","Jan","Nieaktywny"},
                {"3","Maria","Aktywny"},
                {"4","Piotr","Aktywny"}
        };

        JTable table = new JTable(new DefaultTableModel(data, columns));
        JScrollPane scrollPane = new JScrollPane(table);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);
    }

    private void changeTheme(boolean light) {

        try {

            if(light) {
                UIManager.setLookAndFeel(new FlatLightLaf());
            } else {
                UIManager.setLookAndFeel(new FlatDarkLaf());
            }

            SwingUtilities.updateComponentTreeUI(this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        FlatLightLaf.setup();

        SwingUtilities.invokeLater(() -> {
            new Zadanie().setVisible(true);
        });

    }
}