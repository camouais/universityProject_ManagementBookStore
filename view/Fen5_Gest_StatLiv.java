package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import model.*;

public class Fen5_Gest_StatLiv extends JFrame {
	
	private static final long serialVersionUID = 1L;
    
	public Fen5_Gest_StatLiv(Magasin m) {
		
		// Fenêtre 
		
    	JPanel p = new JPanel();
		setTitle("Statistiques des livres");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setContentPane(p);
	    p.setLayout(null);
	    p.setBackground(new Color(180, 112, 147));
	    
		// Tableau
		
    	String[] entetes1 = {"Titre", "Auteur", "Éditeur", "Catégorie", "Date de parution", "Quantit\u00E9 initiale", "Nombre de ventes", "Quantit\u00E9 en Stock"};
	    String[][] donnees = new String[m.listLivre.size()][8];
	    for(int i = 0; i < m.listLivre.size(); i++) {
	    	String[] temp = new String[8];

	    	temp[0] = ((Livre) (m.listLivre.toArray()[i])).getTitre();
	    	temp[1] = ((Livre) (m.listLivre.toArray()[i])).getAuteur();
	    	temp[2] = ((Livre) (m.listLivre.toArray()[i])).getEditeur();
	    	temp[3] = ((Livre) (m.listLivre.toArray()[i])).getCategorie();
	    	temp[4] = ((Livre) (m.listLivre.toArray()[i])).getDateParution().toString();
	    	temp[5] = String.valueOf(((Livre) (m.listLivre.toArray()[i])).getQtEntree());
	    	temp[6] = String.valueOf(((Livre) (m.listLivre.toArray()[i])).qtSortie());
	    	temp[7] = String.valueOf(((Livre) (m.listLivre.toArray()[i])).getStock());

	    	donnees[i] = temp;
	    }
	    JTable table1 = new JTable(donnees, entetes1);
	    table1.setAutoCreateRowSorter(true);
	    table1.setBounds(100, 150, 800, 400);
		DefaultTableCellRenderer custom = new DefaultTableCellRenderer(); 
	    custom.setHorizontalAlignment(JLabel.CENTER); 
	    for (int i=0 ; i < table1.getColumnCount() ; i++) { 
	    	table1.getColumnModel().getColumn(i).setCellRenderer(custom); 
	    }
	    JScrollPane scrollPane_1 = new JScrollPane(table1);
	    scrollPane_1.setBounds(100, 150, 800, 400);
	    p.add(scrollPane_1);
	    
	    // Labels
	    
	    JLabel l_stem = new JLabel("Statistiques au niveau des livres");
	    l_stem.setHorizontalAlignment(SwingConstants.CENTER);
	    l_stem.setFont(new Font("Tahoma", Font.BOLD, 40));
	    l_stem.setBounds(125, 50, 750, 42);
	    p.add(l_stem);
	    
	    JLabel l_nbri = new JLabel("Nombre de livres initial : ");
	    l_nbri.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_nbri.setBounds(472, 570, 341, 42);
	    p.add(l_nbri);

	    JLabel l_nbrt = new JLabel("Nombre total de livres : ");
	    l_nbrt.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_nbrt.setBounds(472, 610, 341, 42);
	    p.add(l_nbrt);
	    
	    JLabel l_tven = new JLabel("Nombre de ventes : ");
	    l_tven.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_tven.setBounds(472, 650, 341, 42);
	    p.add(l_tven);
	    
	    JLabel r_l_nbri = new JLabel(" ");
	    r_l_nbri.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    r_l_nbri.setBounds(799, 570, 47, 42);
	    r_l_nbri.setText(String.valueOf(m.getAllInitStock(m)));
	    p.add(r_l_nbri);
	    
	    JLabel r_l_nbrt = new JLabel(" ");
	    r_l_nbrt.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    r_l_nbrt.setBounds(799, 610, 47, 42);
	    r_l_nbrt.setText(String.valueOf(m.getAllStock(m)));
	    p.add(r_l_nbrt);
	    
	    JLabel r_l_valueT = new JLabel(" ");
	    r_l_valueT.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    r_l_valueT.setText(String.valueOf(m.getAllVentes(m)));
	    r_l_valueT.setBounds(799, 650, 47, 42);
	    p.add(r_l_valueT);
	    
	    // Bouton "Retour"

    	JButton b_retour = new JButton("Retour");
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
