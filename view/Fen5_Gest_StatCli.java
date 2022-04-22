package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.*;

public class Fen5_Gest_StatCli extends JFrame {
	
	private static final long serialVersionUID = 1L;

	Object[][] donnees1 = {
            {"Nom 1", "Prénom 1", "27", "M", "&", "21/02/2021", "13"},
            {"Nom 2", "Prénom 2", "25", "M", "é", "28/05/2021", "2"},
            {"Nom 3", "Prénom 3", "32", "F", "(", "11/01/2021", "4"},
            {"Nom 4", "Prénom 4", "50", "F", "-", "05/03/2047", "33"},
            {"Nom 5", "Prénom 5", "41", "F"," è", "11/12/2019", "15"},
            {"Nom 6", "Prénom 6", "-7", "M", "_", "03/09/2009", "12"},
            {"Nom 7", "Prénom 7", "35", "M", "ç", "22/10/2021", "8"},
            {"Nom 8", "Prénom 8", "33", "F", "&", "01/07/2022", "2"},
            {"Nom 9", "Prénom 9", "19", "F", "&", "08/04/2020", "20"},
            {"Nom 10", "Prénom 10", "23", "M", "é", "21/02/2021", "37"},
            {"Nom 11", "Prénom 11", "198", "F", "(", "03/13/152", "-9223372036854775808"},
            {"Nom 12", "Prénom 12", "15", "M", "-", "30/03/2022", "12"},
            
    };
    
    String[] entetes1 = {"Nom", "Prénom", "Age", "Sexe", "Date de création", "Nombre d'achats", "Dépenses totales"};
    
    private JPanel p = new JPanel();
    private JTable table1 = new JTable(donnees1, entetes1); 
    private JScrollPane scrollPane_1 = new JScrollPane(table1);
    private JLabel l_stem = new JLabel("Statistiques au niveau des clients");
    private JLabel l_valueAg = new JLabel("ag");
    private JLabel l_valueT = new JLabel("nb");
    private JLabel l_nbrt = new JLabel("Nombre total de clients :");
    private JLabel l_agm = new JLabel("Age moyen :");
    
    JButton b_retour = new JButton("Retour");
    JScrollPane scrollPane = new JScrollPane();
    
	public Fen5_Gest_StatCli(Magasin m) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setContentPane(p);
	    p.setLayout(null);
	    p.setBackground(new Color(244, 164, 96));
	    
	    // Tableau
	   
	    table1.setAutoCreateRowSorter(true);
	    table1.setBounds(100, 150, 800, 400);
	    scrollPane_1.setBounds(100, 150, 800, 400);
	    p.add(scrollPane_1);
	    
	    // JLabel "Statistiques au niveau des clients"
	    
	    l_stem.setHorizontalAlignment(SwingConstants.CENTER);
	    l_stem.setFont(new Font("Tahoma", Font.BOLD, 40));
	    l_stem.setBounds(144, 50, 704, 42);
	    p.add(l_stem);
	    
	    // JLabel "Nombre total de clients"

	    l_nbrt.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_nbrt.setBounds(472, 591, 341, 42);
	    p.add(l_nbrt);
	    
	    // JLabel "Âge moyen"

	    l_agm.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_agm.setBounds(472, 643, 341, 42);
	    p.add(l_agm);
	    
	    // JLabel : Valeur totale de clients
	    
	    l_valueT.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_valueT.setBounds(799, 591, 47, 42);
	    p.add(l_valueT);
	    
	    // JLabel : Valeur de l'âge moyen
	    
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
