package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.*;

public class Fen3_Gest_Mag extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public Fen3_Gest_Mag(Magasin m) {
		
		JPanel p = new JPanel();
		setTitle("Menu de gestion du magasin");
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 460);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Label
		
		JLabel lblNewLabel = new JLabel("Gestion du magasin");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(0, 0, 484, 80);
		p.add(lblNewLabel);
		
		// Boutons : Informations, Statistiques, Employés, Retour
		
		JButton b_info =  new JButton("Informations");
		b_info.setFont(new Font("Tahoma", Font.BOLD, 35));
		b_info.setBackground(new Color(200, 50, 200));
		b_info.setBounds(67, 90, 350, 70);
		b_info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen4_Gest_MagInfo(m);
			}
		});
		p.add(b_info);
		
		JButton b_stat = new JButton("Statistiques");
		b_stat.setFont(new Font("Tahoma", Font.BOLD, 35));
		b_stat.setBackground(new Color(50, 200, 200));
		b_stat.setBounds(67, 290, 350, 70);
		b_stat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen4_Gest_MagStat(m);
			}
		});
		p.add(b_stat);
		
		JButton b_empl =  new JButton("Employ\u00E9s");
		b_empl.setFont(new Font("Tahoma", Font.BOLD, 35));
		b_empl.setBackground(new Color(200, 200, 50));
		b_empl.setBounds(67, 190, 350, 70);
		b_empl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen4_Gest_MagEmp(m);
			}
		});
		p.add(b_empl);
		
		JButton b_retour = new JButton("Retour");
		b_retour.setBackground(new Color(200, 100, 100));
		b_retour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b_retour.setBounds(0, 391, 100, 30);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen2_Gest(m);
			}
		});
		p.add(b_retour);
		
	}
}