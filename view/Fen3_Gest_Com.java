package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Magasin;

public class Fen3_Gest_Com extends JFrame {
		
		private static final long serialVersionUID = 1L;

		private JPanel p = new JPanel();
	    private DefaultListModel<String> model;
		private JScrollPane scrollPane = new JScrollPane();
	    private JScrollPane scrollPane2 = new JScrollPane();
	    private JList<String> list = new JList<String>();
	    private JList<String> list2 = new JList<String>();
		private JPanel panel1 = new JPanel();
		private JPanel panel2 = new JPanel();
	    public static int count = 0;
		private JTextField t_rech= new JTextField();
		private JLabel l_main = new JLabel("Achats");
	    
		JButton b_modifier = new JButton("Modifier");
		JButton b_ajouter = new JButton("Ajouter");
		JButton b_retour = new JButton("Retour");

		public JLabel label = new JLabel("Veuillez sélectionné un achat pour afficher ses informations");
		    
		
		public Fen3_Gest_Com(Magasin m) {
			
			// Fenêtre
			
			p = new JPanel();
			p.setBorder(new EmptyBorder(5, 5, 5, 5));
			p.setBackground(new Color(0, 153, 153));
			p.setLayout(null);
			setContentPane(p);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(0, 0, 1000, 800);
			setLocationRelativeTo(null);
			setResizable(false);
			setVisible(true);
			
			// Liste 1 (Liste des achats)
			
	        list.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        scrollPane.setViewportView(list);
	        list.setLayoutOrientation(JList.VERTICAL);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        panel1.setBounds(50, 175, 400, 440);
	        panel1.setLayout(null);
	        scrollPane.setBounds(0, 0, 400, 440);
	        panel1.add(scrollPane);
	        p.add(panel1);
	        
	        // Liste 2 (Informations de l'achat sélectionné)
	        
	        model=new DefaultListModel<String>();
	        list2.setModel(model);
	        
			list2.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        scrollPane2.setViewportView(list2);
	        list2.setLayoutOrientation(JList.VERTICAL);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			panel2.setBounds(540, 175, 400, 345);
			panel2.setLayout(null);
			scrollPane2.setBounds(0, 0, 400, 345);
			panel2.add(scrollPane2);
			p.add(panel2);

			// Textfield - Recherche d'un achat
			
			t_rech.setFont(new Font("Tahoma", Font.PLAIN, 25));
			t_rech.setText("Recherchez un achat...");
			t_rech.setBounds(50, 100, 890, 45);
			p.add(t_rech);
			t_rech.setColumns(10);
			
			// JLabel "Achats"
			
			l_main.setHorizontalAlignment(SwingConstants.CENTER);
			l_main.setFont(new Font("Arial", Font.BOLD, 50));
			l_main.setBounds(10, 15, 964, 57);
			p.add(l_main);
			
			// Boutons : Modifier, Ajouter, Retour
			
			b_modifier.setFont(new Font("Tahoma", Font.PLAIN, 30));
			b_modifier.setBounds(540, 555, 400, 60);
			b_modifier.setBackground(new Color(200, 200, 100));
			b_modifier.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new Fen4_Gest_ModifLiv(m);
				}
			});
			p.add(b_modifier);
			
			b_ajouter.setIcon(null);
			b_ajouter.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if(list.getSelectedValue()!=null) {
		                model.addElement("Test n°"+count);
		                count++;
	                }           
	            }
			});
			b_ajouter.setFont(new Font("Tahoma", Font.PLAIN, 30));
			b_ajouter.setBounds(50, 650, 400, 60);
			b_ajouter.setBackground(new Color(100, 200, 120));
			p.add(b_ajouter);
	        
			b_retour.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new Fen2_Gest(m);
				}
			});
			b_retour.setFont(new Font("Tahoma", Font.BOLD, 30));
			b_retour.setBounds(540, 650, 400, 60);
			b_retour.setBackground(new Color(200, 100, 100));
			p.add(b_retour);
		}

}