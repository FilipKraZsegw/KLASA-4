import javax.swing.*;

public class Stylowanie extends JFrame {

    public Stylowanie() {

        setTitle("Look and Feel");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        JButton b1 = new JButton("Przycisk 1");
        JButton b2 = new JButton("Przycisk 2");
        JButton b3 = new JButton("Przycisk 3");

        panel.add(b1);
        panel.add(b2);
        panel.add(b3);

        add(panel);
    }

    public static void main(String[] args) {

        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();

        System.out.println("Dostępne style Look and Feel:");

        for(UIManager.LookAndFeelInfo laf : looks) {
            System.out.println("Nazwa: " + laf.getName());
            System.out.println("Klasa: " + laf.getClassName());
            System.out.println("-----------------------");
        }

        SwingUtilities.invokeLater(() -> {
            new Stylowanie().setVisible(true);
        });
    }
}