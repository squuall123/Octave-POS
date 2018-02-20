import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductUI extends JFrame implements ActionListener {

    public Dimension TXT_DIMENTION = new Dimension(200,30);
    JLabel main = new JLabel("Ajouter Produit !");
    JLabel nomLabel = new JLabel("Nom");
    JLabel quantityLabel = new JLabel("Quantitée");
    JLabel priceLabel = new JLabel("Prix");
    JTextField nomField = new JTextField();
    JTextField quantityField = new JTextField();
    JTextField priceField = new JTextField();
    JButton reset = new JButton("Reset");
    JButton valider = new JButton("Valider");

    public AddProductUI(){
        nomField.setPreferredSize(TXT_DIMENTION);
        quantityField.setPreferredSize(TXT_DIMENTION);
        priceField.setPreferredSize(TXT_DIMENTION);
        this.setTitle("Octave POS - Produits");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        //Instanciation d'un objet JPanel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JPanel pan = new JPanel();
        JPanel nomPanel = new JPanel();
        nomPanel.setLayout(new FlowLayout());
        nomPanel.add(nomLabel);
        nomPanel.add(nomField);
        JPanel addressPanel = new JPanel();
        addressPanel.setLayout(new FlowLayout());
        addressPanel.add(quantityLabel);
        addressPanel.add(quantityField);
        JPanel phonePanel = new JPanel();
        phonePanel.setLayout(new FlowLayout());
        phonePanel.add(priceLabel);
        phonePanel.add(priceField);
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout());
        btnPanel.add(valider);
        btnPanel.add(reset);
        //pan.setLayout(new BorderLayout());
        pan.setLayout(new GridLayout(4,1));
        pan.add(nomPanel);
        pan.add(addressPanel);
        pan.add(phonePanel);
        pan.add(btnPanel);
        mainPanel.add(main,BorderLayout.NORTH);
        mainPanel.add(pan,BorderLayout.CENTER);
        this.setContentPane(mainPanel);
        this.setVisible(true);

        valider.addActionListener(this);
        reset.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object  source=e.getSource();

        if  (source==valider) {

            if(nomField.getText().isEmpty() || quantityField.getText().isEmpty() || priceField.getText().isEmpty()){
                System.out.println("cases vides !");
            } else {
                DbConnector connector = new DbConnector();
                try {
                    connector.insertProduct(nomField.getText(),Integer.valueOf(quantityField.getText()),Float.valueOf(priceField.getText()));
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                System.out.println("Produit ajouté !");
            }

        }
        else if (source==reset) {
            nomField.setText(null);
            quantityField.setText(null);
            priceField.setText(null);
        }
    }
}
