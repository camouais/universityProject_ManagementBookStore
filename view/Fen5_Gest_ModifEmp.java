package view;

import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

import controller.*;
import model.*;

public class Fen5_Gest_ModifEmp extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public Fen5_Gest_ModifEmp(Magasin m, Employe emp) { 
		
		// Fen�tre
		
		JPanel p = new JPanel();
		Toolkit tk = Toolkit.getDefaultToolkit();  
        Image img = tk.getImage("src/resources/logo.png");
		setIconImage(img);
		setTitle("Modification de l'employ� s�lectionn�");
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 525);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Labels
		
		JLabel l_rens = new JLabel("Renseignements de l'employ�");
		l_rens.setHorizontalAlignment(SwingConstants.CENTER);
		l_rens.setFont(new Font("Tahoma", Font.BOLD, 34));
		l_rens.setBounds(0, 0, 550, 82);
		p.add(l_rens);

		JLabel l_nom = new JLabel("Nom : ");
		l_nom.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_nom.setBounds(20, 180, 150, 30);
		p.add(l_nom);
		
		JLabel l_prenom = new JLabel("Pr�nom : ");
		l_prenom.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_prenom.setBounds(20, 140, 150, 30);
		p.add(l_prenom);
		
		JLabel l_id = new JLabel("Identifiant : ");
		l_id.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_id.setBounds(20, 100, 150, 30);
		p.add(l_id);
		
		JLabel l_fonc = new JLabel("Fonction : ");
		l_fonc.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_fonc.setBounds(20, 221, 150, 30);
		p.add(l_fonc);
		
		JLabel l_adresse = new JLabel("Adresse : ");
		l_adresse.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_adresse.setBounds(20, 262, 150, 30);
		p.add(l_adresse);
		
		JLabel l_mail = new JLabel("Mail : ");
		l_mail.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_mail.setBounds(20, 303, 150, 30);
		p.add(l_mail);
		
		JLabel l_tel = new JLabel("T�l�phone : ");
		l_tel.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_tel.setBounds(20, 344, 150, 30);
		p.add(l_tel);
		
		// TextFields
		
		JTextField t_nom = new JTextField(emp.getNom());
		t_nom.setBounds(150, 180, 380, 30);
		t_nom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		p.add(t_nom);
		
		JTextField t_prenom = new JTextField(emp.getPrenom());
		t_prenom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_prenom.setBounds(150, 141, 380, 30);
		p.add(t_prenom);
		
		JTextField t_id = new JTextField(String.valueOf(emp.getId()));
		t_id.setEditable(false);
		t_id.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_id.setBounds(150, 100, 380, 30);
		p.add(t_id);
		
		JTextField t_fonction = new JTextField(emp.getFonction());
		t_fonction.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_fonction.setBounds(150, 221, 380, 30);
		p.add(t_fonction);
		
		JTextField t_adresse = new JTextField(emp.getAdresse());
		t_adresse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_adresse.setBounds(150, 262, 380, 30);
		p.add(t_adresse);
		
		JTextField t_mail = new JTextField(emp.getMail());
		t_mail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_mail.setBounds(150, 303, 380, 30);
		p.add(t_mail);
		
		JTextField t_tel = new JTextField(emp.getTel());
		t_tel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_tel.setBounds(150, 344, 380, 30);
		p.add(t_tel);
		
		// Boutons : Retour, Effacer, Enregistrer
		
		JButton b_retour = new JButton("Retour");
		b_retour.setBackground(new Color(200, 100, 100));
		b_retour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b_retour.setBounds(0, 456, 100, 30);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Fen4_Gest_MagEmp(m);
				dispose();
			}
		});
		p.add(b_retour);
		
		JButton b_effacer = new JButton("EFFACER");
		b_effacer.setForeground(Color.WHITE);
		b_effacer.setBackground(new Color(0, 0, 0));
		b_effacer.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_effacer.setBounds(50, 400, 150, 50);
		b_effacer.setToolTipText("Efface l'employ� de la base de donn�es");
		b_effacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame a = new JFrame();
				String[] options = {"Oui", "Non"};
				int f = JOptionPane.showOptionDialog(a, "�tes-vous s�r de vouloir supprimer cet employ� ?", "Suppression d'un employ�", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    		    if(f == JOptionPane.YES_OPTION) {
    				m.supEmp(emp);
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
    				new Fen4_Gest_MagEmp(m);
    		    }
			}
		});
		p.add(b_effacer);
		
		JButton b_enreg = new JButton("ENREGISTRER");
		b_enreg.setBackground(new Color(0, 128, 0));
		b_enreg.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_enreg.setBounds(319, 400, 200, 50);
		b_enreg.setToolTipText("Enregistre les modifications");
		b_enreg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(new Modif_InfoEmploye(m, emp, t_nom, t_prenom, t_id, t_fonction, t_adresse, t_mail, t_tel).status == 1) {
	            	JFrame a = new JFrame();
	    		    JOptionPane.showMessageDialog(a, "Changements enregistr�s.", "Succ�s", 1);
				}
			}
		});
		p.add(b_enreg);
	}
}