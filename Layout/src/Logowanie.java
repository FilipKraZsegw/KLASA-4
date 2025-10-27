import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Logowanie extends JFrame {

    public Logowanie() {
        super("Logowanie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(5, 5));

        JPanel panelGlowny = new JPanel(new GridLayout(2, 2, 5, 5));
        panelGlowny.add(new JLabel("Użytkownik:"));
        panelGlowny.add(new JTextField(15));
        panelGlowny.add(new JLabel("Hasło:"));
        panelGlowny.add(new JPasswordField(15));

        panelGlowny.setBorder(new EmptyBorder(15, 15, 15, 15));

        JPanel panelPrzyciski = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelPrzyciski.add(new JButton("Zaloguj"));
        panelPrzyciski.add(new JButton("Anuluj"));

        add(panelGlowny, BorderLayout.CENTER);
        add(panelPrzyciski, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Logowanie();
    }
}
