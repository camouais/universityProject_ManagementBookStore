package view;

import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

import controller.*;
import model.*;

public class Fen4_Gest_ModifCli extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public Fen4_Gest_ModifCli(Magasin m, Client c) {
		
		// Fenêtre
		
		JPanel p = new JPanel();
		Toolkit tk = Toolkit.getDefaultToolkit();  
        Image img = tk.getImage("src/resources/logo.png");
		setIconImage(img);
		setTitle("Modification du client sélectionné");
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 480);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Labels
		
		JLabel l_rens = new JLabel("Renseignements du client");
		l_rens.setHorizontalAlignment(SwingConstants.CENTER);
		l_rens.setFont(new Font("Tahoma", Font.BOLD, 34));
		l_rens.setBounds(0, 0, 550, 82);
		p.add(l_rens);
		
		JLabel l_id = new JLabel("Identifiant :");
		l_id.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_id.setBounds(20, 100, 150, 30);
		p.add(l_id);
		
		JLabel l_nom = new JLabel("Nom :");
		l_nom.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_nom.setBounds(20, 180, 150, 30);
		p.add(l_nom);
		
		JLabel l_prenom = new JLabel("Pr\u00E9nom :");
		l_prenom.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_prenom.setBounds(20, 140, 150, 30);
		p.add(l_prenom);
		
		JLabel l_adresse = new JLabel("Adresse : ");
		l_adresse.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_adresse.setBounds(20, 220, 150, 30);
		p.add(l_adresse);
		
		JLabel l_mail = new JLabel("Mail : ");
		l_mail.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_mail.setBounds(20, 260, 150, 30);
		p.add(l_mail);
		
		JLabel l_tel = new JLabel("T\u00E9l\u00E9phone : ");
		l_tel.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_tel.setBounds(20, 300, 150, 30);
		p.add(l_tel);
		
		// TextFields
		
		JTextField t_id = new JTextField(String.valueOf(c.getId()));
		t_id.setEditable(false);
		t_id.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_id.setBounds(150, 100, 380, 30);
		p.add(t_id);
		
		JTextField t_nom = new JTextField(c.getNom());
		t_nom.setBounds(150, 180, 380, 30);
		t_nom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		p.add(t_nom);
		
		JTextField t_prenom = new JTextField();
		t_prenom.setFont(new Font("Tahoma", Font.PLAIN, 20));t_prenom.setText(c.getPrenom());
		t_prenom.setBounds(150, 140, 380, 30);
		p.add(t_prenom);
		
		JTextField t_adresse = new JTextField(c.getAdresse());
		t_adresse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_adresse.setBounds(150, 220, 380, 30);
		p.add(t_adresse);
		
		JTextField t_mail = new JTextField(c.getMail());
		t_mail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_mail.setBounds(150, 260, 380, 30);
		p.add(t_mail);
		
		JTextField t_tel = new JTextField(c.getTel());
		t_tel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		t_tel.setBounds(150, 300, 380, 30);
		p.add(t_tel);
		
		// Boutons - Retour, Effacer, Enregistrer
		
		JButton b_retour = new JButton("Retour");
		b_retour.setBackground(new Color(200, 100, 100));
		b_retour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b_retour.setBounds(0, 411, 100, 30);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen3_Gest_Cli(m);
			}
		});
		p.add(b_retour);
		
		JButton b_effacer = new JButton("EFFACER");
		b_effacer.setForeground(Color.WHITE);
		b_effacer.setBackground(new Color(0, 0, 0));
		b_effacer.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_effacer.setBounds(50, 353, 150, 50);
		b_effacer.setToolTipText("Efface le client de la base de données");
		b_effacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame a = new JFrame();
				String[] options = {"Oui", "Non"};
				int f = JOptionPane.showOptionDialog(a, "\u00CAtes-vous s\u00FBr de vouloir supprimer ce client ?", "Suppression d'un client", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    		    if(f == JOptionPane.YES_OPTION) {
    		    	m.supCli(c);
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
    				new Fen3_Gest_Cli(m);
    		    }
			}
		});
		p.add(b_effacer);
		
		JButton b_enreg = new JButton("ENREGISTRER");
		b_enreg.setBackground(new Color(0, 128, 0));
		b_enreg.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_enreg.setBounds(309, 353, 200, 50);
		b_enreg.setToolTipText("Enregistre les modifications");
		b_enreg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modif_InfoClient mic = new Modif_InfoClient(m, c, t_nom, t_prenom, t_adresse, t_mail, t_tel);
				if(mic.status == 1) {
					JFrame a = new JFrame();
				    JOptionPane.showMessageDialog(a, "Changements enregistrés.", "Succès", 1);
				}
			}
		});
		p.add(b_enreg);
	}
}