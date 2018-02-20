import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClientsUI extends JFrame implements ActionListener {

    private static ArrayList<Client> clients = new ArrayList<Client>();
    private JButton addClient = new JButton("Ajouter");

    public ClientsUI(){
        try {
            onLoad();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(clients.size()>0) System.out.println("Success");

        TableModel model = new ClientsTableModel(clients);
        JTable table = new JTable(model);
        JScrollPane scrollPane= new  JScrollPane(table);

        this.setTitle("Octave POS - Clients");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        //Instanciation d'un objet JPanel
        JPanel pan = new JPanel();
        //pan.setLayout(new BorderLayout());
        pan.setLayout(new FlowLayout());
        pan.add(scrollPane);
        pan.add(addClient);

        this.setContentPane(pan);

        this.setVisible(true);
        addClient.addActionListener(this);
    }

    public void onLoad() throws ClassNotFoundException {
        DbConnector connector = new DbConnector();
        clients = connector.selectAllClients();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object  source=e.getSource();

        if  (source==addClient) {
            System.out.println("Ajouter Client !");
            AddClientUI addclientui = new AddClientUI();
            addclientui.show();
        }
    }
}

