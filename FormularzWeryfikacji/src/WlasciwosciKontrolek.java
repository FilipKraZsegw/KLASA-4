import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WlasciwosciKontrolek extends JFrame {

    private JButton przycisk1;
    private JButton przycisk2;

    public WlasciwosciKontrolek() {
        super("Ustawianie Właściwości");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(400, 100);

        przycisk1 = new JButton("Aktywny Przycisk");
        przycisk2 = new JButton("Wyłączony");

        // Ustawienie właściwości:
        przycisk2.setEnabled(false); // Blokujemy przycisk 2

        przycisk1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Po kliknięciu:
                przycisk2.setEnabled(true); // Aktywujemy przycisk 2
                przycisk2.setText("Aktywowany!"); // Zmieniamy jego tekst
                przycisk1.setEnabled(false); // Wyłączamy przycisk 1
            }
        });

        this.add(przycisk1);
        this.add(przycisk2);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WlasciwosciKontrolek::new);
    }
}