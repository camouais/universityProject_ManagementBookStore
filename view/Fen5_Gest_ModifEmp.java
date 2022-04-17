package view;

import model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fen5_Gest_ModifEmp extends JFrame {

	private JPanel p = new JPanel();
	private JTextField t_nom;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public Fen5_Gest_ModifEmp() { // Rajouter une variable de type Employe dans le constructeur lorsqu'on aura fait le controller
		
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 525);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		//JLabel Renseignements du client
		
		JLabel l = new JLabel("Renseignements de l'employé");
		l.setHorizontalAlignment(SwingConstants.CENTER);
		l.setFont(new Font("Tahoma", Font.BOLD, 34));
		l.setBounds(0, 0, 550, 82); //définit la taille et la position (x, y, largeur, hauteur)
		p.add(l);
		
		//JTextField nom
		
		t_nom = new JTextField();
		t_nom.setBounds(150, 100, 380, 30);
		t_nom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		p.add(t_nom);
		t_nom.setColumns(10);
		
		//JLabels nom, prénom, id
		
		JLabel l_nom = new JLabel("Nom :");
		l_nom.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_nom.setBounds(20, 100, 150, 30);
		p.add(l_nom);
		
		JLabel l_prenom = new JLabel("Prénom :");
		l_prenom.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_prenom.setBounds(20, 140, 150, 30);
		p.add(l_prenom);
		
		JLabel l_id = new JLabel("Identifiant :");
		l_id.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_id.setBounds(20, 180, 150, 30);
		p.add(l_id);
		
		//Bouton Retour
		
		JButton b_retour = new JButton("RETOUR");
		b_retour.setBackground(new Color(255, 215, 0));
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_retour.setBounds(50, 400, 150, 50);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fen4_Gest_MagEmp a = new Fen4_Gest_MagEmp();
				dispose();
			}
		});
		p.add(b_retour);
		
		//Bouton Valider
		
		JButton b_enreg = new JButton("ENREGISTRER");
		b_enreg.setBackground(new Color(0, 128, 0));
		b_enreg.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_enreg.setBounds(300, 400, 200, 50);
		p.add(b_enreg);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setColumns(10);
		textField.setBounds(150, 141, 380, 30);
		p.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_1.setColumns(10);
		textField_1.setBounds(150, 180, 380, 30);
		p.add(textField_1);
		
		JLabel l_fonc = new JLabel("Fonction : ");
		l_fonc.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_fonc.setBounds(20, 221, 150, 30);
		p.add(l_fonc);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_2.setColumns(10);
		textField_2.setBounds(150, 221, 380, 30);
		p.add(textField_2);
		
		JLabel l_fonc_1 = new JLabel("Adresse : ");
		l_fonc_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_fonc_1.setBounds(20, 262, 150, 30);
		p.add(l_fonc_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_3.setColumns(10);
		textField_3.setBounds(150, 262, 380, 30);
		p.add(textField_3);
		
		JLabel l_fonc_1_1 = new JLabel("Mail : ");
		l_fonc_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_fonc_1_1.setBounds(20, 303, 150, 30);
		p.add(l_fonc_1_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_4.setColumns(10);
		textField_4.setBounds(150, 303, 380, 30);
		p.add(textField_4);
		
		JLabel l_fonc_1_1_1 = new JLabel("T\u00E9l\u00E9phone : ");
		l_fonc_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_fonc_1_1_1.setBounds(20, 344, 150, 30);
		p.add(l_fonc_1_1_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_5.setColumns(10);
		textField_5.setBounds(150, 344, 380, 30);
		p.add(textField_5);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen5_Gest_ModifEmp frame = new Fen5_Gest_ModifEmp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
