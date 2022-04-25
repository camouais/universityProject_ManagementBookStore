package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.ListClient;
import controller.ListEmploye;
import model.*;

public class Fen3_Gest_Cli extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel p = new JPanel();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
    private DefaultListModel<String> model;
    private JList<String> list = new JList<String>();
    private JList<String> list2 = new JList<String>();
    public static int count = 0;
	private JTextField t_rech= new JTextField();
	private JLabel l_main = new JLabel("Clients");
    
	JScrollPane scrollPane = new JScrollPane();
    JScrollPane scrollPane2 = new JScrollPane();
	JButton b_modifier = new JButton("Modifier");
	JButton b_ajouter = new JButton("Ajouter");
	JButton b_retour = new JButton("Retour");

	
	public JLabel nom = new JLabel(" ");
    public JLabel prenom = new JLabel();
    public JLabel identifiant = new JLabel(" ");
    public JLabel mail = new JLabel(" ");
    public JLabel dateC = new JLabel(" ");
    public JLabel adresse = new JLabel(" ");
    public JLabel tel = new JLabel(" ");
    
    
    public JLabel r_nom = new JLabel(" ");
    public JLabel r_prenom = new JLabel();
    public JLabel r_identifiant = new JLabel(" ");
    public JLabel r_dateC = new JLabel(" ");
    public JLabel r_mail = new JLabel(" ");
    public JLabel r_adresse = new JLabel(" ");
    public JLabel r_tel = new JLabel(" ");
	
	
	
	
	
	public JLabel label = new JLabel("Veuillez sélectionné un client pour afficher ses informations");
    
	Client cli;
	
	public Fen3_Gest_Cli(Magasin m) {
		
		// Fenêtre
		
		p = new JPanel();
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		p.setBackground(new Color(150, 131, 236));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Liste 1 (Liste de clients)
		
		ListClient e = new ListClient(m);
		
		model = new DefaultListModel<String>();
        for (int i = 0; i < e.getListCli().length; i++) {
            for (int j = 0; j < e.getListCli().length; j++) {
                if (Integer.parseInt((e.getListCli()[i]).split(" ")[0]) < Integer.parseInt((e.getListCli()[j]).split(" ")[0])) {
                    String temp = e.getListCli()[i];
                    e.getListCli()[i] = e.getListCli()[j];
                    e.getListCli()[j] = temp;
                }
            }
        }
        for (int i = 0; i < e.getListCli().length; i++) {
            model.addElement(e.getListCli()[i]);
        }
        
        list.setModel(model);
        
        list.setFont(new Font("Tahoma", Font.PLAIN, 15));
        scrollPane.setViewportView(list);
        list.setLayoutOrientation(JList.VERTICAL);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel1.setBounds(50, 175, 400, 440);
        panel1.setLayout(null);
        scrollPane.setBounds(0, 0, 400, 440);
        panel1.add(scrollPane);
        p.add(panel1);
        
        // Liste 2 (Informations du client sélectionné)
        
        model = new DefaultListModel<String>();
        
        
       
        label.setBounds(0,0,400,20);
        
        
        
        nom.setBounds			(50,20,200,20);
        prenom.setBounds		(50,40,200,20);
        identifiant.setBounds	(50,60,200,20);
        mail.setBounds			(50,80,200,20);
        adresse.setBounds		(50,100,200,20);
        tel.setBounds			(50,120,200,20);
         
        
        r_nom.setBounds			(200,20,200,20);
        r_prenom.setBounds		(200,40,200,20);
        r_identifiant.setBounds	(200,60,200,20);
        r_mail.setBounds		(200,80,200,20);
        r_adresse.setBounds		(200,100,200,20);
        r_tel.setBounds			(200,120,200,20);
        
        
        list.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                	
                	label.setVisible(false);
                	
             
                	cli = m.rchCli(Integer.parseInt((list.getSelectedValue().toString()).split(" ")[0]));
                	
                	
                	nom.setText("Nom :");
                	prenom.setText("Prénom :");
                	identifiant.setText("Identifiant :");
                	mail.setText("Mail :");
                	adresse.setText("Adresse :");
                	tel.setText("Téléphone :");
                	
                	r_nom.setText(cli.getNom());
                	r_prenom.setText(cli.getPrenom());
                	r_identifiant.setText(String.valueOf(cli.getId()));
                	r_mail.setText(cli.getMail());
                	r_adresse.setText(cli.getAdresse());
                	r_tel.setText(cli.getTel());
                	
                }
            }
        });
        panel2.add(label);
        panel2.add(nom);
        panel2.add(prenom);
        panel2.add(identifiant);
        panel2.add(mail);
        panel2.add(adresse);
        panel2.add(tel);
        
        panel2.add(r_nom);
        panel2.add(r_prenom);
        panel2.add(r_identifiant);
        panel2.add(r_mail);
        panel2.add(r_adresse);
        panel2.add(r_tel);
        
        
        list2.setModel(model);
        
        list2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        scrollPane2.setViewportView(list2);
        list2.setLayoutOrientation(JList.VERTICAL);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel2.setBounds(540, 175, 400, 345);
		panel2.setLayout(null);
		scrollPane2.setBounds(0, 0, 400, 345);
		panel2.add(scrollPane2);
		p.add(panel2);

		// Text Field : Recherche d'un client
		
		t_rech.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_rech.setText("Recherchez un client...");
		t_rech.setBounds(50, 100, 890, 45);
		p.add(t_rech);
		t_rech.setColumns(10);
		
		// JLabel "Clients"
		
		l_main.setHorizontalAlignment(SwingConstants.CENTER);
		l_main.setFont(new Font("Arial", Font.BOLD, 50));
		l_main.setBounds(10, 15, 964, 57);
		p.add(l_main);
		
		// Boutons : Modifier, Ajouter, Retour
		
		b_modifier.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b_modifier.setBounds(540, 555, 400, 60);
		b_modifier.setBackground(new Color(200, 200, 100));
		b_modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedValue()==null) {
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "Veuillez sélectionner un client.", "Erreur", 2);
				}
				else {
				dispose();
				new Fen4_Gest_ModifCli(m, cli);
				}
			}
		});
		p.add(b_modifier);
		
		b_ajouter.addActionListener(new ActionListener() {
        
            public void actionPerformed(ActionEvent e) {
            	dispose();
            	new Fen4_Gest_NewCli(m);       
            }
		});
		b_ajouter.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b_ajouter.setBounds(50, 650, 400, 60);
		b_ajouter.setBackground(new Color(100, 200, 120));
		p.add(b_ajouter);
        
		
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_retour.setBounds(540, 650, 400, 60);
		b_retour.setBackground(new Color(200, 100, 100));
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen2_Gest(m);
			}
		});
		p.add(b_retour);
	}
}
