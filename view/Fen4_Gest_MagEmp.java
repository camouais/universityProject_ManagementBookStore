package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import controller.*;
import model.*;

public class Fen4_Gest_MagEmp extends JFrame {
	
	static final long serialVersionUID = 1L;
	Employe emp;
	
	public Fen4_Gest_MagEmp(Magasin m) {
		
		// Fenêtre
		
		JPanel p = new JPanel();
		Toolkit tk = Toolkit.getDefaultToolkit();  
        Image img = tk.getImage("src/resources/logo.png");
		setIconImage(img);
		setTitle("Gestion des employés");
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		p.setBackground(new Color(233, 150, 122));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Label
		
		JLabel l_main = new JLabel("Employ\u00E9s");
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
        		"id", 
        		"Adresse", 
        		"Date de naissance", 
        		"\u00C2ge", 
        		"Sexe", 
        		"Fonction", 
        		"T\u00E9l\u00E9phone", 
        		"Mail"}));
        c_filtre.setBounds(540, 100, 400, 48);
		p.add(c_filtre);
		
		// Panel 1 (Liste d'employés)

		JPanel panel1 = new JPanel();
		panel1.setBounds(50, 175, 400, 440);
		panel1.setLayout(null);
		p.add(panel1);
		
		ListEmploye le = new ListEmploye(m, m.listEmp);
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		
		for (int i = 0; i < le.getList().length; i++) {
			for (int j = 0; j < le.getList().length; j++) {
				if (Integer.parseInt((le.getList()[i]).split(" ")[0]) < Integer.parseInt((le.getList()[j]).split(" ")[0])) {
					String temp = le.getList()[i];
					le.getList()[i] = le.getList()[j];
					le.getList()[j] = temp;
				}
			}
		}
		for (int i = 0; i < le.getList().length; i++) {
			model.addElement(le.getList()[i]);
        }
		
		JList<String> list = new JList<String>();
		list.setFont(new Font("Tahoma", Font.PLAIN, 15));
		list.setLayoutOrientation(JList.VERTICAL);
		list.setModel(model);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);
		scrollPane.setBounds(0, 0, 400, 440);
		panel1.add(scrollPane);
		
		// Panel 2 (Informations de l'employé sélectionné)
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(540, 175, 400, 345);
		panel2.setLayout(null);
		p.add(panel2);
		
		DefaultListModel<String> model2 = new DefaultListModel<String>();
		
		JLabel label = new JLabel("Veuillez s\u00E9lectionner un employ\u00E9 pour afficher ses informations.");
		label.setBounds(0,0,400,20);
        label.setHorizontalAlignment(SwingConstants.CENTER);
		panel2.add(label);
        
        JLabel nom = new JLabel(" ");
    	JLabel prenom = new JLabel();
    	JLabel id = new JLabel(" ");
    	JLabel fonction = new JLabel(" ");
    	JLabel salaire  = new JLabel(" ");
    	JLabel mail = new JLabel(" ");
    	JLabel adresse = new JLabel(" ");
    	JLabel tel = new JLabel(" ");
    	
    	JLabel r_nom = new JLabel(" ");
    	JLabel r_prenom = new JLabel();
    	JLabel r_id = new JLabel(" ");
    	JLabel r_fonction = new JLabel(" ");
    	JLabel r_salaire  = new JLabel(" ");
    	JLabel r_mail = new JLabel(" ");
    	JLabel r_adresse = new JLabel(" ");
    	JLabel r_tel = new JLabel(" ");
    	
		nom.setBounds			(20,20,200,25);
		prenom.setBounds		(20,55,200,25);
		id.setBounds			(20,90,200,25);
		fonction.setBounds		(20,125,200,25);
		salaire.setBounds		(20,160,200,25);
		mail.setBounds			(20,195,200,25);
		adresse.setBounds		(20,230,200,25);
		tel.setBounds			(20,265,200,25);
		
		r_nom.setBounds			(150,20,250,25);
		r_prenom.setBounds		(150,55,250,25);
		r_id.setBounds			(150,90,250,25);
		r_fonction.setBounds	(150,125,250,25);
		r_salaire.setBounds		(150,160,250,25);
		r_mail.setBounds		(150,195,250,25);
		r_adresse.setBounds		(150,230,250,25);
		r_tel.setBounds			(150,265,250,25);
		
		Font f = new Font("Tahoma", Font.PLAIN, 20);
		
		nom.setFont(f);
		prenom.setFont(f);
		id.setFont(f);
		fonction.setFont(f);
		salaire.setFont(f);
		mail.setFont(f);
		adresse.setFont(f);
		tel.setFont(f);
		
		r_nom.setFont(f);
		r_prenom.setFont(f);
		r_id.setFont(f);
		r_fonction.setFont(f);
		r_salaire.setFont(f);
		r_mail.setFont(f);
		r_adresse.setFont(f);
		r_tel.setFont(f);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (!arg0.getValueIsAdjusting()) {
					
					label.setVisible(false);
					emp = m.rchEmp(Integer.parseInt((list.getSelectedValue().toString()).split(" ")[0]));
					
                	nom.setText(emp.getNom());
                	prenom.setText(emp.getPrenom());
                	id.setText(String.valueOf(emp.getId()));
                	fonction.setText(emp.getFonction());
                	salaire.setText(String.valueOf(emp.getSalaire()));
                	adresse.setText(emp.getAdresse());
                	tel.setText(emp.getTel());
                	
                	nom.setText("Nom :");
                	prenom.setText("Pr\u00E9nom :");
                	id.setText("id :");
                	fonction.setText("Fonction :");
                	salaire.setText("Salaire : ");
                	
                	mail.setText("Mail :");
                	adresse.setText("Adresse :");
                	tel.setText("T\u00E9l\u00E9phone :");
                	
                	r_nom.setText(emp.getNom());
                	r_prenom.setText(emp.getPrenom());
                	r_id.setText(String.valueOf(emp.getId()));
                	r_fonction.setText(emp.getFonction());
                	r_mail.setText(emp.getMail());
                	r_salaire.setText(String.valueOf(emp.getSalaire()));
                	r_adresse.setText(emp.getAdresse());
                	r_tel.setText(emp.getTel());
				}
			}
		});
		
		panel2.add(nom);
		panel2.add(prenom);
		panel2.add(id);
		panel2.add(fonction);
		panel2.add(salaire);
		panel2.add(mail);
		panel2.add(adresse);
		panel2.add(tel);
		
		panel2.add(r_nom);
		panel2.add(r_prenom);
		panel2.add(r_id);
		panel2.add(r_fonction);
		panel2.add(r_salaire);
		panel2.add(r_mail);
		panel2.add(r_adresse);
		panel2.add(r_tel);
		
		JList<String> list2 = new JList<String>();
		list2.setModel(model2);
		list2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		list2.setLayoutOrientation(JList.VERTICAL);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setViewportView(list2);
		scrollPane2.setBounds(0, 0, 400, 345);
		panel2.add(scrollPane2);

		// Textfield - Recherche d'un employï¿½
		
		JTextField t_rech= new JTextField();
		t_rech.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_rech.setText("Recherchez un livre");
		t_rech.setBounds(50, 100, 345, 45);
		t_rech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.clear();
				ListEmploye def = new ListEmploye(m,new RechercheEmploye(m, t_rech, c_filtre.getSelectedItem().toString() ).getList());
				String[] a = def.getList();
				if(a.length == 0) {
					if(t_rech.getText().equals("")) {
						for(int i = 0; i < le.getList().length; i++) {
							model.addElement(le.getList()[i]);
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
					JOptionPane.showMessageDialog(f, "Veuillez s\u00E9lectionner un employ\u00E9.", "Erreur", 2);
				} else {
				dispose();
				new Fen5_Gest_ModifEmp(m, emp);
				}
			}
		});
		p.add(b_modifier);
		
		JButton b_ajouter = new JButton("Ajouter");
		b_ajouter.setFont(new Font("Tahoma", Font.PLAIN, 30));
		b_ajouter.setBounds(50, 650, 400, 60);
		b_ajouter.setBackground(new Color(100, 200, 120));
		b_ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	dispose();
            	new Fen5_Gest_NewEmp(m);
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
				new Fen3_Gest_Mag(m);
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
				for (int i = 0; i < le.getList().length; i++) {
					for (int j = 0; j < le.getList().length; j++) {
						if (Integer.parseInt((le.getList()[i]).split(" ")[0]) < Integer.parseInt((le.getList()[j]).split(" ")[0])) {
							String temp = le.getList()[i];
							le.getList()[i] = le.getList()[j];
							le.getList()[j] = temp;
						}
					}
				}
		        for(int i = 0; i < le.getList().length; i++) {
		        	model.addElement(le.getList()[i]);
		        }
			}
		});
		p.add(b_clearSearch);
	}
}