package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.*;

public class Fen5_Gest_StatEmp extends JFrame {
	
	private static final long serialVersionUID = 1L;

	Object[][] donnees1 = {
            {"A", "1", "heiugeigeig", true, "&", "ss",true, "&", "ss"},
            {"Z", "2", "heiugeigeig", true, "Ã©",true, "&", "ss"},
            {"E", "3", "heiugeigeig", true, "(",true, "&", "ss"},
            {"R", "4", "heiugeigeig", false, "-",true, "&", "ss"},
            {"T", "5", "heiugeigeig", false," Ã¨",true, "&", "ss"},
            {"Y", "6", "heiugeigeig", false, "_",true, "&", "ss"},
            {"U", "7", "heiugeigeig", true, "Ã§",true, "&", "ss"},
            {"A", "1", "heiugeigeig", true, "&",true, "&", "ss"},
            {"A", "1", "heiugeigeig", true, "&",true, "&", "ss"},
            {"Z", "2", "heiugeigeig", true, "Ã©",true, "&", "ss"},
            {"E", "3", "heiugeigeig", true, "(",true, "&", "ss"},
            {"R", "4", "heiugeigeig", false, "-",true, "&", "ss"},
            {"T", "5", "heiugeigeig", false," Ã¨",true, "&", "ss"},
            {"Y", "6", "heiugeigeig", false, "_",true, "&", "ss"},
            {"U", "7", "heiugeigeig", true, "Ã§",true, "&", "ss"},
            {"A", "1", "heiugeigeig", true, "&",true, "&", "ss"}, 
            {"A", "1", "heiugeigeig", true, "&",true, "&", "ss"},
            {"Z", "2", "heiugeigeig", true, "Ã©",true, "&", "ss"},
            {"E", "3", "heiugeigeig", true, "(",true, "&", "ss"},
            {"R", "4", "heiugeigeig", false, "-",true, "&", "ss"},
            {"T", "5", "heiugeigeig", false," Ã¨",true, "&", "ss"},
            {"Y", "6", "heiugeigeig", false, "_",true, "&", "ss"},
            {"U", "7", "heiugeigeig", true, "Ã§",true, "&", "ss"},
            {"Y", "6", "heiugeigeig", false, "_",true, "&", "ss"},
            {"U", "7", "heiugeigeig", true, "Ã§",true, "&", "ss"}
    };
    
    String[] entetes1 = {"Nom", "PrÃ©nom", "Age", "Sexe", "Salaire", "Fonction", "AnciennetÃ©"};
    
    private JPanel p = new JPanel();
    private JTable table1 = new JTable(donnees1, entetes1); 
    private JScrollPane scrollPane_1 = new JScrollPane(table1);
    private JLabel l_stem = new JLabel("Statistiques au niveau des employÃ©s ");
    private JLabel l_valueAg = new JLabel("ag");
    private JLabel l_valueS = new JLabel("sa");
    private JLabel l_valueT = new JLabel("nb");
    private JLabel l_soms = new JLabel("Somme des salaires : ");
    private JLabel l_agm = new JLabel("Age moyen : ");
    private JLabel l_nbrt = new JLabel("Nombre total d'employÃ©s : ");
    
    JButton b_retour = new JButton("Retour");
    JScrollPane scrollPane = new JScrollPane();
    
	public Fen5_Gest_StatEmp(Magasin m) {
		
		// FenÃªtre 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setContentPane(p);
	    p.setLayout(null);
	    p.setBackground(new Color(0, 222, 100));
		
		// Tableau
	   
	    table1.setAutoCreateRowSorter(true);
	    table1.setBounds(100, 150, 800, 400);
	    scrollPane_1.setBounds(100, 150, 800, 400);
	    p.add(scrollPane_1);
	    
	    // JLabel "Statistiques au niveau des employÃ©s"
	    
	    l_stem.setHorizontalAlignment(SwingConstants.CENTER);
	    l_stem.setFont(new Font("Tahoma", Font.BOLD, 40));
	    l_stem.setBounds(125, 50, 750, 42);
	    p.add(l_stem);
	    
	    // JLabel "Nombre total d'employÃ©s"

	    l_nbrt.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_nbrt.setBounds(472, 591, 341, 42);
	    p.add(l_nbrt);
	    
	    // JLabel "Ã‚ge moyen"

	    l_agm.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_agm.setBounds(472, 643, 341, 42);
	    p.add(l_agm);
	    
	    // JLabel "Somme des salaires"

	    l_soms.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_soms.setBounds(472, 696, 341, 42);
	    p.add(l_soms);
	    
	    // JLabel : Valeur totale d'employÃ©s
	    
	    l_valueT.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_valueT.setBounds(799, 591, 47, 42);
	    p.add(l_valueT);
	    
	    // JLabel : Valeur de l'Ã¢ge moyen
	    
	    l_valueAg.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_valueAg.setBounds(799, 644, 47, 42);
	    p.add(l_valueAg);
	    
	    // JLabel : Valeur de la somme des salaires
	    
	    l_valueS.setFont(new Font("Tahoma", Font.PLAIN, 25));
	    l_valueS.setBounds(799, 696, 64, 42);
	    p.add(l_valueS);
	    
	    // Bouton "Retour"
	   
	    b_retour.setFont(new Font("Tahoma", Font.PLAIN, 33));
	    b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Fen4_Gest_MagStat(m);
				dispose();
			}
		});
	    b_retour.setBounds(71, 634, 222, 57);
	    b_retour.setBackground(new Color(64,128,0));
	    p.add(b_retour);
	}
}
