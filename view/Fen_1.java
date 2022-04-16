package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Fen_1 extends JFrame {
	
	private JPanel p = new JPanel();
	
	public Fen_1() {
		
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
				Fen_2_Gest a = new Fen_2_Gest();
				dispose();
			}
		});
		p.add(b_gestion);
		
		// Bouton "Achats"
		
		JButton b_achats = new JButton("ACHATS");
		
		b_achats.setFont(new Font("Arial", Font.BOLD, 55));
		b_achats.setBackground(new Color(205, 92, 92));
		b_achats.setBounds(50, 200, 400, 100);
		b_achats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fen_2_Ach a = new Fen_2_Ach();
				dispose();
			}
		});
		p.add(b_achats);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen_1 frame = new Fen_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
