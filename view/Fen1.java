package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.*;

public class Fen1 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel p = new JPanel();
	
	JButton b_gest = new JButton("Gestion");
	JButton b_ach = new JButton("Achat");
	JButton b_deco = new JButton("D\u00E9connexion");
	
	public Fen1(Magasin m) {
		
		// Fenêtre
		setTitle("Menu principal");
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 250);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Boutons : Gestion, Achat, Quitter
		
		b_gest.setBackground(new Color(147, 112, 219));
		b_gest.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_gest.setBounds(30, 80, 200, 70);
		b_gest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen2_Gest(m);
			}
		});
		p.add(b_gest);
		
		b_ach.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_ach.setBackground(new Color(205, 92, 92));
		b_ach.setBounds(254, 80, 200, 70);
		b_ach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen2_Ach(m);
			}
		});
		p.add(b_ach);
		
		JLabel l_main = new JLabel("Menu principal");
		l_main.setHorizontalAlignment(SwingConstants.CENTER);
		l_main.setFont(new Font("Tahoma", Font.BOLD, 35));
		l_main.setBounds(0, 0, 484, 70);
		p.add(l_main);
		
		b_deco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b_deco.setBackground(new Color(200, 100, 100));
		b_deco.setBounds(0, 181, 150, 30);
		b_deco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen0();
			}
		});
		p.add(b_deco);
	}
}
