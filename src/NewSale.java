import net.sf.jasperreports.engine.JasperReport;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NewSale extends JFrame {
    DbConnector connector = new DbConnector();

    public NewSale() {
        ArrayList<Produit> produits = null;
        ArrayList<Produit> newSale = new ArrayList<Produit>();
        try {
            produits = connector.selectAllProducts();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.setTitle("Octave POS");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        //Instanciation d'un objet JPanel
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        TableModel model = new NewSaleTableModel(newSale);
        JTable table = new JTable(model);
        JScrollPane scrollPane= new  JScrollPane(table);
        JPanel pan = new JPanel();
        pan.setLayout(new FlowLayout());
        for(Produit produit:produits){
            JButton productbtn = new JButton(produit.getNom());
            pan.add(productbtn);
            productbtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!checkExist(newSale,produit.getId())){
                        System.out.println(produit.getNom() + " " + produit.getPrix());
                        produit.setQuantity(1);
                        newSale.add(produit);
                        table.repaint();
                        table.revalidate();
                    }
                    else {
                        System.out.println("product exist adding +1 to quantity !!");
                        newSale.remove(produit);
                        produit.setQuantity(produit.quantity++);
                        System.out.println(produit.getQuantity());
                        newSale.add(produit);
                        table.repaint();
                        table.revalidate();
                    }


                }
            });
        }
        main.add(pan,BorderLayout.CENTER);
        main.add(scrollPane,BorderLayout.EAST);
        this.setContentPane(main);
        this.setVisible(true);

    }

    public boolean checkExist(ArrayList<Produit> aProduits, int id){
        for (Produit produit:aProduits){
            if (id == produit.getId()){
                return true;
            }
            else return false;
        }
        return false;
    }

}
