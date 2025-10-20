import java.awt.*;
import javax.swing.*;

public class MyFrame extends JPanel {
    public MyFrame() {
        setPreferredSize(new Dimension(400, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawRect(10, 10, 380, 380);
        g2d.drawOval(10, 10, 380, 380);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Rysowanie());
    }
}

class Rysowanie extends JFrame {
    public Rysowanie() {
        super("Rysowanie");
        MyFrame panel = new MyFrame();
        add(panel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
