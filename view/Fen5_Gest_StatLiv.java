package view;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import model.*;

public class Fen5_Gest_StatLiv extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
    String[] entetes1 = {"Titre", "Auteur", "Éditeur", "Catégorie", "Date de parution", "Nombre de ventes"};
    
    private JPanel p = new JPanel();
    private JTable table1; 
    private JScrollPane scrollPane_1;
    private JLabel l_stem = new JLabel("Statistiques au niveau des livres");
    private JLabel l_valueAg = new JLabel("tv");
    private JLabel l_valueT = new JLabel("nb");
    private JLabel l_nbrt = new JLabel("Nombre total de livres : ");
    private JLabel l_tven = new JLabel("Total de ventes : ");

    JScrollPane scrollPane = new JScrollPane();
    JButton b_retour = new JButton("Retour");
    
	public Fen5_Gest_StatLiv(Magasin m) {
		
		// Fenêtre 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setContentPane(p);
	    p.setLayout(null);
	    p.setBackground(new Color(180, 112, 147));
		
		// Tableau
	    String[][] donnees2 = new String[m.listLivre.size()][6];
	    for(int i = 0; i < m.listLivre.size(); i++) {
	    	String[] temp = new String[6];
	    	temp[0] = ((Livre) (m.listLivre.toArray()[i])).getTitre();
	    	temp[1] = ((Livre) (m.listLivre.toArray()[i])).getAuteur();
	    	temp[2] = ((Livre) (m.listLivre.toArray()[i])).getEditeur();
	    	temp[3] = ((Livre) (m.listLivre.toArray()[i])).getCategorie();
	    	temp[4] = ((Livre) (m.listLivre.toArray()[i])).getDateParution();
	    	temp[5] = String.valueOf(((Livre) (m.listLivre.toArray()[i])).qtSortie());
	    	donnees2[i] = temp;
	    }
	    table1 = new JTable(donnees2, entetes1);
	    table1.setAutoCreateRowSorter(true);
	    table1.setBounds(100, 150, 800, 400);
	    scrollPane_1 = new JScrollPane(table1);
	    scrollPane_1.setBounds(100, 150, 800, 400);
	    p.add(scrollPane_1);
	    
	    // JLabel "Statistiques au niveau des livres"
	    
	    l_stem.setHorizontalAlignment(SwingConstants.CENTER);
	    l_stem.setFont(new Font("Tahoma", Font.BOLD, 40));
	    l_stem.setBounds(125, 50, 750, 42);
	    p.add(l_stem);
	    
	    // JLabel "Nombre total de livres"

	    l_nbrt.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_nbrt.setBounds(472, 591, 341, 42);
	    p.add(l_nbrt);
	    
	    // JLabel "Total de ventes"

	    l_tven.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_tven.setBounds(472, 643, 341, 42);
	    p.add(l_tven);
	    
	    // JLabel : Valeur totale de livres
	    
	    l_valueT.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_valueT.setBounds(799, 591, 47, 42);
	    p.add(l_valueT);
	    
	    // JLabel : Valeur totale des ventes
	    
	    l_valueAg.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_valueAg.setBounds(799, 644, 47, 42);
	    p.add(l_valueAg);
	    
	    // Bouton "Retour"
	   
	    b_retour.setFont(new Font("Tahoma", Font.PLAIN, 33));
	    b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen4_Gest_MagStat(m);
			}
		});
	    b_retour.setBounds(71, 634, 222, 57);
	    b_retour.setBackground(new Color(64,128,0));
	    p.add(b_retour);
	}
}
