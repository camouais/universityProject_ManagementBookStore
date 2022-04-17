package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Fen4_Gest_MagStat extends JFrame {

	private JPanel contentPane;

	

	JLabel l_stat = new JLabel("Statistiques : ");
	JButton b_retour = new JButton("Retour");
	JButton b_compta = new JButton("COMPTABILITES");
	JButton b_achats = new JButton("ACHATS");
	JButton b_clients = new JButton("CLIENTS");
    
	JButton b_livres = new JButton("LIVRES");
	public Fen4_Gest_MagStat() {
		
    //Fenêtre 
    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 715);
		setLocationRelativeTo(null);
		setResizable(false);
	  setVisible(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(200, 200, 200));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
    // JLable Statistiques : 
    
    l_stat.setHorizontalAlignment(SwingConstants.CENTER);
		l_stat.setFont(new Font("Tahoma", Font.PLAIN, 55));
		l_stat.setBounds(112, 18, 371, 66);
		contentPane.add(l_stat);
    
    // Bouton livres
    
		b_livres.setBackground(new Color(219, 112, 147));
		b_livres.setFont(new Font("Tahoma", Font.BOLD, 43));
		b_livres.setBounds(87, 100, 400, 100);
		contentPane.add(b_livres);
		
    // Bouton clients
    
		b_clients.setBackground(new Color(244, 164, 96));
		b_clients.setFont(new Font("Tahoma", Font.BOLD, 43));
		b_clients.setBounds(87, 230, 400, 100);
		contentPane.add(b_clients);
		
    // Bouton achats
    
		b_achats.setBackground(new Color(221, 160, 221));
		b_achats.setFont(new Font("Tahoma", Font.BOLD, 43));
		b_achats.setBounds(87, 360, 400, 100);
		contentPane.add(b_achats);
		
    // Bouton comptabilité
    
		b_compta.setBackground(new Color(135, 206, 250));
		b_compta.setFont(new Font("Tahoma", Font.BOLD, 43));
		b_compta.setBounds(87, 490, 400, 100);
		contentPane.add(b_compta);
	
    // Bouton retour
		
		b_retour.setBackground(new Color(200, 100, 100));
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_retour.setBounds(30, 620, 200, 50);
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Fen3_Gest_Mag();
				dispose();
			}
		});
		contentPane.add(b_retour);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen4_Gest_MagStat frame = new Fen4_Gest_MagStat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
