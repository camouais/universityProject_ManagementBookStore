package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fen_3_Ach_ExistC extends JFrame {

	private JPanel p = new JPanel();
	private JTextField t_nom;
	private JTextField textField;
	private JTextField textField_1;

	public Fen_3_Ach_ExistC() {
		
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 350);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		//JLabel Renseignements du client
		
		JLabel l = new JLabel("Renseignements du client");
		l.setHorizontalAlignment(SwingConstants.CENTER);
		l.setFont(new Font("Tahoma", Font.BOLD, 40));
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
		b_retour.setBounds(50, 230, 150, 50);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fen_2_Ach a = new Fen_2_Ach();
				dispose();
			}
		});
		p.add(b_retour);
		
		//Bouton Valider
		
		JButton b_valider = new JButton("VALIDER");
		b_valider.setBackground(new Color(0, 128, 0));
		b_valider.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_valider.setBounds(350, 230, 150, 50);
		b_valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fen_4_Ach_DoAch a = new Fen_4_Ach_DoAch();
				dispose();
			}
		});
		p.add(b_valider);
		
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
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					edit frame = new edit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
