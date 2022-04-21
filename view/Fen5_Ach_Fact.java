package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import model.*;

public class Fen5_Ach_Fact extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JTextField t_client = new JTextField();
	private JTextField t_prix;
	private JPanel p = new JPanel();
	JPanel p_achats = new JPanel();
	JLabel l_facture = new JLabel("Facture ");
	JLabel l_client = new JLabel("Client : ");
	JLabel l_achats = new JLabel("Achats : ");
	
	JButton b_enreg = new JButton("Enregistrer");
	JButton b_retour = new JButton("Retour");
	
	public Fen5_Ach_Fact(Magasin m, Client c) {
		
		// Fenêtre
		
		p = new JPanel();
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		p.setBackground(new Color(150, 200, 150));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 580);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Labels : Client, Facture, Prix, Achats
		
		l_facture.setHorizontalAlignment(SwingConstants.CENTER);
		l_facture.setFont(new Font("Arial", Font.BOLD, 42));
		l_facture.setBounds(0, 0, 484, 100);
		p.add(l_facture);
		
		l_client.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l_client.setBounds(25, 100, 100, 30);
		p.add(l_client);
		
		JLabel l_prix = new JLabel("Prix : ");
		l_prix.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l_prix.setBounds(25, 425, 100, 30);
		p.add(l_prix);
		
		l_achats.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l_achats.setBounds(25, 140, 100, 30);
		p.add(l_achats);
		
		// Text Fields : Client, Prix
		
		t_client.setForeground(new Color(0, 0, 0));
		t_client.setBackground(new Color(102, 255, 204));
		t_client.setBounds(125, 100, 325, 30);
		p.add(t_client);
		t_client.setColumns(10);
		
		t_prix = new JTextField();
		t_prix.setBounds(125, 425, 325, 30);
		p.add(t_prix);
		t_prix.setColumns(10);
		
		// JPanel liste des achats (Tableau à ajouter pour lister les livres & prix)
		
		p_achats.setBounds(25, 180, 432, 236);
		p.add(p_achats);
		
		// Boutons : Enregistrer, Retour
		
		b_enreg.setBackground(new Color(255, 255, 0));
		b_enreg.setFont(new Font("Tahoma", Font.PLAIN, 25));
		b_enreg.setBounds(300, 475, 160, 41);
		b_enreg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Fen1(m);
				dispose();
			}
		});
		p.add(b_enreg);
		
		b_retour.setBackground(new Color(255, 182, 193));
		b_retour.setFont(new Font("Tahoma", Font.PLAIN, 25));
		b_retour.setBounds(25, 475, 160, 41);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Fen4_Ach_DoAch(m,c);
				dispose();
			}
		});
		p.add(b_retour);
	}
}
