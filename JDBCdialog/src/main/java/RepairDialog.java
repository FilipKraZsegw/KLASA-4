import javax.swing.*;

public class RepairDialog extends JDialog {

    private JPanel contentPane;
    private JTextField txtSprzet;
    private JTextField txtKoszt;
    private JButton buttonOK;
    private JButton buttonCancel;

    private boolean confirmed = false;

    public RepairDialog() {

        setContentPane(contentPane);
        setModal(true);

        buttonOK.addActionListener(e -> onOK());

        buttonCancel.addActionListener(e -> {
            confirmed = false;
            dispose();
        });
    }

    private void onOK() {

        String sprzet = txtSprzet.getText().trim();
        String kosztText = txtKoszt.getText().trim();

        if (sprzet.isEmpty() || kosztText.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Wszystkie pola muszą być uzupełnione!",
                    "Błąd",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        try {
            Double.parseDouble(kosztText);
        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Koszt musi być liczbą!",
                    "Błąd",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        confirmed = true;
        dispose();
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public String getSprzet() {
        return txtSprzet.getText();
    }

    public double getKoszt() {
        return Double.parseDouble(txtKoszt.getText());
    }
}