package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.*;
import controller.*;

public class Fen4_Gest_MagInfo extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel p = new JPanel();
	private JTextField t_nom = new JTextField();
	private JTextField t_adresse = new JTextField();

	public Fen4_Gest_MagInfo(Magasin m) {
		
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 320);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Labels : Informations du Magasin, Nom, Adresse
		
		JLabel l = new JLabel("Informations du magasin");
		l.setHorizontalAlignment(SwingConstants.CENTER);
		l.setFont(new Font("Tahoma", Font.BOLD, 40));
		l.setBounds(0, 0, 550, 82);
		p.add(l);
		
		JLabel l_nom = new JLabel("Nom :");
		l_nom.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_nom.setBounds(20, 100, 150, 30);
		p.add(l_nom);
		
		JLabel l_adresse = new JLabel("Adresse :");
		l_adresse.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_adresse.setBounds(20, 140, 150, 30);
		p.add(l_adresse);
		
		// Text Field : Nom, Adresse
		
		t_nom.setBounds(150, 100, 380, 30);
		t_nom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_nom.setColumns(10);
		t_nom.setText(m.getNom());
		p.add(t_nom);
		
		t_adresse.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_adresse.setColumns(10);
		t_adresse.setBounds(150, 141, 380, 30);
		p.add(t_adresse);
		
		// Boutons : Retour, Enregistrer
		
		JButton b_retour = new JButton("RETOUR");
		b_retour.setBackground(new Color(255, 215, 0));
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_retour.setBounds(50, 200, 150, 50);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                System.out.println("nom sortant = " + m.getNom());
				new Fen3_Gest_Mag(m);
				dispose();
			}
		});
		p.add(b_retour);
		
		JButton b_enreg = new JButton("ENREGISTRER");
		b_enreg.setBackground(new Color(0, 128, 0));
		b_enreg.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_enreg.setBounds(300, 200, 200, 50);
		b_enreg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new Modif_InfoMag(m,t_nom);
            }
        });
		p.add(b_enreg);
	}
}
