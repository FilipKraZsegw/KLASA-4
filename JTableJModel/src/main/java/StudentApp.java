import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class StudentApp extends JFrame {

    public StudentApp() {
        setTitle("Lista studentów");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Dane startowe
        List<Student> data = new ArrayList<>();
        data.add(new Student("Jan", "Kowalski", 5));
        data.add(new Student("Anna", "Nowak", 4));
        data.add(new Student("Piotr", "Wiśniewski", 3));

        // Model
        StudentTableModel model = new StudentTableModel(data);

        // Tabela
        JTable table = new JTable(model);

        // Scroll (obowiązkowo!)
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentApp().setVisible(true));
    }
}