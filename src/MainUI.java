import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainUI extends JFrame implements ActionListener {

    private JButton products = new JButton("Produits");
    private JButton clients = new JButton("Clients");
    private JButton sales = new JButton("Ventes");
    private JButton newSale = new JButton("Nouvelle Vente");

    public MainUI() throws IOException {

        this.setTitle("Octave POS");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        //Instanciation d'un objet JPanel
        JPanel pan = new JPanel();
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        pan.setLayout(new FlowLayout());
        pan.add(products);
        pan.add(clients);
        pan.add(sales);
        pan.add(newSale);
        main.add(pan,BorderLayout.EAST);
        BufferedImage myPicture = ImageIO.read(new File("src/averbel-logo.jpg"));
        JLabel pic = new JLabel(new ImageIcon(myPicture));
        main.add(pic,BorderLayout.WEST);
        this.setContentPane(main);

        this.setVisible(true);

        //Actions

        newSale.addActionListener(this);
        sales.addActionListener(this);
        clients.addActionListener(this);
        products.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object  source=e.getSource();

        if  (source==newSale) {
            System.out.println("Nouvelle Vente !");
            NewSale newsale = new NewSale();
            newsale.show();
        }
        else if (source==clients) {
            System.out.println("Clients");
            ClientsUI clientsui = new ClientsUI();
            clientsui.show();
        }
        else if (source==products) {
            System.out.println("Produits");
            ProductsUI productsui = new ProductsUI();
            productsui.show();
        }
        else if (source==sales)
            System.out.println("Ventes");
    }
}
