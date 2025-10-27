import java.awt.*;
import javax.swing.*;

public class BorderLayoutDemo extends JFrame {
    public BorderLayoutDemo() {
        super("BorderLayout Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Ustawienie Layoutu (5px odstępu między komponentami)
        setLayout(new BorderLayout(5, 5));

        // Dodawanie komponentów z określeniem regionu
        add(new JButton("Północ"), BorderLayout.NORTH);
        add(new JButton("Południe"), BorderLayout.SOUTH);
        add(new JButton("Zachód"), BorderLayout.WEST);
        add(new JButton("Wschód"), BorderLayout.EAST);
        add(new JButton("Centrum (Rozciąga się)"), BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BorderLayoutDemo();
    }
}
    