package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.*;

public class Fen2_Ach extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel p = new JPanel();
	private JLabel l_main = new JLabel("Nouveau client ?");
	
	JButton b_oui = new JButton("Oui");
	JButton b_non = new JButton("Non");
	JButton b_retour = new JButton("RETOUR");

	public Fen2_Ach(Magasin m) {
		
		// Fenêtre
		
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		setLocationRelativeTo(null);
		setResizable(false);
	    setVisible(true);
	    
		// JLabel "Nouveau client ?"
		
		l_main.setVerticalAlignment(SwingConstants.BOTTOM);
		l_main.setHorizontalAlignment(SwingConstants.CENTER);
		l_main.setFont(new Font("Calibri", Font.PLAIN, 60));
		l_main.setBounds(0, 11, 484, 80);
		p.add(l_main);
		
		// Boutons : Oui, Non, Retour
		
		b_oui.setBackground(new Color(100, 255, 100));
		b_oui.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_oui.setBounds(50, 100, 150, 56);
		b_oui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Fen3_Ach_NewC(m);
				dispose();
			}
		});
		p.add(b_oui);
		
		b_non.setBackground(new Color(255, 100, 100));
		b_non.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_non.setBounds(284, 100, 150, 56);
		b_non.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Fen3_Ach_ExistC(m);
				dispose();
			}
		});
		p.add(b_non);
		
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_retour.setBackground(new Color(200, 100, 100));
		b_retour.setBounds(165, 180, 150, 50);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Fen1(m);
				dispose();
			}
		});
		p.add(b_retour);
	}
}
