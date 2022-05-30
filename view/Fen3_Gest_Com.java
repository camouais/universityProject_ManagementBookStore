package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import controller.*;
import model.*;

public class Fen3_Gest_Com extends JFrame {
	
	private static final long serialVersionUID = 1L;
	Commande com;
	
	public Fen3_Gest_Com(Magasin m) {
		
		ListCommande c = new ListCommande(m, m.listCom);
		
		// Fenêtre

		Toolkit tk = Toolkit.getDefaultToolkit();  
        Image img = tk.getImage("src/resources/logo.png");
		setIconImage(img);
		JPanel p = new JPanel();
		setTitle("Gestion des achats");
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
		
		// ComboBox - Filtre
		
		JComboBox<String> c_filtre = new JComboBox<String>();
        c_filtre.setFont(new Font("Tahoma", Font.PLAIN, 23));
        c_filtre.setModel(new DefaultComboBoxModel<String>(new String[] {
        		"ID Achat", 
        		"ID Client", 
        		"Nom Client", 
        		"Pr\u00E9nom Client", 
        		"Date"}));
        c_filtre.setBounds(540, 100, 400, 48);
		p.add(c_filtre);
		
		// Label
		
		JLabel l_main = new JLabel("Achats");
		l_main.setHorizontalAlignment(SwingConstants.CENTER);
		l_main.setFont(new Font("Arial", Font.BOLD, 50));
		l_main.setBounds(10, 15, 964, 57);
		p.add(l_main);
		
		// Liste 1 (Liste des achats)
		
		JPanel panel1 = new JPanel();
        panel1.setBounds(50, 175, 400, 440);
        panel1.setLayout(null);
        p.add(panel1);
		
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
        
        // Liste 2 (Informations de l'achat sélectionné)
       	
       	JPanel panel2 = new JPanel();
		panel2.setBounds(540, 175, 400, 535);
		panel2.setLayout(null);
		p.add(panel2);
        
		DefaultListModel<String> model2 = new DefaultListModel<String>();
        
		JLabel label = new JLabel("Veuillez s\u00E9lectionner une commande pour afficher ses informations.");
        label.setBounds(0,0,400,20);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel2.add(label);
        
        JLabel nom = new JLabel(" ");
		JLabel prenom = new JLabel();
		JLabel id_com = new JLabel(" ");
		JLabel id_cli = new JLabel(" ");
		JLabel dateC = new JLabel(" ");
		JLabel prix = new JLabel(" ");
		JLabel articles = new JLabel(" ");

		JLabel r_nom = new JLabel(" ");
		JLabel r_prenom = new JLabel();
		JLabel r_id_com = new JLabel(" ");
		JLabel r_id_cli = new JLabel(" ");
		JLabel r_dateC = new JLabel(" ");
		JLabel r_prix = new JLabel(" ");
		JLabel r_articles = new JLabel(" ");
		r_articles.setVerticalAlignment(SwingConstants.TOP);
		r_articles.setHorizontalAlignment(SwingConstants.LEFT);

        id_com.setBounds	(20,20,200,20);
        id_cli.setBounds 	(20,55,200,20);
        nom.setBounds		(20,90,200,20);
        prenom.setBounds	(20,125,200,20);
        dateC.setBounds		(20,160,200,20);
        prix.setBounds		(20,195,200,20);
        articles.setBounds	(20,230,200,20);
        r_articles.setBounds(20,265,400,400);
        
        r_id_com.setBounds	(200,20,200,20);
        r_id_cli.setBounds	(200,55,200,20);
        r_nom.setBounds		(200,90,200,20);
        r_prenom.setBounds	(200,125,200,20);
        r_dateC.setBounds	(200,160,200,20);
        r_prix.setBounds	(200,195,200,20);
        
        Font f = new Font("Tahoma", Font.PLAIN, 20);
        
        id_com.setFont(f);
        id_cli.setFont(f);
        nom.setFont(f);
        prenom.setFont(f);
        dateC.setFont(f);
        prix.setFont(f);
        articles.setFont(f);
        
        r_id_com.setFont(f);
        r_id_cli.setFont(f);
        r_nom.setFont(f);
        r_prenom.setFont(f);
        r_dateC.setFont(f);
        r_prix.setFont(f);
        r_articles.setFont(f);
        r_articles.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                	label.setVisible(false);
                	if(list.getSelectedValue() != null) {
	                	com = m.rchCm1(Integer.parseInt((list.getSelectedValue().toString()).split(" ")[0]));
	                	
	                	nom.setText("Nom :");
	                	prenom.setText("Pr\u00E9nom :");
	                	id_com.setText("ID Commande :");
	                	id_cli.setText("ID Client :");
	                	dateC.setText("Date :");
	                	prix.setText("Prix total :");
	                	articles.setText("Liste d'articles :");
	                	
	                	r_nom.setText(com.getClient().getNom());
	                	r_prenom.setText((com.getClient()).getPrenom());
	                	r_id_com.setText(String.valueOf(com.getId()));
	                	r_dateC.setText(com.getDateAchat().toString());
	                	r_id_cli.setText(String.valueOf((com.getClient()).getId()));	
	                	r_prix.setText(com.getPrixTotal() + " €");	
	                	String temp = "<html>";
	                	ListLivres ll = new ListLivres(m, com.getLivres());
	                	for(int i = 0; i < com.listLivres.size(); i++) {
	                		temp = temp.concat(ll.getList()[i] + "<br/>");
	                	}
	                	temp = temp.concat("</html>");
	                	r_articles.setText(temp);
                	}
                }
            }
        });
        
        panel2.add(nom);
        panel2.add(prenom);
        panel2.add(id_com);
        panel2.add(id_cli);
        panel2.add(dateC);
        panel2.add(prix);
        panel2.add(articles);
        
        panel2.add(r_nom);
        panel2.add(r_prenom);
        panel2.add(r_id_com);
        panel2.add(r_id_cli);
        panel2.add(r_dateC);
        panel2.add(r_prix);
        panel2.add(r_articles);
        
    	JList<String> list2 = new JList<String>();
        list2.setModel(model2);
		list2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        list2.setLayoutOrientation(JList.VERTICAL);
		
 	   	JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(0, 0, 400, 535);
        scrollPane2.setViewportView(list2);
		panel2.add(scrollPane2);
		
		// Textfield - Recherche d'un achat
		
		JTextField t_rech = new JTextField();
		t_rech.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_rech.setText("Recherchez un achat");
		t_rech.setBounds(50, 100, 345, 45);
		t_rech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.clear();
				ListCommande def = new ListCommande(m,new RechercheAchat(m, t_rech, c_filtre.getSelectedItem().toString()).getList());
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
		
		// Boutons
	
		JButton b_retour = new JButton("Retour");
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen2_Gest(m);
			}
		});
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_retour.setBounds(50, 650, 400, 60);
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