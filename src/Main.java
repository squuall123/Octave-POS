import java.io.IOException;
import java.util.ArrayList;

public class Main {


    private static ArrayList<Produit> products = new ArrayList<Produit>();
    private static ArrayList<Client> clients = new ArrayList<Client>();

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        DbConnector connector = new DbConnector();
            products = connector.selectAllProducts();
            clients = connector.selectAllClients();
        //System.out.println(products.size());
        //System.out.println(clients.size());

        //connector.insertProduct("produit",5, 35.5f);
        //connector.insertClient("foulen","sahloul","55555555");


            MainUI ui = new MainUI();
            ui.show();
    }
}
