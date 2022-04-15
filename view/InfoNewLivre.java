package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class InfoNewLivre extends JFrame {

	private JPanel p = new JPanel();
	private JTextField t_titre;
	private JTextField t_auteur;
	private JTextField t_edition;
	private JTextField t_dateP;
	private JTextField t_format;
	private JTextField t_categorie;
	private JTextField t_prix;


	JButton b_effacer = new JButton("EFFACER");
	JButton b_valider = new JButton("VALIDER");
	JButton b_retour = new JButton("RETOUR");
	public InfoNewLivre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		setResizable(false);
		setLocationRelativeTo(null);
	    setVisible(true);
		
	    setContentPane(p);
		p.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Renseignez les informations du nouveau livre");
		lblNewLabel.setBounds(120, 21, 912, 48);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 39));
		p.add(lblNewLabel);
		
		
		
		JLabel l_titre = new JLabel("Titre :");
		l_titre.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_titre.setBounds(115, 119, 147, 37);
		p.add(l_titre);
		
		JLabel l_auteur = new JLabel("Auteur :");
		l_auteur.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_auteur.setBounds(115, 237, 147, 37);
		p.add(l_auteur);
		
		JLabel l_edition = new JLabel("Edition :");
		l_edition.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_edition.setBounds(115, 353, 147, 37);
		p.add(l_edition);
		
		JLabel l_format = new JLabel("Format :");
		l_format.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_format.setBounds(115, 477, 207, 37);
		p.add(l_format);
		
		JLabel l_dateP = new JLabel("Date de parution :");
		l_dateP.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_dateP.setBounds(643, 119, 326, 37);
		p.add(l_dateP);
		
		JLabel l_categorie = new JLabel("Catégorie :");
		l_categorie.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_categorie.setBounds(643, 237, 337, 37);
		p.add(l_categorie);
		
		JLabel l_prix = new JLabel("Prix :");
		l_prix.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 34));
		l_prix.setBounds(643, 353, 326, 37);
		p.add(l_prix);
		
		t_edition = new JTextField();
		t_edition.setColumns(10);
		t_edition.setBounds(115, 392, 389, 58);
		p.add(t_edition);
		
		t_auteur = new JTextField();
		t_auteur.setColumns(10);
		t_auteur.setBounds(115, 272, 389, 58);
		p.add(t_auteur);
		
		t_titre = new JTextField();
		t_titre.setColumns(10);
		t_titre.setBounds(115, 154, 389, 58);
		p.add(t_titre);
		
		t_format = new JTextField();
		t_format.setColumns(10);
		t_format.setBounds(115, 513, 389, 58);
		p.add(t_format);
		
		t_dateP = new JTextField();
		t_dateP.setColumns(10);
		t_dateP.setBounds(643, 154, 389, 58);
		p.add(t_dateP);
		
		t_categorie = new JTextField();
		t_categorie.setColumns(10);
		t_categorie.setBounds(643, 272, 389, 58);
		p.add(t_categorie);
		
		t_prix = new JTextField();
		t_prix.setColumns(10);
		t_prix.setBounds(643, 392, 389, 58);
		p.add(t_prix);
		

		//JButton effacer
		b_effacer.setForeground(new Color(255, 255, 255));
		b_effacer.setBackground(new Color(0, 0, 0));
		b_effacer.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_effacer.setBounds(739, 502, 207, 64);
		b_effacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		p.add(b_effacer);
		
		//JButton valider
		b_valider.setBackground(new Color(0, 128, 0));
		b_valider.setForeground(new Color(255, 255, 255));
		b_valider.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_valider.setBounds(739, 619, 207, 64);
		b_valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		p.add(b_valider);
		
		//JButton retour
		b_retour.setForeground(new Color(255, 255, 255));
		b_retour.setBackground(new Color(255, 215, 0));
		b_retour.setFont(new Font("Tahoma", Font.BOLD, 30));
		b_retour.setBounds(208, 619, 207, 64);
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
					InfoNewLivre frame = new InfoNewLivre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
