import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddTaskWorker extends SwingWorker<Boolean, Void> {

    private String title;
    private String description;
    private JLabel statusLabel;
    private JTable table;
    private JButton loadButton;

    public AddTaskWorker(String title, String description,
                         JLabel statusLabel, JTable table, JButton loadButton) {
        this.title = title;
        this.description = description;
        this.statusLabel = statusLabel;
        this.table = table;
        this.loadButton = loadButton;
    }

    @Override
    protected Boolean doInBackground() throws Exception {

        String sql = "INSERT INTO tasks (title, description, is_done) VALUES (?, ?, 0)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, title);
            ps.setString(2, description);
            ps.executeUpdate();
            return true;
        }
    }

    @Override
    protected void done() {
        try {
            if (get()) {
                statusLabel.setText("Zadanie dodane");
                new LoadTaskWorker(table, statusLabel, loadButton).execute();
            }
        } catch (Exception e) {
            statusLabel.setText("Błąd zapisu zadania");
            e.printStackTrace(); // 🔥 WAŻNE
        }
    }
}
