import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormularzWeryfikacji extends JFrame{

    private JTextField Wiek;
    private JCheckBox Regulamin;
    private JButton Zatwierdz;

    public FormularzWeryfikacji() {
        setTitle("Formularz weryfikacyjny");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Podaj wiek:"));
        Wiek = new JTextField(10);
        add(Wiek);

        Regulamin = new JCheckBox("Akceptuję regulamin");
        add(Regulamin);

        Zatwierdz = new JButton("Zatwierdz");
        add(Zatwierdz);

        Zatwierdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int wiek = Integer.parseInt(Wiek.getText());
                    boolean regulamin = Regulamin.isSelected();

                    if (wiek >= 18 && regulamin) {
                        JOptionPane.showMessageDialog(null, "Rejestracja pomyślna");
                    } else {
                        JOptionPane.showMessageDialog(null, "Wprowadź wiek powyżej 18 i akceptuj regulamin");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Wprowadź poprawny wiek");
                    {
                    }
                }
            }
        });
    setVisible(true);
    }
}
