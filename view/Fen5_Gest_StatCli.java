package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import model.*;

public class Fen5_Gest_StatCli extends JFrame {
	
	private static final long serialVersionUID = 1L;
    
	public Fen5_Gest_StatCli(Magasin m) {
		
		// Fenêtre
		
    	JPanel p = new JPanel();
		Toolkit tk = Toolkit.getDefaultToolkit();  
        Image img = tk.getImage("src/resources/logo.png");
		setIconImage(img);
		setTitle("Statistiques des clients");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setContentPane(p);
	    p.setLayout(null);
	    p.setBackground(new Color(244, 164, 96));
	    
	    // Tableau
	    
	    String[][] donnees = new String[m.listClient.size()][8];
	    String[] entetes1 = {"Nom", "Pr\u00E9nom", "Age", "Sexe", "Date de cr\u00E9ation", "Nombre d'achats", "D\u00E9penses totales", "Panier moyen"};
    	
	    for(int i = 0; i < m.listClient.size(); i++) {
	    	String[] temp = new String[8];
	    	temp[0] = ((Client) (m.listClient.toArray()[i])).getNom();
	    	temp[1] = ((Client) (m.listClient.toArray()[i])).getPrenom();
	    	temp[2] = String.valueOf(((Client) (m.listClient.toArray()[i])).getAge());
	    	temp[3] = ((Client) (m.listClient.toArray()[i])).getSexe();
	    	temp[4] = (((Client) (m.listClient.toArray()[i])).getDateCC()).toString();
	    	temp[5] = String.valueOf((m.listComCli(((Client) (m.listClient.toArray()[i])))).size());
	    	temp[6] = String.valueOf((m.getPrixTotalComCli(((Client) (m.listClient.toArray()[i])))));
	    	temp[7] = (m.panierMoy(((((Client) (m.listClient.toArray()[i]))))));;
	    	
	    	donnees[i] = temp;
	    }
	    
    	JTable table1 = new JTable(donnees, entetes1); 
	    table1.setAutoCreateRowSorter(true);
	    
    	DefaultTableCellRenderer custom = new DefaultTableCellRenderer(); 
	    custom.setHorizontalAlignment(JLabel.CENTER); 
	    for (int i=0 ; i < table1.getColumnCount() ; i++) { 
	    	table1.getColumnModel().getColumn(i).setCellRenderer(custom); 
	    }
	    table1.setBounds(100, 150, 800, 400);
	    
   		JScrollPane scrollPane_1 = new JScrollPane(table1);
	    scrollPane_1 = new JScrollPane(table1);
	    scrollPane_1.setBounds(100, 150, 800, 400);
	    p.add(scrollPane_1);
	    
	    // Labels
	    
	    JLabel l_stem = new JLabel("Statistiques au niveau des clients");
	    l_stem.setHorizontalAlignment(SwingConstants.CENTER);
	    l_stem.setFont(new Font("Tahoma", Font.BOLD, 40));
	    l_stem.setBounds(144, 50, 704, 42);
	    p.add(l_stem);
	    
	    JLabel l_nbrt = new JLabel("Nombre total de clients :");
	    l_nbrt.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_nbrt.setBounds(472, 591, 341, 42);
	    p.add(l_nbrt);

	    JLabel l_agm = new JLabel("Age moyen :");
	    l_agm.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_agm.setBounds(472, 643, 341, 42);
	    p.add(l_agm);
	    
	    JLabel l_valueT = new JLabel(String.valueOf((m.listClient).size()));
	    l_valueT.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_valueT.setText(String.valueOf((m.listClient).size()));
	    l_valueT.setBounds(799, 591, 100, 42);
	    p.add(l_valueT);
	    
	    JLabel l_valueAg = new JLabel(m.getMoyAge(m));
	    l_valueAg.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_valueAg.setBounds(799, 644, 100, 42);
	    l_valueAg.setText(m.getMoyAge(m));
	    p.add(l_valueAg);
	    
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