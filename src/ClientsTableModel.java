import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ClientsTableModel extends AbstractTableModel {
    private ArrayList<Client> clients ;
    private String[] columns ;

    public ClientsTableModel(ArrayList<Client> aClientsList){
        super();
        clients = aClientsList ;
        columns = new String[]{"Nom","Addresse","Téléphone"};
    }


    // Number of column of your table
    public int getColumnCount() {
        return columns.length ;
    }

    // Number of row of your table
    @Override
    public int getRowCount() {
        return clients.size();
    }

    // The object to render in a cell
    public Object getValueAt(int row, int col) {
        Client client = clients.get(row);
        switch(col) {
            case 0: return client.getNom();
            case 1: return client.getAddress();
            case 2: return client.getTelephone();
            // to complete here...
            default: return null;
        }
    }

    // Optional, the name of your column
    public String getColumnName(int col) {
        return columns[col] ;
    }

}