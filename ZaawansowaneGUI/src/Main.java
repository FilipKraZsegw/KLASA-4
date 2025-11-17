import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            List<Product> produkty = new ArrayList<>();
            produkty.add(new Product("Japuszko", 3.50, 10));
            produkty.add(new Product("Kabanosy", 6.70, 15));
            produkty.add(new Product("Żelki", 5.50, 18));

            ProductTableModel model = new ProductTableModel(produkty);

            JTable tabela = new JTable(model);

            JFrame frame = new JFrame("Lista produktów");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new JScrollPane(tabela));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
