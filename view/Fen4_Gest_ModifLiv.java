package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controller.Modif_InfoClient;
import controller.Modif_InfoLivre;
import model.*;

public class Fen4_Gest_ModifLiv extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel p = new JPanel();
	private JTextField t_titre;
	private JTextField t_auteur;
	private JTextField t_editeur;
	private JTextField t_id;
	private JTextField t_prix;
	private JTextField t_categorie;
	private JLabel l_rens = new JLabel("Renseignements du livre");
	private JLabel l_titre = new JLabel("Titre :");
	private JLabel l_auteur = new JLabel("Auteur :");
	private JLabel l_id = new JLabel("Identifiant :");
	private JLabel l_editeur = new JLabel("Editeur : ");
	private JLabel l_categorie = new JLabel("Cat\u00E9gorie : ");
	private JLabel l_prix = new JLabel("Prix : ");
	
	JButton b_retour = new JButton("RETOUR");
	JButton b_effacer = new JButton("EFFACER");
	JButton b_enreg = new JButton("ENREGISTRER");
	private final JLabel l_stock = new JLabel("Stock :");
	private final JTextField t_stock = new JTextField();

	public Fen4_Gest_ModifLiv(Magasin m, Livre l) {
		
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// JLabel : Renseignements du livre
		
		l_rens.setHorizontalAlignment(SwingConstants.CENTER);
		l_rens.setFont(new Font("Tahoma", Font.BOLD, 34));
		l_rens.setBounds(0, 0, 550, 82); //définit la taille et la position (x, y, largeur, hauteur)
		p.add(l_rens);
		
		// JLabel & JTextField : Titre
		
		l_titre.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_titre.setBounds(20, 100, 150, 30);
		p.add(l_titre);
		
		t_titre = new JTextField();
		t_titre.setBounds(150, 100, 380, 30);
		t_titre.setText(l.getTitre());
		t_titre.setFont(new Font("Tahoma", Font.PLAIN, 25));
		p.add(t_titre);
		t_titre.setColumns(10);
		
		// JLabel & JTextField : Auteur
		
		l_auteur.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_auteur.setBounds(20, 140, 150, 30);
		p.add(l_auteur);
		
		t_auteur = new JTextField();
		t_auteur.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_auteur.setColumns(10);
		t_auteur.setText(l.getAuteur());
		t_auteur.setBounds(150, 140, 380, 30);
		p.add(t_auteur);
		
		// JLabel & JTextField : Identifiant
		
		l_id.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_id.setBounds(20, 180, 150, 30);
		p.add(l_id);
		
		t_id = new JTextField();
		t_id.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_id.setColumns(10);
		t_id.setText(String.valueOf(l.getId()));
		t_id.setBounds(150, 180, 380, 30);
		p.add(t_id);
		
		// JLabel & JTextField : Editeur
		
		l_editeur.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_editeur.setBounds(20, 220, 150, 30);
		p.add(l_editeur);
		
		t_editeur = new JTextField();
		t_editeur.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_editeur.setColumns(10);
		t_editeur.setText(l.getEditeur());
		t_editeur.setBounds(150, 220, 380, 30);
		p.add(t_editeur);
		
		// JLabel & JTextfield : Categorie
		
		l_categorie.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_categorie.setBounds(20, 260, 150, 30);
		p.add(l_categorie);
		
		t_categorie = new JTextField();
		t_categorie.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_categorie.setColumns(10);
		t_categorie.setText(l.getCategorie());
		t_categorie.setBounds(150, 260, 380, 30);
		p.add(t_categorie);
		
		// JLabel & JTextfield : Prix
		
		l_prix.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_prix.setBounds(20, 300, 150, 30);
		p.add(l_prix);
				
		t_prix = new JTextField();
		t_prix.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_prix.setColumns(10);
		t_prix.setText(String.valueOf(l.getPrix()));
		t_prix.setBounds(150, 300, 380, 30);
		p.add(t_prix);
		
		// JLabel & JTextField : Stock
		
		l_stock.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_stock.setBounds(20, 341, 150, 30);
		p.add(l_stock);
		
		t_stock.setText(String.valueOf(l.getStock()));
		t_stock.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_stock.setColumns(10);
		t_stock.setBounds(150, 341, 380, 30);
		
		p.add(t_stock);
		
		// Boutons : Retour, Effacer, Enregistrer
		
		b_retour.setBackground(new Color(255, 215, 0));
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_retour.setBounds(10, 400, 150, 50);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen3_Gest_Liv(m);
			}
		});
		p.add(b_retour);
		
		b_effacer.setForeground(Color.WHITE);
		b_effacer.setBackground(new Color(0, 0, 0));
		b_effacer.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_effacer.setBounds(180, 400, 150, 50);
		b_effacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.supLivre(l);
				dispose();
				new Fen3_Gest_Liv(m);
			}
		});
		p.add(b_effacer);
		
		b_enreg.setBackground(new Color(0, 128, 0));
		b_enreg.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_enreg.setBounds(350, 400, 200, 50);
		b_enreg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Modif_InfoLivre(m, l, t_titre, t_auteur, t_editeur, t_prix, t_categorie, t_stock);
			}
		});
		p.add(b_enreg);
	}
}
