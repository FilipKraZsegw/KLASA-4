import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPrzycisk extends JFrame {

    public PanelPrzycisk() {
        super("Przyciski kumplu");

        JPanel buttonPanel = new PrzyciskPanel();
        add(buttonPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    private class PrzyciskPanel extends JPanel implements ActionListener {

        public static final int HEIGHT = 100;
        public static final int WIDTH = 300;
        private JButton greenButton;
        private JButton blueButton;
        private JButton redButton;

        public PrzyciskPanel() {
            greenButton = new JButton("Zielony");
            blueButton = new JButton("Niebieski");
            redButton = new JButton("Czerwony");

            greenButton.addActionListener(this);
            blueButton.addActionListener(this);
            redButton.addActionListener(this);

            setLayout(new FlowLayout());
            setPreferredSize(new Dimension(WIDTH, HEIGHT));
            add(greenButton);
            add(blueButton);
            add(redButton);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();

            if(source == greenButton)
                setBackground(Color.GREEN);

            else if(source == blueButton)
                setBackground(Color.BLUE);

            else if(source == redButton)
                setBackground(Color.RED);
        }
    }
    private class Przycisk extends JButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
        }
    }
}