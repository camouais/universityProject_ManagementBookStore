package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.BevelBorder;

import model.Magasin;

public class Fen6_Gest_Recettes extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel l_compta = new JLabel("Comptabilit\u00E9");
	private JLabel l_totalVentes = new JLabel("Prix total des ventes");
	private JLabel l_valeur_totalVentes = new JLabel("Error");
	private JLabel l_totalDepenses = new JLabel("Prix total des d\u00E9penses");
	private JLabel l_valeur_totalDepenses = new JLabel("Error");
	private JLabel l_sommeSalaires = new JLabel("Sommes des salaires ");
	private JLabel l_valeur_sommeSalaires = new JLabel("Error");
	private JLabel l_recette = new JLabel("Recette :");
	private JLabel l_valeur_recette = new JLabel("Error");
	
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	
	private JButton b_retour = new JButton("Retour");
	private JPanel p ;
	
	public Fen6_Gest_Recettes(Magasin m) {
		p = new JPanel();
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		p.setBackground(new Color(100, 131, 236));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 900, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		panel1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 128), null, null, null));
		panel1.setBounds(62, 126, 226, 116);
		p.add(panel1);
		panel1.setLayout(null);
		
		l_totalVentes.setHorizontalAlignment(SwingConstants.CENTER);
		l_totalVentes.setFont(new Font("Tahoma", Font.PLAIN, 19));
		l_totalVentes.setBounds(10, 11, 206, 40);
		panel1.add(l_totalVentes);
		
		l_valeur_totalVentes.setHorizontalAlignment(SwingConstants.CENTER);
		l_valeur_totalVentes.setFont(new Font("Tahoma", Font.PLAIN, 30));
		l_valeur_totalVentes.setText(String.valueOf(m.getPrixTotalCom(m)));
		l_valeur_totalVentes.setBounds(52, 62, 115, 43);
		
		panel1.add(l_valeur_totalVentes);
		
		panel2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 128), null, null, null));
		panel2.setBounds(331, 126, 226, 116);
		p.add(panel2);
		panel2.setLayout(null);
		
		l_totalDepenses.setHorizontalAlignment(SwingConstants.CENTER);
		l_totalDepenses.setFont(new Font("Tahoma", Font.PLAIN, 19));
		l_totalDepenses.setBounds(10, 11, 206, 40);
		panel2.add(l_totalDepenses);
		
		l_valeur_totalDepenses.setHorizontalAlignment(SwingConstants.CENTER);
		l_valeur_totalDepenses.setFont(new Font("Tahoma", Font.PLAIN, 30));
		l_valeur_totalDepenses.setBounds(64, 62, 115, 43);
		l_valeur_totalDepenses.setText(String.valueOf(m.getAllDepenses(m)));
		panel2.add(l_valeur_totalDepenses);
		
		panel3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 128), null, null, null));
		panel3.setBounds(593, 126, 226, 116);
		p.add(panel3);
		panel3.setLayout(null);
		
		l_sommeSalaires.setHorizontalAlignment(SwingConstants.CENTER);
		l_sommeSalaires.setFont(new Font("Tahoma", Font.PLAIN, 19));
		l_sommeSalaires.setBounds(10, 11, 206, 40);
		panel3.add(l_sommeSalaires);
		
		l_valeur_sommeSalaires.setHorizontalAlignment(SwingConstants.CENTER);
		l_valeur_sommeSalaires.setFont(new Font("Tahoma", Font.PLAIN, 30));
		l_valeur_sommeSalaires.setBounds(64, 62, 115, 43);
		l_valeur_sommeSalaires.setText(String.valueOf(m.getSomSalaire(m)));
		panel3.add(l_valeur_sommeSalaires);
		
		panel4.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), null, null, null));
		panel4.setBounds(145, 301, 587, 116);
		p.add(panel4);
		panel4.setLayout(null);
		
		l_recette.setHorizontalAlignment(SwingConstants.CENTER);
		l_recette.setFont(new Font("Tahoma", Font.PLAIN, 40));
		l_recette.setBounds(33, 31, 296, 58);
		panel4.add(l_recette);
		
		l_valeur_recette.setHorizontalAlignment(SwingConstants.CENTER);
		l_valeur_recette.setFont(new Font("Tahoma", Font.PLAIN, 40));
		l_valeur_recette.setBounds(321, 39, 206, 43);
		l_valeur_recette.setText(String.valueOf((m.getAllVentes(m))-((m.getAllDepenses(m))+(m.getSomSalaire(m)))));
		panel4.add(l_valeur_recette);
		
		l_compta.setHorizontalAlignment(SwingConstants.CENTER);
		l_compta.setFont(new Font("Tahoma", Font.PLAIN, 47));
		l_compta.setBounds(130, 39, 613, 58);
		p.add(l_compta);
		
		b_retour.setBackground(Color.ORANGE);
		b_retour.setFont(new Font("Tahoma", Font.PLAIN, 34));
		b_retour.setBounds(707, 451, 167, 49);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen5_Gest_StatCompta(m);
			}
		});
		p.add(b_retour);
	}
	
}
