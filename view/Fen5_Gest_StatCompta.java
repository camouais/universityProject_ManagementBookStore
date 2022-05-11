package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.*;

public class Fen5_Gest_StatCompta extends JFrame{
	
	private static final long serialVersionUID = 1L;

	private JPanel p = new JPanel();

	JButton b_recettes = new JButton("Recettes");
	JButton b_depenses = new JButton("D\u00E9penses");
	JButton b_retour = new JButton("Retour");
	private final JLabel lblNewLabel = new JLabel("Comptabilit\u00E9s");
	
	
	public Fen5_Gest_StatCompta(Magasin m) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 260);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		p.setBackground(Color.LIGHT_GRAY);
		setContentPane(p);
		p.setLayout(null);
		
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
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 484, 70);
		
		p.add(lblNewLabel);
	}
}
