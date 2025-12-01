import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ZadanieModel {
    private Connection conn;

    public ZadanieModel() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ToDo?useSSL=false&serverTimezone=UTC",
                    "root",
                    ""
            );
            System.out.println("Połączono z bazą.");

            utworzTabele(); // ← DODANE

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void utworzTabele() throws SQLException {
        String sql = """
            CREATE TABLE IF NOT EXISTS zadania (
                id INT AUTO_INCREMENT PRIMARY KEY,
                tresc VARCHAR(255) NOT NULL,
                wykonane TINYINT(1) NOT NULL DEFAULT 0
            );
        """;
        conn.createStatement().execute(sql);
    }

    public void dodajZadanie(String tresc) throws SQLException {
        String sql = "INSERT INTO zadania(tresc, wykonane) VALUES (?, 0)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, tresc);
        stmt.executeUpdate();
    }

    public void usunZadanie(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM zadania WHERE id=?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public List<Zadanie> pobierzWszystkieZadania() throws SQLException {
        List<Zadanie> lista = new ArrayList<>();
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM zadania");

        while (rs.next()) {
            lista.add(new Zadanie(
                    rs.getInt("id"),
                    rs.getString("tresc"),
                    rs.getInt("wykonane") == 1
            ));
        }
        return lista;
    }
}
