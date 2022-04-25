package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;

import controller.*;
import model.*;

public class Fen3_Gest_Com extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel p = new JPanel();
	private DefaultListModel<String> model;
	private JScrollPane scrollPane = new JScrollPane();
	private JScrollPane scrollPane2 = new JScrollPane();
	private JList<String> list = new JList<String>();
	private JList<String> list2 = new JList<String>();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	public static int count = 0;
	private JTextField t_rech= new JTextField();
	private JLabel l_main = new JLabel("Achats");
	
	JButton b_modifier = new JButton("Modifier");
	JButton b_ajouter = new JButton("Ajouter");
	JButton b_retour = new JButton("Retour");
	
	public JLabel nom = new JLabel(" ");
	public JLabel prenom = new JLabel();
	public JLabel identifiant_com = new JLabel(" ");
	public JLabel identifiant_cli = new JLabel(" ");
	public JLabel dateC = new JLabel(" ");
	public JLabel livraison = new JLabel(" ");
	public JLabel adresse = new JLabel(" ");
	public JLabel prix = new JLabel(" ");
	
	public JLabel r_nom = new JLabel(" ");
	public JLabel r_prenom = new JLabel();
	public JLabel r_identifiant_com = new JLabel(" ");
	public JLabel r_identifiant_cli = new JLabel(" ");
	public JLabel r_dateC = new JLabel(" ");
	public JLabel r_livraison = new JLabel(" ");
	public JLabel r_adresse = new JLabel(" ");
	public JLabel r_prix = new JLabel(" ");
	
	public JLabel label = new JLabel("Veuillez sélectionner un achat pour afficher ses informations");
	Commande com;
	
	public Fen3_Gest_Com(Magasin m) {
		
		// Fenêtre
			
		p = new JPanel();
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		p.setBackground(new Color(0, 153, 153));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Liste 1 (Liste des achats)
		
		ListCommande c = new ListCommande(m);
		
		model = new DefaultListModel<String>();
		for (int i = 0; i < c.getListCom().length; i++) {
			for (int j = 0; j < c.getListCom().length; j++) {
				if (Integer.parseInt((c.getListCom()[i]).split(" ")[0]) < Integer.parseInt((c.getListCom()[j]).split(" ")[0])) {
					String temp = c.getListCom()[i];
					c.getListCom()[i] = c.getListCom()[j];
							c.getListCom()[j] = temp;
				}
			}
		}
		for (int i = 0; i < c.getListCom().length; i++) {
			model.addElement(c.getListCom()[i]);
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
		
		// 	Liste 2 (Informations de l'achat sélectionné)
		
		model = new DefaultListModel<String>();
		
		label.setBounds(0,0,400,20);
		
		identifiant_com.setBounds	(50,20,200,20);
		identifiant_cli.setBounds 	(50,40,200,20);
		nom.setBounds			    (50,60,200,20);
		prenom.setBounds			(50,80,200,20);
		dateC.setBounds				(50,100,200,20);
		livraison.setBounds			(50,120,200,20);
		adresse.setBounds			(50,140,200,20);
		prix.setBounds				(50,160,200,20);  
		
		r_identifiant_com.setBounds	(200,20,200,20);
		r_identifiant_cli.setBounds	(200,40,200,20);
		r_nom.setBounds				(200,60,200,20);
		r_prenom.setBounds			(200,80,200,20);
		r_dateC.setBounds			(200,100,200,20);
		r_livraison.setBounds		(200,120,200,20);
		r_adresse.setBounds			(200,140,200,20);
		r_prix.setBounds			(200,160,200,20);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (!arg0.getValueIsAdjusting()) {
					
					label.setVisible(false);
					
					com = m.rchCm1(Integer.parseInt((list.getSelectedValue().toString()).split(" ")[0]));
					
					nom.setText("Nom :");
					prenom.setText("Prénom :");
					identifiant_com.setText("Identifiant commande :");
					identifiant_cli.setText("Identifiant client:");
					dateC.setText("Date :");
					adresse.setText("Adresse :");
					livraison.setText("Livraison :");
					prix.setText("Prix total : ");
					
					r_nom.setText(com.getClient().getNom());
					r_prenom.setText((com.getClient()).getPrenom());
					r_identifiant_com.setText(String.valueOf(com.getId()));
					r_dateC.setText(com.getDateAchat().toString());
					r_identifiant_cli.setText(String.valueOf((com.getClient()).getId()));	         
					r_adresse.setText((com.getClient()).getAdresse());
					r_prix.setText(Float.toString(com.getPrixTotal()));
				
				}
			}
		});
		panel2.add(label);
		panel2.add(nom);
		panel2.add(prenom);
		panel2.add(identifiant_com);
		panel2.add(identifiant_cli);
		panel2.add(adresse);
		panel2.add(livraison);
		panel2.add(dateC);
		panel2.add(prix);
		
		panel2.add(r_nom);
		panel2.add(r_prenom);
		panel2.add(r_identifiant_com);
		panel2.add(r_identifiant_cli);
		panel2.add(r_adresse);
		panel2.add(r_dateC);
		panel2.add(r_prix);
		
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
		
		// Textfield - Recherche d'un achat
		
		t_rech.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_rech.setText("Recherchez un achat...");
		t_rech.setBounds(50, 100, 890, 45);
		p.add(t_rech);
		t_rech.setColumns(10);
		
		// JLabel "Achats"
		
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
				dispose();
				new Fen4_Gest_ModifLiv(m);
			}
		});
		p.add(b_modifier);
	
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen2_Gest(m);
			}
		});
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_retour.setBounds(540, 650, 400, 60);
		b_retour.setBackground(new Color(200, 100, 100));
		p.add(b_retour);
	}
}
