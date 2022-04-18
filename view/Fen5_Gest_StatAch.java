package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class Fen5_Gest_StatAch extends JFrame {

    Object[][] donnees1 = {
            {"1", "Client.getName() 1", "12.33€", "Liste livresa"},
            {"2", "Client.getName() 2", "56.00€", "Liste livresb"},
            {"3", "Client.getName() 1", "25.50€", "Liste livresc"},
            {"4", "Client.getName() 4", "AB.CD€", "Liste livresd"},
            {"5", "Client.getName() 5", "87.40€", "Liste livrese"},
            {"6", "Client.getName() 6", "a", "Liste livresf"},
            {"7", "Client.getName() 7", "12087.20€", "hehe"},
            {"8", "Client.getName() 1", "b", "Liste livresg"},
            {"9", "Client.getName() 1", "c", "Liste livres"},
            {"10", "Client.getName() 2", "d", "Liste livres"},
            {"11", "Client.getName() 3", "e", "Liste livres"},
            {"12", "Client.getName() 4", "f", "Liste livres"},
            {"13", "Client.getName() 5", "g", "Liste livres"},
            {"14", "Client.getName() 6", "h", "Liste livres"},
            {"15", "Client.getName() 7", "h", "Liste livres"},
            {"16", "Client.getName() 1", "h", "Liste livres"}, 
            {"17", "Client.getName() 1", "h", "Liste livres"},
            {"18", "Client.getName() 2", "h", "Liste livres"},
            {"19", "Client.getName() 3", "h", "Liste livres"},
            {"20", "Client.getName() 4", "h", "Liste livres"},
            {"21", "Client.getName() 5", "h", "Liste livres"},
            {"22", "Client.getName() 6", "h", "Liste livres"},
            {"23", "Client.getName() 7", "h", "Liste livres"},
            {"24", "Client.getName() 6", "h", "Liste livres"},
            {"25", "Client.getName() 7", "h", "Liste livres"}
    };
    
    String[] entetes1 = {"ID", "Nom du client", "Prix total", "Livres achetés"};
    
    JScrollPane scrollPane = new JScrollPane();
    
    JLabel l_stem = new JLabel("Statistiques au niveau des achats");
    JLabel l_valueAg = new JLabel("tv");
    JButton b_retour = new JButton("Retour");
    JLabel l_valueT = new JLabel("nb");
    JLabel l_nbrt = new JLabel("Nombre total de commandes : ");
    JLabel l_soms = new JLabel("Total de ventes : ");
    JPanel panel = new JPanel();
    
	public Fen5_Gest_StatAch() {
		
		// Fenêtre 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setContentPane(panel);
	    panel.setLayout(null);
		panel.setBackground(new Color(221, 150, 221));
		
		// Tableau
	   
	    JTable table1 = new JTable(donnees1, entetes1); 
	    table1.setAutoCreateRowSorter(true);
	    table1.setBounds(100, 150, 800, 400);
	    JScrollPane scrollPane_1 = new JScrollPane(table1);
	    scrollPane_1.setBounds(100, 100, 800, 400);
	    panel.add(scrollPane_1);
	    
	    // JLabel "Statistiques au niveau des livres"
	    
	    l_stem.setHorizontalAlignment(SwingConstants.CENTER);
	    l_stem.setFont(new Font("Tahoma", Font.BOLD, 40));
	    l_stem.setBounds(10, 30, 984, 42);
	    panel.add(l_stem);

	    l_nbrt.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_nbrt.setBounds(400, 520, 400, 42);
	    panel.add(l_nbrt);

	    l_soms.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_soms.setBounds(400, 580, 390, 42);
	    panel.add(l_soms);
	    
	    l_valueT.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_valueT.setBounds(800, 520, 47, 42);
	    panel.add(l_valueT);
	    
	    l_valueAg.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_valueAg.setBounds(800, 580, 47, 42);
	    panel.add(l_valueAg);
	   
	    b_retour.setFont(new Font("Tahoma", Font.PLAIN, 33));
	    b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fen4_Gest_MagStat a = new Fen4_Gest_MagStat();
				dispose();
			}
		});
	    b_retour.setBounds(71, 550, 222, 57);
	    b_retour.setBackground(new Color(64,128,0));
	    
	    panel.add(b_retour);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen5_Gest_StatAch frame = new Fen5_Gest_StatAch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
