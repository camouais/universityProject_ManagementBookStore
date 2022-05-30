package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import model.Magasin;

public class Fen6_Gest_Recettes extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public Fen6_Gest_Recettes(Magasin m) {
		
		// Fenêtre
		
		JPanel p = new JPanel();
		Toolkit tk = Toolkit.getDefaultToolkit();  
        Image img = tk.getImage("src/resources/logo.png");
		setIconImage(img);
		setTitle("Aper\u00E7u des recettes");
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		p.setBackground(new Color(100, 131, 236));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 900, 450);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 128), null, null, null));
		panel1.setBounds(62, 100, 226, 116);
		p.add(panel1);
		panel1.setLayout(null);
		
		JLabel l_totalVentes = new JLabel("Prix total des ventes");
		l_totalVentes.setHorizontalAlignment(SwingConstants.CENTER);
		l_totalVentes.setFont(new Font("Tahoma", Font.PLAIN, 19));
		l_totalVentes.setBounds(10, 11, 206, 40);
		panel1.add(l_totalVentes);
		
		JLabel l_valeur_totalVentes = new JLabel("Error");
		l_valeur_totalVentes.setHorizontalAlignment(SwingConstants.CENTER);
		l_valeur_totalVentes.setFont(new Font("Tahoma", Font.PLAIN, 30));
		l_valeur_totalVentes.setText(String.valueOf(m.getPrixTotalCom(m)) + " \u20AC");
		l_valeur_totalVentes.setBounds(0, 62, 226, 43);
		
		panel1.add(l_valeur_totalVentes);
		
		JPanel panel2 = new JPanel();
		panel2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 128), null, null, null));
		panel2.setBounds(331, 100, 226, 116);
		p.add(panel2);
		panel2.setLayout(null);
		
		JLabel l_totalDepenses = new JLabel("Prix total des d\u00E9penses");
		l_totalDepenses.setHorizontalAlignment(SwingConstants.CENTER);
		l_totalDepenses.setFont(new Font("Tahoma", Font.PLAIN, 19));
		l_totalDepenses.setBounds(10, 11, 206, 40);
		panel2.add(l_totalDepenses);
		
		JLabel l_valeur_totalDepenses = new JLabel("Error");
		l_valeur_totalDepenses.setHorizontalAlignment(SwingConstants.CENTER);
		l_valeur_totalDepenses.setFont(new Font("Tahoma", Font.PLAIN, 30));
		l_valeur_totalDepenses.setBounds(0, 62, 226, 43);
		l_valeur_totalDepenses.setText(String.valueOf(m.getAllDepenses(m)) + " \u20AC");
		panel2.add(l_valeur_totalDepenses);
		
		JPanel panel3 = new JPanel();
		panel3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 128), null, null, null));
		panel3.setBounds(593, 100, 226, 116);
		p.add(panel3);
		panel3.setLayout(null);
		
		JLabel l_sommeSalaires = new JLabel("Sommes des salaires ");
		l_sommeSalaires.setHorizontalAlignment(SwingConstants.CENTER);
		l_sommeSalaires.setFont(new Font("Tahoma", Font.PLAIN, 19));
		l_sommeSalaires.setBounds(10, 11, 206, 40);
		panel3.add(l_sommeSalaires);
		
		JLabel l_valeur_sommeSalaires = new JLabel("Error");
		l_valeur_sommeSalaires.setHorizontalAlignment(SwingConstants.CENTER);
		l_valeur_sommeSalaires.setFont(new Font("Tahoma", Font.PLAIN, 30));
		l_valeur_sommeSalaires.setBounds(0, 62, 226, 43);
		l_valeur_sommeSalaires.setText(String.valueOf(m.getSomSalaire(m)) + " \u20AC");
		panel3.add(l_valeur_sommeSalaires);
		
		JPanel panel4 = new JPanel();
		panel4.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), null, null, null));
		panel4.setBounds(145, 250, 587, 116);
		p.add(panel4);
		panel4.setLayout(null);
		
		JLabel l_recette = new JLabel("Recette :");
		l_recette.setHorizontalAlignment(SwingConstants.CENTER);
		l_recette.setFont(new Font("Tahoma", Font.PLAIN, 40));
		l_recette.setBounds(33, 31, 296, 58);
		panel4.add(l_recette);
		
		JLabel l_valeur_recette = new JLabel("Error");
		l_valeur_recette.setHorizontalAlignment(SwingConstants.LEFT);
		l_valeur_recette.setFont(new Font("Tahoma", Font.PLAIN, 40));
		l_valeur_recette.setBounds(321, 39, 266, 43);
		l_valeur_recette.setText(String.valueOf((m.getAllVentes(m))-((m.getAllDepenses(m))+(m.getSomSalaire(m)))) + " \u20AC");
		panel4.add(l_valeur_recette);
		
		JLabel l_compta = new JLabel("Comptabilités");
		l_compta.setHorizontalAlignment(SwingConstants.CENTER);
		l_compta.setFont(new Font("Tahoma", Font.BOLD, 40));
		l_compta.setBounds(0, 20, 884, 58);
		p.add(l_compta);
		
		JButton b_retour = new JButton("Retour");
		b_retour.setBackground(new Color(200, 100, 100));
		b_retour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b_retour.setBounds(0, 381, 100, 30);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen5_Gest_StatCompta(m);
			}
		});
		p.add(b_retour);
	}
}