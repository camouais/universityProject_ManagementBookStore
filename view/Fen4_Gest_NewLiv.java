package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.*;

public class Fen4_Gest_NewLiv extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane = new JPanel();
	private JTextField t_titre;
	private JTextField t_auteur;
	private JTextField t_editeur;
	private JTextField t_prix;
	private JTextField t_resume;
	private JTextField t_categorie;
	private JTextField t_format;
	private JTextField t_langueVO;
	private JTextField t_dateP;


	JButton b_effacer = new JButton("EFFACER");
	JButton b_valider = new JButton("VALIDER");
	JButton b_retour = new JButton("RETOUR");
	
	public Fen4_Gest_NewLiv(Magasin m) {
		contentPane.setBackground(new Color(200, 200, 200));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 719);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		
		// JLabel "Renseignements du nouveau livre"
		
		JLabel l_rens = new JLabel("Renseignements du nouveau livre");
		l_rens.setHorizontalAlignment(SwingConstants.CENTER);
		l_rens.setFont(new Font("Tahoma", Font.PLAIN, 40));
		l_rens.setBounds(35, 37, 774, 65);
		contentPane.add(l_rens);
		
		// JLabel & JTextfield "Titre"
		
		JLabel l_titre = new JLabel("Titre :");
		l_titre.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_titre.setBounds(35, 128, 190, 31);
		contentPane.add(l_titre);
		
		t_titre = new JTextField();
		t_titre.setBounds(35, 159, 319, 31);
		contentPane.add(t_titre);
		t_titre.setColumns(10);
		
		// JLabel & JTextfield "Auteur"
		
		JLabel l_auteur = new JLabel("Auteur :");
		l_auteur.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_auteur.setBounds(35, 201, 190, 31);
		contentPane.add(l_auteur);
		
		t_auteur = new JTextField();
		t_auteur.setColumns(10);
		t_auteur.setBounds(35, 231, 319, 31);
		contentPane.add(t_auteur);

		// JLabel & JTextfield "Editeur"
				
		JLabel l_editeur = new JLabel("Editeur :");
		l_editeur.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_editeur.setBounds(35, 273, 190, 31);
		contentPane.add(l_editeur);
		
		t_editeur = new JTextField();
		t_editeur.setColumns(10);
		t_editeur.setBounds(35, 303, 319, 31);
		contentPane.add(t_editeur);
		
		// JLabel & JTextfield "Prix"
		
		JLabel l_prix = new JLabel("Prix : ");
		l_prix.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_prix.setBounds(35, 340, 190, 31);
		contentPane.add(l_prix);
		
		t_prix = new JTextField();
		t_prix.setColumns(10);
		t_prix.setBounds(35, 372, 319, 31);
		contentPane.add(t_prix);
		
		// JLabel & JTextfield "Résumé"
		
		JLabel l_resume = new JLabel("Résumé : ");
		l_resume.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_resume.setBounds(35, 410, 190, 31);
		contentPane.add(l_resume);
		
		t_resume = new JTextField();
		t_resume.setColumns(10);
		t_resume.setBounds(35, 440, 774, 139);
		contentPane.add(t_resume);
		
		// JLabel & JTextfield "Catégorie"
		
		JLabel l_categorie = new JLabel("Catégorie : ");
		l_categorie.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_categorie.setBounds(490, 128, 190, 31);
		contentPane.add(l_categorie);
		
		t_categorie = new JTextField();
		t_categorie.setColumns(10);
		t_categorie.setBounds(490, 159, 319, 31);
		contentPane.add(t_categorie);
		
		// JLabel & JTextfield "Format"
		
		JLabel l_format = new JLabel("Format : ");
		l_format.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_format.setBounds(490, 201, 190, 31);
		contentPane.add(l_format);
		
		t_format = new JTextField();
		t_format.setColumns(10);
		t_format.setBounds(490, 231, 319, 31);
		contentPane.add(t_format);
		
		// JLabel & JTextfield "Langue originale"
		
		JLabel l_langueVO = new JLabel("Lange originale :");
		l_langueVO.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_langueVO.setBounds(490, 273, 319, 31);
		contentPane.add(l_langueVO);
		
		t_langueVO = new JTextField();
		t_langueVO.setColumns(10);
		t_langueVO.setBounds(490, 303, 319, 31);
		contentPane.add(t_langueVO);
		
		// JLabel & JTextfield "Date de parution"
		
		JLabel l_dateP = new JLabel("Date de parution : ");
		l_dateP.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_dateP.setBounds(490, 340, 319, 31);
		contentPane.add(l_dateP);
		
		t_dateP = new JTextField();
		t_dateP.setColumns(10);
		t_dateP.setBounds(490, 372, 319, 31);
		contentPane.add(t_dateP);
		
		// Bouton retour 
		
		JButton b_retour = new JButton("Retour");
		b_retour.setBackground(new Color(255, 215, 0));
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_retour.setBounds(30, 610, 207, 64);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Fen3_Gest_Liv(m);
				dispose();
			}
		});
		contentPane.add(b_retour);
		
		// Bouton enregistrer
		
		JButton b_enregistrer = new JButton("Enregistrer ");
		b_enregistrer.setBackground(new Color(255, 215, 0));
		b_enregistrer.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_enregistrer.setBackground(new Color(30, 144, 255));
		b_enregistrer.setBounds(574, 610, 235, 64);
		b_enregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Fen3_Gest_Liv(m);
				dispose();
			}
		});
		contentPane.add(b_enregistrer);
	}
}
