package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import controller.*;

public class Fen0 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField t_mag;
	private JTextField t_mdp;
	
	public Fen0() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l_main = new JLabel("Bienvenue");
		l_main.setHorizontalAlignment(SwingConstants.CENTER);
		l_main.setFont(new Font("Tahoma", Font.PLAIN, 30));
		l_main.setBounds(10, 10, 414, 50);
		contentPane.add(l_main);
		
		JLabel l_mag = new JLabel("Nom du magasin :");
		l_mag.setFont(new Font("Tahoma", Font.PLAIN, 18));
		l_mag.setBounds(10, 98, 150, 25);
		contentPane.add(l_mag);
		
		JLabel l_mdp = new JLabel("Mot de passe :");
		l_mdp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		l_mdp.setBounds(10, 135, 150, 25);
		contentPane.add(l_mdp);
		
		JButton b_valider = new JButton("Valider");
		b_valider.setFont(new Font("Arial", Font.PLAIN, 20));
		b_valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewMagasin(t_mag);
				dispose();
			}
		});
		b_valider.setBackground(new Color(100, 200, 120));
		b_valider.setBounds(158, 185, 125, 50);
		contentPane.add(b_valider);
		
		t_mdp = new JTextField();
		t_mdp.setColumns(10);
		t_mdp.setBounds(162, 139, 262, 20);
		contentPane.add(t_mdp);
		
		t_mag = new JTextField();
		t_mag.setBounds(162, 100, 262, 20);
		contentPane.add(t_mag);
		t_mag.setColumns(10);
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
