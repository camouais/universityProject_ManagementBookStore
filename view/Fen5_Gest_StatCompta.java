package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.*;

public class Fen5_Gest_StatCompta extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public Fen5_Gest_StatCompta(Magasin m) {
		
		// Fenêtre
		
		JPanel p = new JPanel();
		Toolkit tk = Toolkit.getDefaultToolkit();  
        Image img = tk.getImage("src/resources/logo.png");
		setIconImage(img);
		setTitle("Comptabilités");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 260);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		p.setBackground(Color.LIGHT_GRAY);
		setContentPane(p);
		p.setLayout(null);
		
		// Label
		
		JLabel l_main = new JLabel("Comptabilit\u00E9s");
		l_main.setFont(new Font("Tahoma", Font.BOLD, 35));
		l_main.setHorizontalAlignment(SwingConstants.CENTER);
		l_main.setBounds(0, 10, 484, 70);
		p.add(l_main);
		
		// Boutons
		
		JButton b_depenses = new JButton("D\u00E9penses");
		b_depenses.setBackground(new Color(178, 34, 34));
		b_depenses.setFont(new Font("Tahoma", Font.BOLD, 25));
		b_depenses.setBounds(30, 100, 200, 60);
		b_depenses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen6_Gest_Depenses(m);
			}
		});
		p.add(b_depenses);
		
		JButton b_recettes = new JButton("Recettes");
		b_recettes.setBackground(new Color(135, 206, 235));
		b_recettes.setFont(new Font("Tahoma", Font.BOLD, 25));
		b_recettes.setBounds(254, 100, 200, 60);
		b_recettes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen6_Gest_Recettes(m);
			}
		});
		p.add(b_recettes);
		
		JButton b_retour = new JButton("Retour");
		b_retour.setBackground(new Color(200, 100, 100));
		b_retour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		b_retour.setBounds(0, 191, 100, 30);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen4_Gest_MagStat(m);
			}
		});
		p.add(b_retour);
	}
}
