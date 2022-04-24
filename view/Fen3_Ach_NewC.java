package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controller.*;
import model.*;

public class Fen3_Ach_NewC extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel p = new JPanel();
	private JLabel l_main = new JLabel("Ajout d'un nouveau client");
	private JLabel l_nom = new JLabel("Nom :");
	private JLabel l_prenom = new JLabel("Pr\u00E9nom :");
	private JLabel l_adresse = new JLabel("Adresse :");
	private JLabel l_tel = new JLabel("T\u00E9l\u00E9phone :");
	private JLabel l_sexe = new JLabel("Sexe :");
	private JLabel l_mail = new JLabel("Mail :");
	private JLabel l_dateN = new JLabel("Date de naissance :");
	private JTextField t_nom;
	private JTextField t_prenom;
	private JTextField t_adresse;
	private JTextField t_tel;
	private JTextField t_mail;
	private JTextField t_dateN;

	JButton b_effacer = new JButton("EFFACER");
	JButton b_valider = new JButton("VALIDER");
	JButton b_retour = new JButton("RETOUR");
	private final JComboBox<String> c_sexe = new JComboBox<String>();
	
	public Fen3_Ach_NewC(Magasin m) {
		
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		l_main.setBounds(350, 21, 912, 48);
		l_main.setFont(new Font("Tahoma", Font.BOLD, 39));
		p.add(l_main);
		
		// Labels : "Nom", "Prénom", "Adresse", "Téléphone", "Sexe", "Mail", "Date de naissance"
		
		l_nom.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_nom.setBounds(115, 119, 147, 37);
		p.add(l_nom);
		
		l_prenom.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_prenom.setBounds(115, 237, 147, 37);
		p.add(l_prenom);
		
		l_adresse.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_adresse.setBounds(115, 353, 147, 37);
		p.add(l_adresse);
		
		l_tel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_tel.setBounds(115, 477, 207, 37);
		p.add(l_tel);
		
		l_sexe.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_sexe.setBounds(643, 119, 147, 37);
		p.add(l_sexe);
		
		l_mail.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_mail.setBounds(643, 237, 147, 37);
		p.add(l_mail);
		
		l_dateN.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_dateN.setBounds(643, 353, 326, 37);
		p.add(l_dateN);
		
		// Text Fields : Nom, Prénom, Adresse, Téléphone, Mail, Date de naissance
		
		t_nom = new JTextField();
		t_nom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_nom.setBounds(115, 154, 389, 58);
		p.add(t_nom);
		
		t_prenom = new JTextField();
		t_prenom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_prenom.setBounds(115, 272, 389, 58);
		p.add(t_prenom);
		
		t_adresse = new JTextField();
		t_adresse.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_adresse.setBounds(115, 392, 389, 58);
		p.add(t_adresse);
		
		t_tel = new JTextField();
		t_tel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_tel.setBounds(115, 513, 389, 58);
		p.add(t_tel);
		
		t_mail = new JTextField();
		t_mail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_mail.setBounds(643, 272, 389, 58);
		p.add(t_mail);
		
		t_dateN = new JTextField();
		t_dateN.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_dateN.setBounds(643, 392, 389, 58);
		p.add(t_dateN);
		
		// Boutons : Effacer, Valider, Retour
		
		b_effacer.setForeground(Color.BLACK);
		b_effacer.setBackground(Color.LIGHT_GRAY);
		b_effacer.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_effacer.setBounds(739, 502, 207, 64);
		p.add(b_effacer);
		
		b_valider.setBackground(new Color(0, 128, 0));
		b_valider.setForeground(Color.BLACK);
		b_valider.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_valider.setBounds(739, 619, 207, 64);
		b_valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (new NewClient(m, t_nom, t_prenom, t_adresse, t_tel, t_mail, c_sexe).status == 1) {
					dispose();
				}
			}
		});
		p.add(b_valider);
		
		b_retour.setForeground(Color.BLACK);
		b_retour.setBackground(new Color(255, 215, 0));
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_retour.setBounds(208, 619, 207, 64);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen2_Ach(m);
			}
		});
		p.add(b_retour);
		
		c_sexe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		c_sexe.setModel(new DefaultComboBoxModel<String>(new String[] {"Homme", "Femme"}));
		c_sexe.setBounds(643, 154, 389, 58);
		
		p.add(c_sexe);
	}
}
