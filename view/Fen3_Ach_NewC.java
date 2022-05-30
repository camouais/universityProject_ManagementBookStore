package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controller.*;
import model.*;

public class Fen3_Ach_NewC extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public Fen3_Ach_NewC(Magasin m) {
		
		// Fenêtre
		
		Toolkit tk = Toolkit.getDefaultToolkit();  
        Image img = tk.getImage("src/resources/logo.png");
		setIconImage(img);
		JPanel p = new JPanel();
		setTitle("Enregistrement d'un nouveau client");
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 610);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Labels
		
		JLabel l_main = new JLabel("Ajout d'un nouveau client");
		l_main.setHorizontalAlignment(SwingConstants.CENTER);
		l_main.setBounds(0, 0, 634, 80);
		l_main.setFont(new Font("Tahoma", Font.BOLD, 35));
		p.add(l_main);
		
		JLabel l_nom = new JLabel("Nom :");
		l_nom.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 25));
		l_nom.setBounds(30, 100, 150, 40);
		p.add(l_nom);
		
		JLabel l_prenom = new JLabel("Pr\u00E9nom :");
		l_prenom.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 25));
		l_prenom.setBounds(30, 150, 150, 40);
		p.add(l_prenom);
		
		JLabel l_adresse = new JLabel("Adresse :");
		l_adresse.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 25));
		l_adresse.setBounds(30, 250, 150, 40);
		p.add(l_adresse);
		
		JLabel l_tel = new JLabel("T\u00E9l\u00E9phone :");
		l_tel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 25));
		l_tel.setBounds(30, 300, 150, 40);
		p.add(l_tel);
		
		JLabel l_sexe = new JLabel("Sexe :");
		l_sexe.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 25));
		l_sexe.setBounds(30, 200, 150, 40);
		p.add(l_sexe);
		
		JLabel l_mail = new JLabel("Mail :");
		l_mail.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 25));
		l_mail.setBounds(30, 350, 150, 40);
		p.add(l_mail);
		
		JLabel l_jour = new JLabel("Jour :");
		l_jour.setFont(new Font("Arial", Font.PLAIN, 20));
		l_jour.setBounds(270, 395, 100, 30);
		p.add(l_jour);
		
		JLabel l_mois = new JLabel("Mois");
		l_mois.setFont(new Font("Arial", Font.PLAIN, 20));
		l_mois.setBounds(380, 395, 100, 30);
		p.add(l_mois);
		
		JLabel l_annee = new JLabel("Ann\u00E9e");
		l_annee.setFont(new Font("Arial", Font.PLAIN, 20));
		l_annee.setBounds(490, 395, 100, 30);
		p.add(l_annee);
		
		JLabel l_daten = new JLabel("Date de naissance :");
		l_daten.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 25));
		l_daten.setBounds(30, 400, 250, 40);
		p.add(l_daten);
		
		// TextFields
		
		JTextField t_nom;
		t_nom = new JTextField();
		t_nom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_nom.setBounds(200, 100, 400, 40);
		p.add(t_nom);
		
		JTextField t_prenom;
		t_prenom = new JTextField();
		t_prenom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_prenom.setBounds(200, 150, 400, 40);
		p.add(t_prenom);
		
		JTextField t_adresse;
		t_adresse = new JTextField();
		t_adresse.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_adresse.setBounds(200, 250, 400, 40);
		p.add(t_adresse);
		
		JTextField t_tel;
		t_tel = new JTextField();
		t_tel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_tel.setBounds(200, 300, 400, 40);
		p.add(t_tel);
		
		JTextField t_mail;
		t_mail = new JTextField();
		t_mail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_mail.setBounds(200, 350, 400, 40);
		p.add(t_mail);
		
		JTextField t_annee;
		t_annee = new JTextField();
		t_annee.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (t_annee.getText().length() >= 4)
		            e.consume(); 
		    }  
		});
		t_annee.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_annee.setBounds(490, 425, 100, 30);
		p.add(t_annee);
		
		// ComboBoxes
		
		JComboBox<String> c_sexe = new JComboBox<String>();
		c_sexe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		c_sexe.setModel(new DefaultComboBoxModel<String>(new String[] {"Homme", "Femme"}));
		c_sexe.setBounds(200, 200, 400, 40);
		p.add(c_sexe);
		
		JComboBox<String> c_jour = new JComboBox<String>();
		c_jour.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		c_jour.setBounds(270, 425, 100, 30);
		p.add(c_jour);
		
		JComboBox<String> c_mois = new JComboBox<String>();
		c_mois.setModel(new DefaultComboBoxModel<String>(new String[] {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"}));
		c_mois.setBounds(380, 425, 100, 30);
		p.add(c_mois);
		
		// Boutons
		
		JButton b_valider = new JButton("Valider");
		b_valider.setBackground(new Color(128, 255, 128));
		b_valider.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_valider.setBounds(217, 480, 200, 60);
		b_valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewClient nc = new NewClient(m, t_nom, t_prenom, t_adresse, t_tel, t_mail, c_sexe, c_jour, c_mois, t_annee);
				if (nc.status == 1) {
					dispose();
					new Fen4_Ach_DoAch(m, nc.getClient());
					JFrame a = new JFrame();
				    JOptionPane.showMessageDialog(a, "Client créé et ajouté à la base de données.", "Succès", 1);
				}
			}
		});
		p.add(b_valider);
		
		JButton b_retour = new JButton("Retour");
		b_retour.setForeground(Color.BLACK);
		b_retour.setBackground(new Color(200, 100, 100));
		b_retour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b_retour.setBounds(0, 542, 100, 30);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen2_Ach(m);
			}
		});
		p.add(b_retour);
		
	}
}