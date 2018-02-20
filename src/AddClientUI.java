import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClientUI extends JFrame implements ActionListener {

    public Dimension TXT_DIMENTION = new Dimension(200,30);
    JLabel main = new JLabel("Ajouter Client !");
    JLabel nomLabel = new JLabel("Nom");
    JLabel addressLabel = new JLabel("Addresse");
    JLabel phoneLabel = new JLabel("Téléphone");
    JTextField nomField = new JTextField();
    JTextField addressField = new JTextField();
    JTextField phoneField = new JTextField();
    JButton reset = new JButton("Reset");
    JButton valider = new JButton("Valider");

    public AddClientUI(){
        nomField.setPreferredSize(TXT_DIMENTION);
        addressField.setPreferredSize(TXT_DIMENTION);
        phoneField.setPreferredSize(TXT_DIMENTION);
        this.setTitle("Octave POS - Clients");
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
        addressPanel.add(addressLabel);
        addressPanel.add(addressField);
        JPanel phonePanel = new JPanel();
        phonePanel.setLayout(new FlowLayout());
        phonePanel.add(phoneLabel);
        phonePanel.add(phoneField);
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

            if(nomField.getText().isEmpty() || addressField.getText().isEmpty() || phoneField.getText().isEmpty()){
                System.out.println("cases vides !");
            } else {
                DbConnector connector = new DbConnector();
                try {
                    connector.insertClient(nomField.getText(),addressField.getText(),phoneField.getText());
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                System.out.println("Client ajouté !");
            }

        }
        else if (source==reset) {
            nomField.setText(null);
            addressField.setText(null);
            phoneField.setText(null);
        }
    }
}
