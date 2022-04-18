package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fen4_Gest_MagInfo extends JFrame {
	private JPanel p = new JPanel();
	private JTextField t_nom;
	private JTextField t_adresse;

	public Fen4_Gest_MagInfo() {
		
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 320);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		//JLabel Informations du Magasin
		
		JLabel l_info = new JLabel("Informations du magasin");
		l_info.setHorizontalAlignment(SwingConstants.CENTER);
		l_info.setFont(new Font("Tahoma", Font.BOLD, 40));
		l_info.setBounds(0, 0, 550, 82); //définit la taille et la position (x, y, largeur, hauteur)
		p.add(l_info);
		
		
		//JLabel & JTextField nom
		
		JLabel l_nom = new JLabel("Nom :");
		l_nom.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_nom.setBounds(20, 100, 150, 30);
		p.add(l_nom);
		
		t_nom = new JTextField();
		t_nom.setBounds(150, 100, 380, 30);
		t_nom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		p.add(t_nom);
		t_nom.setColumns(10);

		//JLabel & JTextField Adresse
		
		JLabel l_adresse = new JLabel("Adresse :");
		l_adresse.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_adresse.setBounds(20, 140, 150, 30);
		p.add(l_adresse);
		
		t_adresse = new JTextField();
		t_adresse.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_adresse.setColumns(10);
		t_adresse.setBounds(150, 141, 380, 30);
		p.add(t_adresse);
		
		//Bouton Retour
		
		JButton b_retour = new JButton("RETOUR");
		b_retour.setBackground(new Color(255, 215, 0));
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_retour.setBounds(50, 200, 150, 50);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fen3_Gest_Mag a = new Fen3_Gest_Mag();
				dispose();
			}
		});
		p.add(b_retour);
		
		//Bouton Enregistrer
		
		JButton b_valider = new JButton("ENREGISTRER");
		b_valider.setBackground(new Color(0, 128, 0));
		b_valider.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_valider.setBounds(300, 200, 200, 50);
		b_valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fen3_Gest_Mag a = new Fen3_Gest_Mag();
				dispose();
			}
		});
		p.add(b_valider);
		
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen4_Gest_MagInfo frame = new Fen4_Gest_MagInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
