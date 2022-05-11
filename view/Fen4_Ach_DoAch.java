package view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.*;
import model.*;
import controller.*;

public class Fen4_Ach_DoAch extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
    public static int count = 0;

	private float pT = 0.F;
	private JPanel p = new JPanel();
	private DefaultListModel<String> model;
	private DefaultListModel<String> model2;
	private JScrollPane scrollPane = new JScrollPane();
	private JScrollPane scrollPane2 = new JScrollPane();
	private JList<String> list = new JList<String>();
	private JList<String> list2 = new JList<String>();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JLabel l_achat = new JLabel("R\u00E9alisation de l'achat");
	private JTextField t_rech = new JTextField();
	private Vector<Livre> livresSelect = new Vector<Livre>();
	JButton b_effacer = new JButton("Effacer");
	JButton b_tEffacer = new JButton("Tout Effacer");
	JButton b_ajouter = new JButton("Ajouter");
	JButton b_retour = new JButton("Retour");
	JButton b_enregistrer = new JButton("Enregistrer");
	JButton b_clearSearch = new JButton("X");
	private final JComboBox<String> c_filtre = new JComboBox<String>();
	
	public Fen4_Ach_DoAch(Magasin m, Client c) {
		
		// Fenêtre
		
		p = new JPanel();
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		c_filtre.setFont(new Font("Tahoma", Font.PLAIN, 23));
        c_filtre.setModel(new DefaultComboBoxModel<String>(new String[] {
        		"Cat\u00E9gorie", 
        		"Titre", 
        		"ID livre", 
        		"Auteur", 
        		"Date", 
        		"Editeur"}));
        c_filtre.setBounds(540, 100, 400, 45);
		
		p.add(c_filtre);
		
		// Panel 1 (Liste de livres)
		
		ListLivres l = new ListLivres(m,m.listLivre);
		
        model = new DefaultListModel<String>();
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
        list.setModel(model);
        list.setFont(new Font("Tahoma", Font.PLAIN, 15));
        scrollPane.setViewportView(list);
        list.setLayoutOrientation(JList.VERTICAL);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel1.setBounds(50, 150, 400, 400);
        panel1.setLayout(null);
        scrollPane.setBounds(0, 0, 400, 400);
        panel1.add(scrollPane);
        p.add(panel1);
        
        // Panel 2 (Liste d'articles)
        
        model2 = new DefaultListModel<String>();
        list2.setModel(model2);
        
		list2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        scrollPane2.setViewportView(list2);
        list2.setLayoutOrientation(JList.VERTICAL);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel2.setBounds(540, 150, 400, 300);
		panel2.setLayout(null);
		scrollPane2.setBounds(0, 0, 400, 300);
		panel2.add(scrollPane2);
		p.add(panel2);
		
		// Panel 3 (Prix total articles)
        
		JLabel prix = new JLabel("Prix total :");

		JLabel prixt = new JLabel("0 \u20AC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel3.add(prix);
        prix.setBounds(20,10,100,30);
        prix.setFont(new Font("Tahoma", Font.PLAIN, 20));
        
        panel3.add(prixt);
        prixt.setBounds(320,10,100,30);
        prixt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
        panel3.setBounds(540, 450, 400, 45);
		panel3.setLayout(null);
		p.add(panel3);
		// Textfield - Recherche de livres
		
		t_rech.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_rech.setText("Recherchez un livre");
		t_rech.setBounds(50, 100, 345, 45);
		t_rech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.clear();
				ListLivres def = new ListLivres(m,new RechercheLivre(m, t_rech, c_filtre.getSelectedItem().toString()).getList());
				String[] a = def.getList();
				if(a.length == 0) {
					if(t_rech.getText().equals("")) {
						JFrame aa = new JFrame();
					    JOptionPane.showMessageDialog(aa, "Recherche vide.", "Erreur", 2);
						for(int i = 0; i < l.getList().length; i++) {
							model.addElement(l.getList()[i]);
						}
					}
				} else {
			        for (int i = 0; i < a.length; i++) {
						for (int j = 0; j < a.length; j++) {
							if (Integer.parseInt((a[i]).split(" ")[0]) < Integer.parseInt((a[j]).split(" ")[0])) {
								String temp = def.getList()[i];
								a[i] = a[j];
								a[j] = temp;
							}
						}
					}
					for (int i = 0; i < a.length; i++) {
						model.addElement(a[i]);
					}
				}
			}
		});
		p.add(t_rech);
		t_rech.setColumns(10);
		
		// JLabel R�alisation de l'achat
		
		l_achat.setHorizontalAlignment(SwingConstants.CENTER);
		l_achat.setFont(new Font("Tahoma", Font.BOLD, 36));
		l_achat.setBounds(10, 11, 964, 57);
		p.add(l_achat);
		
		// Boutons : Effacer, Tout Effacer, Ajouter, Retour, Enregistrer
		
		b_effacer.setBackground(new Color(58, 2, 13));
		b_effacer.setForeground(Color.WHITE);
		b_effacer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b_effacer.setBounds(540, 500, 400, 50);
		b_effacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list2.getSelectedValue()!=null) {
					boolean found = false;
					boolean last = false;
					Livre livre = m.rchLivreId(Integer.parseInt(list2.getSelectedValue().split(" ")[0]));
					for(int i = 0; i < livresSelect.size(); i++) {
						if(livresSelect.toArray()[i].equals(livre)) {
							if(!found) {
								livresSelect.remove(livre);
								i--;
								last = true;
								found = true;
							} else {
								last = false;
							}
						}
					}
					if(last) {
						model2.removeElement(list2.getSelectedValue());
					} else {
						int counter = 0;
            			if(!livresSelect.contains(livre)) {
            				counter++;
            			} else {
            				for(int i = 0; i < livresSelect.size(); i++) {
            					if(((Livre) (livresSelect.toArray()[i])).getId() == livre.getId()) {
            						counter++;
            					}
            				}
            			}
                		model2.addElement(livre.getId() + " - \"" + livre.getTitre() +  "\" (x" + (int)counter + ") - Prix = " + (Math.round((counter * livre.getPrix())*100f)/100f) + " \u20AC");
                		model2.removeElement(livre.getId() + " - \"" + livre.getTitre() + "\" (x" + (int)(counter + 1) + ") - Prix = " + (Math.round(((counter + 1) * livre.getPrix())*100f)/100f) + " \u20AC");
					}
            		pT=0.F;
            		for(int i = 0; i < livresSelect.size(); i++) {
        				pT +=(((Livre) livresSelect.toArray()[i]).getPrix());
        			}
            		pT = Math.round(pT*100f)/100f;
					prixt.setText(String.valueOf(pT) + " \u20AC");
				}
				else {
					JFrame a = new JFrame();
				    JOptionPane.showMessageDialog(a, "Si vous souhiatez supprimer un article, veuillez s\u00E9lectionner un livre de la liste \u00E0 droite.", "Erreur", 2);
				}
			}
			
		});
		p.add(b_effacer);
		
		b_tEffacer.setBackground(new Color(0, 0, 0));
		b_tEffacer.setForeground(Color.WHITE);
		b_tEffacer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b_tEffacer.setBounds(540, 555, 400, 50);
		b_tEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pT = 0f;
				prixt.setText(String.valueOf(pT) + " \u20AC");
				model2.clear();
				livresSelect.clear();
				}
			});
		p.add(b_tEffacer);
		
		b_ajouter.setBackground(new Color(150, 255, 150));
		b_ajouter.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b_ajouter.setBounds(50, 555, 400, 50);
		b_ajouter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(list.getSelectedValue()!=null) {
            		int ctrl = 0;
            		Livre livre = m.rchLivreId(Integer.parseInt(list.getSelectedValue().split(" ")[0]));
            		if(livre.getStock()<=0){
            			JFrame a = new JFrame();
					    JOptionPane.showMessageDialog(a, "Pas assez de livres en stock pour cet ajout.", "Erreur", 2);
					    ctrl++;
            		}
            		for(int i = 0; i < model2.size(); i++) {
            			if(livre.getId() == Integer.parseInt(((String)(model2.toArray()[i])).split(" ")[0])) {
	            			if(livre.getStock() <= Integer.parseInt(((String) model2.toArray()[i]).split(Pattern.quote(")"))[0].split(Pattern.quote("("))[1].split("x")[1])) {
								JFrame a = new JFrame();
							    JOptionPane.showMessageDialog(a, "Pas assez de livres en stock pour cet ajout.", "Erreur", 2);
							    ctrl++;
	            			}
            			}
            		}
            		if(ctrl == 0) {
	            		livresSelect.add(livre);
	            		float counter = 0;
	            		if(!livresSelect.contains(livre)) {
	            			counter++;
	            		} else {
	            			for(int i = 0; i < livresSelect.size(); i++) {
	            				if(((Livre) (livresSelect.toArray()[i])).getId() == livre.getId()) {
	            					counter++;
	            				}
	            			}
	            		}
	            		pT=0.F;
	            		for(int i = 0; i < livresSelect.size(); i++) {
	        				pT +=(((Livre) livresSelect.toArray()[i]).getPrix());
	        			}
	            		pT = Math.round(pT*100f)/100f;
	                	model2.addElement(livre.getId() + " - \"" + livre.getTitre() + "\" (x" + (int)counter + ") - Prix = " + (Math.round((counter * livre.getPrix())*100f)/100f) + " \u20AC");
	                	model2.removeElement(livre.getId() + " - \"" + livre.getTitre() + "\" (x" + (int)(counter - 1) + ") - Prix = " + (Math.round(((counter - 1) * livre.getPrix())*100f)/100f) + " \u20AC");
	                	prixt.setText(String.valueOf(pT) + " \u20AC");
	            	}
            	} else {
	                JFrame a = new JFrame();
					JOptionPane.showMessageDialog(a, "Si vous souhiatez ajouter un article, veuillez s\u00E9lectionner un livre de la liste de gauche.", "Erreur", 2);
            	}
            }
		});
		p.add(b_ajouter);
		
        b_retour.setBackground(new Color(255, 255, 0));
        b_retour.setFont(new Font("Tahoma", Font.PLAIN, 30));
        b_retour.setBounds(50, 650, 400, 60);
        b_retour.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		new Fen2_Ach(m);
        	}
        });
        p.add(b_retour);
        
		b_enregistrer.setBackground(new Color(1, 215, 88));
		b_enregistrer.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_enregistrer.setBounds(540, 650, 400, 60);
		b_enregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewCommande nc = new NewCommande(m, c, livresSelect);
				if(nc.status == 1) {
					new Fen5_Ach_Fact(m, c, nc.getCommande(), model2);
					dispose();
				} else {
					JFrame err = new JFrame();
					JOptionPane.showMessageDialog(err, "La liste de livres s\u00E9lectionn\u00E9s est vide.\nImpossible de cr\u00E9er une commande.", "Erreur", 2);
				}
			}
		});
		p.add(b_enregistrer);
		
		b_clearSearch.setForeground(new Color(255, 255, 255));
		b_clearSearch.setBackground(new Color(165, 42, 42));
		b_clearSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		b_clearSearch.setBounds(405, 100, 45, 45);
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
		
		int a = m.listLivre.size();
		if(a == 0) {
			JFrame err = new JFrame();
			JOptionPane.showMessageDialog(err, "La liste de livres est vide", "Avertissement", 1);
		}
	}
}