import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class SystemRaportowaniaMagazynowego extends JFrame {

    private JTable table;
    private JButton btnRaport;

    public SystemRaportowaniaMagazynowego() {
        setTitle("System Raportowania Magazynowego");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columns = {"ID", "Nazwa Produktu", "Ilość", "Cena"};

        Object[][] data = {
                {1, "Laptop", 10, 3500.00},
                {2, "Mysz", 50, 80.00},
                {3, "Klawiatura", 30, 150.00},
                {4, "Monitor", 15, 900.00}
        };

        DefaultTableModel model = new DefaultTableModel(data, columns);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        btnRaport = new JButton("Generuj Raport PDF");

        btnRaport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exportToPDF(table);
            }
        });

        add(scrollPane, BorderLayout.CENTER);
        add(btnRaport, BorderLayout.SOUTH);
    }

    public void exportToPDF(JTable table) {
        JFileChooser chooser = new JFileChooser();
        int state = chooser.showSaveDialog(this);

        if (state == JFileChooser.APPROVE_OPTION) {
            Document document = new Document();
            try {
                PdfWriter.getInstance(document,
                        new FileOutputStream(chooser.getSelectedFile() + ".pdf"));

                document.open();

                PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
                
                for (int i = 0; i < table.getColumnCount(); i++) {
                    pdfTable.addCell(table.getColumnName(i));
                }

                for (int rows = 0; rows < table.getRowCount(); rows++) {
                    for (int cols = 0; cols < table.getColumnCount(); cols++) {
                        pdfTable.addCell(
                                table.getModel().getValueAt(rows, cols).toString()
                        );
                    }
                }

                document.add(pdfTable);

                JOptionPane.showMessageDialog(this,
                        "Raport PDF został wygenerowany!");

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                document.close();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SystemRaportowaniaMagazynowego().setVisible(true);
        });
    }

}
