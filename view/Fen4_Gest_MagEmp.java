package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import controller.*;
import model.*;

public class Fen4_Gest_MagEmp extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel p = new JPanel();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private DefaultListModel<String> model;
	private DefaultListModel<String> model2;
	private JList<String> list = new JList<String>();
	private JList<String> list2 = new JList<String>();
	public static int count = 0;
	private JTextField t_rech= new JTextField();
	private JLabel l_main = new JLabel("Employ�s");
    
	JScrollPane scrollPane = new JScrollPane();
	JScrollPane scrollPane2 = new JScrollPane();
	JButton b_modifier = new JButton("Modifier");
	JButton b_ajouter = new JButton("Ajouter");
	JButton b_retour = new JButton("RETOUR");
	JButton b_clearSearch = new JButton("X");
	
	public JLabel label = new JLabel("Veuillez s�lectionner un employ� pour afficher ses informations.");
	
	public JLabel nom = new JLabel(" ");
	public JLabel prenom = new JLabel();
	public JLabel identifiant = new JLabel(" ");
	public JLabel fonction = new JLabel(" ");
	public JLabel salaire  = new JLabel(" ");
	public JLabel mail = new JLabel(" ");
	public JLabel adresse = new JLabel(" ");
	public JLabel tel = new JLabel(" ");
	
	public JLabel r_nom = new JLabel(" ");
	public JLabel r_prenom = new JLabel();
	public JLabel r_identifiant = new JLabel(" ");
	public JLabel r_fonction = new JLabel(" ");
	public JLabel r_salaire  = new JLabel(" ");
	public JLabel r_mail = new JLabel(" ");
	public JLabel r_adresse = new JLabel(" ");
	public JLabel r_tel = new JLabel(" ");

	private final JComboBox<String> c_filtre = new JComboBox<String>();
	Employe emp;
	
	public Fen4_Gest_MagEmp(Magasin m) {
		
		// Fen�tre
		
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		p.setBackground(new Color(233, 150, 122));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Panel 1 (Liste d'employ�s)
		
		ListEmploye le = new ListEmploye(m, m.listEmp);
		
		model = new DefaultListModel<String>();
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
		
		// Panel 2 (Informations de l'employ� s�lectionn�)
        model2 = new DefaultListModel<String>();
		
		label.setBounds(0,0,400,20);
		
		nom.setBounds			(50,20,200,20);
		prenom.setBounds		(50,40,200,20);
		identifiant.setBounds	(50,60,200,20);
		fonction.setBounds		(50,80,200,20);
		salaire.setBounds		(50,100,200,20);
		mail.setBounds			(50,120,200,20);
		adresse.setBounds		(50,140,200,20);
		tel.setBounds			(50,160,200,20);
		
		r_nom.setBounds			(200,20,200,20);
		r_prenom.setBounds		(200,40,200,20);
		r_identifiant.setBounds	(200,60,200,20);
		r_fonction.setBounds	(200,80,200,20);
		r_salaire.setBounds		(200,100,200,20);
		r_mail.setBounds		(200,120,200,20);
		r_adresse.setBounds		(200,140,200,20);
		r_tel.setBounds			(200,160,200,20);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (!arg0.getValueIsAdjusting()) {
					
					label.setVisible(false);
					emp = m.rchEmp(Integer.parseInt((list.getSelectedValue().toString()).split(" ")[0]));
					
                	nom.setText(emp.getNom());
                	prenom.setText(emp.getPrenom());
                	identifiant.setText(String.valueOf(emp.getId()));
                	fonction.setText(emp.getFonction());
                	salaire.setText(String.valueOf(emp.getSalaire()));
                	adresse.setText(emp.getAdresse());
                	tel.setText(emp.getTel());
                	
                	nom.setText("Nom :");
                	prenom.setText("Pr�nom :");
                	identifiant.setText("Identifiant :");
                	fonction.setText("Fonction :");
                	salaire.setText("Salaire : ");
                	
                	mail.setText("Mail :");
                	adresse.setText("Adresse :");
                	tel.setText("T�l�phone :");
                	
                	r_nom.setText(emp.getNom());
                	r_prenom.setText(emp.getPrenom());
                	r_identifiant.setText(String.valueOf(emp.getId()));
                	r_fonction.setText(emp.getFonction());
                	r_mail.setText(emp.getMail());
                	r_salaire.setText(String.valueOf(emp.getSalaire()));
                	r_adresse.setText(emp.getAdresse());
                	r_tel.setText(emp.getTel());
				}
			}
		});

		c_filtre.setFont(new Font("Tahoma", Font.PLAIN, 23));
        c_filtre.setModel(new DefaultComboBoxModel<String>(new String[] 
        		{"Nom", "Prenom", "id employe", "Adresse", "Date Naissance", "Age", "Sexe", "Fonction", "Téléphone", "Mail"}));
        c_filtre.setBounds(480, 100, 200, 48);
		
		p.add(c_filtre);
		
		panel2.add(label);
		panel2.add(nom);
		panel2.add(prenom);
		panel2.add(identifiant);
		panel2.add(fonction);
		panel2.add(salaire);
		panel2.add(mail);
		panel2.add(adresse);
		panel2.add(tel);
		
		panel2.add(r_nom);
		panel2.add(r_prenom);
		panel2.add(r_identifiant);
		panel2.add(r_fonction);
		panel2.add(r_salaire);
		panel2.add(r_mail);
		panel2.add(r_adresse);
		panel2.add(r_tel);

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

		// Textfield - Recherche d'un employ�
		
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
						JFrame aa = new JFrame();
					    JOptionPane.showMessageDialog(aa, "Recherche vide.", "Erreur", 2);
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
		
		// JLabel "Employ�s"
		
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
					JOptionPane.showMessageDialog(f, "Veuillez s�lectionner un employ�.", "Erreur", 2);
				} else {
				dispose();
				new Fen5_Gest_ModifEmp(m, emp);
				}
			}
		});
		p.add(b_modifier);
		
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

		b_clearSearch.setForeground(new Color(255, 255, 255));
		b_clearSearch.setBackground(new Color(165, 42, 42));
		b_clearSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		b_clearSearch.setBounds(405, 100, 45, 45);
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