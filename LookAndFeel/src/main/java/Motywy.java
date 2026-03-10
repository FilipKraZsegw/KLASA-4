import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Motywy extends JFrame {

    private JComboBox<String> combo;

    public Motywy() {

        setTitle("Motywy");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        JButton b1 = new JButton("Przycisk 1");
        JButton b2 = new JButton("Przycisk 2");

        combo = new JComboBox<>();
        combo.addItem("Metal");
        combo.addItem("Nimbus");
        combo.addItem("CDE/Motif");

        combo.addActionListener(this::changeLookAndFeel);

        panel.add(new JLabel("Wybierz styl:"));
        panel.add(combo);
        panel.add(b1);
        panel.add(b2);

        add(panel);
    }

    private void changeLookAndFeel(ActionEvent e) {

        String selected = (String) combo.getSelectedItem();

        try {

            switch (selected) {

                case "Metal":
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                    break;

                case "Nimbus":
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    break;

                case "CDE/Motif":
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    break;
            }

            SwingUtilities.updateComponentTreeUI(this);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Motywy().setVisible(true);
        });

    }
}