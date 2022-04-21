package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.*;

public class Fen3_Gest_Mag extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel p = new JPanel();
	
	JButton b_stat = new JButton("STATISTIQUES");
	JButton b_info =  new JButton("INFORMATIONS");
	JButton b_empl =  new JButton("EMPLOYES");
	JButton b_retour = new JButton("RETOUR");
	
	public Fen3_Gest_Mag(Magasin m) {
		
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 650);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Boutons : Informations, Statistiques, EmployÃ©s, Retour
		
		b_info.setFont(new Font("Tahoma", Font.BOLD, 55));
		b_info.setBackground(new Color(200, 50, 200));
		b_info.setBounds(50, 50, 500, 100);
		b_info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Fen4_Gest_MagInfo(m);
				dispose();
			}
		});
		p.add(b_info);
		
		b_stat.setFont(new Font("Tahoma", Font.BOLD, 55));
		b_stat.setBackground(new Color(50, 200, 200));
		b_stat.setBounds(50, 350, 500, 100);
		b_stat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Fen4_Gest_MagStat(m);
				dispose();
			}
		});
		p.add(b_stat);
		
		b_empl.setFont(new Font("Tahoma", Font.BOLD, 55));
		b_empl.setBackground(new Color(200, 200, 50));
		b_empl.setBounds(50, 200, 500, 100);
		b_empl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Fen4_Gest_MagEmp(m);
				dispose();
			}
		});
		p.add(b_empl);
		
		b_retour.setBackground(new Color(200, 100, 100));
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_retour.setBounds(50, 500, 200, 50);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Fen2_Gest(m);
				dispose();
			}
		});
		p.add(b_retour);
	}
}
