package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CliLivStatMag extends JFrame {

	private JPanel p = new JPanel();
	
	JButton b_stat = new JButton("STATISTIQUES");
	JButton b_clients = new JButton("CLIENTS");
	JButton b_livres = new JButton("LIVRES");
	JButton b_retour = new JButton("RETOUR");
	

	
	public CliLivStatMag() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setResizable(false);
		setLocationRelativeTo(null);
	    setVisible(true);
		p.setBackground(new Color(153, 204, 255));
		
		setContentPane(p);
		p.setLayout(null);
		
		
		
		//Bouton livres 
		b_livres.setBackground(new Color(204, 204, 255));
		b_livres.setFont(new Font("Tahoma", Font.BOLD, 55));
		b_livres.setBounds(329, 51, 468, 119);
		p.add(b_livres);
		
		//bouton magasin
		
		JButton b_magasin = new JButton("MAGASIN");
		b_magasin.setFont(new Font("Tahoma", Font.BOLD, 55));
		b_magasin.setBackground(new Color(255, 255, 153));
		b_magasin.setBounds(329, 375, 468, 119);
		p.add(b_magasin);
		
		//Bouton clients
		
		b_clients.setFont(new Font("Tahoma", Font.BOLD, 55));
		b_clients.setBackground(new Color(102, 102, 255));
		b_clients.setBounds(329, 207, 468, 119);
		b_clients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		p.add(b_clients);
		
		//Bouton statistiques
		
		b_stat.setFont(new Font("Tahoma", Font.BOLD, 55));
		b_stat.setBackground(new Color(0, 139, 139));
		b_stat.setBounds(329, 547, 468, 119);
		b_stat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		//p.add(b_stat);
		
		//Bouton retour
		
		b_retour.setBackground(new Color(255, 215, 0));
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_retour.setBounds(950, 572, 177, 63);
		
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		p.add(b_retour);
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CliLivStatMag frame = new CliLivStatMag();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}


