package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.*;
import controller.*;

public class Fen5_Gest_NewEmp extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel p = new JPanel();
	private JTextField t_nom;
	private JTextField t_prenom;
	private JTextField t_annee;
	private JTextField t_fonction;
	private JTextField t_adresse;
	private JTextField t_sexe;
	private JTextField t_mail;
	private JTextField t_tel;
	private JTextField t_salaire;
	
	private JLabel l_rens = new JLabel("Renseignements du nouvel employ�");
	private JLabel l_nom = new JLabel("Nom :");
	private JLabel l_prenom = new JLabel("Pr�nom :");
	private JLabel l_dateN = new JLabel("Date de naissance :");
	private JLabel l_salaire = new JLabel("Salaire : ");
	
	private JLabel l_fonction = new JLabel("Fonction : ");
	private JLabel l_adresse = new JLabel("Adresse : ");
	private JLabel l_sexe = new JLabel("Sexe : ");
	private JLabel l_mail = new JLabel("Mail : ");
	private JLabel l_tel = new JLabel("T�l�phone : ");
	
	JButton b_effacer = new JButton("EFFACER");
	JButton b_valider = new JButton("VALIDER");
	JButton b_retour = new JButton("RETOUR");
	private final JComboBox<String> c_jour = new JComboBox<String>();
	private final JComboBox<String> c_mois = new JComboBox<String>();

	public Fen5_Gest_NewEmp(Magasin m) {
		setTitle("Ajout nouvel employé");
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		l_rens.setHorizontalAlignment(SwingConstants.CENTER);
		l_rens.setFont(new Font("Tahoma", Font.BOLD, 34));
		l_rens.setBounds(0, 0, 700, 82); //d�finit la taille et la position (x, y, largeur, hauteur)
		p.add(l_rens);


		// JLabel & JTextfield : Nom
		
		l_nom.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_nom.setBounds(50, 100, 150, 30);
		p.add(l_nom);
		
		t_nom = new JTextField();
		t_nom.setBounds(260, 100, 380, 30);
		t_nom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		p.add(t_nom);
		t_nom.setColumns(10);
		
		// JLabel & JTextfield : Pr�nom
		
		l_prenom.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_prenom.setBounds(50, 140, 150, 30);
		p.add(l_prenom);
		
		t_prenom = new JTextField();
		t_prenom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_prenom.setColumns(10);
		t_prenom.setBounds(260, 140, 380, 30);
		p.add(t_prenom);

		// JLabel & JTextfield : Adresse
		
		l_adresse.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_adresse.setBounds(50, 180, 150, 30);
		p.add(l_adresse);
		
		t_adresse = new JTextField();
		t_adresse.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_adresse.setColumns(10);
		t_adresse.setBounds(260, 180, 380, 30);
		p.add(t_adresse);
		

		// JLabel & JTextfield : T�l�phone
		
		
		l_tel.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_tel.setBounds(50, 220, 150, 30);
		p.add(l_tel);
		
		t_tel = new JTextField();
		t_tel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_tel.setColumns(10);
		t_tel.setBounds(260, 220, 380, 30);
		p.add(t_tel);
		
		// JLabel & JTextfield : Sexe

		l_sexe.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_sexe.setBounds(50, 260, 150, 30);
		p.add(l_sexe);
		
		t_sexe = new JTextField();
		t_sexe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_sexe.setColumns(10);
		t_sexe.setBounds(260, 260, 380, 30);
		p.add(t_sexe);
		
		

		// JLabel & JTextfield : Adresse Mail
		
		l_mail.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_mail.setBounds(50, 300, 150, 30);
		p.add(l_mail);
		
		t_mail = new JTextField();
		t_mail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_mail.setColumns(10);
		t_mail.setBounds(260, 300, 380, 30);
		p.add(t_mail);
		

		//JLabel & JTextfield : Date de Naissance
		
		l_dateN.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_dateN.setBounds(50, 340, 200, 30);
		p.add(l_dateN);
		
		t_annee = new JTextField();
		t_annee.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_annee.setColumns(10);
		t_annee.setBounds(520, 340, 120, 30);
		p.add(t_annee);
		

		// JLabel & JTextfield : Fonction
		
		l_fonction.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_fonction.setBounds(50, 380, 150, 30);
		p.add(l_fonction);
		
		t_fonction = new JTextField();
		t_fonction.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_fonction.setColumns(10);
		t_fonction.setBounds(260, 380, 380, 30);
		p.add(t_fonction);

		// JLabel & JTextfield : Salaire
		
		l_salaire.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_salaire.setBounds(50, 420, 150, 37);
		p.add(l_salaire);

		t_salaire = new JTextField();
		t_salaire.setColumns(10);
		t_salaire.setBounds(260, 420, 380, 30);
		p.add(t_salaire);

		// Boutons : Valider, Retour
		b_valider.setBackground(new Color(0, 128, 0));
		b_valider.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_valider.setBounds(470, 480, 200, 50);
		b_valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(new NewEmploye(m, t_nom, t_prenom, t_sexe, t_salaire, t_fonction, t_adresse, t_mail, t_tel, c_jour, c_mois, t_annee).status == 1) {
					dispose();
					JFrame a = new JFrame();
				    JOptionPane.showMessageDialog(a, "Employé créé et ajouté à la base de données.", "Succès", 1);
				}
			}
		});
		p.add(b_valider);

		b_retour.setBackground(new Color(255, 215, 0));
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_retour.setBounds(50, 480, 150, 50);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen4_Gest_MagEmp(m);
			}
		});
		p.add(b_retour);
		c_jour.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		c_jour.setBounds(260, 341, 120, 29);
		
		p.add(c_jour);
		c_mois.setModel(new DefaultComboBoxModel<String>(new String[] {"Janvier", "F\\u00E9vrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Ao\\u00FAt", "Septembre", "Octobre", "Novembre", "D\\u00E9cembre"}));
		c_mois.setBounds(390, 341, 120, 29);
		
		p.add(c_mois);
	}
}
