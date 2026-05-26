import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class MainWindow extends JFrame {

    private DefaultTableModel tableModel;

    private JPanel mainPanel;
    private JTable table1;
    private JButton btnDodaj;

    public MainWindow() {

        setContentPane(mainPanel);
        setTitle("System Serwisowy");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableModel = new DefaultTableModel();

        tableModel.addColumn("ID");
        tableModel.addColumn("Sprzęt");
        tableModel.addColumn("Koszt naprawy");

        table1.setModel(tableModel);

        refreshTable();

        btnDodaj.addActionListener(e -> openDialog());
    }

    private void openDialog() {

        RepairDialog dialog = new RepairDialog();

        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);

        if (dialog.isConfirmed()) {

            insertToDatabase(
                    dialog.getSprzet(),
                    dialog.getKoszt()
            );

            refreshTable();
        }
    }

    private void insertToDatabase(String sprzet, double koszt) {

        String sql =
                "INSERT INTO zgloszenia(sprzet, koszt_naprawy) VALUES(?, ?)";

        try (
                Connection conn = DbConnector.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {

            pstmt.setString(1, sprzet);
            pstmt.setDouble(2, koszt);

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void refreshTable() {

        tableModel.setRowCount(0);

        String sql =
                "SELECT id, sprzet, koszt_naprawy FROM zgloszenia";

        try (
                Connection conn = DbConnector.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {

            while (rs.next()) {

                tableModel.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("sprzet"),
                        rs.getDouble("koszt_naprawy")
                });
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}