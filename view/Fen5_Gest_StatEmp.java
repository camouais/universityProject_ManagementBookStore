package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

import javax.swing.table.*;
public class Fen5_Gest_StatEmp extends JFrame {

    Object[][] donnees1 = {
            {"A", "1", "heiugeigeig", true, "&", "ss",true, "&", "ss"},
            {"Z", "2", "heiugeigeig", true, "é",true, "&", "ss"},
            {"E", "3", "heiugeigeig", true, "(",true, "&", "ss"},
            {"R", "4", "heiugeigeig", false, "-",true, "&", "ss"},
            {"T", "5", "heiugeigeig", false," è",true, "&", "ss"},
            {"Y", "6", "heiugeigeig", false, "_",true, "&", "ss"},
            {"U", "7", "heiugeigeig", true, "ç",true, "&", "ss"},
            {"A", "1", "heiugeigeig", true, "&",true, "&", "ss"},
            {"A", "1", "heiugeigeig", true, "&",true, "&", "ss"},
            {"Z", "2", "heiugeigeig", true, "é",true, "&", "ss"},
            {"E", "3", "heiugeigeig", true, "(",true, "&", "ss"},
            {"R", "4", "heiugeigeig", false, "-",true, "&", "ss"},
            {"T", "5", "heiugeigeig", false," è",true, "&", "ss"},
            {"Y", "6", "heiugeigeig", false, "_",true, "&", "ss"},
            {"U", "7", "heiugeigeig", true, "ç",true, "&", "ss"},
            {"A", "1", "heiugeigeig", true, "&",true, "&", "ss"}, 
            {"A", "1", "heiugeigeig", true, "&",true, "&", "ss"},
            {"Z", "2", "heiugeigeig", true, "é",true, "&", "ss"},
            {"E", "3", "heiugeigeig", true, "(",true, "&", "ss"},
            {"R", "4", "heiugeigeig", false, "-",true, "&", "ss"},
            {"T", "5", "heiugeigeig", false," è",true, "&", "ss"},
            {"Y", "6", "heiugeigeig", false, "_",true, "&", "ss"},
            {"U", "7", "heiugeigeig", true, "ç",true, "&", "ss"},
            {"Y", "6", "heiugeigeig", false, "_",true, "&", "ss"},
            {"U", "7", "heiugeigeig", true, "ç",true, "&", "ss"}
            
    };
    Object[][] donnees2 = {
            {"A", "1", "heiugeigeig"}
            
            
    };
    String[] entetes1 = {"Nom", "Prénom", "Age", "Sexe", "Salaire", "Fonction", "Ancienneté"};
    String[] entetes2 = {"Total employé", "Total Salaire", "Age moyen"};
    JScrollPane scrollPane = new JScrollPane();
    
    
    
    
    JLabel l_stem = new JLabel("Statistiques au niveau des employés ");
    JLabel l_valueAg = new JLabel("ag");
    JButton b_retour = new JButton("Retour");
    JLabel l_valueS = new JLabel("sa");
    JLabel l_valueT = new JLabel("nb");
    JLabel l_soms = new JLabel("Somme salaires :");
    JLabel l_agm = new JLabel("Age moyen :");
    JLabel l_nbrt = new JLabel("Nombre total d'employés :");
    JPanel panel = new JPanel();
	public Fen5_Gest_StatEmp() {
		
		// Fenêtre 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setContentPane(panel);
	    panel.setLayout(null);
	    
		
		// Tableau
	   
	    JTable table1 = new JTable(donnees1, entetes1); 
	    table1.setAutoCreateRowSorter(true);
	    table1.setBounds(100,150,800,400);
	    JScrollPane scrollPane_1 = new JScrollPane(table1);
	    scrollPane_1.setBounds(100,150,800,400);
	    panel.add(scrollPane_1);
	    
	    // JLabel Statistiques au niveau des employés
	    
	    
	    l_stem.setHorizontalAlignment(SwingConstants.CENTER);
	    l_stem.setFont(new Font("Tahoma", Font.PLAIN, 40));
	    l_stem.setBounds(144, 78, 704, 42);
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

	  
	    
	 
	}public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen5_Gest_StatEmp frame = new Fen5_Gest_StatEmp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
