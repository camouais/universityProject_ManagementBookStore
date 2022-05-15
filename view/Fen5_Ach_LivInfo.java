package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.*;

public class Fen5_Ach_LivInfo extends JFrame {

	private static final long serialVersionUID = 1L;

	public Fen5_Ach_LivInfo(Magasin m, Livre l, Client c) {
		
		// Fenêtre
		
		JPanel p = new JPanel();
		setTitle("Information du livre s\u00E9lectionn\u00E9");
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setBounds(100, 100, 600, 450);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
				
		// Labels
				
		JLabel l_rens = new JLabel("Informations du livre");
		l_rens.setHorizontalAlignment(SwingConstants.CENTER);
		l_rens.setFont(new Font("Tahoma", Font.BOLD, 34));
		l_rens.setBounds(0, 0, 584, 82);
		p.add(l_rens);
				
		JLabel l_id = new JLabel("Identifiant :");
		l_id.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_id.setBounds(20, 100, 150, 30);
		p.add(l_id);
				
		JLabel l_titre = new JLabel("Titre :");
		l_titre.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_titre.setBounds(20, 140, 150, 30);
		p.add(l_titre);
				
		JLabel l_auteur = new JLabel("Auteur :");
		l_auteur.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_auteur.setBounds(20, 180, 150, 30);
		p.add(l_auteur);
				
		JLabel l_editeur = new JLabel("Editeur : ");
		l_editeur.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_editeur.setBounds(20, 220, 150, 30);
		p.add(l_editeur);
				
		JLabel l_categorie = new JLabel("Cat\u00E9gorie : ");
		l_categorie.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_categorie.setBounds(20, 260, 150, 30);
		p.add(l_categorie);
				
		JLabel l_prix = new JLabel("Prix : ");
		l_prix.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_prix.setBounds(20, 300, 150, 30);
		p.add(l_prix);
				
		JLabel l_stock = new JLabel("Stock :");
		l_stock.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_stock.setBounds(20, 341, 150, 30);
		p.add(l_stock);
				
		// TextFields
				
		JTextField t_id;
		t_id = new JTextField();
		t_id.setEditable(false);
		t_id.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_id.setColumns(10);
		t_id.setText(String.valueOf(l.getId()));
		t_id.setBounds(150, 100, 414, 30);
		p.add(t_id);
				
		JTextField t_titre;
		t_titre = new JTextField();
		t_titre.setEditable(false);
		t_titre.setBounds(150, 140, 414, 30);
		t_titre.setText(l.getTitre());
		t_titre.setFont(new Font("Tahoma", Font.PLAIN, 25));
		p.add(t_titre);
		t_titre.setColumns(10);
				
		JTextField t_auteur;
		t_auteur = new JTextField();
		t_auteur.setEditable(false);
		t_auteur.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_auteur.setColumns(10);
		t_auteur.setText(l.getAuteur());
		t_auteur.setBounds(150, 180, 414, 30);
		p.add(t_auteur);
				
		JTextField t_editeur;
		t_editeur = new JTextField();
		t_editeur.setEditable(false);
		t_editeur.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_editeur.setColumns(10);
		t_editeur.setText(l.getEditeur());
		t_editeur.setBounds(150, 220, 414, 30);
		p.add(t_editeur);
				
		JTextField t_categorie;
		t_categorie = new JTextField();
		t_categorie.setEditable(false);
		t_categorie.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_categorie.setColumns(10);
		t_categorie.setText(l.getCategorie());
		t_categorie.setBounds(150, 260, 414, 30);
		p.add(t_categorie);
				
		JTextField t_prix;
		t_prix = new JTextField();
		t_prix.setEditable(false);
		t_prix.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_prix.setColumns(10);
		t_prix.setText(String.valueOf(l.getPrix()));
		t_prix.setBounds(150, 300, 414, 30);
		p.add(t_prix);
				
		JTextField t_stock = new JTextField();
		t_stock.setEditable(false);
		t_stock.setText(String.valueOf(l.getStock()));
		t_stock.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_stock.setColumns(10);
		t_stock.setBounds(150, 341, 414, 30);
		p.add(t_stock);
				
		// Boutons
				
		JButton b_retour = new JButton("Retour");
		b_retour.setBackground(new Color(200, 100, 100));
		b_retour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b_retour.setBounds(0, 381, 100, 30);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		p.add(b_retour);
	}
}