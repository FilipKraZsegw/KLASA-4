import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Obraz extends JPanel {

    private BufferedImage image;

    public Obraz() {
        super();

        File imageFile = new File("uncbao.jpg");
        try {
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            System.err.println("Błąd odczytu obrazka: " + e.getMessage());
            e.printStackTrace();
        }

        if (image != null) {
            Dimension dimension = new Dimension(image.getWidth(), image.getHeight());
            setPreferredSize(dimension);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        } else {
            g.drawString("Nie udało się wczytać obrazu.", 10, 20);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new ObrazFrame());
    }
}

class ObrazFrame extends JFrame {
    public ObrazFrame() {
        super("Obrazek kota");
        add(new Obraz());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
