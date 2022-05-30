package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.*;

public class Fen2_Ach extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public Fen2_Ach(Magasin m) {
		
		// Fenêtre

		Toolkit tk = Toolkit.getDefaultToolkit();  
        Image img = tk.getImage("src/resources/logo.png");
		setIconImage(img);
		JPanel p = new JPanel();	
		setTitle("Achat");
		p.setBackground(new Color(200, 200, 200));
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		setLocationRelativeTo(null);
		setResizable(false);
	    setVisible(true);
		
		// Labels
		
		JLabel l_main = new JLabel("Cr\u00E9ation d'un achat");
		l_main.setHorizontalAlignment(SwingConstants.CENTER);
		l_main.setFont(new Font("Tahoma", Font.BOLD, 35));
		l_main.setBounds(0, 0, 484, 70);
		p.add(l_main);
		
		JLabel l_newcli = new JLabel("Nouveau client?");
		l_newcli.setHorizontalAlignment(SwingConstants.CENTER);
		l_newcli.setFont(new Font("Tahoma", Font.PLAIN, 25));
		l_newcli.setBounds(50, 81, 384, 30);
		p.add(l_newcli);
		
		// Boutons
		
		JButton b_oui = new JButton("Oui");
		b_oui.setBackground(new Color(100, 255, 100));
		b_oui.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_oui.setBounds(50, 140, 150, 60);
		b_oui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen3_Ach_NewC(m);
			}
		});
		p.add(b_oui);
		
		JButton b_non = new JButton("Non");
		b_non.setBackground(new Color(255, 100, 100));
		b_non.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_non.setBounds(284, 140, 150, 60);
		b_non.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen3_Ach_ExistC(m);
			}
		});
		p.add(b_non);
		
		JButton b_retour = new JButton("Retour");
		b_retour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b_retour.setBackground(new Color(200, 100, 100));
		b_retour.setBounds(0, 231, 100, 30);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Fen1(m);
			}
		});
		p.add(b_retour);
	}
}