import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class TaskManagerApp extends JFrame {


    public TaskManagerApp() {
        setTitle("Task Manager");
        setSize(750, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JTable table = new JTable(new DefaultTableModel(
                new Object[]{"ID", "Tytuł", "Opis", "Wykonane"}, 0));


        JButton loadButton = new JButton("Wczytaj zadania");
        JButton addButton = new JButton("Dodaj zadanie");
        JLabel statusLabel = new JLabel("Status: oczekiwanie");


        JTextField titleField = new JTextField(10);
        JTextField descField = new JTextField(10);


        loadButton.addActionListener(e -> {
            statusLabel.setText("Ładowanie danych... Proszę czekać");
            loadButton.setEnabled(false);
            new LoadTaskWorker(table, statusLabel, loadButton).execute();
        });


        addButton.addActionListener(e -> {
            new AddTaskWorker(
                    titleField.getText(),
                    descField.getText(),
                    statusLabel, table, loadButton
            ).execute();
        });


        JPanel top = new JPanel();
        top.add(loadButton);
        top.add(new JLabel("Tytuł:"));
        top.add(titleField);
        top.add(new JLabel("Opis:"));
        top.add(descField);
        top.add(addButton);


        add(top, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TaskManagerApp().setVisible(true));
    }
}