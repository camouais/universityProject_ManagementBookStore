package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;
import model.*;
import controller.*;

public class Fen7_Gest_ModifDepense extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public Fen7_Gest_ModifDepense(Magasin m, Depense d) {
		
		// Fenêtre
		
		JPanel p = new JPanel();
		setTitle("Modification de la dépense sélectionnée");
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Labels
		
		JLabel l_main = new JLabel("Modification de la d\u00E9pense ");
		l_main.setHorizontalAlignment(SwingConstants.CENTER);
		l_main.setFont(new Font("Tahoma", Font.BOLD, 34));
		l_main.setBounds(0, 0, 684, 82);
		p.add(l_main);
		
		JLabel l_description = new JLabel("Description :");
		l_description.setFont(new Font("Franklin Gothic Medium", Font.PLAIN,30));
		l_description.setBounds(30, 100, 200, 30);
		p.add(l_description);
		
		JLabel l_Iemploye = new JLabel("ID employ\u00E9 :");
		l_Iemploye.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_Iemploye.setBounds(30, 260, 230, 30);
		p.add(l_Iemploye);
		
		JLabel l_Pemploye = new JLabel("Pr\u00E9nom employ\u00E9 :");
		l_Pemploye.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_Pemploye.setBounds(30, 220, 250, 30);
		p.add(l_Pemploye);
		
		JLabel l_Nemploye = new JLabel("Nom employ\u00E9 :");
		l_Nemploye.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_Nemploye.setBounds(30, 180, 200, 30);
		p.add(l_Nemploye);
		
		JLabel l_cout = new JLabel("Co\u00FBt :");
		l_cout.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 30));
		l_cout.setBounds(30, 140, 200, 30);
		p.add(l_cout);
		
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
		
		// TextFields
		
		JTextField t_cout = new JTextField();
		t_cout.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_cout.setText(String.valueOf(d.getCout()));
		t_cout.setBounds(270, 140, 380, 30);
		p.add(t_cout);
		
		JTextField t_Nemploye = new JTextField();
		t_Nemploye.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_Nemploye.setBounds(270, 180, 380, 30);
		t_Nemploye.setText(d.getEmp().getNom());
		p.add(t_Nemploye);
		
		JTextField t_Pemploye = new JTextField();
		t_Pemploye.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_Pemploye.setBounds(270, 220, 380, 30);
		t_Pemploye.setText(d.getEmp().getPrenom());
		p.add(t_Pemploye);
		
		JTextField t_Iemploye = new JTextField();
		t_Iemploye.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_Iemploye.setBounds(270, 260, 380, 30);
		t_Iemploye.setText(String.valueOf(d.getEmp().getId()));
		p.add(t_Iemploye);
		
		JTextField t_annee = new JTextField();
		t_annee.setText(String.valueOf(d.getDate().getYear()));
		t_annee.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_annee.setBounds(530, 342, 120, 30);
		p.add(t_annee);
		
		// ComboBoxes
		
		JComboBox<String> c_jour = new JComboBox<String>();
		c_jour.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		c_jour.setSelectedIndex(d.getDate().getDayOfMonth() - 1);
		c_jour.setBounds(270, 342, 120, 30);
		p.add(c_jour);
		
		JComboBox<String> c_mois = new JComboBox<String>();
		c_mois.setModel(new DefaultComboBoxModel<String>(new String[] {"Janvier", "F\u00E9vrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Ao\u00FBt", "Septembre", "Octobre", "Novembre", "D\u00E9cembre"}));
		c_mois.setSelectedIndex(d.getDate().getMonthValue() - 1);
		c_mois.setBounds(400, 342, 120, 30);
		p.add(c_mois);
		
		JComboBox<String> c_description = new JComboBox<String>();
		c_description.setFont(new Font("Tahoma", Font.PLAIN, 20));
		c_description.setModel(new DefaultComboBoxModel<String>(new String[] {"Achat d'un nouveau stock", "Location", "Achat mat\u00E9riel", "Autre"}));
		c_description.setBounds(270, 100, 389, 30);
		c_description.setToolTipText(d.getDescription());
		p.add(c_description);
		
		// Boutons : Effacer, Valider, Retour
		
		JButton b_effacer = new JButton("Effacer");
		b_effacer.setForeground(Color.BLACK);
		b_effacer.setBackground(Color.LIGHT_GRAY);
		b_effacer.setFont(new Font("Tahoma", Font.BOLD, 25));
		b_effacer.setBounds(100, 400, 200, 60);
		b_effacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame a = new JFrame();
				String[] options = {"Oui", "Non"};
				int f = JOptionPane.showOptionDialog(a, "\u00CAtes-vous s\u00FBr de vouloir supprimer cette d\u00E9pense ?", "Suppression d'une d\u00E9pense", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    		    if(f == JOptionPane.YES_OPTION) {
    				m.supDepense(d);
    				try {
    					FileOutputStream fout = new FileOutputStream("src/data/m_" + m.getNom() + "/data.txt");
    					ObjectOutputStream out = new ObjectOutputStream(fout);
    					out.writeObject(m);    
    					out.flush();
    					out.close();
    					fout.flush();
    					fout.close();
    				} catch(Exception ex) {
    					System.out.println(e);
    				}
    				dispose();
    				new Fen6_Gest_Depenses(m);
    		    }
			}
		});
		p.add(b_effacer);
		
		JButton b_enreg = new JButton("Enregistrer");
		b_enreg.setBackground(new Color(0, 128, 0));
		b_enreg.setForeground(Color.BLACK);
		b_enreg.setFont(new Font("Tahoma", Font.BOLD, 25));
		b_enreg.setBounds(384, 400, 200, 60);
		b_enreg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(new Modif_InfoDepense(m, d, t_Iemploye, t_Nemploye, t_Pemploye, c_description, t_cout, c_jour, c_mois, t_annee).status == 1) {
					JFrame a = new JFrame();
		            JOptionPane.showMessageDialog(a, "Changements enregistr\u00E9s.", "Succ\u00E8s", 1);
				}
			}
		});
		p.add(b_enreg);
		
		JButton b_retour = new JButton("Retour");
		b_retour.setForeground(Color.BLACK);
		b_retour.setBackground(new Color(200, 100, 100));
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 25));
		b_retour.setBounds(0, 481, 100, 30);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen6_Gest_Depenses(m);
			}
		});
		p.add(b_retour);
	}
}