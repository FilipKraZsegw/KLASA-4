import javax.swing.*;

public class MainFrame extends JFrame {
    private JPanel panel1; // To pole musi mieć 'field name' w Designerze
    private JButton actionButton;
    private JLabel myLabel;

    public MainFrame() {
        setContentPane(panel1);
        setTitle("Moja Aplikacja");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);

        actionButton.addActionListener(e -> myLabel.setText("Witaj w Swing!")); {
            System.out.println("Kliknięto przycisk!");
        };
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}