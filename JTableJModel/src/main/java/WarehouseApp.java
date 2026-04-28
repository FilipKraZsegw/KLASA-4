import javax.swing.*;
import java.awt.*;

public class WarehouseApp extends JFrame {

    private final JTextField idField = new JTextField(10);
    private final JTextField nameField = new JTextField(10);
    private final JTextField quantityField = new JTextField(10);
    private final JTextField categoryField = new JTextField(10);

    private final ItemTableModel model = new ItemTableModel();
    private final JTable table = new JTable(model);

    public WarehouseApp() {
        setTitle("System Magazynowy");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Formularz po lewej
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createTitledBorder("Dodaj produkt"));

        formPanel.add(new JLabel("ID:"));
        formPanel.add(idField);

        formPanel.add(new JLabel("Nazwa:"));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Ilość:"));
        formPanel.add(quantityField);

        formPanel.add(new JLabel("Kategoria:"));
        formPanel.add(categoryField);

        JButton addButton = new JButton("Dodaj");
        JButton removeButton = new JButton("Usuń zaznaczone");

        formPanel.add(addButton);
        formPanel.add(removeButton);

        // Tabela po prawej
        JScrollPane scrollPane = new JScrollPane(table);

        add(formPanel, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);

        // Obsługa przycisku Dodaj
        addButton.addActionListener(e -> addItem());

        // Obsługa przycisku Usuń
        removeButton.addActionListener(e -> removeItem());
    }

    private void addItem() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            String category = categoryField.getText();

            Item item = new Item(id, name, quantity, category);
            model.addItem(item);

            clearFields();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "ID i Ilość muszą być liczbami!",
                    "Błąd danych",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeItem() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            model.removeItem(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Nie zaznaczono wiersza!",
                    "Błąd",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        quantityField.setText("");
        categoryField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WarehouseApp().setVisible(true));
    }
}