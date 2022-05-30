package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import controller.*;
import model.*;

public class Fen3_Gest_Liv extends JFrame {

	private static final long serialVersionUID = 1L;
	Livre liv;
	
	public Fen3_Gest_Liv(Magasin m) {
		
		ListLivres l = new ListLivres(m, m.listLivre);
		
		// Fenêtre

		Toolkit tk = Toolkit.getDefaultToolkit();  
        Image img = tk.getImage("src/resources/logo.png");
		setIconImage(img);
		JPanel p = new JPanel();
		setTitle("Gestion des livres");
		p = new JPanel();
		p.setBackground(new Color(119, 181, 254));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// JLabel "Livres"
		
		JLabel l_main = new JLabel("Gestion des livres");
		l_main.setHorizontalAlignment(SwingConstants.CENTER);
		l_main.setFont(new Font("Arial", Font.BOLD, 50));
		l_main.setBounds(10, 15, 964, 57);
		p.add(l_main);
		
		// ComboBox - Filtre
		
		JComboBox<String> c_filtre = new JComboBox<String>();
		c_filtre.setFont(new Font("Tahoma", Font.PLAIN, 23));
        c_filtre.setModel(new DefaultComboBoxModel<String>(new String[] {
        		"Catégorie", 
        		"Titre", 
        		"ID Livre", 
        		"Auteur", 
        		"Date de parution", 
        		"Éditeur"}));
        c_filtre.setBounds(540, 100, 400, 48);
		p.add(c_filtre);
		
		// Liste 1 (Liste de livres)

		JPanel panel1 = new JPanel();
        panel1.setBounds(50, 175, 400, 440);
        panel1.setLayout(null);
        p.add(panel1);
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		
        for (int i = 0; i < l.getList().length; i++) {
			for (int j = 0; j < l.getList().length; j++) {
				if (Integer.parseInt((l.getList()[i]).split(" ")[0]) < Integer.parseInt((l.getList()[j]).split(" ")[0])) {
					String temp = l.getList()[i];
					l.getList()[i] = l.getList()[j];
					l.getList()[j] = temp;
				}
			}
		}
        for(int i = 0; i < l.getList().length; i++) {
        	model.addElement(l.getList()[i]);
        }
        
		JList<String> list = new JList<String>();
        list.setModel(model);
        list.setFont(new Font("Tahoma", Font.PLAIN, 15));
        list.setLayoutOrientation(JList.VERTICAL);
        
        
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(list);
        scrollPane.setBounds(0, 0, 400, 440);
        panel1.add(scrollPane);
        
        // Liste 2 (Informations du livre sélectionné)
        
        JPanel panel2 = new JPanel();
		panel2.setBounds(540, 175, 400, 345);
		panel2.setLayout(null);
		p.add(panel2);
		
		DefaultListModel<String> model2 = new DefaultListModel<String>();
       
		JLabel label = new JLabel("Veuillez sélectionner un livre pour afficher ses informations.");
        label.setBounds(0,0,400,20);
        label.setHorizontalAlignment(SwingConstants.CENTER);
		panel2.add(label);
		
		JLabel titre = new JLabel(" ");
		JLabel auteur = new JLabel();
		JLabel identifiant = new JLabel(" ");
		JLabel editeur = new JLabel(" ");
		JLabel dateParution  = new JLabel(" ");
		JLabel prix = new JLabel(" ");
		JLabel categorie = new JLabel(" ");
		JLabel stock = new JLabel(" ");
		
		JLabel r_titre = new JLabel(" ");
		JLabel r_auteur = new JLabel();
		JLabel r_identifiant = new JLabel(" ");
		JLabel r_editeur = new JLabel(" ");
		JLabel r_dateParution  = new JLabel(" ");
		JLabel r_prix = new JLabel(" ");
		JLabel r_categorie = new JLabel(" ");
		JLabel r_stock = new JLabel(" ");
		
        titre.setBounds			(25,20,200,25);
        auteur.setBounds		(25,55,200,25);
		identifiant.setBounds	(25,90,200,25);
		editeur.setBounds		(25,125,200,25);
		dateParution.setBounds	(25,160,200,25);
		prix.setBounds			(25,195,200,25);
		categorie.setBounds		(25,230,200,25);
		stock.setBounds			(25,265,200,25);
		
		r_titre.setBounds		(150,20,225,25);
		r_auteur.setBounds		(150,55,225,25);
		r_identifiant.setBounds	(150,90,225,25);
		r_editeur.setBounds		(150,125,225,25);
		r_dateParution.setBounds(200,160,200,25);
		r_prix.setBounds		(150,195,225,25);
		r_categorie.setBounds	(150,230,225,25);
		r_stock.setBounds		(150,265,225,25);
		
		Font f = new Font("Tahoma", Font.PLAIN, 20);
		titre.setFont(f);
		auteur.setFont(f);
		identifiant.setFont(f);
		editeur.setFont(f);
		dateParution.setFont(f);
		prix.setFont(f);
		categorie.setFont(f);
		stock.setFont(f);
		
		r_titre.setFont(f);
		r_auteur.setFont(f);
		r_identifiant.setFont(f);
		r_editeur.setFont(f);
		r_dateParution.setFont(f);
		r_prix.setFont(f);
		r_categorie.setFont(f);
		r_stock.setFont(f);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (!arg0.getValueIsAdjusting()) {
					label.setVisible(false);
					if (list.getSelectedValue() != null) {
						liv = m.rchLivreId(Integer.parseInt((list.getSelectedValue().toString()).split(" ")[0]));
						
						titre.setText("Titre : ");
						auteur.setText("Auteur : ");
	                	identifiant.setText("Identifiant : ");
	                	editeur.setText("Éditeur : ");
	                	dateParution.setText("Date de parution : ");
	                	prix.setText("Prix : ");
	                	categorie.setText("Catégorie : ");
	                	stock.setText("Stock");
	                	
	                	r_titre.setText(liv.getTitre());
	                	r_auteur.setText(liv.getAuteur());
	                	r_identifiant.setText(String.valueOf(liv.getId()));
	                	r_editeur.setText(liv.getEditeur());
	                	r_dateParution.setText(liv.getDateParution().toString());
	                	r_prix.setText(String.valueOf(liv.getPrix()) + " \u20AC");
	                	r_categorie.setText(liv.getCategorie());
	                	r_stock.setText(String.valueOf(liv.getStock()));
					}
				}
			}
		});
		
		panel2.add(titre);
		panel2.add(auteur);
		panel2.add(identifiant);
		panel2.add(editeur);
		panel2.add(dateParution);
		panel2.add(prix);
		panel2.add(categorie);
		panel2.add(stock);
		
		panel2.add(r_titre);
		panel2.add(r_auteur);
		panel2.add(r_identifiant);
		panel2.add(r_editeur);
		panel2.add(r_dateParution);
		panel2.add(r_prix);
		panel2.add(r_categorie);
		panel2.add(r_stock);
		
		JList<String> list2 = new JList<String>();
		list2.setModel(model2);
		list2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        list2.setLayoutOrientation(JList.VERTICAL);
        
		JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setViewportView(list2);
		scrollPane2.setBounds(0, 0, 400, 345);
		panel2.add(scrollPane2);

		// Textfield - Recherche d'un livre
		
		JTextField t_rech = new JTextField();
		t_rech.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_rech.setText("Recherchez un livre");
		t_rech.setBounds(50, 100, 345, 45);
		t_rech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.clear();
				ListLivres def = new ListLivres(m,new RechercheLivre(m, t_rech, c_filtre.getSelectedItem().toString() ).getList());
				String[] a = def.getList();
				if(a.length == 0) {
					if(t_rech.getText().equals("")) {
						for(int i = 0; i < l.getList().length; i++) {
							model.addElement(l.getList()[i]);
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
					JOptionPane.showMessageDialog(f, "Veuillez s\u00E9lectionner un livre.", "Erreur", 2);
				}
				else {
				dispose();
				new Fen4_Gest_ModifLiv(m, liv);}
			}
			
		});
		p.add(b_modifier);
		
		JButton b_ajouter = new JButton("Ajouter");
		b_ajouter.setIcon(null);
		b_ajouter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen4_Gest_NewLiv(m);
			}
		});
		b_ajouter.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b_ajouter.setBounds(50, 650, 400, 60);
		b_ajouter.setBackground(new Color(100, 200, 120));
		p.add(b_ajouter);
        
		JButton b_retour = new JButton("Retour");
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

		JButton b_clearSearch = new JButton("X");
		b_clearSearch.setForeground(new Color(255, 255, 255));
		b_clearSearch.setBackground(new Color(165, 42, 42));
		b_clearSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		b_clearSearch.setBounds(405, 100, 45, 45);
		b_clearSearch.setToolTipText("Efface la recherche");
		b_clearSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t_rech.setText("");
				model.clear();
				for (int i = 0; i < l.getList().length; i++) {
					for (int j = 0; j < l.getList().length; j++) {
						if (Integer.parseInt((l.getList()[i]).split(" ")[0]) < Integer.parseInt((l.getList()[j]).split(" ")[0])) {
							String temp = l.getList()[i];
							l.getList()[i] = l.getList()[j];
							l.getList()[j] = temp;
						}
					}
				}
		        for(int i = 0; i < l.getList().length; i++) {
		        	model.addElement(l.getList()[i]);
		        }
			}
		});
		p.add(b_clearSearch);
	}
}