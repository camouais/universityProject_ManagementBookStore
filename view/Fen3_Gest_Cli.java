package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.ListClient;
import controller.RechercheClient;
import model.*;

public class Fen3_Gest_Cli extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Client cli;
	
	public Fen3_Gest_Cli(Magasin m) {
		
		// Fenêtre
		
		JPanel p = new JPanel();
		setTitle("Gestion des clients");
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
		
		// Label
		
		JLabel l_main = new JLabel("Clients");
		l_main.setHorizontalAlignment(SwingConstants.CENTER);
		l_main.setFont(new Font("Arial", Font.BOLD, 50));
		l_main.setBounds(10, 15, 964, 57);
		p.add(l_main);
		
		// ComboBox - Filtre
		
		JComboBox<String> c_filtre = new JComboBox<String>();
		c_filtre.setFont(new Font("Tahoma", Font.PLAIN, 23));
        c_filtre.setModel(new DefaultComboBoxModel<String>(new String[] {
        		"Nom", 
        		"Pr\u00E9nom", 
        		"ID Client", 
        		"Adresse", 
        		"Date de naissance", 
        		"\u00C2ge", 
        		"Sexe", 
        		"Date de cr\u00E9ation du compte", 
        		"T\u00E9l\u00E9phone", 
        		"Mail"}));
        c_filtre.setBounds(540, 100, 400, 48);
		p.add(c_filtre);
		
		// Liste 1 (Liste de clients)
		
		JPanel panel1 = new JPanel();
        panel1.setBounds(50, 175, 400, 440);
        panel1.setLayout(null);
        p.add(panel1);
        
		ListClient c = new ListClient(m, m.listClient);
    	DefaultListModel<String> model = new DefaultListModel<String>();
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
        
    	JList<String> list = new JList<String>();
        list.setModel(model);
        list.setFont(new Font("Tahoma", Font.PLAIN, 15));
        list.setLayoutOrientation(JList.VERTICAL);
        
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);
        scrollPane.setBounds(0, 0, 400, 440);
        panel1.add(scrollPane);
        
        // Liste 2 (Informations du client sélectionné)
        
		JPanel panel2 = new JPanel();
		panel2.setBounds(540, 175, 400, 345);
		panel2.setLayout(null);
		p.add(panel2);
		
		DefaultListModel<String> model2 = new DefaultListModel<String>();
        
		JLabel label = new JLabel("Veuillez s\u00E9lectionner un client pour afficher ses informations.");
        label.setBounds(0,0,400,20);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel2.add(label);
        
        JLabel nom = new JLabel(" ");
	    JLabel prenom = new JLabel();
	    JLabel identifiant = new JLabel(" ");
	    JLabel mail = new JLabel(" ");
	    JLabel adresse = new JLabel(" ");
	    JLabel tel = new JLabel(" ");
	    
	    JLabel r_nom = new JLabel(" ");
	    JLabel r_prenom = new JLabel();
	    JLabel r_identifiant = new JLabel(" ");
	    JLabel r_mail = new JLabel(" ");
	    JLabel r_adresse = new JLabel(" ");
	    JLabel r_tel = new JLabel(" ");
	    
        nom.setBounds			(25,20,200,25);
        prenom.setBounds		(25,55,200,25);
        identifiant.setBounds	(25,90,200,25);
        mail.setBounds			(25,125,200,25);
        adresse.setBounds		(25,160,200,25);
        tel.setBounds			(25,195,200,25);
        
        r_nom.setBounds			(150,20,250,25);
        r_prenom.setBounds		(150,55,250,25);
        r_identifiant.setBounds	(150,90,250,25);
        r_mail.setBounds		(150,125,250,25);
        r_adresse.setBounds		(150,160,250,25);
        r_tel.setBounds			(150,195,250,25);
        
        Font f = new Font("Tahoma", Font.PLAIN, 20);
        nom.setFont(f);
        prenom.setFont(f);
        identifiant.setFont(f);
        mail.setFont(f);
        adresse.setFont(f);
        tel.setFont(f);
        
        r_nom.setFont(f);
        r_prenom.setFont(f);
        r_identifiant.setFont(f);
        r_mail.setFont(f);
        r_adresse.setFont(f);
        r_tel.setFont(f);
        
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                	label.setVisible(false);
                	if (list.getSelectedValue() != null) {
	                	cli = m.rchCli(Integer.parseInt((list.getSelectedValue().toString()).split(" ")[0]));
	                	nom.setText("Nom :");
	                	prenom.setText("Pr\u00E9nom :");
	                	identifiant.setText("Identifiant :");
	                	mail.setText("Mail :");
	                	adresse.setText("Adresse :");
	                	tel.setText("T\u00E9l\u00E9phone :");
	                	
	                	r_nom.setText(cli.getNom());
	                	r_prenom.setText(cli.getPrenom());
	                	r_identifiant.setText(String.valueOf(cli.getId()));
	                	r_mail.setText(cli.getMail());
	                	r_adresse.setText(cli.getAdresse());
	                	r_tel.setText(cli.getTel());
                	}
                }
            }
        });
		
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
        
    	JList<String> list2 = new JList<String>();
		list2.setModel(model2);
        list2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        list2.setLayoutOrientation(JList.VERTICAL);
        
   	 	JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(0, 0, 400, 345);
        scrollPane2.setViewportView(list2);
		panel2.add(scrollPane2);

		// Text Field : Recherche d'un client
		
		JTextField t_rech= new JTextField();
		t_rech.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_rech.setText("Recherchez un client");
		t_rech.setBounds(50, 100, 345, 45);
		t_rech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.clear();
				ListClient def = new ListClient(m,new RechercheClient(m, t_rech, c_filtre.getSelectedItem().toString() ).getList());
				String[] a = def.getList();
				if(a.length == 0) {
					if(t_rech.getText().equals("")) {
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
		
		// Boutons : Modifier, Ajouter, Retour
		
		JButton b_modifier = new JButton("Modifier");
		b_modifier.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b_modifier.setBounds(540, 555, 400, 60);
		b_modifier.setBackground(new Color(200, 200, 100));
		b_modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedValue()==null) {
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "Veuillez s\u00E9lectionner un client.", "Erreur", 2);
				} else {
					dispose();
					new Fen4_Gest_ModifCli(m, cli);
				}
			}
		});
		p.add(b_modifier);
		
		JButton b_ajouter = new JButton("Ajouter");
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
		
		JButton b_retour = new JButton("Retour");
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
		
		JButton b_clearSearch = new JButton("X");
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