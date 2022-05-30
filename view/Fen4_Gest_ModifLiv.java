package view;

import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

import controller.Modif_InfoLivre;
import model.*;

public class Fen4_Gest_ModifLiv extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public Fen4_Gest_ModifLiv(Magasin m, Livre l) {
		
		// Fenêtre
		
		JPanel p = new JPanel();
		Toolkit tk = Toolkit.getDefaultToolkit();  
        Image img = tk.getImage("src/resources/logo.png");
		setIconImage(img);
		setTitle("Modification du livre sélectionné");
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 530);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Labels
		
		JLabel l_rens = new JLabel("Renseignements du livre");
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
		
		JTextField t_id = new JTextField(String.valueOf(l.getId()));
		t_id.setEditable(false);
		t_id.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_id.setBounds(150, 100, 414, 30);
		p.add(t_id);
		
		JTextField t_titre = new JTextField(l.getTitre());
		t_titre.setBounds(150, 140, 414, 30);
		t_titre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		p.add(t_titre);
		
		JTextField t_auteur = new JTextField(l.getAuteur());
		t_auteur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_auteur.setBounds(150, 180, 414, 30);
		p.add(t_auteur);
		
		JTextField t_editeur = new JTextField(l.getEditeur());
		t_editeur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_editeur.setBounds(150, 220, 414, 30);
		p.add(t_editeur);
		
		JTextField t_categorie = new JTextField(l.getCategorie());
		t_categorie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_categorie.setBounds(150, 260, 414, 30);
		p.add(t_categorie);
		
		JTextField t_prix = new JTextField(String.valueOf(l.getPrix()));
		t_prix.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_prix.setBounds(150, 300, 414, 30);
		p.add(t_prix);
		
		JTextField t_stock = new JTextField(String.valueOf(l.getStock()));
		t_stock.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_stock.setBounds(150, 341, 414, 30);
		p.add(t_stock);
		
		// Boutons
		
		JButton b_retour = new JButton("Retour");
		b_retour.setBackground(new Color(200, 100, 100));
		b_retour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b_retour.setBounds(0, 461, 100, 30);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen3_Gest_Liv(m);
			}
		});
		p.add(b_retour);
		
		JButton b_effacer = new JButton("EFFACER");
		b_effacer.setForeground(Color.WHITE);
		b_effacer.setBackground(new Color(0, 0, 0));
		b_effacer.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_effacer.setBounds(60, 400, 150, 50);
		b_effacer.setToolTipText("Efface le livre de la base de données");
		b_effacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame a = new JFrame();
				String[] options = {"Oui", "Non"};
				int f = JOptionPane.showOptionDialog(a, "Êtes-vous sûr de vouloir supprimer ce livre ?", "Suppression d'un livre", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    		    if(f == JOptionPane.YES_OPTION) {
    				m.supLivre(l);
    				try {
    					FileOutputStream fout = new FileOutputStream("src/data/m_" + m.getNom() + "/data.txt");
    					ObjectOutputStream out = new ObjectOutputStream(fout);
    					out.writeObject(m);    
    					out.flush();
    					out.close();
    					fout.flush();
    					fout.close();
    				} catch(Exception ex) {
    					System.out.println(e);
    				}
    				dispose();
    				new Fen3_Gest_Liv(m);
    		    }
			}
		});
		p.add(b_effacer);
		
		JButton b_enreg = new JButton("ENREGISTRER");
		b_enreg.setBackground(new Color(0, 128, 0));
		b_enreg.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_enreg.setBounds(324, 400, 200, 50);
		b_enreg.setToolTipText("Enregistre les modifications");
		b_enreg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(new Modif_InfoLivre(m, l, t_titre, t_auteur, t_editeur, t_prix, t_categorie, t_stock).status == 1) {
					JFrame a = new JFrame();
				    JOptionPane.showMessageDialog(a, "Changements enregistrés.", "Succès", 1);
				}
			}
		});
		p.add(b_enreg);
	}
}