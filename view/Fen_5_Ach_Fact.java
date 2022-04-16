package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Fen_5_Ach_Fact extends JFrame {

	private JPanel contentPane;
	private JTextField t_client;
	private JTextField t_prix;
	
	public Fen_5_Ach_Fact() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 755);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//panel
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(127, 255, 212));
		panel.setBounds(182, 11, 445, 694);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//JLabel Facture 
		
		JLabel l_facture = new JLabel("Facture ");
		l_facture.setHorizontalAlignment(SwingConstants.CENTER);
		l_facture.setFont(new Font("Tahoma", Font.PLAIN, 42));
		l_facture.setBounds(109, 11, 227, 78);
		panel.add(l_facture);
		
		//JLabel Client
		
		JLabel l_client = new JLabel("Client : ");
		l_client.setFont(new Font("Tahoma", Font.PLAIN, 27));
		l_client.setBounds(32, 134, 105, 58);
		panel.add(l_client);
		
		//Textfield client
		
		t_client = new JTextField();
		t_client.setForeground(new Color(0, 0, 0));
		t_client.setBackground(new Color(102, 255, 204));
		t_client.setBounds(147, 150, 257, 30);
		panel.add(t_client);
		t_client.setColumns(10);
		
		
		//JLabel Achats
		
		JLabel l_achats = new JLabel("Achats : ");
		l_achats.setFont(new Font("Tahoma", Font.PLAIN, 27));
		l_achats.setBounds(32, 213, 105, 58);
		panel.add(l_achats);
		
		
		//JPanel liste des achats 
		
		JPanel p_achats = new JPanel();
		p_achats.setBounds(32, 282, 372, 236);
		panel.add(p_achats);
		
		//JTextfield prix
		
		t_prix = new JTextField();
		t_prix.setBounds(147, 518, 254, 41);
		panel.add(t_prix);
		t_prix.setColumns(10);

		
		//JButton Enregistrer
		JButton b_enregistrer = new JButton("Enregistrer");
		b_enregistrer.setBackground(new Color(255, 255, 0));
		b_enregistrer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		b_enregistrer.setBounds(244, 623, 160, 41);
		panel.add(b_enregistrer);
		
		//JLabel Prix
		
		JLabel l_prix = new JLabel("Prix : ");
		l_prix.setFont(new Font("Tahoma", Font.PLAIN, 27));
		l_prix.setBounds(32, 518, 105, 41);
		panel.add(l_prix);
		
		//JButton retour
		
		JButton b_retour = new JButton("Retour");
		b_retour.setBackground(new Color(255, 182, 193));
		b_retour.setFont(new Font("Tahoma", Font.PLAIN, 25));
		b_retour.setBounds(32, 623, 160, 41);
		panel.add(b_retour);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen_5_Ach_Fact frame = new Fen_5_Ach_Fact();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
