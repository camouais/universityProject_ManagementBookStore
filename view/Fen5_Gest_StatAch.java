package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import model.*;

public class Fen5_Gest_StatAch extends JFrame {
	
	private static final long serialVersionUID = 1L;
    
	public Fen5_Gest_StatAch(Magasin m) {
		
		// Fenêtre 
		
		JPanel p = new JPanel();
		setTitle("Statistiques des achats");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setContentPane(p);
	    p.setLayout(null);
		p.setBackground(new Color(221, 150, 221));
		
		// Tableau
	    String[][] donnees = new String[m.listClient.size()][5];
	    String[] entetes1 = {"Nom","Pr\u00E9nom", "Date", "Nombre d'articles", "Prix total"};
	   
	    for(int i = 0; i < m.listCom.size(); i++) {
	    	String[] temp = new String[5];
	    	temp[0] = (((Commande) (m.listCom.toArray()[i])).getClient()).getNom();
	    	temp[1] = (((Commande) (m.listCom.toArray()[i])).getClient()).getPrenom();
	    	temp[2] = ((Commande) (m.listCom.toArray()[i])).getDateAchat().toString();
	    	temp[3] = String.valueOf(((Commande) (m.listCom.toArray()[i])).getAchat(((Commande) (m.listCom.toArray()[i])).getClient()).size());
	    	temp[4] = ((Commande) (m.listCom.toArray()[i])).getPrixTotal();
	    	
	    	donnees[i] = temp;
	    }
		
   		JTable table1 = new JTable(donnees, entetes1);
	    table1.setBounds(100, 150, 800, 400);
	    table1.setAutoCreateRowSorter(true);
	    
    	DefaultTableCellRenderer custom = new DefaultTableCellRenderer(); 
	    custom.setHorizontalAlignment(JLabel.CENTER); 
	    for (int i=0 ; i < table1.getColumnCount() ; i++) { 
	    	table1.getColumnModel().getColumn(i).setCellRenderer(custom); 
	    }
	    
    	JScrollPane scrollPane_1 = new JScrollPane(table1);
	    scrollPane_1.setBounds(100, 150, 800, 400);
	    p.add(scrollPane_1);
	    
	    // Labels
	    
	    JLabel l_stem = new JLabel("Statistiques au niveau des achats");
	    l_stem.setHorizontalAlignment(SwingConstants.CENTER);
	    l_stem.setFont(new Font("Tahoma", Font.BOLD, 40));
	    l_stem.setBounds(10, 30, 984, 42);
	    p.add(l_stem);
	    
	    JLabel l_nbrt = new JLabel("Nombre de ventes : ");
	    l_nbrt.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_nbrt.setBounds(400, 630, 400, 42);
	    p.add(l_nbrt);
	    
	    JLabel l_soms = new JLabel("Total des ventes : ");
	    l_soms.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_soms.setBounds(400, 580, 390, 42);
	    p.add(l_soms);
	    
	    JLabel r_l_valueT = new JLabel(String.valueOf((m.listCom).size()));
	    r_l_valueT.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    r_l_valueT.setBounds(800, 630, 100, 42);
	    p.add(r_l_valueT);
	    
	    JLabel r_l_valueAg = new JLabel(m.getPrixTotalCom(m));
	    r_l_valueAg.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    r_l_valueAg.setBounds(800, 580, 100, 42);
	    p.add(r_l_valueAg);
	    
	    // Bouton Retour
	    
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
