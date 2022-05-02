package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.*;
import controller.*;
public class Fen7_Gest_ModifDepense extends JFrame{
	
		private static final long serialVersionUID = 1L;
		
		
		private JPanel p = new JPanel();
		private JLabel l_main = new JLabel("Modification de la dépense ");
		private JLabel l_description = new JLabel("Description :");
		private JLabel l_cout = new JLabel("Cout :");
		private JLabel l_Nemploye = new JLabel("Nom employé :");
		private JLabel l_Pemploye = new JLabel("Prénom employé :");
		private JLabel l_Iemploye = new JLabel("Id employé :");
		
		private JTextField t_cout = new JTextField();
		private JTextField t_Nemploye = new JTextField();
		private JTextField t_Pemploye = new JTextField();
		private JTextField t_Iemploye = new JTextField();
		private JTextField t_annee = new JTextField();
		
		JButton b_retour = new JButton("RETOUR");
		JButton b_effacer = new JButton("EFFACER");
		JButton b_enreg = new JButton("ENREGISTRER");
		JComboBox c_jour = new JComboBox();
		JComboBox c_mois = new JComboBox();
		

		private final JComboBox<String> c_description = new JComboBox<String>();
		public Fen7_Gest_ModifDepense(Magasin m, Depense d) {	
		
			
			p.setBackground(new Color(200, 200, 200));
				p.setLayout(null);
				setContentPane(p);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 700, 600);
				setLocationRelativeTo(null);
				setResizable(false);
				setVisible(true);
				
				l_main.setHorizontalAlignment(SwingConstants.CENTER);
				l_main.setFont(new Font("Tahoma", Font.BOLD, 34));
				l_main.setBounds(0, 0, 700, 82); //d�finit la taille et la position (x, y, largeur, hauteur)
				p.add(l_main);

				// JLabels & JTextfield description
				
				
				l_description.setFont(new Font("Franklin Gothic Medium", Font.PLAIN,30));
				l_description.setBounds(30, 100, 200, 30);
				p.add(l_description);
				
				c_description.setFont(new Font("Tahoma", Font.PLAIN, 20));
				c_description.setModel(new DefaultComboBoxModel<String>(new String[] {"Achat nouveau stock", "Location",
						"Achat matériel", "Autre" }));
				c_description.setBounds(270, 100, 389, 30);
				c_description.setToolTipText(d.getDescription());
				p.add(c_description);
				// JLabels & JTextfield cout
				
				
				l_cout.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
				l_cout.setBounds(30, 140, 200, 30);
				p.add(l_cout);
				
				t_cout.setFont(new Font("Tahoma", Font.PLAIN, 25));
				t_cout.setText(String.valueOf(d.getCout()));
				t_cout.setBounds(270, 140, 380, 30);
				p.add(t_cout);
				
				// JLabels & JTextfield nom de l'employe
				
				l_Nemploye.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
				l_Nemploye.setBounds(30, 180, 200, 30);
				p.add(l_Nemploye);

				t_Nemploye.setFont(new Font("Tahoma", Font.PLAIN, 25));
				t_Nemploye.setBounds(270, 180, 380, 30);
				t_Nemploye.setText(d.getEmp().getNom());
				p.add(t_Nemploye);
				
				// JLabels & JTextfield prenom de l'employe
				
				l_Pemploye.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
				l_Pemploye.setBounds(30, 220, 250, 30);
				p.add(l_Pemploye);
				
				t_Pemploye.setFont(new Font("Tahoma", Font.PLAIN, 25));
				t_Pemploye.setBounds(270, 220, 380, 30);
				t_Pemploye.setText(d.getEmp().getPrenom());
				p.add(t_Pemploye);
				
				// JLabels & JTextfield identifiant de l'employe
				
				l_Iemploye.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
				l_Iemploye.setBounds(30, 260, 230, 30);
				p.add(l_Iemploye);
				
				t_Iemploye.setFont(new Font("Tahoma", Font.PLAIN, 25));
				t_Iemploye.setBounds(270, 260, 380, 30);
				t_Iemploye.setText(String.valueOf(d.getEmp().getId()));
				p.add(t_Iemploye);
			
				// Boutons : Effacer, Valider, Retour
				
				b_effacer.setForeground(Color.BLACK);
				b_effacer.setBackground(Color.LIGHT_GRAY);
				b_effacer.setFont(new Font("Tahoma", Font.BOLD, 30));
				b_effacer.setBounds(235, 440, 207, 64);
				b_effacer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						m.supDepense(d);
						dispose();
						new Fen6_Gest_Depenses(m);
					}
					
				});
				p.add(b_effacer);
				
				b_enreg.setBackground(new Color(0, 128, 0));
				b_enreg.setForeground(Color.BLACK);
				b_enreg.setFont(new Font("Tahoma", Font.BOLD, 30));
				b_enreg.setBounds(450, 440, 207, 64);
				b_enreg.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(new ModifInfoDepense(m, d, t_Iemploye, t_Nemploye, t_Pemploye, c_description, t_cout, c_jour, c_mois, t_annee).status == 1) {
							JFrame a = new JFrame();
				            JOptionPane.showMessageDialog(a, "Changements enregistrés.", "Succès", 1);
						}
					}
				});
				p.add(b_enreg);
				
				b_retour.setForeground(Color.BLACK);
				b_retour.setBackground(new Color(255, 215, 0));
				b_retour.setFont(new Font("Tahoma", Font.BOLD, 30));
				b_retour.setBounds(20, 440, 207, 64);
				b_retour.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						new Fen6_Gest_Depenses(m);
					}
				});
				p.add(b_retour);
				
				c_description.setFont(new Font("Tahoma", Font.PLAIN, 20));
				c_description.setModel(new DefaultComboBoxModel<String>(new String[] {"Achat nouveau stock", "Location",
						"Achat matériel", "Autre" }));
				c_description.setBounds(270, 100, 389, 30);
				
				p.add(c_description);
				JLabel l_date = new JLabel("Date d\u00E9pense :");
				l_date.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
				l_date.setBounds(30, 301, 230, 30);
				p.add(l_date);
				
				JLabel l_jour = new JLabel("Jour :");
				l_jour.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
				l_jour.setBounds(270, 301, 120, 30);
				p.add(l_jour);
				
				JLabel l_mois = new JLabel("Mois : ");
				l_mois.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
				l_mois.setBounds(400, 301, 120, 30);
				p.add(l_mois);
				
				JLabel l_annee = new JLabel("Ann\u00E9e :");
				l_annee.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
				l_annee.setBounds(530, 301, 120, 30);
				p.add(l_annee);
				
				c_jour.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
				c_jour.setSelectedIndex(d.getDate().getDayOfMonth() - 1);
				c_jour.setBounds(270, 342, 120, 30);
				p.add(c_jour);
				
				c_mois.setModel(new DefaultComboBoxModel(new String[] {"Janvier", "F\u00E9vrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Ao\u00FBt", "Septembre", "Octobre", "Novembre", "D\u00E9cembre"}));
				c_mois.setSelectedIndex(d.getDate().getMonthValue() - 1);
				c_mois.setBounds(400, 342, 120, 30);
				p.add(c_mois);
				
				t_annee = new JTextField();
				t_annee.setText(String.valueOf(d.getDate().getYear()));
				t_annee.setFont(new Font("Tahoma", Font.PLAIN, 25));
				t_annee.setBounds(530, 342, 120, 30);
				p.add(t_annee);
				
			}
		
	}