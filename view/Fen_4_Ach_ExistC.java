
package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fen_4_Ach_ExistC extends JFrame {

	private JPanel p = new JPanel();
	private JTextField t_nom;
	private JTextField t_prenom;
	private JTextField t_id;

	

	public Fen_4_Ach_ExistC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setResizable(false);
		setLocationRelativeTo(null);
	    setVisible(true);
	
		setContentPane(p);//le container de la fenetre est p
		p.setLayout(null);//null => oblige à ajouter la position de chaque composant
		
		
		//JLabel Renseignements du client
		JLabel l = new JLabel("Renseignements du client");
		l.setFont(new Font("Tahoma", Font.BOLD, 40));
		l.setBounds(352, 11, 609, 82);//définit la taille et la position (x, y, largeur, hauteur)
		p.add(l);
		
		
		//JTextField nom
		t_nom = new JTextField();
		t_nom.setBounds(427, 204, 527, 75);
		t_nom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		p.add(t_nom);
		t_nom.setColumns(10);
		
		//JTextField prénom
		t_prenom = new JTextField();
		t_prenom.setBounds(427, 362, 527, 75);
		t_prenom.setFont(new Font("Tahoma", Font.PLAIN, 25));
		p.add(t_prenom);
		
		//JTextField identifiant
		t_id = new JTextField();
		t_id.setFont(new Font("Tahoma", Font.PLAIN, 25));
		t_id.setBounds(427, 522, 527, 75);
		p.add(t_id);
		
		//JLabels nom, prénom, id
		JLabel l_nom = new JLabel("Nom :");
		l_nom.setFont(new Font("Tahoma", Font.BOLD, 28));
		l_nom.setBounds(138, 203, 177, 63);
		p.add(l_nom);
		
		JLabel l_prenom = new JLabel("Prénom :");
		l_prenom.setFont(new Font("Tahoma", Font.BOLD, 28));
		l_prenom.setBounds(138, 361, 177, 63);
		p.add(l_prenom);
		
		JLabel l_id = new JLabel("Identifiant :");
		l_id.setFont(new Font("Tahoma", Font.BOLD, 28));
		l_id.setBounds(138, 534, 177, 63);
		p.add(l_id);
		
		//Bouton retour
		JButton b_retour = new JButton("RETOUR");
		b_retour.setBackground(new Color(255, 215, 0));
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_retour.setBounds(50, 672, 177, 63);
		
		b_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		p.add(b_retour);
		
		//Bouton valider
		JButton b_valider = new JButton("VALIDER");
		b_valider.setBackground(new Color(0, 128, 0));
		b_valider.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_valider.setBounds(949, 672, 177, 63);
		b_valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		p.add(b_valider);
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fen_4_Ach_ExistC frame = new Fen_4_Ach_ExistC();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

