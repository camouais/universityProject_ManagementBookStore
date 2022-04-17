
package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Fen_3_Gest_InfoStat extends JFrame {

	private JPanel p = new JPanel();
	
	JButton b_stat = new JButton("STATISTIQUES");
	JButton b_info =  new JButton("INFORMATIONS");
	JButton b_empl =  new JButton("EMPLOYES");
	JButton b_retour = new JButton("RETOUR");
	

	
	public Fen_3_Gest_InfoStat() {
		
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 650);
		setLocationRelativeTo(null);
		setResizable(false);
	    setVisible(true);
		
		// Bouton "Informations"
		
		b_info.setFont(new Font("Tahoma", Font.BOLD, 55));
		b_info.setBackground(new Color(255, 0, 255));
		b_info.setBounds(50, 50, 500, 100);
		b_info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		p.add(b_info);
		
		// Bouton "Statistiques"
		
		b_stat.setFont(new Font("Tahoma", Font.BOLD, 55));
		b_stat.setBackground(new Color(0, 50, 200));
		b_stat.setBounds(50, 350, 500, 100);
		b_stat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		p.add(b_stat);
		// Bouton "Employés"
		
		b_empl.setFont(new Font("Tahoma", Font.BOLD, 55));
		b_empl.setBackground(new Color(255, 0, 0));
		b_empl.setBounds(50, 200, 500, 100);
		b_empl.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
		p.add(b_empl);
		
		// Bouton "Retour"


		b_retour.setBackground(new Color(200, 100, 100));
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_retour.setBounds(50, 500, 200, 50);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fen_2_Gest a = new Fen_2_Gest();
				dispose();
			}
		});
		p.add(b_retour);
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen_3_Gest_InfoStat frame = new Fen_3_Gest_InfoStat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

