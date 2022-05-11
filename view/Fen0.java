package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fen0 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel p = new JPanel();
	private JTextField t_mag;
	private JPasswordField t_mdp;
	
	public Fen0() {

		p.setBackground(Color.LIGHT_GRAY);
		p.setLayout(null);
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
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
		
		JButton b_valider = new JButton("Valider");
		b_valider.setFont(new Font("Arial", Font.BOLD, 25));
		b_valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b_valider.setBackground(new Color(128, 255, 128));
		b_valider.setBounds(160, 280, 150, 50);
		p.add(b_valider);
		
		t_mdp = new JPasswordField();
		t_mdp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t_mdp.setColumns(10);
		t_mdp.setBounds(35, 180, 414, 30);
		p.add(t_mdp);
		
		t_mag = new JTextField();
		t_mag.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t_mag.setBounds(35, 110, 414, 30);
		p.add(t_mag);
		t_mag.setColumns(10);
		
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
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen0 frame = new Fen0();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}