package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import model.*;

public class Fen5_Gest_StatEmp extends JFrame {
	
	private static final long serialVersionUID = 1L;

	
    
    String[] entetes1 = {"Nom", "Pr�nom", "Sexe", "Fonction", "Salaire", "Age"};
    
    private JPanel p = new JPanel();
    private JTable table1 ; 
    DefaultTableCellRenderer custom = new DefaultTableCellRenderer(); 
    
    private JScrollPane scrollPane_1 ;
    private JLabel l_stem = new JLabel("Statistiques au niveau des employ�s ");
    private JLabel l_valueAg = new JLabel("ag");
    private JLabel l_valueS = new JLabel("sa");
    private JLabel l_valueT = new JLabel("nb");
    private JLabel l_soms = new JLabel("Somme des salaires : ");
    private JLabel l_agm = new JLabel("Age moyen : ");
    private JLabel l_nbrt = new JLabel("Nombre total d'employ�s : ");
    
    JButton b_retour = new JButton("Retour");
    JScrollPane scrollPane = new JScrollPane();
    
	public Fen5_Gest_StatEmp(Magasin m) {
		
		// Fen�tre 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setContentPane(p);
	    p.setLayout(null);
	    p.setBackground(new Color(0, 222, 100));
		
		// Tableau
	   
	    String[][] donnees2 = new String[m.listEmp.size()][6];
	    for(int i = 0; i < m.listEmp.size(); i++) {
	    	String[] temp = new String[6];
	    	temp[0] = ((Employe) (m.listEmp.toArray()[i])).getNom();
	    	temp[1] = ((Employe) (m.listEmp.toArray()[i])).getPrenom();
	    	temp[2] = ((Employe) (m.listEmp.toArray()[i])).getSexe();
	    	temp[3] = ((Employe) (m.listEmp.toArray()[i])).getFonction();
	    	temp[4] = String.valueOf((((Employe) (m.listEmp.toArray()[i])).getSalaire()));
	    	temp[5] = String.valueOf(((Employe) (m.listEmp.toArray()[i])).getAge());
	    	donnees2[i] = temp;
	    }
	    table1 = new JTable(donnees2, entetes1);
	    table1.setAutoCreateRowSorter(true);
	    // Centre les donn�es du tableaux
	     custom.setHorizontalAlignment(JLabel.CENTER); 
	    for (int i=0 ; i < table1.getColumnCount() ; i++) { 
	    	table1.getColumnModel().getColumn(i).setCellRenderer(custom); 
	    }
	    table1.setBounds(100, 150, 800, 400);
	    scrollPane_1 = new JScrollPane(table1);
	    scrollPane_1.setBounds(100, 150, 800, 400);
	    p.add(scrollPane_1);
	    
	    // JLabel "Statistiques au niveau des employ�s"
	    
	    l_stem.setHorizontalAlignment(SwingConstants.CENTER);
	    l_stem.setFont(new Font("Tahoma", Font.BOLD, 40));
	    l_stem.setBounds(107, 50, 800, 42);
	    p.add(l_stem);
	    
	    // JLabel "Nombre total d'employ�s"

	    l_nbrt.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_nbrt.setBounds(472, 591, 341, 42);
	    p.add(l_nbrt);
	    
	    // JLabel "�ge moyen"

	    l_agm.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_agm.setBounds(472, 643, 341, 42);
	    p.add(l_agm);
	    
	    // JLabel "Somme des salaires"

	    l_soms.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_soms.setBounds(472, 696, 341, 42);
	    p.add(l_soms);
	    
	    // JLabel : Valeur totale d'employ�s
	    
	    l_valueT.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_valueT.setBounds(799, 591, 47, 42);
	    l_valueT.setText(String.valueOf((m.listEmp).size()));
	    p.add(l_valueT);
	    
	    // JLabel : Valeur de l'�ge moyen
	    
	    l_valueAg.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_valueAg.setBounds(799, 644, 47, 42);
	    l_valueAg.setText(String.valueOf((m.getEmpMoyAge(m))));
	    p.add(l_valueAg);
	    
	    // JLabel : Valeur de la somme des salaires
	    
	    l_valueS.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_valueS.setBounds(799, 696, 100, 42);
	    l_valueS.setText(String.valueOf(m.getSomSalaire(m)));
	    p.add(l_valueS);
	    
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
