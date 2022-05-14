package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controller.*;
import model.*;

public class Fen4_Gest_NewCli extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public Fen4_Gest_NewCli(Magasin m) {
		
		JPanel p = new JPanel();
		setTitle("Création d'un nouveau client");
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Labels
		
		JLabel l_main = new JLabel("Ajout d'un nouveau client");
		l_main.setBounds(350, 21, 912, 48);
		l_main.setFont(new Font("Tahoma", Font.BOLD, 39));
		p.add(l_main);
		
		JLabel l_nom = new JLabel("Nom :");
		l_nom.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_nom.setBounds(115, 119, 147, 37);
		p.add(l_nom);
		
		JLabel l_prenom = new JLabel("Pr\u00E9nom :");
		l_prenom.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_prenom.setBounds(115, 237, 147, 37);
		p.add(l_prenom);
		
		JLabel l_adresse = new JLabel("Adresse :");
		l_adresse.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_adresse.setBounds(115, 353, 147, 37);
		p.add(l_adresse);
		
		JLabel l_tel = new JLabel("T\u00E9l\u00E9phone :");
		l_tel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_tel.setBounds(115, 477, 207, 37);
		p.add(l_tel);
		
		JLabel l_sexe = new JLabel("Sexe :");
		l_sexe.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_sexe.setBounds(650, 119, 147, 37);
		p.add(l_sexe);
		
		JLabel l_mail = new JLabel("Mail :");
		l_mail.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_mail.setBounds(650, 237, 147, 37);
		p.add(l_mail);
		
		JLabel l_jour = new JLabel("Jour");
		l_jour.setFont(new Font("Arial", Font.PLAIN, 20));
		l_jour.setBounds(650, 390, 147, 30);
		p.add(l_jour);
		
		JLabel l_mois = new JLabel("Mois");
		l_mois.setFont(new Font("Arial", Font.PLAIN, 20));
		l_mois.setBounds(799, 390, 147, 30);
		p.add(l_mois);
		
		JLabel l_annee = new JLabel("Ann\u00E9e");
		l_annee.setFont(new Font("Arial", Font.PLAIN, 20));
		l_annee.setBounds(950, 390, 147, 30);
		p.add(l_annee);
		
		JLabel l_daten = new JLabel("Date de naissance :");
		l_daten.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_daten.setBounds(653, 338, 386, 37);
		p.add(l_daten);
		
		// TextFields
		
		JTextField t_nom = new JTextField();
		t_nom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_nom.setBounds(115, 154, 389, 58);
		p.add(t_nom);
		
		JTextField t_prenom = new JTextField();
		t_prenom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_prenom.setBounds(115, 272, 389, 58);
		p.add(t_prenom);
		
		JTextField t_adresse = new JTextField();
		t_adresse.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_adresse.setBounds(115, 392, 389, 58);
		p.add(t_adresse);
		
		JTextField t_tel = new JTextField();
		t_tel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_tel.setBounds(115, 513, 389, 58);
		p.add(t_tel);
		
		JTextField t_mail = new JTextField();
		t_mail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_mail.setBounds(650, 272, 389, 58);
		p.add(t_mail);
		
		JTextField t_annee = new JTextField();
		t_annee.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_annee.setBounds(950, 420, 100, 30);
		p.add(t_annee);
		
		// ComboBoxes
		
		JComboBox<String> c_sexe = new JComboBox<String>();
		c_sexe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		c_sexe.setModel(new DefaultComboBoxModel<String>(new String[] {"Homme", "Femme"}));
		c_sexe.setBounds(650, 154, 389, 58);
		
		p.add(c_sexe);
		
		JComboBox<String> c_jour = new JComboBox<String>();
		c_jour.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		c_jour.setBounds(650, 420, 100, 30);
		p.add(c_jour);
		
		JComboBox<String> c_mois = new JComboBox<String>();
		c_mois.setModel(new DefaultComboBoxModel<String>(new String[] {"Janvier", "F\u00E9vrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Ao\u00FBt", "Septembre", "Octobre", "Novembre", "D\u00E9cembre"}));
		c_mois.setBounds(800, 420, 100, 30);
		p.add(c_mois);
		
		// Boutons : Effacer, Valider, Retour
		
		JButton b_effacer = new JButton("EFFACER");
		b_effacer.setForeground(Color.BLACK);
		b_effacer.setBackground(Color.LIGHT_GRAY);
		b_effacer.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_effacer.setBounds(739, 502, 207, 64);
		p.add(b_effacer);
		
		JButton b_valider = new JButton("VALIDER");
		b_valider.setBackground(new Color(0, 128, 0));
		b_valider.setForeground(Color.BLACK);
		b_valider.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_valider.setBounds(739, 619, 207, 64);
		b_valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewClient nc = new NewClient(m, t_nom, t_prenom, t_adresse, t_tel, t_mail, c_sexe, c_jour, c_mois, t_annee);
				if (nc.status == 1) {
					dispose();
					new Fen3_Gest_Cli(m);
					JFrame a = new JFrame();
				    JOptionPane.showMessageDialog(a, "Client cr\u00E9\u00E9 et ajout\u00E9 \u00E0 la base de donn\u00E9es.", "Succ\u00E8s", 1);
				}
			}
		});
		p.add(b_valider);
		
		JButton b_retour = new JButton("Retour");
		b_retour.setForeground(Color.BLACK);
		b_retour.setBackground(new Color(255, 215, 0));
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_retour.setBounds(208, 619, 207, 64);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen3_Gest_Cli(m);
			}
		});
		p.add(b_retour);
	}
}