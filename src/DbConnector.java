import java.sql.*;
import java.util.ArrayList;

public class DbConnector {

    private ArrayList<Produit> products = new ArrayList();
    private ArrayList<Client> clients = new ArrayList();

    /**
     * Connect to the test.db database
     * @return the Connection object
     */
    private Connection connect() throws ClassNotFoundException {
        // SQLite connection string
        Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:pos.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * select all rows in the Clients table
     */
    public ArrayList<Client> selectAllClients() throws ClassNotFoundException {
        String sql = "SELECT id, nom, addresse, telephone FROM Clients";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("nom") + "\t" +
                        rs.getString("addresse") + "\t" +
                        rs.getString("telephone"));
                Client client = new Client(rs.getInt("id"),rs.getString("nom"),rs.getString("addresse"),rs.getString("telephone"));
                clients.add(client);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return clients;
    }


    /**
     * select all rows in the Products table
     */
    public ArrayList<Produit> selectAllProducts() throws ClassNotFoundException {
        String sql = "SELECT id, nom, quantity, prix FROM Produits";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("nom") + "\t" +
                        rs.getInt("quantity") + "\t" +
                        rs.getFloat("prix"));
                Produit produit = new Produit(rs.getInt("id"),rs.getString("nom"),rs.getInt("quantity"),rs.getFloat("prix"));
                products.add(produit);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return products;
    }

    /**
     * Insert a new row into the Clients table
     */
    public void insertClient(String nom, String addresse, String telephone) throws ClassNotFoundException {
        String sql = "INSERT INTO Clients(nom,addresse,telephone) VALUES(?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nom);
            pstmt.setString(2, addresse);
            pstmt.setString(3, telephone);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Insert a new row into the Products table
     */
    public void insertProduct(String nom, int quantity, float prix) throws ClassNotFoundException {
        String sql = "INSERT INTO Produits(nom,quantity,prix) VALUES(?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nom);
            pstmt.setInt(2, quantity);
            pstmt.setFloat(3, prix);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
