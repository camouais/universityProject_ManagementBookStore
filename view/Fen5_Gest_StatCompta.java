package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Magasin;

public class Fen5_Gest_StatCompta extends JFrame{
	
	private static final long serialVersionUID = 1L;

	private JPanel p = new JPanel();

	JButton b_recettes = new JButton("RECETTES");
	JButton b_depenses = new JButton("DEPENSES");
	JButton b_retour = new JButton("Retour");
	
	
	public Fen5_Gest_StatCompta(Magasin m) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 465);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setContentPane(p);
		p.setLayout(null);
		
		b_depenses.setBackground(new Color(178, 34, 34));
		b_depenses.setFont(new Font("Tahoma", Font.BOLD, 35));
		b_depenses.setBounds(131, 157, 231, 105);
		b_depenses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen6_Gest_Depenses(m);
			}
		});
		p.add(b_depenses);
		
		b_recettes.setBackground(new Color(135, 206, 235));
		b_recettes.setFont(new Font("Tahoma", Font.BOLD, 35));
		b_recettes.setBounds(387, 157, 231, 105);
		b_recettes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen6_Gest_Recettes(m);
			}
		});
		p.add(b_recettes);
		
		b_retour.setBackground(new Color(200, 100, 100));
		b_retour.setFont(new Font("Tahoma", Font.PLAIN, 20));
		b_retour.setBounds(0, 381, 100, 30);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen4_Gest_MagStat(m);
			}
		});
		p.add(b_retour);
	}
}

