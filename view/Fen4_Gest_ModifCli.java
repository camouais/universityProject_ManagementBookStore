package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controller.*;
import model.*;

public class Fen4_Gest_ModifCli extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel p = new JPanel();
	private JLabel l_rens = new JLabel("Renseignements du client");
	private JLabel l_nom = new JLabel("Nom :");
	private JLabel l_prenom = new JLabel("Prénom :");
	private JLabel l_id = new JLabel("Identifiant :");
	private JLabel l_adresse = new JLabel("Adresse : ");
	private JLabel l_mail = new JLabel("Mail : ");
	private JLabel l_tel = new JLabel("T\u00E9l\u00E9phone : ");
	private JTextField t_nom;
	private JTextField t_prenom;
	private JTextField t_id;
	private JTextField t_adresse;
	private JTextField t_mail;
	private JTextField t_tel;
	
	JButton b_retour = new JButton("RETOUR");
	JButton b_effacer = new JButton("EFFACER");
	JButton b_enreg = new JButton("ENREGISTRER");

	public Fen4_Gest_ModifCli(Magasin m, Client c) { // Rajouter une variable de type Employe dans le constructeur lorsqu'on aura fait le controller
		
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 480);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// JLabel Renseignements du client
		
		l_rens.setHorizontalAlignment(SwingConstants.CENTER);
		l_rens.setFont(new Font("Tahoma", Font.BOLD, 34));
		l_rens.setBounds(0, 0, 550, 82); //définit la taille et la position (x, y, largeur, hauteur)
		p.add(l_rens);
		
		// JLabels & JTextfield nom
		
		l_nom.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_nom.setBounds(20, 100, 150, 30);
		p.add(l_nom);
	
		t_nom = new JTextField();
		t_nom.setBounds(150, 100, 380, 30);
		t_nom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_nom.setText(c.getNom());
		p.add(t_nom);
		t_nom.setColumns(10);

		//JLabels & JTextfield prénom
		
		l_prenom.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_prenom.setBounds(20, 140, 150, 30);
		p.add(l_prenom);
		
		t_prenom = new JTextField();
		t_prenom.setFont(new Font("Tahoma", Font.PLAIN, 25));t_prenom.setText(c.getPrenom());
		t_prenom.setColumns(10);
		t_prenom.setBounds(150, 140, 380, 30);
		p.add(t_prenom);
		
		// JLabel & JTextfield identifiant
		
		l_id.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_id.setBounds(20, 180, 150, 30);
		p.add(l_id);
		
		t_id = new JTextField();
		t_id.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_id.setColumns(10);
		t_id.setText(String.valueOf(c.getId()));
		t_id.setBounds(150, 180, 380, 30);
		p.add(t_id);
		
		// JLabel & JTextfield adresse
		
		l_adresse.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_adresse.setBounds(20, 220, 150, 30);
		p.add(l_adresse);
		
		t_adresse = new JTextField();
		t_adresse.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_adresse.setColumns(10);
		t_adresse.setText(c.getAdresse());
		t_adresse.setBounds(150, 220, 380, 30);
		p.add(t_adresse);
		
		// JLabel & JTextfield mail
		
		l_mail.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_mail.setBounds(20, 260, 150, 30);
		p.add(l_mail);
		
		t_mail = new JTextField();
		t_mail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_mail.setColumns(10);
		t_mail.setText(c.getMail());
		t_mail.setBounds(150, 260, 380, 30);
		p.add(t_mail);

		// JLabel & JTextfield téléphone
		
		l_tel.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_tel.setBounds(20, 300, 150, 30);
		p.add(l_tel);
		
		t_tel = new JTextField();
		t_tel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_tel.setColumns(10);
		t_tel.setText(c.getTel());
		t_tel.setBounds(150, 300, 380, 30);
		p.add(t_tel);
		
		// Boutons : Retour, Effacer, Enregistrer
		
		b_retour.setBackground(new Color(255, 215, 0));
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_retour.setBounds(10, 370, 150, 50);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen3_Gest_Cli(m);
			}
		});
		p.add(b_retour);
		
		b_effacer.setForeground(Color.WHITE);
		b_effacer.setBackground(new Color(0, 0, 0));
		b_effacer.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_effacer.setBounds(180, 370, 150, 50);
		b_effacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.supCli(c);
				dispose();
				new Fen3_Gest_Cli(m);
			}
		});
		p.add(b_effacer);
		
		b_enreg.setBackground(new Color(0, 128, 0));
		b_enreg.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_enreg.setBounds(350, 370, 200, 50);
		b_enreg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Modif_InfoClient(m, c, t_nom, t_prenom, t_adresse, t_mail, t_tel);
			}
		});
		p.add(b_enreg);
	}
}
