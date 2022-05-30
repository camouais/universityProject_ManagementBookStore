package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import model.*;
import controller.*;

public class Fen6_Gest_Depenses extends JFrame {

	private static final long serialVersionUID = 1L;
	public Depense dep;
		
	public Fen6_Gest_Depenses(Magasin m) {
		
		// Fenêtre
		
		JPanel p = new JPanel();
		Toolkit tk = Toolkit.getDefaultToolkit();  
        Image img = tk.getImage("src/resources/logo.png");
		setIconImage(img);
		setTitle("Gestion des dépenses");
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		p.setBackground(new Color(100, 131, 236));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Label
		
		JLabel l_main = new JLabel("Gestion des d\u00E9penses");
		l_main.setHorizontalAlignment(SwingConstants.CENTER);
		l_main.setFont(new Font("Arial", Font.BOLD, 50));
		l_main.setBounds(10, 15, 964, 57);
		p.add(l_main);
		
		// ComboBox - Filtre
        
		JComboBox<String> c_filtre = new JComboBox<String>();
        c_filtre.setFont(new Font("Tahoma", Font.PLAIN, 23));
        c_filtre.setModel(new DefaultComboBoxModel<String>(new String[] {"Description", "ID Dépense", "ID Employé", "Nom Employé", "Date"}));
        c_filtre.setBounds(540, 100, 400, 48);
		p.add(c_filtre);
		
		// Liste 1 (Liste des dépenses)
		
		JPanel panel1 = new JPanel();
        panel1.setBounds(50, 175, 400, 440);
        panel1.setLayout(null);
        p.add(panel1);
		ListDepense d = new ListDepense(m, m.listDep);
		
		DefaultListModel<String> model;
		model = new DefaultListModel<String>();
        for (int i = 0; i < d.getList().length; i++) {
            for (int j = 0; j < d.getList().length; j++) {
                if (Integer.parseInt((d.getList()[i]).split(" ")[0]) < Integer.parseInt((d.getList()[j]).split(" ")[0])) {
                    String temp = d.getList()[i];
                    d.getList()[i] = d.getList()[j];
                    d.getList()[j] = temp;
                }
            }
        }
        for (int i = 0; i < d.getList().length; i++) {
            model.addElement(d.getList()[i]);
        }
        
		JList<String> list = new JList<String>();
        list.setModel(model);
        list.setFont(new Font("Tahoma", Font.PLAIN, 15));
        list.setLayoutOrientation(JList.VERTICAL);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(list);
        scrollPane.setBounds(0, 0, 400, 440);
        panel1.add(scrollPane);
        
        // Liste 2 (Informations de la dépense sélectionnée)
        
		JPanel panel2 = new JPanel();
		DefaultListModel<String> model2;
        model2 = new DefaultListModel<String>();
        
		JLabel label = new JLabel("Veuillez s\u00E9lectionner une d\u00E9pense pour afficher ses informations.");
        label.setBounds(0,0,400,20);
        
        JLabel identifiant = new JLabel(" ");
		JLabel description = new JLabel(" ");
		JLabel cout = new JLabel();
		JLabel Nemploye = new JLabel(" ");
		JLabel Pemploye = new JLabel(" ");
		JLabel Iemploye = new JLabel();
		JLabel dateDep = new JLabel(" ");
		JLabel r_identifiant = new JLabel(" ");
		JLabel r_description = new JLabel(" ");
		JLabel r_cout = new JLabel(" ");
		JLabel r_Nemploye = new JLabel(" ");
		JLabel r_Pemploye = new JLabel(" ");
		JLabel r_Iemploye = new JLabel(" ");
		JLabel r_dateDep = new JLabel(" ");
		
        identifiant.setBounds		(50,20,200,20);
        description.setBounds		(50,40,200,20);
        cout.setBounds				(50,60,200,20);
        Nemploye.setBounds			(50,80,200,20);
        Pemploye.setBounds			(50,100,200,20);
        Iemploye.setBounds			(50,120,200,20);
        dateDep.setBounds			(50,140,200,20);
        
        r_identifiant.setBounds		(200,20,200,20);
        r_description.setBounds		(200,40,200,20);
        r_cout.setBounds			(200,60,200,20);
        r_Nemploye.setBounds		(200,80,200,20);
        r_Pemploye.setBounds		(200,100,200,20);
        r_Iemploye.setBounds		(200,120,200,20);
        r_dateDep.setBounds			(200,140,200,20);
        
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                	label.setVisible(false);
                	dep = m.rchDep(Integer.parseInt((list.getSelectedValue()).split(" ")[0]));
                	
                	identifiant.setText("Identifiant :");
                	description.setText("Description :");
                	cout.setText("Cout :");
                	Nemploye.setText("Nom de l'employ\u00E9 :");
                	Pemploye.setText("Nom de l'employ\u00E9 :");
                	Iemploye.setText("Identifiant de l'employ\u00E9 :");
                	dateDep.setText("Date de la d\u00E9pense :");
                	
                	r_identifiant.setText(String.valueOf(dep.getId()));
                	r_description.setText(dep.getDescription());
                	r_cout.setText(String.valueOf(dep.getCout()));
                	r_Nemploye.setText(dep.getEmp().getNom());
                	r_Pemploye.setText(dep.getEmp().getPrenom());
                	r_Iemploye.setText(String.valueOf(dep.getEmp().getId()));
                	r_dateDep.setText(dep.getDate().toString());
                }
            }
        });
        
        panel2.add(label);
        panel2.add(identifiant);
        panel2.add(description);
        panel2.add(cout);
        panel2.add(Nemploye);
        panel2.add(Pemploye);
        panel2.add(Iemploye);
        panel2.add(dateDep);
        
        panel2.add(r_identifiant);
        panel2.add(r_description);
        panel2.add(r_cout);
        panel2.add(r_Nemploye);
        panel2.add(r_Pemploye);
        panel2.add(r_Iemploye);
        panel2.add(r_dateDep);
        
		JList<String> list2 = new JList<String>();
        list2.setModel(model2);
        list2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        list2.setLayoutOrientation(JList.VERTICAL);
        
		JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setViewportView(list2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel2.setBounds(540, 175, 400, 345);
		panel2.setLayout(null);
		scrollPane2.setBounds(0, 0, 400, 345);
		panel2.add(scrollPane2);
		p.add(panel2);

		// Textfield - Recherche d'une dépense
		
		JTextField t_rech = new JTextField();
		t_rech.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_rech.setText("Recherchez une d\u00E9pense...");
		t_rech.setBounds(50, 100, 345, 45);
		t_rech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.clear();
				ListDepense def = new ListDepense(m,new RechercheDepense(m, t_rech, c_filtre.getSelectedItem().toString()).getList());
				String[] a = def.getList();
				if(a.length == 0) {
					if(t_rech.getText().equals("")) {
						JFrame aa = new JFrame();
					    JOptionPane.showMessageDialog(aa, "Recherche vide.", "Erreur", 2);
						for(int i = 0; i < d.getList().length; i++) {
							model.addElement(d.getList()[i]);
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
		b_modifier.setToolTipText("Modifie la dépense sélectionnée");
		b_modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedValue() == null) {
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "Veuillez s\u00E9lectionner une d\u00E9pense.", "Erreur", 2);
				} else {
					dispose();
					new Fen7_Gest_ModifDepense(m, dep);
				}
			}
		});
		p.add(b_modifier);
		
		JButton b_ajouter = new JButton("Ajouter");
		b_ajouter.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b_ajouter.setBounds(50, 650, 400, 60);
		b_ajouter.setBackground(new Color(100, 200, 120));
		b_ajouter.setToolTipText("Ajoute une dépense");
		b_ajouter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
            	new Fen7_Gest_NewDepense(m);       
            }
		});
		p.add(b_ajouter);
		
		JButton b_retour = new JButton("Retour");
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_retour.setBounds(540, 650, 400, 60);
		b_retour.setBackground(new Color(200, 100, 100));
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen5_Gest_StatCompta(m);
			}
		});
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
				for (int i = 0; i < d.getList().length; i++) {
					for (int j = 0; j < d.getList().length; j++) {
						if (Integer.parseInt((d.getList()[i]).split(" ")[0]) < Integer.parseInt((d.getList()[j]).split(" ")[0])) {
							String temp = d.getList()[i];
							d.getList()[i] = d.getList()[j];
							d.getList()[j] = temp;
						}
					}
				}
		        for(int i = 0; i < d.getList().length; i++) {
		        	model.addElement(d.getList()[i]);
		        }
			}
		});
		p.add(b_clearSearch);
	
	}
}