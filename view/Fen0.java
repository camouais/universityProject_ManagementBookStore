package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controller.*;

public class Fen0 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public Fen0() {
		
		// Fenêtre
		
		JPanel p = new JPanel();
		setTitle("Login");
		p.setBackground(Color.LIGHT_GRAY);
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		// Labels
		
		JLabel l_main = new JLabel("Logiciel de gestion de vente\r\n");
		l_main.setDisplayedMnemonic('L');
		l_main.setHorizontalAlignment(SwingConstants.CENTER);
		l_main.setFont(new Font("Tahoma", Font.BOLD, 25));
		l_main.setBounds(10, 11, 464, 59);
		p.add(l_main);
		
		JLabel l_mag = new JLabel("Nom du magasin :");
		l_mag.setHorizontalAlignment(SwingConstants.CENTER);
		l_mag.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l_mag.setBounds(25, 80, 434, 25);
		p.add(l_mag);
		
		JLabel l_mdp = new JLabel("Mot de passe :");
		l_mdp.setHorizontalAlignment(SwingConstants.CENTER);
		l_mdp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l_mdp.setBounds(25, 150, 434, 25);
		p.add(l_mdp);
		
		// TextFields
		
		JTextField t_nom = new JTextField();
		t_nom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t_nom.setBounds(35, 110, 414, 30);
		p.add(t_nom);
		
		JPasswordField t_mdp = new JPasswordField();
		t_mdp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t_mdp.setColumns(10);
		t_mdp.setBounds(35, 180, 414, 30);
		p.add(t_mdp);
		
		// Boutons
		
		JButton b_valider = new JButton("Valider");
		b_valider.setFont(new Font("Arial", Font.BOLD, 25));
		b_valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RechercheMagasin rm = new RechercheMagasin(t_nom.getText(), String.valueOf(t_mdp.getPassword()));    
                if(rm.status==1) {
                    dispose();
                    new Fen1(rm.getMagasin());
                }
			}
		});
		b_valider.setBackground(new Color(128, 255, 128));
		b_valider.setBounds(160, 280, 150, 50);
		p.add(b_valider);
		
		JButton b_nmag = new JButton("Nouveau magasin ?");
		b_nmag.setBackground(SystemColor.info);
		b_nmag.setForeground(SystemColor.textHighlight);
		b_nmag.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b_nmag.setBounds(90, 230, 300, 30);
		b_nmag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen0_NewMag();
			}
		});
		p.add(b_nmag);
	}
}