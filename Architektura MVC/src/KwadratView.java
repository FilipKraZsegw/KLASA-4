import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class KwadratView extends JFrame {

    private JTextField poleLiczby = new JTextField(10);
    private JLabel wynikLabel = new JLabel("Wynik: ");
    private JButton obliczButton = new JButton("Oblicz");

    public KwadratView() {
        super("Kalkulator Kwadratu");

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(new JLabel("Podaj liczbę:"));
        panel.add(poleLiczby);
        panel.add(obliczButton);
        panel.add(wynikLabel);

        this.setContentPane(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 120);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public String getWprowadzonaLiczba() {
        return poleLiczby.getText();
    }

    public void setWynik(int wynik) {
        wynikLabel.setText("Wynik: " + wynik);
    }

    public void setError(String komunikat) {
        wynikLabel.setText("Błąd: " + komunikat);
    }

    public void addObliczListener(ActionListener listener) {
        obliczButton.addActionListener(listener);
    }
}
