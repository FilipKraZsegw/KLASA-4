import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class KsiegiApp extends JFrame {

    private static final String URL = "jdbc:mysql://localhost:3306/biblioteka";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private JTable tabela;
    private DefaultTableModel model;

    private JTextField poleTytul;
    private JTextField poleAutor;
    private JTextField poleRok;

    public KsiegiApp() {
        setTitle("Księgozbiór - CRUD");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        model = new DefaultTableModel(new String[]{"ID", "Tytuł", "Autor", "Rok"}, 0);
        tabela = new JTable(model);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        JPanel panelForm = new JPanel(new GridLayout(4, 2, 5, 5));
        poleTytul = new JTextField();
        poleAutor = new JTextField();
        poleRok = new JTextField();

        panelForm.add(new JLabel("Tytuł:"));
        panelForm.add(poleTytul);
        panelForm.add(new JLabel("Autor:"));
        panelForm.add(poleAutor);
        panelForm.add(new JLabel("Rok wydania:"));
        panelForm.add(poleRok);

        add(panelForm, BorderLayout.NORTH);

        JPanel panelButtons = new JPanel();

        JButton btnDodaj = new JButton("Dodaj");
        JButton btnUsun = new JButton("Usuń");
        JButton btnAktualizuj = new JButton("Aktualizuj");

        panelButtons.add(btnDodaj);
        panelButtons.add(btnUsun);
        panelButtons.add(btnAktualizuj);

        add(panelButtons, BorderLayout.SOUTH);


        btnDodaj.addActionListener(e -> dodajKsiazke());
        btnUsun.addActionListener(e -> usunKsiazke());
        btnAktualizuj.addActionListener(e -> aktualizujKsiazke());

        odswiezTabele();
    }

    private void dodajKsiazke() {
        String tytul = poleTytul.getText();
        String autor = poleAutor.getText();
        String rok = poleRok.getText();

        String sql = "INSERT INTO ksiazki (tytul, autor, rok_wydania) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tytul);
            pstmt.setString(2, autor);
            pstmt.setInt(3, Integer.parseInt(rok));

            pstmt.executeUpdate();
            odswiezTabele();

            JOptionPane.showMessageDialog(this, "Książkę dodano pomyślnie!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Błąd bazy danych: " + ex.getMessage());
        }
    }

    private void usunKsiazke() {
        int row = tabela.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Wybierz książkę do usunięcia.");
            return;
        }

        int id = (int) model.getValueAt(row, 0);

        String sql = "DELETE FROM ksiazki WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            odswiezTabele();

            JOptionPane.showMessageDialog(this, "Książka usunięta.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Błąd: " + ex.getMessage());
        }
    }

    private void aktualizujKsiazke() {
        int row = tabela.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Wybierz książkę do aktualizacji.");
            return;
        }

        int id = (int) model.getValueAt(row, 0);
        String tytul = poleTytul.getText();
        String autor = poleAutor.getText();
        int rok = Integer.parseInt(poleRok.getText());

        String sql = "UPDATE ksiazki SET tytul = ?, autor = ?, rok_wydania = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tytul);
            pstmt.setString(2, autor);
            pstmt.setInt(3, rok);
            pstmt.setInt(4, id);

            pstmt.executeUpdate();
            odswiezTabele();

            JOptionPane.showMessageDialog(this, "Zaktualizowano książkę.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Błąd: " + ex.getMessage());
        }
    }

    private void odswiezTabele() {
        model.setRowCount(0);

        String sql = "SELECT * FROM ksiazki";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("tytul"),
                        rs.getString("autor"),
                        rs.getInt("rok_wydania")
                });
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Błąd odczytu danych.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new KsiegiApp().setVisible(true));
    }
}
