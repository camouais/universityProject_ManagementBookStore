package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fen3_Ach_ExistC extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel p = new JPanel();
	private JTextField t_nom;
	private JTextField t_prenom = new JTextField();
	private JTextField t_id = new JTextField();
	private JLabel l_main = new JLabel("Renseignements du client");
	private JLabel l_nom = new JLabel("Nom :");
	private JLabel l_prenom = new JLabel("Prénom :");
	private JLabel l_id = new JLabel("Identifiant :");
	
	JButton b_valider = new JButton("VALIDER");
	JButton b_retour = new JButton("RETOUR");

	public Fen3_Ach_ExistC() {
		
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 350);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Labels : "Renseignements du client", "Nom", "Prénom", "Identifiant"
		
		l_main.setHorizontalAlignment(SwingConstants.CENTER);
		l_main.setFont(new Font("Tahoma", Font.BOLD, 40));
		l_main.setBounds(0, 0, 550, 82);
		p.add(l_main);
		
		l_nom.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_nom.setBounds(20, 100, 150, 30);
		p.add(l_nom);
		
		l_prenom.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_prenom.setBounds(20, 140, 150, 30);
		p.add(l_prenom);
		
		l_id.setFont(new Font("Tahoma", Font.BOLD, 20));
		l_id.setBounds(20, 180, 150, 30);
		p.add(l_id);
		
		// Text Fields : Nom, Prénom, Identifiant
		
		t_nom = new JTextField();
		t_nom.setBounds(150, 100, 380, 30);
		t_nom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		p.add(t_nom);
		t_nom.setColumns(10);

		t_prenom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_prenom.setColumns(10);
		t_prenom.setBounds(150, 141, 380, 30);
		p.add(t_prenom);
		
		t_id.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_id.setColumns(10);
		t_id.setBounds(150, 180, 380, 30);
		p.add(t_id);
		
		// Boutons : Retour, Valider
		
		b_retour.setBackground(new Color(255, 215, 0));
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_retour.setBounds(50, 230, 150, 50);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Fen2_Ach();
				dispose();
			}
		});
		p.add(b_retour);
		
		b_valider.setBackground(new Color(0, 128, 0));
		b_valider.setFont(new Font("Tahoma", Font.BOLD, 20));
		b_valider.setBounds(350, 230, 150, 50);
		b_valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Fen4_Ach_DoAch();
				dispose();
			}
		});
		p.add(b_valider);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen3_Ach_ExistC frame = new Fen3_Ach_ExistC();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
