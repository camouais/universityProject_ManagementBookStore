package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fen1 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel p = new JPanel();
	
	public Fen1() {
		
		// Fenêtre
		
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Bouton "Gestion"
		
		JButton b_gestion = new JButton("GESTION");
		
		b_gestion.setBackground(new Color(147, 112, 219));
		b_gestion.setFont(new Font("Arial", Font.BOLD, 55));
		b_gestion.setBounds(50, 50, 400, 100);
		b_gestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Fen2_Gest();
				dispose();
			}
		});
		p.add(b_gestion);
		
		// Bouton "Achats"
		
		JButton b_achats = new JButton("ACHAT");
		
		b_achats.setFont(new Font("Arial", Font.BOLD, 55));
		b_achats.setBackground(new Color(205, 92, 92));
		b_achats.setBounds(50, 200, 400, 100);
		b_achats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Fen2_Ach();
				dispose();
			}
		});
		p.add(b_achats);
		
		// Bouton "Quitter"
		
		JButton b_quit = new JButton("Quitter");
		
		b_quit.setBackground(new Color(255, 200, 200));
		b_quit.setFont(new Font("Arial", Font.BOLD, 10));
		b_quit.setBounds(0, 0, 80, 20);
		b_quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		p.add(b_quit);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen1 frame = new Fen1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
