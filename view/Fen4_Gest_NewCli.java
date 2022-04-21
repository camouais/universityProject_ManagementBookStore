package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.*;

public class Fen4_Gest_NewCli extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel p = new JPanel();
	private JTextField t_nom;
	private JTextField t_prenom;
	private JTextField t_adresse;
	private JTextField t_tel;
	private JTextField t_sexe;
	private JTextField t_mail;
	private JTextField t_dateN;

	JButton b_effacer = new JButton("EFFACER");
	JButton b_valider = new JButton("VALIDER");
	JButton b_retour = new JButton("RETOUR");
	
	public Fen4_Gest_NewCli(Magasin m) {
		
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Ajout d'un nouveau client");
		lblNewLabel.setBounds(350, 21, 912, 48);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 39));
		p.add(lblNewLabel);
		
		//JLabel nom
		
		JLabel l_nom = new JLabel("Nom :");
		l_nom.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_nom.setBounds(115, 119, 147, 37);
		p.add(l_nom);
		
		//JLabel prénom
		
		JLabel l_prenom = new JLabel("Prénom :");
		l_prenom.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_prenom.setBounds(115, 237, 147, 37);
		p.add(l_prenom);
		
		//JLabel adresse
		
		JLabel l_adresse = new JLabel("Adresse :");
		l_adresse.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_adresse.setBounds(115, 353, 147, 37);
		p.add(l_adresse);
		
		//JLabel téléphone
		
		JLabel l_tel = new JLabel("Téléphone :");
		l_tel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_tel.setBounds(115, 477, 207, 37);
		p.add(l_tel);
		
		//JLabel sexe
		
		JLabel l_sexe = new JLabel("Sexe :");
		l_sexe.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_sexe.setBounds(643, 119, 147, 37);
		p.add(l_sexe);
		
		//JLabel mail
		
		JLabel l_mail = new JLabel("Mail :");
		l_mail.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_mail.setBounds(643, 237, 147, 37);
		p.add(l_mail);
		
		//JLabel date de naissance
		
		JLabel l_dateN = new JLabel("Date de naissance :");
		l_dateN.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_dateN.setBounds(643, 353, 326, 37);
		p.add(l_dateN);
		
		//JTextfield nom 
		
		t_nom = new JTextField();
		t_nom.setBounds(115, 154, 389, 58);
		p.add(t_nom);
		
		//JTextfield prenom 
		
		t_prenom = new JTextField();
		t_prenom.setBounds(115, 272, 389, 58);
		p.add(t_prenom);
		
		//JTextfield adresse 
		
		t_adresse = new JTextField();
		t_adresse.setBounds(115, 392, 389, 58);
		p.add(t_adresse);
		
		//JTextfield téléphone
		
		t_tel = new JTextField();
		t_tel.setBounds(115, 513, 389, 58);
		p.add(t_tel);
		
		//JTextfield sexe 
		
		t_sexe = new JTextField();
		t_sexe.setBounds(643, 154, 389, 58);
		p.add(t_sexe);
		
		//JTextfield mail
		
		t_mail = new JTextField();
		t_mail.setBounds(643, 272, 389, 58);
		p.add(t_mail);
		
		//JTextfield date de naissance 
		
		t_dateN = new JTextField();
		t_dateN.setBounds(643, 392, 389, 58);
		p.add(t_dateN);
		
		//JButton Effacer
		
		b_effacer.setForeground(new Color(255, 255, 255));
		b_effacer.setBackground(new Color(0, 0, 0));
		b_effacer.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_effacer.setBounds(739, 502, 207, 64);
		b_effacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		p.add(b_effacer);
		
		//JButton Valider
		
		b_valider.setBackground(new Color(0, 128, 0));
		b_valider.setForeground(new Color(255, 255, 255));
		b_valider.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_valider.setBounds(739, 619, 207, 64);
		b_valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Fen3_Gest_Cli(m);
				dispose();
			}
		});
		p.add(b_valider);
		
		//JButton retour
		
		b_retour.setForeground(new Color(255, 255, 255));
		b_retour.setBackground(new Color(255, 215, 0));
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_retour.setBounds(208, 619, 207, 64);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Fen3_Gest_Cli(m);
				dispose();
			}
		});
		p.add(b_retour);
	}
}
