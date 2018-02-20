import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ProductsTableModel extends AbstractTableModel {
    private ArrayList<Produit> products ;
    private String[] columns ;

    public ProductsTableModel(ArrayList<Produit> aProductsList){
        super();
        products = aProductsList ;
        columns = new String[]{"Nom","Quantité","Prix"};
    }


    // Number of column of your table
    public int getColumnCount() {
        return columns.length ;
    }

    // Number of row of your table
    @Override
    public int getRowCount() {
        return products.size();
    }

    // The object to render in a cell
    public Object getValueAt(int row, int col) {
        Produit produit = products.get(row);
        switch(col) {
            case 0: return produit.getNom();
            case 1: return produit.getQuantity();
            case 2: return produit.getPrix();
            // to complete here...
            default: return null;
        }
    }

    // Optional, the name of your column
    public String getColumnName(int col) {
        return columns[col] ;
    }

}