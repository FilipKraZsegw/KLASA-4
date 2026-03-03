import javax.swing.*;
import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.PdfPTable;

public class ExportToPDF {

    public void exportToPDF(JTable table) {

        JFileChooser chooser = new JFileChooser();
        int state = chooser.showSaveDialog(null);

        if (state == JFileChooser.APPROVE_OPTION) {

            Document document = new Document();

            try {
                PdfWriter.getInstance(document,
                        new FileOutputStream(chooser.getSelectedFile() + ".pdf"));

                document.open();

                PdfPTable pdfTable = new PdfPTable(table.getColumnCount());

                // Nagłówki
                for (int i = 0; i < table.getColumnCount(); i++) {
                    pdfTable.addCell(table.getColumnName(i));
                }

                // Dane
                for (int rows = 0; rows < table.getRowCount(); rows++) {
                    for (int cols = 0; cols < table.getColumnCount(); cols++) {

                        Object value = table.getModel().getValueAt(rows, cols);

                        pdfTable.addCell(value != null ? value.toString() : "");
                    }
                }

                document.add(pdfTable);

                JOptionPane.showMessageDialog(null,
                        "Eksport zakończony sukcesem!");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                document.close();
            }
        }
    }
}
// zad 4
// JFileChooser umożliwia użytkownikowi wskazanie miejsca zapisu pliku PDF.
// Biblioteka PDF oczekuje Stringa przy dodawaniu komórki do tabeli PDF.
//Jeżeli zapomnimy wywołać funkcję document.close() plik PDF najprawdopodobniej nie bedzie działał poprawnie