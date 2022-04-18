package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class Fen5_Gest_StatLiv extends JFrame {

    Object[][] donnees1 = {
            {"Titre 1", "Auteur 1", "Éditeur 1", "Catégorie 1", "Date 1", "89"},
            {"Titre 2", "Auteur 2", "Éditeur 1", "Catégorie 2", "Date 2", "55"},
            {"Titre 3", "Auteur 1", "Éditeur 2", "Catégorie 1", "Date 3", "107"},
            {"Titre 4", "Auteur 3", "Éditeur 3", "Catégorie 3", "Date 4", "8"},
            {"Titre 5", "Auteur 4", "Éditeur 1", "Catégorie 2", "Date 5", "95344"},
            {"Titre 6", "Auteur 2", "Éditeur 4", "Catégorie 4", "Date 6", "1085134"},
            {"Titre 7", "Auteur 5", "Éditeur 5", "Catégorie 2", "Date 7", "87261931"},
            {"Titre 8", "Auteur 6", "Éditeur 3", "Catégorie 2", "Date 8", "917324728923"},
            {"Titre 9", "Auteur 3", "Éditeur 4", "Catégorie 3", "Date 9", "beaucoup"},
    };
    
    String[] entetes1 = {"Titre", "Auteur", "Éditeur", "Catégorie", "Date de parution", "Nombre de ventes"};
    
    JScrollPane scrollPane = new JScrollPane();
    
    JLabel l_stem = new JLabel("Statistiques au niveau des livres");
    JLabel l_valueAg = new JLabel("tv");
    JButton b_retour = new JButton("Retour");
    JLabel l_valueT = new JLabel("nb");
    JLabel l_nbrt = new JLabel("Nombre total de livres : ");
    JLabel l_soms = new JLabel("Total de ventes : ");
    JPanel panel = new JPanel();
    
	public Fen5_Gest_StatLiv() {
		
		// Fenêtre 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setContentPane(panel);
	    panel.setLayout(null);
	    panel.setBackground(new Color(180, 112, 147));
		
		// Tableau
	   
	    JTable table1 = new JTable(donnees1, entetes1); 
	    table1.setAutoCreateRowSorter(true);
	    table1.setBounds(100, 150, 800, 400);
	    JScrollPane scrollPane_1 = new JScrollPane(table1);
	    scrollPane_1.setBounds(100, 150, 800, 400);
	    panel.add(scrollPane_1);
	    
	    // JLabel "Statistiques au niveau des livres"
	    
	    l_stem.setHorizontalAlignment(SwingConstants.CENTER);
	    l_stem.setFont(new Font("Tahoma", Font.BOLD, 40));
	    l_stem.setBounds(125, 50, 750, 42);
	    panel.add(l_stem);

	    l_nbrt.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_nbrt.setBounds(472, 591, 341, 42);
	    panel.add(l_nbrt);

	    l_soms.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_soms.setBounds(472, 643, 341, 42);
	    panel.add(l_soms);
	    
	    l_valueT.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_valueT.setBounds(799, 591, 47, 42);
	    panel.add(l_valueT);
	    
	    l_valueAg.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_valueAg.setBounds(799, 644, 47, 42);
	    panel.add(l_valueAg);
	   
	    b_retour.setFont(new Font("Tahoma", Font.PLAIN, 33));
	    b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fen4_Gest_MagStat a = new Fen4_Gest_MagStat();
				dispose();
			}
		});
	    b_retour.setBounds(71, 634, 222, 57);
	    b_retour.setBackground(new Color(64,128,0));
	    
	    panel.add(b_retour);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen5_Gest_StatLiv frame = new Fen5_Gest_StatLiv();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
