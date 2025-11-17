import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ProductTableModel extends AbstractTableModel {
    private List<Product> produkty;
    private String[] nazwyKolumn = {"Nazwa", "Cena", "Ilość"};

    public ProductTableModel(List<Product> produkty) {
        this.produkty = produkty;
    }

    @Override
    public int getRowCount() { return produkty.size(); }

    @Override
    public int getColumnCount() { return nazwyKolumn.length; }

    @Override
    public String getColumnName(int column) { return nazwyKolumn[column]; }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product p = produkty.get(rowIndex);
        switch (columnIndex) {
            case 0: return p.getNazwa();
            case 1: return p.getCena();
            case 2: return p.getIlosc();
            default: return null;
        }
    }
}
