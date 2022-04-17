package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fen2_Ach extends JFrame {

	private JPanel p = new JPanel();

	public Fen2_Ach() {
		
		// Fenêtre
		
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		setLocationRelativeTo(null);
		setResizable(false);
	    setVisible(true);
	    
		// JLabel Nouveau client ?
		
		JLabel lblNewLabel = new JLabel("Nouveau client ?");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 60));
		lblNewLabel.setBounds(0, 11, 484, 80);
		p.add(lblNewLabel);
		
		// Bouton "Oui"
		
		JButton b_oui = new JButton("Oui");
		b_oui.setBackground(new Color(0, 128, 0));
		b_oui.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_oui.setBounds(50, 100, 150, 56);
		b_oui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fen3_Ach_NewC a = new Fen3_Ach_NewC();
				dispose();
			}
		});
		p.add(b_oui);
		
		// Bouton "Non"
		
		JButton b_non = new JButton("Non");
		b_non.setBackground(new Color(255, 0, 0));
		b_non.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_non.setBounds(284, 100, 150, 56);
		b_non.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fen3_Ach_ExistC a = new Fen3_Ach_ExistC();
				dispose();
			}
		});
		p.add(b_non);
		
		// Bouton "Retour"
		
		JButton b_retour = new JButton("RETOUR");
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_retour.setBackground(new Color(200, 100, 100));
		b_retour.setBounds(165, 180, 150, 50);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fen1 a = new Fen1();
				dispose();
			}
		});
		p.add(b_retour);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen2_Ach f = new Fen2_Ach();
					f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
