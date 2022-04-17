package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fen_2_Gest extends JFrame {

	private JPanel p = new JPanel();
	
	public Fen_2_Gest() {
		
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 650);
		setLocationRelativeTo(null);
		setResizable(false);
	    setVisible(true);
		
		// Bouton "Livres"
		
		JButton b_livres = new JButton("LIVRES");
		b_livres.setBackground(new Color(204, 204, 255));
		b_livres.setFont(new Font("Tahoma", Font.BOLD, 55));
		b_livres.setBounds(50, 50, 400, 100);
		p.add(b_livres);
		
		// Bouton "Magasin"
		
		JButton b_magasin = new JButton("MAGASIN");
		b_magasin.setFont(new Font("Tahoma", Font.BOLD, 55));
		b_magasin.setBackground(new Color(255, 255, 153));
		b_magasin.setBounds(50, 350, 400, 100);
		b_magasin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fen_3_Gest_InfoStat a = new Fen_3_Gest_InfoStat();
				dispose();
			}
		});
		p.add(b_magasin);
		
		// Bouton "Clients"
		
		JButton b_clients = new JButton("CLIENTS");
		b_clients.setFont(new Font("Tahoma", Font.BOLD, 55));
		b_clients.setBackground(new Color(102, 102, 255));
		b_clients.setBounds(50, 200, 400, 100);
		b_clients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		p.add(b_clients);
		
		// Bouton "Retour"
		
		JButton b_retour = new JButton("RETOUR");
		b_retour.setBackground(new Color(200, 100, 100));
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_retour.setBounds(50, 500, 200, 50);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fen_1 a = new Fen_1();
				dispose();
			}
		});
		p.add(b_retour);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen_2_Gest frame = new Fen_2_Gest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}


