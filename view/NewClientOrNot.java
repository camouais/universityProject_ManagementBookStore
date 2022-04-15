package view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewClientOrNot extends JFrame {

	private JPanel p = new JPanel();

	public NewClientOrNot() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setResizable(false);
		setLocationRelativeTo(null);
	    setVisible(true);
		
		setContentPane(p);//le container de la fenetre est p
		p.setLayout(null); //null => oblige à ajouter la position de chaque composant
		
		
		//JLabel Nouveau client ?
		JLabel lblNewLabel = new JLabel("Nouveau client ?");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 70));
		lblNewLabel.setBounds(325, 234, 587, 145);
		p.add(lblNewLabel);
		
		//JButton Oui
		JButton b_oui = new JButton("Oui");
		b_oui.setBackground(new Color(0, 128, 0));
		b_oui.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_oui.setBounds(192, 395, 150, 56);
		b_oui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		p.add(b_oui);
		
		//JButton Non
		JButton b_non = new JButton("Non");
		b_non.setBackground(new Color(255, 0, 0));
		b_non.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_non.setBounds(783, 395, 150, 56);
		b_non.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		p.add(b_non);
		
		//JButton Retour
		JButton b_retour = new JButton("RETOUR");
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_retour.setBackground(new Color(255, 215, 0));
		b_retour.setBounds(950, 672, 177, 63);
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
					NewClientOrNot f = new NewClientOrNot();
					f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
