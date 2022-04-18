package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class Fen5_Gest_StatCli extends JFrame {

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
    
    JScrollPane scrollPane = new JScrollPane();
    
    JLabel l_stem = new JLabel("Statistiques au niveau des clients");
    JLabel l_valueAg = new JLabel("ag");
    JButton b_retour = new JButton("Retour");
    JLabel l_valueS = new JLabel("sa");
    JLabel l_valueT = new JLabel("nb");
    JLabel l_nbrt = new JLabel("Nombre total de clients :");
    JLabel l_agm = new JLabel("Age moyen :");
    JLabel l_soms = new JLabel("Recette totale :");
    JPanel panel = new JPanel();
    
	public Fen5_Gest_StatCli() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setContentPane(panel);
	    panel.setLayout(null);
	    panel.setBackground(new Color(244, 164, 96));
	    
	    // Tableau
	   
	    JTable table1 = new JTable(donnees1, entetes1); 
	    table1.setAutoCreateRowSorter(true);
	    table1.setBounds(100, 150, 800, 400);
	    JScrollPane scrollPane_1 = new JScrollPane(table1);
	    scrollPane_1.setBounds(100, 150, 800, 400);
	    panel.add(scrollPane_1);
	    
	    // JLabel "Statistiques au niveau des clients"
	    
	    l_stem.setHorizontalAlignment(SwingConstants.CENTER);
	    l_stem.setFont(new Font("Tahoma", Font.BOLD, 40));
	    l_stem.setBounds(144, 50, 704, 42);
	    panel.add(l_stem);

	    l_nbrt.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_nbrt.setBounds(472, 591, 341, 42);
	    panel.add(l_nbrt);

	    l_agm.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_agm.setBounds(472, 643, 341, 42);
	    panel.add(l_agm);

	    l_soms.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_soms.setBounds(472, 696, 341, 42);
	    panel.add(l_soms);
	    
	    l_valueT.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_valueT.setBounds(799, 591, 47, 42);
	    panel.add(l_valueT);
	    
	    l_valueAg.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_valueAg.setBounds(799, 644, 47, 42);
	    panel.add(l_valueAg);
	    
	    l_valueS.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_valueS.setBounds(799, 696, 64, 42);
	    panel.add(l_valueS);
	    
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
					Fen5_Gest_StatCli frame = new Fen5_Gest_StatCli();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
