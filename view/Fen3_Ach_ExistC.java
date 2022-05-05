package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.*;
import controller.*;

public class Fen3_Ach_ExistC extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel p = new JPanel();
	private JTextField t_nom;
	private JTextField t_prenom = new JTextField();
	private JTextField t_mail = new JTextField();
	private JLabel l_main = new JLabel("Renseignements du client");
	private JLabel l_nom = new JLabel("Nom :");
	private JLabel l_prenom = new JLabel("Pr\u00E9nom :");
	private JLabel l_mail = new JLabel("Adresse mail :");
	
	JButton b_valider = new JButton("VALIDER");
	JButton b_retour = new JButton("RETOUR");

	public Fen3_Ach_ExistC(Magasin m) {
		
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 350);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Labels : "Renseignements du client", "Nom", "Pr�nom", "Identifiant"
		
		l_main.setHorizontalAlignment(SwingConstants.CENTER);
		l_main.setFont(new Font("Tahoma", Font.BOLD, 40));
		l_main.setBounds(0, 0, 550, 82);
		p.add(l_main);
		
		l_nom.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_nom.setBounds(20, 100, 150, 30);
		p.add(l_nom);
		
		l_prenom.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_prenom.setBounds(20, 140, 150, 30);
		p.add(l_prenom);
		
		l_mail.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_mail.setBounds(20, 180, 150, 30);
		p.add(l_mail);
		
		// Text Fields : Nom, Prénom, Identifiant
		
		t_nom = new JTextField();
		t_nom.setBounds(150, 100, 380, 30);
		t_nom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		p.add(t_nom);
		t_nom.setColumns(10);

		t_prenom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_prenom.setColumns(10);
		t_prenom.setBounds(150, 141, 380, 30);
		p.add(t_prenom);
		
		t_mail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_mail.setColumns(10);
		t_mail.setBounds(150, 180, 380, 30);
		p.add(t_mail);
		
		// Boutons : Retour, Valider
		
		b_retour.setBackground(new Color(255, 215, 0));
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_retour.setBounds(50, 230, 150, 50);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen2_Ach(m);
			}
		});
		p.add(b_retour);
		
		b_valider.setBackground(new Color(0, 128, 0));
		b_valider.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_valider.setBounds(350, 230, 150, 50);
		b_valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(new ClientExists(m, t_nom, t_prenom, t_mail).status == 1) {
					dispose();
				}
			}
		});
		p.add(b_valider);
	}
}