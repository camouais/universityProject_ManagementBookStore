package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.*;
import controller.*;
public class Fen7_Gest_NewDepense extends JFrame {
	
private static final long serialVersionUID = 1L;
	
	private JPanel p = new JPanel();
	
	public Fen7_Gest_NewDepense(Magasin m) {
		
		setTitle("Cr�ation d'une nouvelle d�pense");
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Labels
		
		JLabel l_main = new JLabel("Ajout d'une nouvelle d\u00E9pense ");
		l_main.setHorizontalAlignment(SwingConstants.CENTER);
		l_main.setFont(new Font("Tahoma", Font.BOLD, 34));
		l_main.setBounds(0, 0, 700, 82);
		p.add(l_main);
		
		JLabel l_description = new JLabel("Description :");
		l_description.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_description.setBounds(30, 100, 200, 30);
		p.add(l_description);
		
		 JLabel l_cout = new JLabel("Co\u00FAt :");
		l_cout.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_cout.setBounds(30, 140, 200, 30);
		p.add(l_cout);
		
		JLabel l_Nemploye = new JLabel("Nom employ\u00E9 :");
		l_Nemploye.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_Nemploye.setBounds(30, 180, 200, 30);
		p.add(l_Nemploye);
		
		JLabel l_Pemploye = new JLabel("Pr\u00E9nom employ\u00E9 :");
		l_Pemploye.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_Pemploye.setBounds(30, 220, 250, 30);
		p.add(l_Pemploye);
		
		JLabel l_Iemploye = new JLabel("Id employ\u00E9 :");
		l_Iemploye.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_Iemploye.setBounds(30, 260, 230, 30);
		p.add(l_Iemploye);
		
		JLabel l_date = new JLabel("Date d\u00E9pense :");
		l_date.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_date.setBounds(30, 301, 230, 30);
		p.add(l_date);
		
		JLabel l_jour = new JLabel("Jour :");
		l_jour.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_jour.setBounds(270, 301, 120, 30);
		p.add(l_jour);
		
		JLabel l_mois = new JLabel("Mois : ");
		l_mois.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_mois.setBounds(400, 301, 120, 30);
		p.add(l_mois);
		
		JLabel l_annee = new JLabel("Ann\u00E9e :");
		l_annee.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_annee.setBounds(530, 301, 120, 30);
		p.add(l_annee);
		
		// TextFields
		
		JTextField t_cout = new JTextField();
		t_cout.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_cout.setBounds(270, 140, 380, 30);
		p.add(t_cout);
		
		JTextField t_Nemploye = new JTextField();
		t_Nemploye.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_Nemploye.setBounds(270, 180, 380, 30);
		p.add(t_Nemploye);
		
		JTextField t_Pemploye = new JTextField();
		t_Pemploye.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_Pemploye.setBounds(270, 220, 380, 30);
		p.add(t_Pemploye);
		
		JTextField t_Iemploye = new JTextField();
		t_Iemploye.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_Iemploye.setBounds(270, 260, 380, 30);
		p.add(t_Iemploye);
		
 		JTextField t_annee = new JTextField();
		t_annee.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_annee.setBounds(530, 342, 120, 30);
		p.add(t_annee);
		
		// ComboBoxes
		
		JComboBox<String> c_description = new JComboBox<String>();
		c_description.setFont(new Font("Tahoma", Font.PLAIN, 20));
		c_description.setModel(new DefaultComboBoxModel<String>(new String[] {"Achat nouveau stock", "Location", "Achat matériel", "Autre"}));
		c_description.setBounds(270, 100, 380, 30);
		p.add(c_description);
		
		JComboBox<String> c_jour = new JComboBox<String>();
		c_jour.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		c_jour.setBounds(270, 342, 120, 30);
		p.add(c_jour);
		
		JComboBox<String> c_mois = new JComboBox<String>();
		c_mois.setModel(new DefaultComboBoxModel<String>(new String[] {"Janvier", "F\u00E9vrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Ao\u00FBt", "Septembre", "Octobre", "Novembre", "D\u00E9cembre"}));
		c_mois.setBounds(400, 342, 120, 30);
		p.add(c_mois);
		
		// Boutons : Effacer, Valider, Retour
		
		JButton b_effacer = new JButton("EFFACER");
		b_effacer.setForeground(Color.BLACK);
		b_effacer.setBackground(Color.LIGHT_GRAY);
		b_effacer.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_effacer.setBounds(739, 502, 207, 64);
		p.add(b_effacer);
		
		JButton b_valider = new JButton("VALIDER");
		b_valider.setBackground(new Color(0, 128, 0));
		b_valider.setForeground(Color.BLACK);
		b_valider.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_valider.setBounds(450, 440, 207, 64);
		b_valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(new NewDepense(m, t_Iemploye, t_Nemploye, t_Pemploye, t_cout, (String) c_description.getSelectedItem(), c_jour, c_mois, t_annee).status == 1) {
					dispose();
				    new Fen6_Gest_Depenses(m);
				}
			}
		});
		p.add(b_valider);
		
		JButton b_retour = new JButton("Retour");
		b_retour.setForeground(Color.BLACK);
		b_retour.setBackground(new Color(255, 215, 0));
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_retour.setBounds(30, 440, 207, 64);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen6_Gest_Depenses(m);
			}
		});
		p.add(b_retour);
	}
}