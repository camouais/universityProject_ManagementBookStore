package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Fen5_Gest_NewEmp extends JFrame {

	private JPanel p = new JPanel();
	private JTextField t_nom;
	private JTextField t_prenom;
	private JTextField t_adresse;
	private JTextField t_tel;
	private JTextField t_sexe;
	private JTextField t_mail;
	private JTextField t_dateN;
	private JTextField t_fonction;
	private JTextField t_salaire;
	

	JButton b_effacer = new JButton("EFFACER");
	JButton b_valider = new JButton("VALIDER");
	JButton b_retour = new JButton("RETOUR");
	
	public Fen5_Gest_NewEmp() {
		
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 850);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Ajout d'un nouvel employé");
		lblNewLabel.setBounds(350, 21, 912, 48);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 39));
		p.add(lblNewLabel);
		
		// JLabel & JTextfield nom
		
		JLabel l_nom = new JLabel("Nom :");
		l_nom.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_nom.setBounds(115, 119, 147, 37);
		p.add(l_nom);
		
		t_nom = new JTextField();
		t_nom.setBounds(115, 154, 389, 58);
		p.add(t_nom);
		// JLabel & JTextfield prénom
		
		JLabel l_prenom = new JLabel("Prénom :");
		l_prenom.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_prenom.setBounds(115, 237, 147, 37);
		p.add(l_prenom);
		
		t_prenom = new JTextField();
		t_prenom.setBounds(115, 272, 389, 58);
		p.add(t_prenom);
		
		// JLabel & JTextfield adresse
		
		JLabel l_adresse = new JLabel("Adresse :");
		l_adresse.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_adresse.setBounds(115, 353, 147, 37);
		p.add(l_adresse);
				
		t_adresse = new JTextField();
		t_adresse.setBounds(115, 392, 389, 58);
		p.add(t_adresse);
		
		// JLabel & JTextfield téléphone
		
		JLabel l_tel = new JLabel("Téléphone :");
		l_tel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_tel.setBounds(115, 477, 207, 37);
		p.add(l_tel);
			
		t_tel = new JTextField();
		t_tel.setBounds(115, 513, 389, 58);
		p.add(t_tel);
		
		// JLabel & JTextfield sexe
		
		JLabel l_sexe = new JLabel("Sexe :");
		l_sexe.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_sexe.setBounds(643, 119, 147, 37);
		p.add(l_sexe);
		
		t_sexe = new JTextField();
		t_sexe.setBounds(643, 154, 389, 58);
		p.add(t_sexe);
		
		// JLabel & JTextfield mail
		
		JLabel l_mail = new JLabel("Mail :");
		l_mail.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_mail.setBounds(643, 237, 147, 37);
		p.add(l_mail);
		
		t_mail = new JTextField();
		t_mail.setBounds(643, 272, 389, 58);
		p.add(t_mail);
		
		//JLabel & JTextfield date de naissance
		
		JLabel l_dateN = new JLabel("Date de naissance :");
		l_dateN.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_dateN.setBounds(643, 353, 326, 37);
		p.add(l_dateN);
		
		t_dateN = new JTextField();
		t_dateN.setBounds(643, 392, 389, 58);
		p.add(t_dateN);
		
		// JLabel & JTextfield  fonction
		
		JLabel l_fonction = new JLabel("Fonction :");
		l_fonction.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_fonction.setBounds(643, 477, 326, 37);
		p.add(l_fonction);
		
		t_fonction = new JTextField();
		t_fonction.setBounds(643, 513, 389, 58);
		p.add(t_fonction);
		
		// JLabel & JTextfield salaire
		
		JLabel l_salaire = new JLabel("Salaire :");
		l_salaire.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_salaire.setBounds(643, 599, 326, 37);
		p.add(l_salaire);
		
		t_salaire = new JTextField();
		t_salaire.setBounds(643, 634, 389, 58);
		p.add(t_salaire);
				
		//JButton Valider
		
		b_valider.setBackground(new Color(0, 128, 0));
		b_valider.setForeground(new Color(255, 255, 255));
		b_valider.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_valider.setBounds(739, 719, 207, 64);
		b_valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fen4_Gest_MagEmp a = new Fen4_Gest_MagEmp();
				dispose();
			}
		});
		p.add(b_valider);
		
		//JButton retour
		
		b_retour.setForeground(new Color(255, 255, 255));
		b_retour.setBackground(new Color(255, 215, 0));
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_retour.setBounds(208, 719, 207, 64);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fen4_Gest_MagEmp a = new Fen4_Gest_MagEmp();
				dispose();
			}
		});
		p.add(b_retour);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen5_Gest_NewEmp frame = new Fen5_Gest_NewEmp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
