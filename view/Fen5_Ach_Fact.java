package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Fen5_Ach_Fact extends JFrame {
	
	private JTextField t_client;
	private JTextField t_prix;
	private JPanel p = new JPanel();
	
	public Fen5_Ach_Fact() {
		
		p = new JPanel();
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		p.setBackground(new Color(150, 200, 150));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 580);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// JLabel Facture 
		
		JLabel l_facture = new JLabel("Facture ");
		l_facture.setHorizontalAlignment(SwingConstants.CENTER);
		l_facture.setFont(new Font("Arial", Font.BOLD, 42));
		l_facture.setBounds(0, 0, 484, 100);
		p.add(l_facture);
		
		// JLabel "Client"
		
		JLabel l_client = new JLabel("Client : ");
		l_client.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l_client.setBounds(25, 100, 100, 30);
		p.add(l_client);
		
		// Textfield Client
		
		t_client = new JTextField();
		t_client.setForeground(new Color(0, 0, 0));
		t_client.setBackground(new Color(102, 255, 204));
		t_client.setBounds(125, 100, 325, 30);
		p.add(t_client);
		t_client.setColumns(10);
		
		// JLabel "Achats"
		
		JLabel l_achats = new JLabel("Achats : ");
		l_achats.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l_achats.setBounds(25, 140, 100, 30);
		p.add(l_achats);
		
		// JPanel liste des achats 
		
		JPanel p_achats = new JPanel();
		p_achats.setBounds(25, 180, 432, 236);
		p.add(p_achats);
		
		// JTextfield prix
		
		t_prix = new JTextField();
		t_prix.setBounds(125, 425, 325, 30);
		p.add(t_prix);
		t_prix.setColumns(10);
		
		// Bouton "Enregistrer"
		
		JButton b_enregistrer = new JButton("Enregistrer");
		b_enregistrer.setBackground(new Color(255, 255, 0));
		b_enregistrer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		b_enregistrer.setBounds(300, 475, 160, 41);
		b_enregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fen1 a = new Fen1();
				dispose();
			}
		});
		p.add(b_enregistrer);
		
		// JLabel Prix
		
		JLabel l_prix = new JLabel("Prix : ");
		l_prix.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l_prix.setBounds(25, 425, 100, 30);
		p.add(l_prix);
		
		// JButton retour
		
		JButton b_retour = new JButton("Retour");
		b_retour.setBackground(new Color(255, 182, 193));
		b_retour.setFont(new Font("Tahoma", Font.PLAIN, 25));
		b_retour.setBounds(25, 475, 160, 41);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fen4_Ach_DoAch a = new Fen4_Ach_DoAch();
				dispose();
			}
		});
		p.add(b_retour);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen5_Ach_Fact frame = new Fen5_Ach_Fact();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
