import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProductsUI extends JFrame implements ActionListener {

    private static ArrayList<Produit> products = new ArrayList<Produit>();
    private JButton addProduct = new JButton("Ajouter");

    public ProductsUI(){
        try {
            onLoad();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(products.size()>0) System.out.println("Success");

        TableModel model = new ProductsTableModel(products);
        JTable table = new JTable(model);
        JScrollPane scrollPane= new  JScrollPane(table);

        this.setTitle("Octave POS - Produits");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        //Instanciation d'un objet JPanel
        JPanel pan = new JPanel();
        //pan.setLayout(new BorderLayout());
        pan.setLayout(new FlowLayout());
        pan.add(scrollPane);
        pan.add(addProduct);

        this.setContentPane(pan);

        this.setVisible(true);
        addProduct.addActionListener(this);
    }

    public void onLoad() throws ClassNotFoundException {
        DbConnector connector = new DbConnector();
        products = connector.selectAllProducts();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object  source=e.getSource();

        if  (source==addProduct) {
            System.out.println("Ajouter Produit !");
            AddProductUI addproductui = new AddProductUI();
            addproductui.show();
        }
    }
}

