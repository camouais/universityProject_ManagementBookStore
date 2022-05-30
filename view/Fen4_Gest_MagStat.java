package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.*;

public class Fen4_Gest_MagStat extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JLabel l_main = new JLabel("Statistiques du magasin");
	
	public Fen4_Gest_MagStat(Magasin m) {
		
		// Fenêtre
		
		JPanel p = new JPanel();
		Toolkit tk = Toolkit.getDefaultToolkit();  
        Image img = tk.getImage("src/resources/logo.png");
		setIconImage(img);
		setTitle("Menu des statistiques");
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Label 
		
		l_main.setHorizontalAlignment(SwingConstants.CENTER);
		l_main.setFont(new Font("Tahoma", Font.BOLD, 35));
		l_main.setBounds(0, 10, 484, 66);
		p.add(l_main);
		
		// Boutons : Livres, Clients, Achats, Employés
		
		JButton b_livres = new JButton("Livres");
		b_livres.setBackground(new Color(180, 112, 147));
		b_livres.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_livres.setBounds(30, 90, 200, 70);
		b_livres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen5_Gest_StatLiv(m);
			}
		});
		p.add(b_livres);
		
		JButton b_clients = new JButton("Clients");
		b_clients.setBackground(new Color(244, 164, 96));
		b_clients.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_clients.setBounds(30, 185, 200, 75);
		b_clients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen5_Gest_StatCli(m);
			}
		});
		p.add(b_clients);
		
		JButton b_achats = new JButton("Achats");
		b_achats.setBackground(new Color(221, 150, 221));
		b_achats.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_achats.setBounds(254, 90, 200, 70);
		b_achats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen5_Gest_StatAch(m);
			}
		});
		p.add(b_achats);
		
		JButton b_emp = new JButton("Employés");
		b_emp.setBackground(new Color(0, 222, 100));
		b_emp.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_emp.setBounds(254, 185, 200, 75);
		b_emp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen5_Gest_StatEmp(m);
			}
		});
		p.add(b_emp);
		
		JButton b_compta = new JButton("Comptabilités");
		b_compta.setBackground(new Color(222, 206, 250));
		b_compta.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_compta.setBounds(92, 285, 300, 75);
		b_compta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen5_Gest_StatCompta(m);
			}
		});
		p.add(b_compta);
		
		JButton b_retour = new JButton("Retour");
		b_retour.setBackground(new Color(200, 100, 100));
		b_retour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b_retour.setBounds(0, 381, 100, 30);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen3_Gest_Mag(m);
			}
		});
		p.add(b_retour);
	}
}