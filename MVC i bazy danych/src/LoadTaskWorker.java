import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoadTaskWorker extends SwingWorker<List<Task>, Void> {


    private JTable table;
    private JLabel statusLabel;
    private JButton loadButton;


    public LoadTaskWorker(JTable table, JLabel statusLabel, JButton loadButton) {
        this.table = table;
        this.statusLabel = statusLabel;
        this.loadButton = loadButton;
    }


    @Override
    protected List<Task> doInBackground() throws Exception {
        Thread.sleep(4000);
        List<Task> tasks = new ArrayList<>();


        String sql = "SELECT id, title, description, is_done FROM tasks ORDER BY id";


        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {


            while (rs.next()) {
                boolean done = rs.getInt("is_done") == 1;
                tasks.add(new Task(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        done
                ));
            }
        }
        return tasks;
    }


    @Override
    protected void done() {
        try {
            List<Task> tasks = get();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);


            for (Task t : tasks) {
                model.addRow(new Object[]{
                        t.getId(),
                        t.getTitle(),
                        t.getDescription(),
                        t.isDone()
                });
            }


            statusLabel.setText("Gotowe. Wczytano " + tasks.size() + " zadań.");
        } catch (Exception e) {
            statusLabel.setText("Błąd wczytywania danych");
        } finally {
            loadButton.setEnabled(true);
        }
    }
}