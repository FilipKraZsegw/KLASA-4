import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {

    private JButton btnFreeze;
    private JButton btnWorker;
    private JLabel statusLabel;

    public MainFrame() {
        setTitle("Okienko");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        btnFreeze = new JButton("Zawieś program");
        btnWorker = new JButton("Start");
        statusLabel = new JLabel("Czekam...", SwingConstants.CENTER);

        setLayout(new BorderLayout());
        JPanel buttons = new JPanel(new GridLayout(1, 2));
        buttons.add(btnFreeze);
        buttons.add(btnWorker);

        add(buttons, BorderLayout.NORTH);
        add(statusLabel, BorderLayout.CENTER);

        btnFreeze.addActionListener(e -> wykonajZawieszajacaWersje());
        btnWorker.addActionListener(e -> wykonajSwingWorker());
    }

    private void wykonajZawieszajacaWersje() {
        statusLabel.setText("Startuję...");

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {}

            statusLabel.setText("Pracuję... " + (i + 1) + "s");
        }

        statusLabel.setText("Zakończono blokadę.");
    }

    private void wykonajSwingWorker() {

        statusLabel.setText("Startuję...");

        SwingWorker<Void, String> worker = new SwingWorker<>() {

            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(1000);
                    publish("Pracuję... " + (i + 1) + "s");
                }
                return null;
            }

            @Override
            protected void process(List<String> chunks) {
                String ostatniStatus = chunks.get(chunks.size() - 1);
                statusLabel.setText(ostatniStatus);
            }

            @Override
            protected void done() {
                statusLabel.setText("Zakończono pomyślnie!");
            }
        };

        worker.execute();
    }
}
