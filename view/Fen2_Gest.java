package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.*;

public class Fen2_Gest extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel p = new JPanel();
	
	JButton b_livres = new JButton("Livres");
	JButton b_magasin = new JButton("Magasin");
	JButton b_clients = new JButton("Clients");
	JButton b_achats = new JButton("Achats");
	JButton b_retour = new JButton("Retour");
	private final JLabel lblNewLabel = new JLabel("Gestion g\u00E9n\u00E9rale");
	
	public Fen2_Gest(Magasin m) {
		
		// Fen�tre
		setTitle("Menu");
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 360);
		setLocationRelativeTo(null);
		setResizable(false);
	    setVisible(true);
		
		// Boutons : Livres, Clients, Magasin, Retour
		
		b_livres.setBackground(new Color(204, 204, 255));
		b_livres.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_livres.setBounds(30, 94, 200, 70);
		b_livres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen3_Gest_Liv(m);
			}
		});
		p.add(b_livres);
		
		b_magasin.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_magasin.setBackground(new Color(255, 255, 153));
		b_magasin.setBounds(254, 190, 200, 70);
		b_magasin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen3_Gest_Mag(m);
			}
		});
		p.add(b_magasin);
		
		b_clients.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_clients.setBackground(new Color(102, 102, 255));
		b_clients.setBounds(254, 94, 200, 70);
		b_clients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen3_Gest_Cli(m);
			}
		});
		p.add(b_clients);
		
		b_achats.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_achats.setBackground(new Color(0, 102, 102));
		b_achats.setBounds(30, 190, 200, 70);
		b_achats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen3_Gest_Com(m);
			}
		});
		p.add(b_achats);
		
		b_retour.setBackground(new Color(200, 100, 100));
		b_retour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b_retour.setBounds(0, 291, 100, 30);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen1(m);
			}
		});
		p.add(b_retour);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 484, 60);
		
		p.add(lblNewLabel);
	}
}
