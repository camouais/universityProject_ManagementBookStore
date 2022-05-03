package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.*;
import model.*;




public class Fen3_Gest_Com extends JFrame {
		
		private static final long serialVersionUID = 1L;

		private JPanel p = new JPanel();
	    private DefaultListModel<String> model;
		private DefaultListModel<String> model2;
		private JScrollPane scrollPane = new JScrollPane();
	    private JScrollPane scrollPane2 = new JScrollPane();
	    private JList<String> list = new JList<String>();
	    private JList<String> list2 = new JList<String>();
		private JPanel panel1 = new JPanel();
		private JPanel panel2 = new JPanel();
	    public static int count = 0;
		private JTextField t_rech= new JTextField();
		private JLabel l_main = new JLabel("Achats");
	    
		JButton b_ajouter = new JButton("Ajouter");
		JButton b_retour = new JButton("Retour");

		public JLabel nom = new JLabel(" ");
		public JLabel prenom = new JLabel();
		public JLabel identifiant_com = new JLabel(" ");
		public JLabel identifiant_cli = new JLabel(" ");
		public JLabel dateC = new JLabel(" ");
		public JLabel prix = new JLabel(" ");

		public JLabel r_nom = new JLabel(" ");
		public JLabel r_prenom = new JLabel();
		public JLabel r_identifiant_com = new JLabel(" ");
		public JLabel r_identifiant_cli = new JLabel(" ");
		public JLabel r_dateC = new JLabel(" ");
		public JLabel r_prix = new JLabel(" ");

		JButton b_clearSearch = new JButton("X");
		public JLabel label = new JLabel("Veuillez s�lectionner un achat pour afficher ses informations");

