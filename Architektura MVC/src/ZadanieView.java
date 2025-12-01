import javax.swing.*;
import java.awt.event.ActionListener;

public class ZadanieView extends JFrame {

    private DefaultListModel<Zadanie> listaModel = new DefaultListModel<>();
    private JList<Zadanie> listaZadan = new JList<>(listaModel);

    private JTextField poleTresc = new JTextField(15);
    private JButton dodajButton = new JButton("Dodaj");
    private JButton usunButton = new JButton("Usuń");

    public ZadanieView() {
        super("Lista To-Do");

        JPanel panel = new JPanel();
        panel.add(new JScrollPane(listaZadan));
        panel.add(poleTresc);
        panel.add(dodajButton);
        panel.add(usunButton);

        this.setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void wyczyscListe() {
        listaModel.clear();
    }

    public void dodajDoListy(Zadanie zadanie) {
        listaModel.addElement(zadanie);
    }

    public Zadanie getWybraneZadanie() {
        return listaZadan.getSelectedValue();
    }

    public String getNowaTresc() {
        return poleTresc.getText();
    }

    public void addDodajListener(ActionListener al) {
        dodajButton.addActionListener(al);
    }

    public void addUsunListener(ActionListener al) {
        usunButton.addActionListener(al);
    }

    public void wyswietlBlad(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Błąd", JOptionPane.ERROR_MESSAGE);
    }
}
