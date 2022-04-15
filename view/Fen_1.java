package view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Fen_1 extends JFrame {

	private JPanel p = new JPanel();;

	JButton b_gestion = new JButton("GESTION");
	JButton b_achats = new JButton("ACHATS");
	
	
	public Fen_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		p.setBackground(new Color(248, 248, 255));
		setContentPane(p);
		p.setLayout(null);
		setLocationRelativeTo(null);
		
	
		
		b_gestion.setBackground(new Color(147, 112, 219));
		b_gestion.setFont(new Font("Tahoma", Font.BOLD, 55));
		b_gestion.setBounds(360, 207, 386, 119);
		b_gestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		p.add(b_gestion);
		
		
		b_achats.setFont(new Font("Tahoma", Font.BOLD, 55));
		b_achats.setBackground(new Color(205, 92, 92));
		b_achats.setBounds(360, 368, 386, 119);
		b_achats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		p.add(b_achats);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen_1 frame = new Fen_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