		private final JComboBox<String> c_filtre = new JComboBox<String>();
		Commande com;
    
		
		public Fen3_Gest_Com(Magasin m) {
			
			// Fen�tre
			
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
			
			ListCommande c = new ListCommande(m, m.listCom);
			
			model = new DefaultListModel<String>();
	        for (int i = 0; i < c.getList().length; i++) {
	            for (int j = 0; j < c.getList().length; j++) {
	                if (Integer.parseInt((c.getList()[i]).split(" ")[0]) < Integer.parseInt((c.getList()[j]).split(" ")[0])) {
	                    String temp = c.getList()[i];
	                    c.getList()[i] = c.getList()[j];
	                    c.getList()[j] = temp;
	                }
	            }
	        }
	        for (int i = 0; i < c.getList().length; i++) {
	            model.addElement(c.getList()[i]);
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
	        
	        // Liste 2 (Informations de l'achat s�lectionn�)
	        
	        model2 = new DefaultListModel<String>();
	        
	        
	        
	        label.setBounds(0,0,400,20);
	        
	        
	        
	        identifiant_com.setBounds	(50,20,200,20);
	        identifiant_cli.setBounds 	(50,40,200,20);
	        nom.setBounds			    (50,60,200,20);
	        prenom.setBounds			(50,80,200,20);
	        dateC.setBounds				(50,100,200,20);
	        prix.setBounds				(50,120,200,20);
	        r_identifiant_com.setBounds	(200,20,200,20);
	        r_identifiant_cli.setBounds	(200,40,200,20);
	        r_nom.setBounds				(200,60,200,20);
	        r_prenom.setBounds			(200,80,200,20);
	        r_dateC.setBounds			(200,100,200,20);
	        r_prix.setBounds			(200,120,200,20);
	       
	        
	        list.addListSelectionListener(new ListSelectionListener() {

	            public void valueChanged(ListSelectionEvent arg0) {
	                if (!arg0.getValueIsAdjusting()) {
	                	
	                	label.setVisible(false);
	                	
	             
	                	com = m.rchCm1(Integer.parseInt((list.getSelectedValue().toString()).split(" ")[0]));
	                	
	                	
	                	nom.setText("Nom :");
	                	prenom.setText("Pr�nom :");
	                	identifiant_com.setText("Identifiant commande :");
	                	identifiant_cli.setText("Identifiant client:");
	                	dateC.setText("Date :");
	                	prix.setText("Prix total : ");
	                	
	                	r_nom.setText(com.getClient().getNom());
	                	r_prenom.setText((com.getClient()).getPrenom());
	                	r_identifiant_com.setText(String.valueOf(com.getId()));
	                	r_dateC.setText(com.getDateAchat().toString());
	                	r_identifiant_cli.setText(String.valueOf((com.getClient()).getId()));	
	                	r_prix.setText(com.getPrixTotal());
	                	
	                }
	            }
	        });
	        
	        c_filtre.setFont(new Font("Tahoma", Font.PLAIN, 23));
	        c_filtre.setModel(new DefaultComboBoxModel<String>(new String[] 
	        		{"id achat", "Nom client", "Prenom client", "id client", "Date"}));
	        c_filtre.setBounds(480, 100, 200, 48);
			p.add(c_filtre);
			
			
	        panel2.add(label);
	        panel2.add(nom);
	        panel2.add(prenom);
	        panel2.add(identifiant_com);
	        panel2.add(identifiant_cli);
	        panel2.add(dateC);
	        panel2.add(prix);
	        
	        panel2.add(r_nom);
	        panel2.add(r_prenom);
	        panel2.add(r_identifiant_com);
	        panel2.add(r_identifiant_cli);
	        panel2.add(r_dateC);
	        panel2.add(r_prix);
	        
	        list2.setModel(model2);
	        
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
			t_rech.setText("Recherchez un achat");
			t_rech.setBounds(50, 100, 345, 45);
			t_rech.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					model.clear();
					ListCommande def = new ListCommande(m,new RechercheAchat(m, t_rech, c_filtre.getSelectedItem().toString() ).getList());
					String[] a = def.getList();
					if(a.length == 0) {
						if(t_rech.getText().equals("")) {
							JFrame aa = new JFrame();
						    JOptionPane.showMessageDialog(aa, "Recherche vide.", "Erreur", 2);
							for(int i = 0; i < c.getList().length; i++) {
								model.addElement(c.getList()[i]);
							}
						}
					} else {
						for (int i = 0; i < def.getList().length; i++) {
							for (int j = 0; j < def.getList().length; j++) {
								if (Integer.parseInt((def.getList()[i]).split(" ")[0]) < Integer.parseInt((def.getList()[j]).split(" ")[0])) {
									String temp = def.getList()[i];
									def.getList()[i] = def.getList()[j];
									def.getList()[j] = temp;
								}
							}
						}
						for (int i = 0; i < def.getList().length; i++) {
							model.addElement(def.getList()[i]);
						}
					}
				}
			});
			
			p.add(t_rech);
			t_rech.setColumns(10);
			// JLabel "Achats"
			
			l_main.setHorizontalAlignment(SwingConstants.CENTER);
			l_main.setFont(new Font("Arial", Font.BOLD, 50));
			l_main.setBounds(10, 15, 964, 57);
			p.add(l_main);
			
			// Boutons :  Ajouter, Retour
		
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
			

			b_clearSearch.setForeground(new Color(255, 255, 255));
			b_clearSearch.setBackground(new Color(165, 42, 42));
			b_clearSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
			b_clearSearch.setBounds(405, 100, 45, 45);
			b_clearSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					t_rech.setText("");
					model.clear();
					for (int i = 0; i < c.getList().length; i++) {
						for (int j = 0; j < c.getList().length; j++) {
							if (Integer.parseInt((c.getList()[i]).split(" ")[0]) < Integer.parseInt((c.getList()[j]).split(" ")[0])) {
								String temp = c.getList()[i];
								c.getList()[i] = c.getList()[j];
								c.getList()[j] = temp;
							}
						}
					}
			        for(int i = 0; i < c.getList().length; i++) {
			        	model.addElement(c.getList()[i]);
			        }
				}
			});
			p.add(b_clearSearch);
		}

}