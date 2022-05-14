package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controller.*;

public class Fen0_NewMag extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public Fen0_NewMag() {
		
		// Fenêtre
		
		JPanel p = new JPanel();
		setTitle("Enregistrement d'un nouveau magasin");
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 380);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Labels
		
		JLabel l_main = new JLabel("Création du magasin");
		l_main.setHorizontalAlignment(SwingConstants.CENTER);
		l_main.setFont(new Font("Tahoma", Font.BOLD, 40));
		l_main.setBounds(0, 0, 584, 82);
		p.add(l_main);
		
		JLabel l_nom = new JLabel("Nom* :");
		l_nom.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_nom.setBounds(20, 100, 170, 30);
		p.add(l_nom);
		
		JLabel l_adresse = new JLabel("Adresse :");
		l_adresse.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_adresse.setBounds(20, 180, 170, 30);
		p.add(l_adresse);
		
		JLabel l_mdp = new JLabel("Mot de passe* :");
		l_mdp.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_mdp.setBounds(20, 140, 170, 30);
		p.add(l_mdp);
		
		JLabel l_champs = new JLabel("* : Champs obligatoires");
		l_champs.setFont(new Font("Tahoma", Font.ITALIC, 15));
		l_champs.setBounds(20, 221, 200, 30);
		p.add(l_champs);
		
		// TextFields
		
		JTextField t_nom = new JTextField();
		t_nom.setBounds(200, 100, 350, 30);
		t_nom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_nom.setColumns(10);
		p.add(t_nom);
		
		JTextField t_adr = new JTextField();
		t_adr.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_adr.setColumns(10);
		t_adr.setBounds(200, 180, 350, 30);
		p.add(t_adr);
		
		JPasswordField t_mdp = new JPasswordField();
		t_mdp.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_mdp.setColumns(10);
		t_mdp.setBounds(200, 140, 350, 30);
		p.add(t_mdp);
		
		// Boutons
		
		JButton b_retour = new JButton("Retour");
		b_retour.setBackground(new Color(200, 100, 100));
		b_retour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b_retour.setBounds(0, 311, 100, 30);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen0();
			}
		});
		p.add(b_retour);
		
		JButton b_valid = new JButton("Valider");
		b_valid.setBackground(new Color(128, 255, 128));
		b_valid.setFont(new Font("Tahoma", Font.BOLD, 25));
		b_valid.setBounds(217, 262, 150, 60);
		b_valid.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	NewMagasin nm = new NewMagasin(t_nom, t_mdp, t_adr);
				if (nm.status == 1) {
					dispose();
					new Fen1(nm.getMagasin());
	            	JFrame a = new JFrame();
	    		    JOptionPane.showMessageDialog(a, "Magasin créé.", "Succès", 1);
				}
            }
        });
		p.add(b_valid);
	}
}