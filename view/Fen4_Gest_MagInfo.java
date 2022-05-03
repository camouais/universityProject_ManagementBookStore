package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.*;
import controller.*;

public class Fen4_Gest_MagInfo extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel p = new JPanel();
	private JTextField t_nom = new JTextField();
	private JTextField t_adresse = new JTextField();
	private JPasswordField t_mdp;
	private JTextField t_site;
	private JTextField t_tel;
	private JTextField t_datec;
	private JTextField t_annee;
	
	JComboBox c_jour = new JComboBox();
	JComboBox c_mois = new JComboBox();

	public Fen4_Gest_MagInfo(Magasin m) {
		
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Labels : Informations du Magasin, Nom, Adresse
		
		JLabel l = new JLabel("Informations du magasin");
		l.setHorizontalAlignment(SwingConstants.CENTER);
		l.setFont(new Font("Tahoma", Font.BOLD, 40));
		l.setBounds(0, 0, 550, 82);
		p.add(l);
		
		JLabel l_nom = new JLabel("Nom :");
		l_nom.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_nom.setBounds(20, 100, 150, 30);
		p.add(l_nom);
		
		JLabel l_adresse = new JLabel("Adresse :");
		l_adresse.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_adresse.setBounds(20, 140, 150, 30);
		p.add(l_adresse);
		
		// Text Field : Nom, Adresse
		
		t_nom.setBounds(200, 100, 330, 30);
		t_nom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_nom.setColumns(10);
		t_nom.setText(m.getNom());
		p.add(t_nom);
		
		t_adresse.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_adresse.setColumns(10);
		t_adresse.setBounds(200, 140, 330, 30);
		p.add(t_adresse);
		
		// Boutons : Retour, Enregistrer
		
		JButton b_retour = new JButton("RETOUR");
		b_retour.setBackground(new Color(255, 215, 0));
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_retour.setBounds(50, 400, 150, 50);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen3_Gest_Mag(m);
			}
		});
		p.add(b_retour);
		
		JButton b_enreg = new JButton("ENREGISTRER");
		b_enreg.setBackground(new Color(0, 128, 0));
		b_enreg.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_enreg.setBounds(300, 400, 200, 50);
		b_enreg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new Modif_InfoMag(m,t_nom, t_adresse, t_mdp, t_site, t_tel, c_jour, c_mois, t_annee);
            	JFrame a = new JFrame();
    		    JOptionPane.showMessageDialog(a, "Changements enregistr�s.", "Succ�s", 1);
            }
        });
		p.add(b_enreg);
		
		JLabel l_mdp = new JLabel("Mot de passe :");
		l_mdp.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_mdp.setBounds(20, 180, 150, 30);
		p.add(l_mdp);
		
		t_mdp = new JPasswordField();
		t_mdp.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_mdp.setColumns(10);
		t_mdp.setBounds(200, 180, 330, 30);
		p.add(t_mdp);
		
		JLabel l_site = new JLabel("Lien site web :");
		l_site.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_site.setBounds(20, 220, 150, 30);
		p.add(l_site);
		
		t_site = new JTextField();
		t_site.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_site.setColumns(10);
		t_site.setBounds(200, 220, 330, 30);
		p.add(t_site);
		
		JLabel l_tel = new JLabel("T\u00E9l\u00E9phone :");
		l_tel.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_tel.setBounds(20, 260, 150, 30);
		p.add(l_tel);
		
		t_tel = new JTextField();
		t_tel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_tel.setColumns(10);
		t_tel.setBounds(200, 260, 330, 30);
		p.add(t_tel);
		
		JLabel l_datec = new JLabel("Date cr\u00E9ation :");
		l_datec.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_datec.setBounds(20, 300, 150, 30);
		p.add(l_datec);
		
		t_datec.setEditable(false);
		t_datec.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_datec.setColumns(10);
		t_datec.setBounds(200, 300, 330, 30);
		p.add(t_datec);
		
		JLabel l_jour = new JLabel("Jour :");
		l_jour.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_jour.setBounds(200, 300, 100, 30);
		p.add(l_jour);
		
		JLabel l_mois = new JLabel("Mois :");
		l_mois.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_mois.setBounds(310, 300, 100, 30);
		p.add(l_mois);
		
		JLabel l_annee = new JLabel("Ann\u00E9e :");
		l_annee.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_annee.setBounds(420, 301, 100, 30);
		p.add(l_annee);
		
		t_annee = new JTextField();
		t_annee.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_annee.setColumns(10);
		t_annee.setBounds(420, 341, 100, 30);
		p.add(t_annee);
		
		c_jour.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		c_jour.setBounds(200, 341, 100, 30);
		p.add(c_jour);
		
		c_mois.setModel(new DefaultComboBoxModel(new String[] {"Janvier", "F\u00E9vrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Ao\u00FBt", "Septembre", "Octobre", "Novembre", "D\u00E9cembre"}));
		c_mois.setBounds(310, 341, 100, 30);
		p.add(c_mois);
	}
}