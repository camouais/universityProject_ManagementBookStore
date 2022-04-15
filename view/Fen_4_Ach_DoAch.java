package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Fen_4_Ach_DoAch extends JFrame{
	private JPanel contentPane;
	private JTextField txtRecherchezUnLivre;

	
	public Fen_4_Ach_DoAch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(634, 195, 357, 378);
		contentPane.add(panel);
		
		txtRecherchezUnLivre = new JTextField();
		txtRecherchezUnLivre.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtRecherchezUnLivre.setText("Recherchez un livre");
		txtRecherchezUnLivre.setBounds(165, 78, 819, 36);
		contentPane.add(txtRecherchezUnLivre);
		txtRecherchezUnLivre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("R\u00E9alisez l'achat");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setBounds(442, 25, 256, 38);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Annuler");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(634, 619, 357, 54);
		contentPane.add(btnNewButton);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnEnregistrer.setBounds(634, 684, 357, 54);
		contentPane.add(btnEnregistrer);
		
	}
		
		
		public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen_4_Ach_DoAch frame = new Fen_4_Ach_DoAch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
