package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.*;
import controller.*;

public class Fen5_Gest_NewEmp extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public Fen5_Gest_NewEmp(Magasin m) {
		
		// Fenêtre
		
		JPanel p = new JPanel();
		Toolkit tk = Toolkit.getDefaultToolkit();  
        Image img = tk.getImage("src/resources/logo.png");
		setIconImage(img);
		setTitle("Création d'un nouvel employé");
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Labels
		
		JLabel l_rens = new JLabel("Ajout d'un nouvel employé");
		l_rens.setHorizontalAlignment(SwingConstants.CENTER);
		l_rens.setFont(new Font("Tahoma", Font.BOLD, 34));
		l_rens.setBounds(0, 0, 584, 82); //dï¿½finit la taille et la position (x, y, largeur, hauteur)
		p.add(l_rens);
		
		JLabel l_nom = new JLabel("Nom :");
		l_nom.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_nom.setBounds(20, 100, 150, 30);
		p.add(l_nom);
		
		JLabel l_prenom = new JLabel("Prénom :");
		l_prenom.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_prenom.setBounds(20, 140, 150, 30);
		p.add(l_prenom);
		
		JLabel l_adresse = new JLabel("Adresse : ");
		l_adresse.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_adresse.setBounds(20, 180, 150, 30);
		p.add(l_adresse);
		
		JLabel l_tel = new JLabel("Téléphone : ");
		l_tel.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_tel.setBounds(20, 220, 150, 30);
		p.add(l_tel);
		
		JLabel l_sexe = new JLabel("Sexe : ");
		l_sexe.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_sexe.setBounds(20, 260, 150, 30);
		p.add(l_sexe);
		
		JLabel l_mail = new JLabel("Mail : ");
		l_mail.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_mail.setBounds(20, 300, 150, 30);
		p.add(l_mail);
		
		JLabel l_dateN = new JLabel("Date de naissance :");
		l_dateN.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_dateN.setBounds(20, 340, 200, 30);
		p.add(l_dateN);
		
		JLabel l_fonction = new JLabel("Fonction : ");
		l_fonction.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_fonction.setBounds(20, 380, 150, 30);
		p.add(l_fonction);
		
		JLabel l_salaire = new JLabel("Salaire : ");
		l_salaire.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_salaire.setBounds(20, 420, 150, 37);
		p.add(l_salaire);
		
		// TextFields
		
		JTextField t_nom = new JTextField();
		t_nom.setBounds(175, 100, 380, 30);
		t_nom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		p.add(t_nom);
		t_nom.setColumns(10);
		
		JTextField t_prenom = new JTextField();
		t_prenom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_prenom.setColumns(10);
		t_prenom.setBounds(175, 140, 380, 30);
		p.add(t_prenom);
		
		JTextField t_adresse = new JTextField();
		t_adresse.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_adresse.setColumns(10);
		t_adresse.setBounds(175, 180, 380, 30);
		p.add(t_adresse);
		
		JTextField t_tel = new JTextField();
		t_tel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_tel.setColumns(10);
		t_tel.setBounds(175, 220, 380, 30);
		p.add(t_tel);
		
		JTextField t_mail = new JTextField();
		t_mail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_mail.setColumns(10);
		t_mail.setBounds(175, 300, 380, 30);
		p.add(t_mail);
		
		JTextField t_annee = new JTextField();
		t_annee.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_annee.setColumns(10);
		t_annee.setBounds(450, 340, 100, 30);
		p.add(t_annee);
		
		JTextField t_fonction = new JTextField();
		t_fonction.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_fonction.setColumns(10);
		t_fonction.setBounds(175, 380, 380, 30);
		p.add(t_fonction);
		
		JTextField t_salaire = new JTextField();
		t_salaire.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_salaire.setColumns(10);
		t_salaire.setBounds(175, 420, 380, 30);
		p.add(t_salaire);
		
		// ComboBoxes
		
		JComboBox<String> c_jour = new JComboBox<String>();
		c_jour.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		c_jour.setBounds(230, 341, 100, 29);
		p.add(c_jour);
		
		JComboBox<String> c_mois = new JComboBox<String>();
		c_mois.setModel(new DefaultComboBoxModel<String>(new String[] {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"}));
		c_mois.setBounds(340, 341, 100, 29);
		p.add(c_mois);

		JComboBox<String> c_sexe = new JComboBox<String>();
		c_sexe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		c_sexe.setModel(new DefaultComboBoxModel<String>(new String[] {"Homme", "Femme"}));
		c_sexe.setBounds(175, 260, 380, 30);
		p.add(c_sexe);
		
		// Boutons : Valider, Retour
		
		JButton b_valider = new JButton("Valider");
		b_valider.setBackground(new Color(100, 200, 100));
		b_valider.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_valider.setBounds(192, 477, 200, 50);
		b_valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(new NewEmploye(m, t_nom, t_prenom, c_sexe, t_salaire, t_fonction, t_adresse, t_mail, t_tel, c_jour, c_mois, t_annee).status == 1) {
					dispose();
					new Fen4_Gest_MagEmp(m);
					JFrame a = new JFrame();
				    JOptionPane.showMessageDialog(a, "Employé créé et ajouté à la base de données.", "Succès", 1);
				}
			}
		});
		p.add(b_valider);

		JButton b_retour = new JButton("Retour");
		b_retour.setBackground(new Color(200, 100, 100));
		b_retour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b_retour.setBounds(0, 531, 100, 30);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen4_Gest_MagEmp(m);
			}
		});
		p.add(b_retour);
	}
}