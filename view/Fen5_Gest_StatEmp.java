package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import model.*;

public class Fen5_Gest_StatEmp extends JFrame {
	
	private static final long serialVersionUID = 1L;
    
	public Fen5_Gest_StatEmp(Magasin m) {
		
		// Fenêtre 
		
    	JPanel p = new JPanel();
		Toolkit tk = Toolkit.getDefaultToolkit();  
        Image img = tk.getImage("src/resources/logo.png");
		setIconImage(img);
		setTitle("Statistiques des emplpoyés");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setContentPane(p);
	    p.setLayout(null);
	    p.setBackground(new Color(0, 222, 100));
		
		// Tableau
	   
    	String[] entetes1 = {"Nom", "Pr\u00E9nom", "Sexe", "Fonction", "Salaire", "Age"};
	    String[][] donnees = new String[m.listEmp.size()][6];
	    for(int i = 0; i < m.listEmp.size(); i++) {
	    	String[] temp = new String[6];
	    	temp[0] = ((Employe) (m.listEmp.toArray()[i])).getNom();
	    	temp[1] = ((Employe) (m.listEmp.toArray()[i])).getPrenom();
	    	temp[2] = ((Employe) (m.listEmp.toArray()[i])).getSexe();
	    	temp[3] = ((Employe) (m.listEmp.toArray()[i])).getFonction();
	    	temp[4] = String.valueOf((((Employe) (m.listEmp.toArray()[i])).getSalaire()));
	    	temp[5] = String.valueOf(((Employe) (m.listEmp.toArray()[i])).getAge());
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
	    scrollPane_1.setBounds(100, 150, 800, 400);
	    p.add(scrollPane_1);
	    
	    // Labels
	    
	    JLabel l_stem = new JLabel("Statistiques au niveau des employ\u00E9s ");
	    l_stem.setHorizontalAlignment(SwingConstants.CENTER);
	    l_stem.setFont(new Font("Tahoma", Font.BOLD, 40));
	    l_stem.setBounds(107, 50, 800, 42);
	    p.add(l_stem);
	    
	    JLabel l_nbrt = new JLabel("Nombre total d'employ\u00E9s : ");
	    l_nbrt.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_nbrt.setBounds(472, 590, 341, 42);
	    p.add(l_nbrt);
	    
	    JLabel l_agm = new JLabel("Age moyen : ");
	    l_agm.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_agm.setBounds(472, 630, 341, 42);
	    p.add(l_agm);
	    
	    JLabel l_soms = new JLabel("Somme des salaires : ");
	    l_soms.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_soms.setBounds(472, 670, 341, 42);
	    p.add(l_soms);
	    
	    JLabel l_valueT = new JLabel(String.valueOf((m.listEmp).size()));
	    l_valueT.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_valueT.setBounds(799, 590, 100, 42);
	    p.add(l_valueT);
	    
	    JLabel l_valueAg = new JLabel(String.valueOf((m.getEmpMoyAge(m))));
	    l_valueAg.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_valueAg.setBounds(799, 630, 100, 42);
	    p.add(l_valueAg);
	    
	    JLabel l_valueS = new JLabel(String.valueOf(m.getSomSalaire(m)));
	    l_valueS.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_valueS.setBounds(799, 670, 100, 42);
	    p.add(l_valueS);
	    
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
