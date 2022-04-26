package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.*;

public class Fen4_Gest_MagStat extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel p = new JPanel();
	private JLabel l_main = new JLabel("Statistiques");
	
	JButton b_retour = new JButton("Retour");
	JButton b_compta = new JButton("Comptabilit\u00E9s");
	JButton b_achats = new JButton("Achats");
	JButton b_clients = new JButton("Clients");
	JButton b_emp = new JButton("Employ\u00E9s");
	JButton b_livres = new JButton("Livres");
	
	public Fen4_Gest_MagStat(Magasin m) {
		
		//FenÃªtre
		
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// JLable Statistiques : 
    
		l_main.setHorizontalAlignment(SwingConstants.CENTER);
		l_main.setFont(new Font("Tahoma", Font.BOLD, 50));
		l_main.setBounds(153, 11, 371, 66);
		p.add(l_main);
    
		// Boutons : Livres, Clients, Achats, EmployÃ©s
    
		b_livres.setBackground(new Color(180, 112, 147));
		b_livres.setFont(new Font("Tahoma", Font.BOLD, 40));
		b_livres.setBounds(30, 101, 300, 75);
		b_livres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen5_Gest_StatLiv(m);
			}
		});
		p.add(b_livres);
    
		b_clients.setBackground(new Color(244, 164, 96));
		b_clients.setFont(new Font("Tahoma", Font.BOLD, 43));
		b_clients.setBounds(30, 200, 300, 75);
		b_clients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen5_Gest_StatCli(m);
			}
		});
		p.add(b_clients);
		
		b_achats.setBackground(new Color(221, 150, 221));
		b_achats.setFont(new Font("Tahoma", Font.BOLD, 43));
		b_achats.setBounds(360, 100, 300, 75);
		b_achats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen5_Gest_StatAch(m);
			}
		});
		p.add(b_achats);
	    
		b_emp.setBackground(new Color(0, 222, 100));
		b_emp.setFont(new Font("Tahoma", Font.BOLD, 43));
		b_emp.setBounds(360, 200, 300, 75);
		b_emp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen5_Gest_StatEmp(m);
			}
		});
		p.add(b_emp);
    
		b_compta.setBackground(new Color(222, 206, 250));
		b_compta.setFont(new Font("Tahoma", Font.BOLD, 43));
		b_compta.setBounds(150, 300, 400, 75);
		b_compta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen5_Gest_StatCompta(m);
			}
		});
		p.add(b_compta);
		
		b_retour.setBackground(new Color(200, 100, 100));
		b_retour.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
