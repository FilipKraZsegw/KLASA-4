
import java.awt.*;
import javax.swing.*;

public class BoxLayoutDemo extends JFrame {
    public BoxLayoutDemo() {
        super("BoxLayout Demo (Pionowy)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        // Tworzenie JPanel, który będzie używał BoxLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Pionowy rozkład

        // Dodawanie komponentów i elementów dystansowych
        panel.add(new JLabel("Etykieta 1"));
        panel.add(Box.createVerticalStrut(10)); // Sztywny odstęp 10px
        panel.add(new JTextField(15));
        panel.add(Box.createVerticalGlue()); // Elastyczny odstęp (popycha następny element na dół)
        panel.add(new JButton("Zapisz"));

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BoxLayoutDemo();
    }
}