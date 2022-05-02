package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import model.*;

public class Fen5_Gest_StatAch extends JFrame {
	
	private static final long serialVersionUID = 1L;


	Object[][] donnees1;
    
    String[] entetes1 = {"id","Nom","Prénom", "Date", "Nombre d'articles", "Prix total"};
    DefaultTableCellRenderer custom = new DefaultTableCellRenderer(); 
    
    private JPanel p = new JPanel();
    private JTable table1 = new JTable(donnees1, entetes1); 
    private JScrollPane scrollPane_1 = new JScrollPane(table1);
    private JLabel l_stem = new JLabel("Statistiques au niveau des achats");
    private JLabel r_l_valueAg = new JLabel("tv");
    private JLabel r_l_valueT = new JLabel("nb");
    private JLabel l_nbrt = new JLabel("Nombre de ventes : ");
    private JLabel l_soms = new JLabel("Total des ventes : ");
    
    JButton b_retour = new JButton("Retour");
    JScrollPane scrollPane = new JScrollPane();
    
	public Fen5_Gest_StatAch(Magasin m) {
		
		// Fenêtre 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setContentPane(p);
	    p.setLayout(null);
		p.setBackground(new Color(221, 150, 221));
		
		// Tableau
	    String[][] donnees2 = new String[m.listClient.size()][6];
	   
	    for(int i = 0; i < m.listCom.size(); i++) {
	    	String[] temp = new String[6];
	    	temp[0] = String.valueOf((((Commande) (m.listCom.toArray()[i])).getId()));
	    	temp[1] = (((Commande) (m.listCom.toArray()[i])).getClient()).getNom();
	    	temp[2] = (((Commande) (m.listCom.toArray()[i])).getClient()).getPrenom();
	    	temp[3] = ((Commande) (m.listCom.toArray()[i])).getDateAchat();
	    	temp[4] = String.valueOf(((Commande) (m.listCom.toArray()[i])).getAchat(((Commande) (m.listCom.toArray()[i])).getClient()).size());
	    	temp[5] = ((Commande) (m.listCom.toArray()[i])).getPrixTotal();
	    	
	    	donnees2[i] = temp;
	    }
		
	   
		
	    table1 = new JTable(donnees2, entetes1);
	    table1.setAutoCreateRowSorter(true);
	    // Centre les données du tableaux
	     custom.setHorizontalAlignment(JLabel.CENTER); 
	    for (int i=0 ; i < table1.getColumnCount() ; i++) { 
	    	table1.getColumnModel().getColumn(i).setCellRenderer(custom); 
	    }
	    table1.setBounds(100, 150, 800, 400);
	    scrollPane_1 = new JScrollPane(table1);
	    scrollPane_1.setBounds(100, 150, 800, 400);
	    p.add(scrollPane_1);

	    // JLabel "Statistiques au niveau des achats"
	    
	    l_stem.setHorizontalAlignment(SwingConstants.CENTER);
	    l_stem.setFont(new Font("Tahoma", Font.BOLD, 40));
	    l_stem.setBounds(10, 30, 984, 42);
	    p.add(l_stem);
	    
	    // JLabel "Nombre de ventes :"
	    
	    l_nbrt.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_nbrt.setBounds(400, 630, 400, 42);
	    p.add(l_nbrt);
	    
	    // JLabel "Total des ventes" (Individuelles)

	    l_soms.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_soms.setBounds(400, 580, 390, 42);
	    p.add(l_soms);
	    
	    // JLabel : Valeur totale des commandes
	    
	    r_l_valueT.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    r_l_valueT.setBounds(800, 630, 100, 42);
	    r_l_valueT.setText(String.valueOf((m.listCom).size()));
	    p.add(r_l_valueT);
	    
	    // JLabel : Valeur totale de ventes
	    
	    r_l_valueAg.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    r_l_valueAg.setBounds(800, 580, 100, 42);
	    r_l_valueAg.setText(m.getPrixTotalCom(m));
	    p.add(r_l_valueAg);
	   
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
